package au.elegantmedia.com.mygithubacc.models;

import java.io.Serializable;

/**
 * Created by Devinda on 9/22/17.
 */

public class User implements Serializable {

    public String login;
    public String avatar_url;
    public String name;
    public String company;
    public String location;
    public String public_repos;

    public String getLogin() {
        return login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getPublic_repos() {
        return public_repos;
    }
}
