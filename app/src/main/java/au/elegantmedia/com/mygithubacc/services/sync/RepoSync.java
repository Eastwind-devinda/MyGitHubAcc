package au.elegantmedia.com.mygithubacc.services.sync;

import android.content.Context;

import java.util.List;

import au.elegantmedia.com.mygithubacc.models.Repo;
import au.elegantmedia.com.mygithubacc.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Devinda on 9/27/17.
 */

public class RepoSync {

    private Context context;

    public RepoSync(Context context) {
        this.context = context;
    }

    public void getRepoDetails(final RepoGetCallback callback, String loginName) {

        ServiceGenerator
                .CreateService()
                .repoData(loginName)
                .enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {

                        if (response.isSuccessful()) {
                            if (response.body() != null)
                                callback.onGetRepoSuccess(response.body());
                        } else {
                            callback.onGetRepoFails("Fail");
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {
                        callback.onGetRepoFails("Request Error");
                    }
                });

    }


    public interface RepoGetCallback {
        void onGetRepoSuccess(List<Repo> repoResponse);

        void onGetRepoFails(String massege);
    }

}
