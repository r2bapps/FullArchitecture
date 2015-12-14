package r2b.apps.gnome.data.rest.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class BrastlewarkRest {

    @SerializedName("Brastlewark")
    @Expose
    private List<GnomeRest> people = new ArrayList<GnomeRest>();

    public List<GnomeRest> getPeople() {
        return people;
    }

    public void setPeople(List<GnomeRest> people) {
        this.people = people;
    }

}
