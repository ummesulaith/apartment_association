package info.androidhive.listviewfeed.naviadapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.Toast;

import info.androidhive.listviewfeed.activity.Home;
import info.androidhive.listviewfeed.fragment.Fragment_Charity;
import info.androidhive.listviewfeed.fragment.Fragment_ChurchGroup;
import info.androidhive.listviewfeed.fragment.Fragment_Church_News;
import info.androidhive.listviewfeed.fragment.Fragment_Daily_Read;
import info.androidhive.listviewfeed.fragment.Fragment_about;

import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_CHARITY_INFO;
import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_FEED;
import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_FEED_ABOUT;
import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_FEED_CHAT_GROUP;
import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_FEED_CHURCH_NEWS;
import static info.androidhive.listviewfeed.imagelibrary.UrlFeed.URL_READ_MSG;

/**
 * Created by HyeHailyn on 10/20/2016.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;


        switch(position){


            case 0:
                fragment = new DisplayContent();
                break;
            case 1:
                fragment = new Fragment_Church_News();
                break;
            case 2:
                fragment = new Fragment_ChurchGroup();
                break;
            case 3:
                fragment = new Fragment_Daily_Read();
                break;
            case 4:
                fragment = new Fragment_Charity();
                break;
            case 5:
                fragment = new Fragment_about();
                break;
            default:
                break;

        }

        return fragment;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;


        switch(position){

            case 0:
                title = "Feeds";
                break;
            case 1:
                title = "ChurchNews";
                break;
            case 2:
                title = "ChurchGroup";
                break;
            case 3:
                title = "DailyRead";
                break;
            case 4:
                title = "Charity";
                break;
            case 5:
                title = "About";
                break;
            default:
                break;

        }

        return title;
    }
}
