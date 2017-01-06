package info.androidhive.listviewfeed.Frag_ment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.activity.Home;
import info.androidhive.listviewfeed.fragment.Fragment_AddEvent;

/**
 * Created by Chanti on 12/30/2016.
 */

public class Fragment_MyComplaints extends Fragment {

    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;

    public Fragment_MyComplaints(){


    }

   /* public static Fragment_MyComplaints newInstance(String param1, String param2) {
        Fragment_MyComplaints fragment = new Fragment_MyComplaints();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.my_complaints, container, false);
        lv = (ListView) rootView.findViewById(R.id.listview3);

        al = new ArrayList<String>();
        al.add("Complaint 1");
        al.add("Complaint 2");
        al.add("Complaint 3");
        al.add("Complaint 4");
        al.add("Complaint 5");
        aa = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,al);
        lv.setAdapter(aa);
        return rootView;

    }
}
