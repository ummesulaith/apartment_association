package info.androidhive.listviewfeed.fragment;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.activity.MainActivity;
import info.androidhive.listviewfeed.adapter.DailyReadFeedListAdapter;
import info.androidhive.listviewfeed.app.AppController;
import info.androidhive.listviewfeed.data.DailyReadFeedItem;

import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_READ_MSG;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Daily_Read extends Fragment {
    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listView;
    private DailyReadFeedListAdapter listAdapter;
    private List<DailyReadFeedItem> feedItemsdailyread;

    public Fragment_Daily_Read() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView  =inflater.inflate(R.layout.fragment_daily_read, container, false);


        listView = (ListView) rootView.findViewById(R.id.list);

        feedItemsdailyread = new ArrayList<DailyReadFeedItem>();

        listAdapter = new DailyReadFeedListAdapter(getActivity(), feedItemsdailyread);
        listView.setAdapter(listAdapter);

//        mAboutBtn = (Button) findViewById(R.id.about_btn);
//        mChurchGroupBtn = (Button) findViewById(R.id.churchgroupbtn_id) ;

//
//        mAboutBtn.setOnClickListener(this);
//        mChurchGroupBtn.setOnClickListener(this);


        // We first check for cached request
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(URL_READ_MSG);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    parseJsonFeed(new JSONObject(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {
            // making fresh volley request and getting json
            JsonObjectRequest jsonReq = new JsonObjectRequest(Request.Method.GET,
                    URL_READ_MSG, null, new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject response) {
                    VolleyLog.d(TAG, "Response: " + response.toString());
                    if (response != null) {
                        parseJsonFeed(response);
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                }
            });

            // Adding request to volley request queue
            AppController.getInstance().addToRequestQueue(jsonReq);
        }

        return rootView;

    }
    private void parseJsonFeed(JSONObject response) {
        try {
            JSONArray feedArray = response.getJSONArray("read");


            for (int i = 0; i < feedArray.length(); i++) {
                JSONObject feedObj = (JSONObject) feedArray.get(i);

                DailyReadFeedItem item = new DailyReadFeedItem();
//                item.setId(feedObj.getInt("id"));
                item.setRead_msg(feedObj.getString("read_msg"));

                // Image might be null sometimes
                String image = feedObj.isNull("image") ? null : feedObj
                        .getString("image");
                item.setImage(image);
//                item.setNews_details(feedObj.getString("news_details"));
//                item.setProfilePic(feedObj.getString("profilePic"));
//                item.setTimeStamp(feedObj.getString("timeStamp"));

                // url might be null sometimes
//                String feedUrl = feedObj.isNull("url") ? null : feedObj
//                        .getString("url");
//                item.setUrl(feedUrl);

                feedItemsdailyread.add(item);
            }

            // notify data changes to list adapater
            listAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
