package au.elegantmedia.com.mygithubacc.services.Request;

/**
 * Created by Devinda on 9/27/17.
 */

public class LoginRequest {

    public String Username;

    public LoginRequest(String loginname) {
        this.Username = loginname;
    }

    public String getUsername() {
        return Username;
    }
}
