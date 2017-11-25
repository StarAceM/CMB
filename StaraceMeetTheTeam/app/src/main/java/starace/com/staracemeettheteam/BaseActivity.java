package starace.com.staracemeettheteam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

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
        initToolbar();
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.base_toolbar);
    }

    public void setToolbar(ToolbarType toolbarType) {
        switch (toolbarType) {
            case MAIN:
                toolbar.setTitle(getString(R.string.main_activity_title));
                break;
            case DETAIL:
                toolbar.setTitle(getString(R.string.detail_activity_title));
                toolbar.setNavigationIcon(getDrawable(R.drawable.ic_back_arrow));
                toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                });
                break;
            default:
                break;
        }

        setSupportActionBar(toolbar);

    }
}
