package JaLaba4.Task4;
import java.io.*;
import java.util.Scanner;

public class User implements Serializable {
    private String name;
    private String login;
    private String password;

    public User(){
        name = "judge";
        login = "admin";
        password = "1111";
    }

    public User(String n, String l, String p){
        name = n;
        login = l;
        password = p;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return name + " " + login +" " + password;
    }
}
