package starace.com.staracemeettheteam;

import android.content.Intent;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mstarace on 11/25/17.
 */

public class Presenter implements Contract.Presenter {

    private static final String TAG = Presenter.class.getSimpleName();
    public static final String INTENT_ID_MODEL = "teamMember";

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
        TeamMemberResponseModel teamGsonArray[] = gson.fromJson(TeamMemberJsonString.jsonString, TeamMemberResponseModel[].class);
        List<TeamMemberResponseModel> teamMemberResponseModels = Arrays.asList(teamGsonArray);
        view.setModelList(convertResponseToModel(teamMemberResponseModels));
    }

    /**
     * Converts the response Model that would normally be created on the API call to the Model used for the view.
     * takes away an logic from being in the Model used to populate the view
     * @param responseModels
     * @return
     */
    private List<TeamMemberModel> convertResponseToModel(List<TeamMemberResponseModel> responseModels) {
        List<TeamMemberModel> teamMemberModelList = new ArrayList<>();
        for (TeamMemberResponseModel currentResponseModel : responseModels) {
            TeamMemberModel teamMemberModel = new TeamMemberModel();
            teamMemberModel.setAvatar(currentResponseModel.getAvatar());
            teamMemberModel.setName(currentResponseModel.getFirstName().concat(" ").concat(currentResponseModel.getLastName()));
            teamMemberModel.setTitle(currentResponseModel.getTitle());
            teamMemberModel.setBio(currentResponseModel.getBio());
            teamMemberModel.setId(currentResponseModel.getId());
            teamMemberModelList.add(teamMemberModel);

        }
        return teamMemberModelList;
    }

    @Override
    public void modelClicked(TeamMemberModel model, int position) {
        if(!model.isHasMet()) {
            model.setHasMet(true);
            view.updateModelList(model, position);
        }
        Intent intent = new Intent(view.getActivityContext(), DetailActivity.class);
        intent.putExtra(INTENT_ID_MODEL, model);
        view.getActivityContext().startActivity(intent);
    }
}
