package starace.com.staracemeettheteam;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by mstarace on 11/25/17.
 */

public class TeamMemberModel implements Parcelable {

    private String avatar;
    private String name;
    private String title;
    private String id;
    private String bio;
    private boolean hasMet;

    public TeamMemberModel() {
    }

    public TeamMemberModel(String avatar, String name, String title, String id, String bio) {
        this.avatar = avatar;
        this.name = name;
        this.title = title;
        this.id = id;
        this.bio = bio;
    }

    public static final Parcelable.Creator<TeamMemberModel> CREATOR = new Parcelable.Creator<TeamMemberModel>() {
        @Override
        public TeamMemberModel createFromParcel(Parcel parcel) {
            return new TeamMemberModel(parcel);
        }

        @Override
        public TeamMemberModel[] newArray(int size) {
            return new TeamMemberModel[size];
        }
    };

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public boolean isHasMet() {
        return hasMet;
    }

    public void setHasMet(boolean hasMet) {
        this.hasMet = hasMet;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeStringArray(new String[]{
                this.avatar,
                this.name,
                this.title,
                this.id,
                this.bio
        });
    }

    public TeamMemberModel(Parcel in) {
        String[] data = new String[5];
        in.readStringArray(data);
        this.avatar = data[0];
        this.name = data[1];
        this.title = data[2];
        this.id = data[3];
        this.bio = data[4];
    }


}
