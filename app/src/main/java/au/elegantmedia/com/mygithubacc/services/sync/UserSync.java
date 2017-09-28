package au.elegantmedia.com.mygithubacc.services.sync;

import android.content.Context;
import android.widget.Toast;

import au.elegantmedia.com.mygithubacc.models.User;
import au.elegantmedia.com.mygithubacc.services.GetAccData;
import au.elegantmedia.com.mygithubacc.services.Request.LoginRequest;
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

    public void getUserDetails(final UserGetCallback callback, LoginRequest loginRequest) {

        GetAccData api = ServiceGenerator.CreateService();

        Call<User> call = api.userData(loginRequest.Username);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

//                Log.i(Contant.TAG, Uri.parse(response.body()
//                        .getAvatar_url()) + response.body()
//                        .getPublic_repos() + response.body().getLocation() + response.body()
//                        .getName() + response.body().getLogin() + response.body().getCompany());

//                User user = new User();
//                user.login = response.body().getLogin();
//                user.avatar_url = response.body().getAvatar_url();
//                user.name = response.body().getName();
//                user.company = response.body().getCompany();
//                user.location = response.body().getLocation();
//                user.public_repos = response.body().getPublic_repos();

                if (response.body() != null) {
                    callback.onGetUserSuccess(response.body());
                } else {
                    callback.onGetUserFails("Fail");
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public interface UserGetCallback {
        void onGetUserSuccess(User response);

        void onGetUserFails(String massege);
    }
}


