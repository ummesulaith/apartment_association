package info.androidhive.listviewfeed.data;

/**
 * Created by Pavan on 02/10/16.
 */
public class AboutFeedItem {

    private String abtTitle;
    private String abtContact;
    private String abtHistory;


    public AboutFeedItem() {
    }

    public AboutFeedItem( String name, String history, String contact) {
        super();

        this.abtTitle = name;
        this.abtContact = history;
        this.abtHistory = contact;
    }
    public String getAbtHistory() {
        return abtHistory;
    }

    public void setAbtHistory(String abtHistory) {
        this.abtHistory = abtHistory;
    }

    public String getAbtTitle() {
        return abtTitle;
    }

    public void setAbtTitle(String abtTitle) {
        this.abtTitle = abtTitle;
    }

    public String getAbtContact() {
        return abtContact;
    }

    public void setAbtContact(String abtContact) {
        this.abtContact = abtContact;
    }






}
