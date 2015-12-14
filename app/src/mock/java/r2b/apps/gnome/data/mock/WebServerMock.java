package r2b.apps.gnome.data.mock;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import java.io.IOException;

import okio.Buffer;
import r2b.apps.gnome.BaseApplication;
import r2b.apps.gnome.R;
import r2b.apps.gnome.data.rest.api.BrastlewarkService;

/**
 * Mocks a web server.
 */
public class WebServerMock {

    private MockWebServer server;

    public WebServerMock() throws IOException {
        server = new MockWebServer();
        Buffer buffer = new Buffer().readFrom(BaseApplication.getContext().getAssets().open("data.json"));
        server.enqueue(new MockResponse().setBody(buffer));

        server.start();

        server.url(BaseApplication.getContext().getResources().getString(R.string.backend_brastlewark)
                + BrastlewarkService.GET_BRASTLEWARK_LIST_PATH);

    }

    public void shutdown() throws IOException {
        server.shutdown();
    }

}
