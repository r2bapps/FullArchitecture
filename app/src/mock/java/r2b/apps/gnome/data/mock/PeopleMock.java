package r2b.apps.gnome.data.mock;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import r2b.apps.gnome.BaseApplication;
import r2b.apps.gnome.data.rest.entity.BrastlewarkRest;
import r2b.apps.gnome.data.rest.entity.GnomeRest;
import r2b.apps.gnome.domain.Mapper;
import r2b.apps.gnome.domain.model.People;

/**
 * Mocks people from JSON file.
 */
public final class PeopleMock {

    public static People getPeople() throws IOException {
        Reader reader = new BufferedReader(
                new InputStreamReader(BaseApplication.getContext().getAssets().open("data.json"), "UTF-8"));
        List<GnomeRest> list = new Gson().fromJson(reader, BrastlewarkRest.class).getPeople();
        return Mapper.parse(list);
    }

}
