package r2b.apps.gnome.data;

import android.support.annotation.NonNull;

import java.util.List;

import r2b.apps.gnome.data.rest.RestSource;
import r2b.apps.gnome.data.rest.entity.GnomeRest;
import r2b.apps.gnome.domain.Mapper;
import r2b.apps.gnome.domain.Repository;
import r2b.apps.gnome.domain.model.People;

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
