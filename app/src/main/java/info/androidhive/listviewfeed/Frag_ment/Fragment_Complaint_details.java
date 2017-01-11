package info.androidhive.listviewfeed.Frag_ment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.androidhive.listviewfeed.R;


public class Fragment_Complaint_details extends Fragment {


    public Fragment_Complaint_details() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v1= inflater.inflate(R.layout.fragment_fragment__complaint_details, container, false);
        return v1;
    }


}
