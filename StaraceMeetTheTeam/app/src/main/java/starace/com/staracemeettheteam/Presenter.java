package starace.com.staracemeettheteam;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mstarace on 11/25/17.
 */

public class Presenter implements Contract.Presenter {

    private static final String TAG = Presenter.class.getSimpleName();

    private Contract.View view;

    public static Contract.Presenter newPresenterInstance(Contract.View view) {
        return new Presenter(view);
    }

    public Presenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void requestModelList() {
        Gson gson = new Gson();
        TeamMemberModel teamGsonArray[] = gson.fromJson(TeamMemberJsonString.jsonString, TeamMemberModel[].class);
        List<TeamMemberModel> teamMemberModelList = Arrays.asList(teamGsonArray);
    }
    
    @Override
    public void modelClicked() {

    }
}
