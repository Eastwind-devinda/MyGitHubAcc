package au.elegantmedia.com.mygithubacc.models;

import java.security.acl.Owner;

/**
 * Created by Devinda on 9/28/17.
 */


public class Repo {

    public String id;
    public String name;
    public String url;
    public String description;

    public Repo() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }
}
