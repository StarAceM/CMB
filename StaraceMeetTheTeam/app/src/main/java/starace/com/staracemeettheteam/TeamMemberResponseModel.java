package starace.com.staracemeettheteam;

/**
 * Created by mstarace on 11/25/17.
 */

public class TeamMemberResponseModel {

    private String avatar;
    private String firstName;
    private String lastName;
    private String title;
    private String id;
    private String bio;

    public TeamMemberResponseModel(String avatar, String firstName, String lastName, String title, String id, String bio) {
        this.avatar = avatar;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.id = id;
        this.bio = bio;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
}
