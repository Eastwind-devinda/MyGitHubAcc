package au.elegantmedia.com.mygithubacc.services;

import au.elegantmedia.com.mygithubacc.helpers.Contant;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Devinda on 9/27/17.
 */

public class ServiceGenerator {

    public static GetAccData CreateService() {

        Retrofit client = new Retrofit.Builder()
                .baseUrl(Contant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return client.create(GetAccData.class);
    }
}
