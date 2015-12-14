package r2b.apps.gnome.data.db;

import android.support.annotation.NonNull;

import java.util.List;

import r2b.apps.gnome.data.db.entity.GnomeDb;
import r2b.apps.gnome.data.strategy.SyncStrategy;


public class SyncDbSourceImpl implements DbSource {

    private final DbSource dbSource;
    private final SyncStrategy syncStrategy;

    public SyncDbSourceImpl(@NonNull DbSource dbSource, @NonNull SyncStrategy syncStrategy) {

        // PRECONDITIONS
        if (dbSource == null) {
            throw new IllegalArgumentException("DbSource can not be null");
        }
        if (syncStrategy == null) {
            throw new IllegalArgumentException("SyncStrategy can not be null");
        }

        this.dbSource = dbSource;
        this.syncStrategy = syncStrategy;
    }

    @Override
    public int save(List<GnomeDb> list) {
        // Applies sync strategy and retrieves the information to store.
        List<GnomeDb> stored = dbSource.listAll();
        List<GnomeDb> processed = syncStrategy.apply(list, stored);
        dbSource.remove(stored);
        return dbSource.save(processed);
    }

    @Override
    public int remove(List<GnomeDb> list) {
        return dbSource.remove(list);
    }

    @Override
    public List<GnomeDb> listAll() {
        return dbSource.listAll();
    }

}
