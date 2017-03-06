package info.androidhive.listviewfeed.Frag_ment;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.activity.Home;
import info.androidhive.listviewfeed.fragment.Fragment_AddEvent;

import static info.androidhive.listviewfeed.R.id.listview1;

public class Fragment_MyEvents extends Fragment {
    public Button b;
    ListView lv,lv1;
    ArrayList<String> al;
    ArrayAdapter<String> aa;


    public Fragment_MyEvents() {
        // Required empty public constructor
    }



 public static Fragment_MyEvents newInstance(String param1, String param2) {
      Fragment_MyEvents fragment = new Fragment_MyEvents();
        Bundle args = new Bundle();

       fragment.setArguments(args);
        return fragment;
   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragment__my_events, container, false);
        lv = (ListView) rootView.findViewById(listview1);
        lv.setBackgroundColor(Color.LTGRAY);

        al = new ArrayList<String>();
        al.add("Invite 1");
        al.add("Invite 2");

        aa = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,al);
        lv.setAdapter(aa);


        b = (Button) rootView.findViewById(R.id.btnnew);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Fragment_AddEvent f1 = new Fragment_AddEvent();
                fragmentTransaction.replace(R.id.Container, f1);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack("events");
                Home.title.setText("add events");
            }
        });

       lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

               FragmentManager fm = getActivity().getSupportFragmentManager();
               fm.beginTransaction().replace(R.id.Container, new Fragment_My_EventDetails())
                       .addToBackStack(null)
                       .addToBackStack("events")
                       .commit();
               Home.title.setText(" Event Details");
           }
       });

     /**   lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                FragmentManager fm = getActivity().getSupportFragmentManager();
                fm.beginTransaction().replace(R.id.Container, new Fragment_My_EventDetails())
                        .addToBackStack(null)
                        .addToBackStack("events")
                        .commit();
                Home.title.setText(" Event Details");
            }
        });**/
        return rootView;

    }
}
