package au.elegantmedia.com.mygithubacc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import au.elegantmedia.com.mygithubacc.R;
import au.elegantmedia.com.mygithubacc.services.Request.LoginRequest;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.edt_user_name)
    EditText mLoginName;

    @OnClick(R.id.btn_login)
    public void login() {

        String loginname = mLoginName.getText().toString().trim();
        if (!loginname.equals("")) {
            Intent loginIntent = new Intent(this, MainActivity.class);
            loginIntent.putExtra("UserName", loginname);
            startActivity(loginIntent);
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
    }
}
