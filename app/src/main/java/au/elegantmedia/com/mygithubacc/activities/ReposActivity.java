package au.elegantmedia.com.mygithubacc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import au.elegantmedia.com.mygithubacc.R;
import au.elegantmedia.com.mygithubacc.adapters.RepoAdapter;
import au.elegantmedia.com.mygithubacc.models.Repo;
import au.elegantmedia.com.mygithubacc.services.Request.LoginRequest;
import au.elegantmedia.com.mygithubacc.services.sync.RepoSync;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ReposActivity extends AppCompatActivity implements RepoSync.RepoGetCallback {

    @BindView(R.id.repo_listview)
    RecyclerView mRecyclerView;
    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    RecyclerView.Adapter adapter;
    List<Repo> repoList;
    RepoSync repoSync;
    LoginRequest loginRequest;
    Repo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repos);
        ButterKnife.bind(this);

        progressBar.setVisibility(View.VISIBLE);

        Intent intent = getIntent();
        String username = intent.getStringExtra("userName");

        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        loginRequest = new LoginRequest(username);

        repoList = new ArrayList<>();
        repoSync = new RepoSync(this);
        repoSync.getRepoDetails(this, loginRequest);
    }

    @Override
    public void onGetRepoSuccess(List<Repo> repoResponse) {

        for (int i = 0; i < repoResponse.size(); i++) {
            repo = new Repo();

            repo.name = repoResponse.get(i).getName();
            repo.url = repoResponse.get(i).getUrl();
            repo.description = repoResponse.get(i).getDescription();

            repoList.add(repo);

            progressBar.setVisibility(View.INVISIBLE);

            adapter = new RepoAdapter(repoList, getApplicationContext());
            mRecyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onGetRepoFails(String massege) {
        Toast.makeText(this, massege, Toast.LENGTH_SHORT).show();
    }
}
