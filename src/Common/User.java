package Common;

import java.io.Serializable;

/**
 * Created by bouguerr on 31/05/2017.
 */
public class User implements Serializable {
    private String login;
    private String password;
    private boolean isLogged;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
        this.isLogged = false;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public void setLogged(boolean logged) {
        isLogged = logged;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
