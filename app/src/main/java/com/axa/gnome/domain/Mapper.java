package com.axa.gnome.domain;

import java.util.ArrayList;
import java.util.List;

import com.axa.gnome.data.db.entity.GnomeDb;
import com.axa.gnome.data.rest.entity.GnomeRest;
import com.axa.gnome.domain.model.Gnome;
import com.axa.gnome.domain.model.People;

public class Mapper {

    public static List<GnomeDb> parse(People people) {
        List<GnomeDb> list = new ArrayList<GnomeDb>(people.size());
        for (Gnome gnome : people) {
            list.add(parse(gnome));
        }
        return list;
    }

    public static People parse(List<GnomeRest> list) {
        People people = new People();
        for(GnomeRest gnomeRest : list) {
            people.add(parse(gnomeRest));
        }
        return people;
    }

    public static People parseFromDb(List<GnomeDb> list) {
        People people = new People();
        for(GnomeDb gnomeDb : list) {
            people.add(parse(gnomeDb));
        }
        return people;
    }

    public static GnomeDb parse(Gnome gnome) {
        GnomeDb gnomeDb = new GnomeDb();

        gnomeDb.setId(gnome.getId());
        gnomeDb.setAge(gnome.getAge());
        //gnomeDb.setFriends(gnome.getFriends());
        gnomeDb.setHairColor(gnome.getHairColor());
        gnomeDb.setHeight(gnome.getHeight());
        gnomeDb.setName(gnome.getName());
        //gnomeDb.setProfessions(gnome.getProfessions());
        gnomeDb.setThumbnail(gnome.getThumbnail());
        gnomeDb.setWeight(gnome.getWeight());

        return gnomeDb;
    }

    public static Gnome parse(GnomeRest gnomeRest) {
        Gnome gnome = new Gnome();

        gnome.setId(gnomeRest.getId());
        gnome.setAge(gnomeRest.getAge());
        //gnome.setFriends(gnomeRest.getFriends());
        gnome.setHairColor(gnomeRest.getHairColor());
        gnome.setHeight(gnomeRest.getHeight());
        gnome.setName(gnomeRest.getName());
        //gnome.setProfessions(gnomeRest.getProfessions());
        gnome.setThumbnail(gnomeRest.getThumbnail());
        gnome.setWeight(gnomeRest.getWeight());

        return gnome;
    }

    public static Gnome parse(GnomeDb gnomeDb) {
        Gnome gnome = new Gnome();

        gnome.setId(gnomeDb.getId());
        gnome.setAge(gnomeDb.getAge());
        //gnome.setFriends(gnomeDb.getFriends());
        gnome.setHairColor(gnomeDb.getHairColor());
        gnome.setHeight(gnomeDb.getHeight());
        gnome.setName(gnomeDb.getName());
        //gnome.setProfessions(gnomeDb.getProfessions());
        gnome.setThumbnail(gnomeDb.getThumbnail());
        gnome.setWeight(gnomeDb.getWeight());

        return gnome;
    }

}
