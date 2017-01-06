package info.androidhive.listviewfeed.Frag_ment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.activity.Home;


public class Fragment_Complaints extends Fragment {
    public Button b2;
    ArrayAdapter<String> ac;


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
        View rootView= inflater.inflate(R.layout.fragment_complaints, container, false);
        ac = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1);
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
        return rootView;

    }
}