package info.androidhive.listviewfeed.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

//import info.androidhive.listviewfeed.imagelibrary.ChurchNewsFeedImageView;
import info.androidhive.listviewfeed.imagelibrary.DailyReadFeedImageView;
import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.app.AppController;
import info.androidhive.listviewfeed.data.DailyReadFeedItem;

/**
 * Created by Pavan on 10/10/2016.
 */
public class DailyReadFeedListAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<DailyReadFeedItem> dailyReadfeedItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public DailyReadFeedListAdapter(Activity activity, List<DailyReadFeedItem> feedItems) {
        this.activity = activity;
        this.dailyReadfeedItems = feedItems;
    }

    @Override
    public int getCount() {
        return dailyReadfeedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return dailyReadfeedItems.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.daily_read_feed_item, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        TextView readmsg = (TextView) convertView.findViewById(R.id.readmsg_id);
//        TextView timestamp = (TextView) convertView
//                .findViewById(R.id.timestamp);
//        TextView newdetails = (TextView) convertView
//                .findViewById(R.id.news_details);
//        TextView url = (TextView) convertView.findViewById(R.id.txtUrl);
//        NetworkImageView profilePic = (NetworkImageView) convertView
//                .findViewById(R.id.profilePic);
        DailyReadFeedImageView feedImageView = (DailyReadFeedImageView) convertView
                .findViewById(R.id.dailyread_feedimageview);

        DailyReadFeedItem item = dailyReadfeedItems.get(position);

        readmsg.setText(item.getRead_msg());

        // Converting timestamp into x ago format
//        CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
//                Long.parseLong(item.getTimeStamp()),
//                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
//        timestamp.setText(timeAgo);

        // Chcek for empty status message
//        if (!TextUtils.isEmpty(item.getNews_details())) {
//            newdetails.setText(item.getNews_details());
//            newdetails.setVisibility(View.VISIBLE);
//        } else {
//            // status is empty, remove from view
//            newdetails.setVisibility(View.GONE);
//        }

        // Checking for null feed url
//        if (item.getUrl() != null) {
//            url.setText(Html.fromHtml("<a href=\"" + item.getUrl() + "\">"
//                    + item.getUrl() + "</a> "));
//
//            // Making url clickable
//            url.setMovementMethod(LinkMovementMethod.getInstance());
//            url.setVisibility(View.VISIBLE);
//        } else {
//            // url is null, remove from the view
//            url.setVisibility(View.GONE);
//        }

        // user profile pic
//        profilePic.setImageUrl(item.getProfilePic(), imageLoader);

        // Feed image
        if (item.getImage() != null) {
            feedImageView.setImageUrl(item.getImage(), imageLoader);
            feedImageView.setVisibility(View.VISIBLE);
            feedImageView
                    .setResponseObserver(new DailyReadFeedImageView.ResponseObserver() {
                        @Override
                        public void onError() {
                        }

                        @Override
                        public void onSuccess() {
                        }
                    });
        } else {
            feedImageView.setVisibility(View.GONE);
        }

        return convertView;
    }
}
