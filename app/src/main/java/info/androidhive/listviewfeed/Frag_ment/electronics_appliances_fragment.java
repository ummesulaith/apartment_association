package info.androidhive.listviewfeed.Frag_ment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import info.androidhive.listviewfeed.Others.ImageAdapter;
import info.androidhive.listviewfeed.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class electronics_appliances_fragment extends Fragment {

    GridView gridv;
    String[] web = {
            "Fridge",
            "Coffemaker",
            "e-induction",
            "Home theatre",
            "Washing machine",
            "Mixer",
            "Hair dryer",
            "Vaccum cleaner"


    } ;
    int[] imageId = {
            R.drawable.app1,
            R.drawable.app2,
            R.drawable.app3,
            R.drawable.speakers,
            R.drawable.app4,
            R.drawable.app5,
            R.drawable.app6,
            R.drawable.app7,






    };


    public electronics_appliances_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v1= inflater.inflate(R.layout.fragment_electronics_appliances_fragment, container, false);
        ImageAdapter adapter = new ImageAdapter(getActivity(), web, imageId);
        gridv=(GridView)v1.findViewById(R.id.gridview1);
        gridv.setAdapter(adapter);
        gridv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
        return v1;
    }


}


