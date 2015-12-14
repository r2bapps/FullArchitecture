package com.axa.gnome.data.db;

import java.util.List;

import com.axa.gnome.data.db.entity.GnomeDb;

public interface DbSource {

    List<GnomeDb> listAll();
    int save(List<GnomeDb> list);
    int remove(List<GnomeDb> list);

}
