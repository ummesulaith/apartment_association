package info.androidhive.listviewfeed.data;

/**
 * Created by Pavan on 10/10/2016.
 */
public class DailyReadFeedItem {

    private String read_msg, image;

    public  DailyReadFeedItem(){


    }
    public String getRead_msg() {
        return read_msg;
    }

    public void setRead_msg(String read_msg) {
        this.read_msg = read_msg;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public DailyReadFeedItem(String image, String read_msg) {

        super();
        this.image = image;
        this.read_msg = read_msg;
    }
}
