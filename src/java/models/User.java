package models;

import java.io.Serializable;

public class User implements Serializable {

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
        this(null, null);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;
}
