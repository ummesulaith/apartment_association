package info.androidhive.listviewfeed.data;

/**
 * Created by Pavan on 10/10/2016.
 */
public class ChurchNewsFeedItem {

    private String news_title,news_details,news_image;


    public  ChurchNewsFeedItem(){


    }
    public ChurchNewsFeedItem(String news_title, String news_details, String news_image) {

        super();
        this.news_title = news_title;
        this.news_details = news_details;
        this.news_image = news_image;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_details() {
        return news_details;
    }

    public void setNews_details(String news_details) {
        this.news_details = news_details;
    }

    public String getNews_image() {
        return news_image;
    }

    public void setNews_image(String news_image) {
        this.news_image = news_image;
    }
}
