package r2b.apps.gnome;


import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import java.io.IOException;

import okio.Buffer;
import r2b.apps.gnome.data.db.DbSource;
import r2b.apps.gnome.data.db.DbSourceImpl;
import r2b.apps.gnome.data.rest.RestSource;
import r2b.apps.gnome.data.rest.RestSourceImpl;
import r2b.apps.gnome.data.rest.api.BrastlewarkService;
import r2b.apps.gnome.data.strategy.CachingStrategy;
import r2b.apps.gnome.data.strategy.SyncStrategy;
import r2b.apps.gnome.data.strategy.cache.TimeCachingStrategy;
import r2b.apps.gnome.data.strategy.sync.PriorityRestSyncStrategy;

public final class DependencyManager {

    private static final DependencyManager INSTANCE = new DependencyManager();
    private final RestSource restSource;
    private final DbSource dbSource;
    private final CachingStrategy cachingStrategy;
    private final SyncStrategy syncStrategy;

    private MockWebServer server;

    private DependencyManager() {
        initMockServer();

        // Mocked with web service
        restSource = new RestSourceImpl();
        dbSource = new DbSourceImpl();
        // Mocked with low delay
        cachingStrategy =
                new TimeCachingStrategy(BaseApplication.getContext().getResources()
                        .getInteger(R.integer.cache_delay_time_milli));
        syncStrategy = new PriorityRestSyncStrategy();
    }

    private void initMockServer() {
        try {
            server = new MockWebServer();
            Buffer buffer = new Buffer().readFrom(BaseApplication.getContext().getAssets().open("data.json"));
            server.enqueue(new MockResponse().setBody(buffer));

            server.start();

            server.url(BaseApplication.getContext().getResources().getString(R.string.backend_brastlewark)
                    + BrastlewarkService.GET_BRASTLEWARK_LIST_PATH);
        } catch (IOException e) {
            Logger.e("DependencyManager", e.getMessage(), e);
        }
    }

    /**
     * Rest source dependency.
     * @return RestSource. Never null.
     */
    public static RestSource getRestSource() {
        return INSTANCE.restSource;
    }

    /**
     * Database source dependency.
     * @return DbSource. Never null.
     */
    public static DbSource getDbSource() {
        return INSTANCE.dbSource;
    }

    /**
     * Caching strategy dependency.
     * @return CachingStrategy. Never null.
     */
    public static CachingStrategy getCachingStrategy() {
        return INSTANCE.cachingStrategy;
    }

    /**
     * Synchronization strategy dependency.
     * @return SyncStrategy. Never null.
     */
    public static SyncStrategy getSyncStrategy() {
        return INSTANCE.syncStrategy;
    }

}
