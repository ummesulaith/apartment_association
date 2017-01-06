package info.androidhive.listviewfeed.naviadapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import info.androidhive.listviewfeed.Frag_ment.Fragment_MyEvents;
import info.androidhive.listviewfeed.fragment.Fragment_Events;
import info.androidhive.listviewfeed.Frag_ment.Fragment_NoticeBoard;
import info.androidhive.listviewfeed.Frag_ment.Fragment_Found_and_Loss;
import info.androidhive.listviewfeed.Frag_ment.Fragment_Complaints;
import info.androidhive.listviewfeed.Frag_ment.Fragment_BuyandSell;
import info.androidhive.listviewfeed.Frag_ment.Fragment_About_us;

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
                fragment = new Fragment_Found_and_Loss();
                break;
            case 3:
                fragment = new Fragment_BuyandSell();
                break;
            case 4:
                fragment = new Fragment_NoticeBoard();
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


                    title = "Notice Board";



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
