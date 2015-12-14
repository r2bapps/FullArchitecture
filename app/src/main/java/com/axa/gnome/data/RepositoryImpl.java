package com.axa.gnome.data;

import android.support.annotation.NonNull;

import java.util.List;

import com.axa.gnome.data.rest.RestSource;
import com.axa.gnome.data.rest.entity.GnomeRest;
import com.axa.gnome.domain.Mapper;
import com.axa.gnome.domain.Repository;
import com.axa.gnome.domain.model.People;

public class RepositoryImpl implements Repository {

    private final RestSource restSource;

    public RepositoryImpl(@NonNull RestSource restSource) {

        // PRECONDITIONS
        if (restSource == null) {
            throw new IllegalArgumentException("RestSource can not be null");
        }

        this.restSource = restSource;
    }

    @Override
    public People getPeople() {
        People people = new People();
        List<GnomeRest> retrievedPeople = restSource.getBrastlewark();
        people.addAll(Mapper.parse(retrievedPeople));
        return people;
    }

}
