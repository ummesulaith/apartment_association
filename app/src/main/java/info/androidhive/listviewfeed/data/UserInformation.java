package info.androidhive.listviewfeed.data;

/**
 * Created by Umme on 28-Feb-17.
 */

public class UserInformation {
    public String name;
    public String username;
    public String email;
    public String contact;
    public String flatno;



    public UserInformation(String name, String username, String flatno, String email, String contact) {
        this.name = name;
        this.username = username;
        this.flatno=flatno;
        this.email=email;
        this.contact=contact;
    }
}


