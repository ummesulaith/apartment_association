package info.androidhive.listviewfeed.data;

/**
 * Created by Pavan on 02/10/16.
 */
public class ChurchGroupFeedItem {

    private String churchGrpname;
    private String churchGrpdetails;
    private String churchGrpimage;

    public ChurchGroupFeedItem() {
    }

    public ChurchGroupFeedItem(String churchGrpname, String churchGrpdetails, String churchGrpimage
                   ) {
        super();
        this.churchGrpname = churchGrpname;
        this.churchGrpdetails = churchGrpdetails;
        this.churchGrpimage = churchGrpimage;

    }

    public String getChurchGrpname() {
        return churchGrpname;
    }

    public void setChurchGrpname(String churchGrpname) {
        this.churchGrpname = churchGrpname;
    }

    public String getChurchGrpdetails() {
        return churchGrpdetails;
    }

    public void setChurchGrpdetails(String churchGrpdetails) {
        this.churchGrpdetails = churchGrpdetails;
    }

    public String getChurchGrpimage() {
        return churchGrpimage;
    }

    public void setChurchGrpimage(String churchGrpimage) {
        this.churchGrpimage = churchGrpimage;
    }
}
