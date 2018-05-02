package au.elegantmedia.com.mygithubacc.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import au.elegantmedia.com.mygithubacc.R;
import au.elegantmedia.com.mygithubacc.helpers.Constant;
import au.elegantmedia.com.mygithubacc.models.User;
import au.elegantmedia.com.mygithubacc.services.sync.UserSync;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements UserSync.UserGetCallback {


    @BindView(R.id.edt_user_name)
    EditText mLoginName;

    ProgressDialog progressBar;

    @OnClick(R.id.btn_login)
    public void login() {

        String loginname = mLoginName.getText().toString().trim();
        if (!loginname.equals("")) {
            progressBar.show();
            UserSync userSync = new UserSync(this);
            userSync.getUserDetails(this, loginname);
        } else {
            mLoginName.setError("User name required");
            mLoginName.requestFocus();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        progressBar = new ProgressDialog(this);
        progressBar.setCancelable(false);
        progressBar.setMessage("Loading...");
    }

    @Override
    public void onGetUserSuccess(User user) {
        progressBar.dismiss();
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra(Constant.USER_EXTRA, user);
        startActivity(intent);
        finish();
    }

    @Override
    public void onGetUserFails(String massege) {
        progressBar.dismiss();
        Toast.makeText(this, massege, Toast.LENGTH_SHORT).show();
    }
}
