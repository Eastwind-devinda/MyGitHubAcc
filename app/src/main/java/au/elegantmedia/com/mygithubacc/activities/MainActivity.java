package au.elegantmedia.com.mygithubacc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import au.elegantmedia.com.mygithubacc.R;
import au.elegantmedia.com.mygithubacc.models.User;
import au.elegantmedia.com.mygithubacc.services.Request.LoginRequest;
import au.elegantmedia.com.mygithubacc.services.sync.UserSync;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements UserSync.UserGetCallback {

    @BindView(R.id.avatar)
    ImageView mImageView;
    @BindView(R.id.login_name)
    TextView mLogin;
    @BindView(R.id.tv_name)
    TextView mName;
    @BindView(R.id.tv_company)
    TextView mCompany;
    @BindView(R.id.tv_location)
    TextView mLocation;
    @BindView(R.id.tv_repo)
    TextView mRepo;

    UserSync userSync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String username = intent.getStringExtra("UserName");


        userSync = new UserSync(this);
        LoginRequest loginRequest = new LoginRequest(username);
        userSync.getUserDetails(this, loginRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.user_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int getItem = item.getItemId();

        if (getItem == R.id.user_select) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onGetUserSuccess(User user) {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();

        mLogin.setText(user.login);
        Picasso.with(getApplication()).load(user.avatar_url).into(mImageView);
        mName.setText(user.name);
        mCompany.setText(user.company);
        mLocation.setText(user.location);
        mRepo.setText(user.public_repos);
    }

    @Override
    public void onGetUserFails(String massege) {
        Toast.makeText(this, massege, Toast.LENGTH_SHORT).show();
    }
}

