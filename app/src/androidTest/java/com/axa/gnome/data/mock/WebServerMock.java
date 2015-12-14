package com.axa.gnome.data.mock;

import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.MockWebServer;

import java.io.IOException;

import com.axa.gnome.BaseApplication;
import com.axa.gnome.R;
import com.axa.gnome.data.rest.api.BrastlewarkService;
import okio.Buffer;

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
