package info.androidhive.listviewfeed.data;

/**
 * Created by Umme on 28-Feb-17.
 */

public class AddComplaint {
    public String imp;
    public String subject;
    public String describ;
    public String complaint_type;
    public String priority;


    public AddComplaint(String imp, String subject, String describ,String complaint_type,String priority) {
        this.imp = imp;
        this.subject = subject;
        this.describ = describ;
        this.complaint_type = complaint_type;
        this.priority = priority;
    }
}
