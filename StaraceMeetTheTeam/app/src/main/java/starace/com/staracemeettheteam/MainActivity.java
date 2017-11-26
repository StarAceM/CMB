package starace.com.staracemeettheteam;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

public class MainActivity extends BaseActivity implements Contract.View {

    private Contract.Presenter presenter;
    private TeamMemberAdapter adapter;
    private ProgressBar progressBar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar(ToolbarType.MAIN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initPresenter();
        initList();
    }

    /**
     * progress bar used as if the data to populate the view was coming from a network call
     */
    private void initProgressBar() {
        progressBar = (ProgressBar) findViewById(R.id.main_progress_bar);
        progressBar.setVisibility(View.VISIBLE);
    }

    private void initPresenter() {
        if (presenter == null) {
            presenter = Presenter.newPresenterInstance(this);
        }
    }

    private void initList() {
        if (adapter == null) {
            initProgressBar();
            presenter.requestModelList();
        }
    }

    @Override
    public void setModelList(List<TeamMemberModel> memberModelsList) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.main_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TeamMemberAdapter(memberModelsList, presenter);
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public Context getActivityContext() {
        return this;
    }

    @Override
    public void updateModelList(TeamMemberModel model, int position) {
        adapter.notifyItemChanged(position, model);
    }
}
