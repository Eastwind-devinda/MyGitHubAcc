package au.elegantmedia.com.mygithubacc.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import au.elegantmedia.com.mygithubacc.R;
import au.elegantmedia.com.mygithubacc.models.Repo;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Devinda on 9/28/17.
 */

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.ViewHolder> {

    List<Repo> list;
    Context context;

    public RepoAdapter(List<Repo> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Repo repo = list.get(position);

        holder.mName.setText(repo.name);
        holder.mUrl.setText(repo.url);
        holder.mDes.setText(repo.description);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_id)
        TextView mDes;
        @BindView(R.id.txt_name)
        TextView mName;
        @BindView(R.id.txt_url)
        TextView mUrl;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
