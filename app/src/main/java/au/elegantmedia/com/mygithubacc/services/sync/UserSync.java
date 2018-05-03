package au.elegantmedia.com.mygithubacc.services.sync;

import android.content.Context;

import au.elegantmedia.com.mygithubacc.models.User;
import au.elegantmedia.com.mygithubacc.services.GetAccData;
import au.elegantmedia.com.mygithubacc.services.ServiceGenerator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Devinda on 9/27/17.
 */

public class UserSync {

    private Context context;

    public UserSync(Context context) {
        this.context = context;
    }

    public void getUserDetails(final UserGetCallback callback, String loginName) {

        GetAccData api = ServiceGenerator.CreateService();

        Call<User> call = api.userData(loginName);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.isSuccessful()) {
                    if (response.body() != null)
                        callback.onGetUserSuccess(response.body());
                } else {
                    callback.onGetUserFails(response.body().message);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                callback.onGetUserFails("Request Error");
            }
        });

    }

    public interface UserGetCallback {
        void onGetUserSuccess(User response);

        void onGetUserFails(String massege);
    }
}


