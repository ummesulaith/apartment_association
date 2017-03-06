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
public class kids_fragment extends Fragment {
    GridView gridv;
    String[] web = {
            "Kitchen toys",
            "Toy Collector",
            "Car",
            "Educational Computer"


    } ;
    int[] imageId = {
            R.drawable.k1,
            R.drawable.k2,
            R.drawable.k3,
            R.drawable.k4


    };

    public kids_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View kid= inflater.inflate(R.layout.fragment_kids_fragment, container, false);
        ImageAdapter adapter = new ImageAdapter(getActivity(), web, imageId);
        gridv=(GridView)kid.findViewById(R.id.gridview4);
        gridv.setAdapter(adapter);
        gridv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
        return kid;
    }

}
