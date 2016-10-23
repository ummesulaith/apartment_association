package info.androidhive.listviewfeed.adapter;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

//import info.androidhive.listviewfeed.imagelibrary.FeedImageView;
import info.androidhive.listviewfeed.imagelibrary.CharityInfoFeedImageView;
import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.app.AppController;
import info.androidhive.listviewfeed.data.CharityInfoFeedItem;
//import info.androidhive.listviewfeed.data.FeedItem;

public class CharityInfoFeedListAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<CharityInfoFeedItem> feedItems;
	ImageLoader imageLoader = AppController.getInstance().getImageLoader();

	public CharityInfoFeedListAdapter(Activity activity, List<CharityInfoFeedItem> feedItems) {
		this.activity = activity;
		this.feedItems = feedItems;
	}

	@Override
	public int getCount() {
		return feedItems.size();
	}

	@Override
	public Object getItem(int location) {
		return feedItems.get(location);
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
			convertView = inflater.inflate(R.layout.charity_info_feed_item, null);

		if (imageLoader == null)
			imageLoader = AppController.getInstance().getImageLoader();

		TextView chairityname = (TextView) convertView.findViewById(R.id.charityname_id);
//		TextView timestamp = (TextView) convertView
//				.findViewById(R.id.timestamp);
		TextView charitystatusMsg = (TextView) convertView
				.findViewById(R.id.charitystatus_id);
		TextView url = (TextView) convertView.findViewById(R.id.charityurl_id);
//		NetworkImageView profilePic = (NetworkImageView) convertView
//				.findViewById(R.id.profilePic);
		CharityInfoFeedImageView feedImageView = (CharityInfoFeedImageView) convertView
				.findViewById(R.id.charityfeedimageview);

		CharityInfoFeedItem item = feedItems.get(position);

		chairityname.setText(item.getName());

		// Converting timestamp into x ago format
//		CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
//				Long.parseLong(item.getTimeStamp()),
//				System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
//		timestamp.setText(timeAgo);

		// Chcek for empty status message
		if (!TextUtils.isEmpty(item.getStatus())) {
			charitystatusMsg.setText(item.getStatus());
			charitystatusMsg.setVisibility(View.VISIBLE);
		} else {
			// status is empty, remove from view
			charitystatusMsg.setVisibility(View.GONE);
		}

		// Checking for null feed url
		if (item.getUrl() != null) {
			url.setText(Html.fromHtml("<a href=\"" + item.getUrl() + "\">"
					+ item.getUrl() + "</a> "));

			// Making url clickable
			url.setMovementMethod(LinkMovementMethod.getInstance());
			url.setVisibility(View.VISIBLE);
		} else {
			// url is null, remove from the view
			url.setVisibility(View.GONE);
		}

		// user profile pic
//		profilePic.setImageUrl(item.getProfilePic(), imageLoader);

		// Feed image
		if (item.getImage() != null) {
			feedImageView.setImageUrl(item.getImage(), imageLoader);
			feedImageView.setVisibility(View.VISIBLE);
			feedImageView
					.setResponseObserver(new CharityInfoFeedImageView.ResponseObserver() {
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
