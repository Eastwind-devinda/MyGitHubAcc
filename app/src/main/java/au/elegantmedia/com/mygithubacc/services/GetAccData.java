package au.elegantmedia.com.mygithubacc.services;


import java.util.List;

import au.elegantmedia.com.mygithubacc.models.Repo;
import au.elegantmedia.com.mygithubacc.models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Nisala on 9/22/17.
 */

public interface GetAccData {

    @GET("/users/{user}")
    Call<User> userData(@Path("user") String user);

    @GET("/users/{user}/repos")
    Call<List<Repo>> repoData(@Path("user") String user);

}
