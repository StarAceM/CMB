package starace.com.staracemeettheteam;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by mstarace on 11/25/17.
 */

public class BaseActivity extends AppCompatActivity {

    private Toolbar toolbar;

    public enum ToolbarType {
        MAIN, DETAIL
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        LinearLayout baseLayout = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout content = (FrameLayout) baseLayout.findViewById(R.id.base_content_main);
        getLayoutInflater().inflate(layoutResID, content, true);
        super.setContentView(baseLayout);
        initToolbar();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.base_toolbar);
    }

    public void setToolbar(ToolbarType toolbarType) {
        TextView title = (TextView) toolbar.findViewById(R.id.base_toolbar_title);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        switch (toolbarType) {
            case MAIN:
                title.setText(getString(R.string.main_activity_title));
                break;
            case DETAIL:
                title.setText(getString(R.string.detail_activity_title));
                toolbar.setNavigationIcon(getDrawable(R.drawable.ic_back_arrow));
                break;
            default:
                break;
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("BaseActivity", "Has BEEN CLICKED");
        finish();
        return true;
    }
}
