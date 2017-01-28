package info.androidhive.listviewfeed.naviadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import info.androidhive.listviewfeed.Frag_ment.Fragment_MyEvents;
import info.androidhive.listviewfeed.Frag_ment.Fragment_Service_Board;
import info.androidhive.listviewfeed.Frag_ment.Fragment_Complaints;
import info.androidhive.listviewfeed.Frag_ment.Fragment_BuyandSell;
import info.androidhive.listviewfeed.Frag_ment.Fragment_About_us;
import info.androidhive.listviewfeed.fragment.Notifications;

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

        switch (position) {


            case 0:
                fragment = new Fragment_MyEvents();
                break;
            case 1:
                fragment = new Fragment_Complaints();
                break;
            case 2:
                fragment = new Fragment_Service_Board();
                break;
            case 3:
                fragment = new Fragment_BuyandSell();
                break;
            case 4:
                fragment = new Notifications();
                break;
            case 5:
                fragment = new Fragment_About_us();
            case 6:

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
        Context context = null;


        switch (position) {

            case 0:

                    title = "Events";


                break;
            case 1:


                    title = "Complaints";




                break;
            case 2:


                    title = "Found and Loss";





                break;
            case 3:


                    title = "Buy and Sell";


                break;
            case 4:


                    title = "Feedback and Query";



                break;
            case 5:


                    title = "About us";


                break;
            default:
                break;

        }

        return title;
    }
}
