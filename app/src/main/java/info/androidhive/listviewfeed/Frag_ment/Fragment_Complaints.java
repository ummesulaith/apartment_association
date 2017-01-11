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


public class Fragment_Complaints extends Fragment {
    public Button b2, btnback;
    ListView lv2;
    ArrayList<String> al1;
    ArrayAdapter<String> ac;
    ArrayAdapter<String> ad;

    public Fragment_Complaints() {
        // Required empty public constructor
    }

    public static Fragment_Complaints newInstance(String param1, String param2) {
        Fragment_Complaints fragment2 = new Fragment_Complaints();
        Bundle args = new Bundle();
        fragment2.setArguments(args);
        return fragment2;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_complaints, container, false);
        lv2 = (ListView) rootView.findViewById(R.id.details);
        // lv3 = (ListView) rootView.findViewById(R.id.listview2);
        al1 = new ArrayList<String>();
        al1.add("Item 1");
        al1.add("Item 2");
        al1.add("Item 3");
        al1.add("Item 4");
        al1.add("Item 5");
        ac = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, al1);
        // ac = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_2);
        //ad = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1);
        lv2.setAdapter(ac);
        btnback = (Button) rootView.findViewById(R.id.btnback);


        b2 = (Button) rootView.findViewById(R.id.complaintsbtn);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Itsoktocomplain f2 = new Itsoktocomplain();
                fragmentTransaction.replace(R.id.Container, f2);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("Complaints");
                Home.title.setText(" ! Its ok to Complain !! ");
            }
        });

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.Container, new Fragment_Complaint_details())
                        .addToBackStack(null)
                        .addToBackStack("Complaints")
                        .commit();
                Home.title.setText(" Complaint Details");
            }
        });

            /**lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            FragmentManager fm = getActivity().getSupportFragmentManager();
            fm.beginTransaction().replace(R.id.Container, new Fragment_Complaint_details())
            .addToBackStack(null)
            .addToBackStack("Complaints")
            .commit();
            Home.title.setText(" Complaints Details");
            }
            });**/

        //home();
        return rootView;
    }
  /*  public void home() {
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment_Home_List Fragment = new Fragment_Home_List();
                fragmentTransaction.replace(R.id.Container, Fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }**/
}

