package starace.com.staracemeettheteam;

import android.content.Context;

import java.util.List;

/**
 * Created by mstarace on 11/25/17.
 */

public class Contract {

    public interface View {
        void setModelList(List<TeamMemberModel> memberModelsList);
        Context getActivityContext();
        void updateModelList(TeamMemberModel model, int position);
    }

    public interface Presenter {
        void requestModelList();
        void modelClicked(TeamMemberModel model, int position);
    }
}
