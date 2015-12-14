package com.axa.gnome.data.db;

import java.util.List;

import com.axa.gnome.BaseApplication;
import com.axa.gnome.data.db.entity.GnomeDb;
import io.realm.Realm;

public class DbSourceImpl implements DbSource {

    private final Realm dbAdapter;

    public DbSourceImpl() {
        dbAdapter = Realm.getInstance(BaseApplication.getContext());
    }

    @Override
    public List<GnomeDb> listAll() {
        dbAdapter.beginTransaction();
        List<GnomeDb> list = dbAdapter.allObjects(GnomeDb.class);
        dbAdapter.commitTransaction();
        return list;
    }

    @Override
    public int save(List<GnomeDb> list) {
        dbAdapter.beginTransaction();
        dbAdapter.copyToRealm(list);
        dbAdapter.commitTransaction();
        return list.size();
    }

    @Override
    public int remove(List<GnomeDb> list) {
        dbAdapter.beginTransaction();
        dbAdapter.clear(GnomeDb.class);
        dbAdapter.commitTransaction();
        return list.size();
    }

}
