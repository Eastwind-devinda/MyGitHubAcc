package au.elegantmedia.com.mygithubacc.services.Request;

/**
 * Created by Devinda on 9/27/17.
 */

public class UserRequest {

    public String login;
    public String avatar_url;
    public String name;
    public String company;
    public String location;
    public String public_repos;

    public UserRequest() {
    }

    public UserRequest(String login, String avatar_url, String name, String company, String location, String public_repos) {
        this.login = login;
        this.avatar_url = avatar_url;
        this.name = name;
        this.company = company;
        this.location = location;
        this.public_repos = public_repos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPublic_repos(String public_repos) {
        this.public_repos = public_repos;
    }
}
