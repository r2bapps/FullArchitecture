package r2b.apps.gnome.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class People extends ArrayList<Gnome> implements List<Gnome> {

    private static final Comparator<Gnome> OrderByName = new Comparator<Gnome>() {
        @Override
        public int compare(Gnome gnome, Gnome gnomeToCompare) {
            return gnome.getName().compareTo(gnomeToCompare.getName());
        }
    };

    private static final Comparator<Gnome> OrderById = new Comparator<Gnome>() {
        @Override
        public int compare(Gnome gnome, Gnome gnomeToCompare) {
            return gnome.getId().compareTo(gnomeToCompare.getId());
        }
    };

    public void sortByName() {
        Collections.sort(this, OrderByName);
    }

    public void sortById() {
        Collections.sort(this, OrderById);
    }

    @Override
    public boolean equals(Object o) {
        People p = (People) o;

        if (p == null) {
            return false;
        }

        if(this.size() != p.size()) {
            return false;
        }

        for (int i = 0; i < this.size(); i++) {
            if(this.get(i) == null) {
                if (p.get(i) != null) {
                    return false;
                }
            } else {
                if (!this.get(i).equals(p.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
