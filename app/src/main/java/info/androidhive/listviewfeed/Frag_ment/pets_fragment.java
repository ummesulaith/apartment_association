package info.androidhive.listviewfeed.Frag_ment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import info.androidhive.listviewfeed.Others.ImageAdapter;
import info.androidhive.listviewfeed.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class pets_fragment extends Fragment {
    GridView gridv;
    String[] web = {
            "Puppy",
            "Beta fish",
            "Kitten",
            "Rabbit"


    } ;
    int[] imageId = {
            R.drawable.p1,
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4


    };

    public pets_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View pet= inflater.inflate(R.layout.fragment_pets_fragment, container, false);
        ImageAdapter adapter = new ImageAdapter(getActivity(), web, imageId);
        gridv=(GridView)pet.findViewById(R.id.gridview5);
        gridv.setAdapter(adapter);
        gridv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
        return pet;
    }

}
