package r2b.apps.gnome.data.strategy.sync;


import java.util.List;

import r2b.apps.gnome.data.db.entity.GnomeDb;
import r2b.apps.gnome.data.strategy.SyncStrategy;

/**
 * Priorization between rest response and db information. Higest priority is rest responses.
 * This is avery basic example of how to implement a synchronization strategy.
 */
public class PriorityRestSyncStrategy implements SyncStrategy<GnomeDb> {

    @Override
    public GnomeDb apply(GnomeDb retrieved, GnomeDb stored) {
        return retrieved;
    }

    @Override
    public List<GnomeDb> apply(List<GnomeDb> retrieved, List<GnomeDb> stored) {
        return retrieved;
    }

}
