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
public class furnitures_fragment extends Fragment {
    GridView gridv;
    String[] web = {
            "Bookshelf",
            "ShowCase",
            "Sofa",
            "Bed",
            "Table"


    } ;
    int[] imageId = {
            R.drawable.f1,
            R.drawable.f2,
            R.drawable.f3,
            R.drawable.f4,
            R.drawable.f5


    };


    public furnitures_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fur= inflater.inflate(R.layout.fragment_furnitures_fragment, container, false);
        ImageAdapter adapter = new ImageAdapter(getActivity(), web, imageId);
        gridv=(GridView)fur.findViewById(R.id.gridview3);
        gridv.setAdapter(adapter);
        gridv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
        return fur;
    }

}
