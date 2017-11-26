package starace.com.staracemeettheteam;

import java.util.List;

/**
 * Created by mstarace on 11/25/17.
 */

public class Contract {

    public interface View {
        void setModelList(List<TeamMemberModel> memberModelsList);
    }

    public interface Presenter {
        void requestModelList();
        void modelClicked();
    }
}
