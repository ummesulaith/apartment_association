package info.androidhive.listviewfeed.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.app.AppController;
import info.androidhive.listviewfeed.data.AboutFeedItem;

/**
 * Created by Pavan on 02/10/16.
 */
public class AboutChurchFeedListAdapter extends BaseAdapter{

    private Activity activity;
    private LayoutInflater inflater;
    private List<AboutFeedItem> abtusfeedItems;
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public AboutChurchFeedListAdapter(Activity activity, List<AboutFeedItem> feedItems) {
        this.activity = activity;
        this.abtusfeedItems = feedItems;
    }

    @Override
    public int getCount() {
        return abtusfeedItems.size();
    }

    @Override
    public Object getItem(int location) {
        return abtusfeedItems.get(location);
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
            convertView = inflater.inflate(R.layout.about_feed_item, null);

        if (imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        TextView name = (TextView) convertView.findViewById(R.id.abttitle_id);
//        TextView timestamp = (TextView) convertView
//                .findViewById(R.id.timestamp);
        TextView statusMsg = (TextView) convertView
                .findViewById(R.id.abthistory_id);
//        TextView contactUs = (TextView) convertView.findViewById(R.id.contact_id);
//        NetworkImageView profilePic = (NetworkImageView) convertView
//                .findViewById(R.id.profilePic);
//        FeedImageView feedImageView = (FeedImageView) convertView
//                .findViewById(R.id.feedImage1);

        AboutFeedItem item = abtusfeedItems.get(position);

        name.setText(item.getAbtTitle());

        // Converting timestamp into x ago format
//        CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
//                Long.parseLong(item.getTimeStamp()),
//                System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
//        timestamp.setText(timeAgo);

        // Chcek for empty status message
        if (!TextUtils.isEmpty(item.getAbtHistory())) {
            statusMsg.setText(item.getAbtHistory());
            statusMsg.setVisibility(View.VISIBLE);
        } else {
            // status is empty, remove from view
            statusMsg.setVisibility(View.GONE);
        }

//        if (!TextUtils.isEmpty(item.getContact())) {
//            contactUs.setText(item.getContact());
//            contactUs.setVisibility(View.VISIBLE);
//        } else {
//            // status is empty, remove from view
//            contactUs.setVisibility(View.GONE);
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
//
//        // Feed image
//        if (item.getImge() != null) {
//            feedImageView.setImageUrl(item.getImge(), imageLoader);
//            feedImageView.setVisibility(View.VISIBLE);
//            feedImageView
//                    .setResponseObserver(new FeedImageView.ResponseObserver() {
//                        @Override
//                        public void onError() {
//                        }
//
//                        @Override
//                        public void onSuccess() {
//                        }
//                    });
//        } else {
//            feedImageView.setVisibility(View.GONE);
//        }

        return convertView;
    }
}
