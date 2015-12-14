package com.axa.gnome.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import java.util.List;

import com.axa.gnome.BaseApplication;
import com.axa.gnome.Logger;
import com.axa.gnome.data.db.DbSource;
import com.axa.gnome.data.db.entity.GnomeDb;
import com.axa.gnome.data.rest.RestSource;
import com.axa.gnome.data.strategy.CachingStrategy;
import com.axa.gnome.data.strategy.cache.Cached;
import com.axa.gnome.domain.Mapper;
import com.axa.gnome.domain.Repository;
import com.axa.gnome.domain.model.People;

/**
 * Wraps {@link RepositoryImpl} with cache functionalities.
 * Data is retrieved from cache. If is not valid data is retrieved from REST, then stored/processed
 * and retrieved to upper layers as it was like retrieved from cache.
 */
public class CachedRepositoryImpl implements Repository {

    private static final String TAG = "CachedRepositoryImpl";


    private final Repository repository;
    private final DbSource dbSource;
    private final CachingStrategy cachingStrategy;
    private final SharedPreferences prefs;

    /**
     * Builder.
     * @param restSource Rest adapter.
     * @param dbSource Database adapter.
     * @param cachingStrategy Caching strategy.
     */
    public CachedRepositoryImpl(@NonNull RestSource restSource, @NonNull DbSource dbSource,
                                @NonNull CachingStrategy cachingStrategy) {

        // PRECONDITIONS
        if (restSource == null) {
            throw new IllegalArgumentException("RestSource can not be null");
        }
        if (dbSource == null) {
            throw new IllegalArgumentException("DbSource can not be null");
        }
        if (cachingStrategy == null) {
            throw new IllegalArgumentException("CachingStrategy can not be null");
        }

        repository = new RepositoryImpl(restSource);
        this.dbSource = dbSource;
        this.cachingStrategy = cachingStrategy;
        prefs = BaseApplication.getContext().getSharedPreferences("cache", Context.MODE_PRIVATE);
    }

    @Override
    public People getPeople() {

        People people;

        List<GnomeDb> peopleDb = dbSource.listAll();
        Cached cached = new Cached("listAll", prefs.getLong("listAll", 0));

        if (cachingStrategy.isValid(cached)) {
            people = Mapper.parseFromDb(peopleDb);

            Logger.d(TAG, "Cached information");
        } else {
            dbSource.remove(peopleDb);

            people = repository.getPeople();
            List<GnomeDb> toCache = Mapper.parse(people);
            dbSource.save(toCache);
            prefs.edit().putLong("listAll", System.currentTimeMillis()).commit();

            Logger.d(TAG, "Cache expired");
        }

        return people;
    }
}
