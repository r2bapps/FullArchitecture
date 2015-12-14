package r2b.apps.gnome.domain;

import r2b.apps.gnome.domain.model.People;

public interface Repository {

    /**
     * Gets the people.
     * @return People. Never null.
     */
    People getPeople();

}
