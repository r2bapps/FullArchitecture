package com.axa.gnome.domain;

import com.axa.gnome.domain.model.People;

public interface Repository {

    /**
     * Gets the people.
     * @return People. Never null.
     */
    People getPeople();

}
