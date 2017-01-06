package info.androidhive.listviewfeed.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import info.androidhive.listviewfeed.R;

/**
 * Created by Chanti on 12/30/2016.
 */

public class Fragment_AddEvent extends Fragment {

    String[] items = {"Wedding","Birthday Party","Wedding Anniversary","Casual Party","Festival","Others"};

    public Fragment_AddEvent(){

}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_addevent, container, false);
        Spinner sp1 = (Spinner) rootView.findViewById(R.id.sp1);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,items);
        sp1.setAdapter(aa);
        return rootView;

    }
}
