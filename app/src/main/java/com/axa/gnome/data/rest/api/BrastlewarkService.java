package com.axa.gnome.data.rest.api;


import com.axa.gnome.data.rest.entity.BrastlewarkRest;
import retrofit.http.GET;

public interface BrastlewarkService {

    // Usefull for accessing paths when testing
    String GET_BRASTLEWARK_LIST_PATH = "/mobilefactory-test/master/data.json";

    @GET(GET_BRASTLEWARK_LIST_PATH)
    BrastlewarkRest getBrastlewark();

}
