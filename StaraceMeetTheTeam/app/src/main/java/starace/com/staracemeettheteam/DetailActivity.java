package starace.com.staracemeettheteam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by mstarace on 11/25/17.
 */

public class DetailActivity extends BaseActivity {

    private TeamMemberModel model;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setToolbar(ToolbarType.DETAIL);
        model = getIntent().getParcelableExtra(Presenter.INTENT_ID_MODEL);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initViews();
    }

    private void initViews() {
        ImageView avatarView = (ImageView) findViewById(R.id.detail_avatar);
        TextView nameView = (TextView) findViewById(R.id.detail_name);
        TextView titleView = (TextView) findViewById(R.id.detail_title);
        TextView bioView = (TextView) findViewById(R.id.details_bio);

        loadAvatar(avatarView, model);
        nameView.setText(model.getName());
        titleView.setText(model.getTitle());
        bioView.setText(model.getBio());

    }

    private void loadAvatar(final ImageView view, TeamMemberModel model) {
        Picasso.with(this)
                .load(model.getAvatar())
                .resize(500, 500)
                .centerCrop()
                .error(R.drawable.default_avatar_175_175)
                .into(view);
    }
}
