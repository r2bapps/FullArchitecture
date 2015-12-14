package r2b.apps.gnome.data;

import android.support.annotation.NonNull;

import java.util.List;

import r2b.apps.gnome.data.db.DbSource;
import r2b.apps.gnome.data.db.SyncDbSourceImpl;
import r2b.apps.gnome.data.db.entity.GnomeDb;
import r2b.apps.gnome.data.rest.RestSource;
import r2b.apps.gnome.data.strategy.SyncStrategy;
import r2b.apps.gnome.domain.Mapper;
import r2b.apps.gnome.domain.Repository;
import r2b.apps.gnome.domain.model.People;

/**
 * Wraps {@link RepositoryImpl} with synchronization functionalities.
 * Data retrieved from REST calls is stored/processed previously to be retrieved to upper layers.
 */
public class SyncRepositoryImpl implements Repository {

    private static final String TAG = "SyncRepositoryImpl";


    private final RepositoryImpl repository;
    private final DbSource dbSource;

    /**
     * Builder.
     * @param restSource Rest adapter.
     * @param dbSource Database adapter.
     * @param syncStrategy Synchronization strategy.
     */
    public SyncRepositoryImpl(@NonNull RestSource restSource, @NonNull DbSource dbSource,
                              @NonNull SyncStrategy syncStrategy) {

        // PRECONDITIONS
        if (restSource == null) {
            throw new IllegalArgumentException("RestSource can not be null");
        }
        if (dbSource == null) {
            throw new IllegalArgumentException("DbSource can not be null");
        }
        if (syncStrategy == null) {
            throw new IllegalArgumentException("SyncStrategy can not be null");
        }

        repository = new RepositoryImpl(restSource);
        this.dbSource = new SyncDbSourceImpl(dbSource, syncStrategy);
    }

    @Override
    public People getPeople() {
        // Retrieved from repository
        People repositoryPeople = repository.getPeople();
        List<GnomeDb> dbPeople = Mapper.parse(repositoryPeople);

        // Saved and synchronized
        // Synchronization can be very complex, it is preferable to processed into db source because
        // can need access to other db entities.
        dbSource.save(dbPeople);

        // Retrieved again
        dbPeople = dbSource.listAll();
        People people = Mapper.parseFromDb(dbPeople);

        return people;
    }

}
