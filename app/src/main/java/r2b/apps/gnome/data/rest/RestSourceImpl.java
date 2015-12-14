package r2b.apps.gnome.data.rest;

import java.util.List;

import r2b.apps.gnome.BaseApplication;
import r2b.apps.gnome.R;
import r2b.apps.gnome.data.rest.api.BrastlewarkService;
import r2b.apps.gnome.data.rest.entity.BrastlewarkRest;
import r2b.apps.gnome.data.rest.entity.GnomeRest;
import retrofit.RestAdapter;

public class RestSourceImpl implements RestSource {

    private static final String TAG = "RestSourceImpl";


    private final BrastlewarkService service;

    public RestSourceImpl() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BaseApplication.getContext().getResources().getString(R.string.backend_brastlewark))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();

        service = restAdapter.create(BrastlewarkService.class);
    }

    @Override
    public List<GnomeRest> getBrastlewark() {
        BrastlewarkRest brastlewarkRest = service.getBrastlewark();
        return brastlewarkRest.getPeople();
    }

}
