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
public class mobile_tablets_fragment extends Fragment {
GridView grid;
    String[] web = {
            "L.G",
            "Iphone 5s",
            "Samsung_Edge",
            "Redmi",
            "Meizu",
            "Nexus",
            "Lenovo_Notepad",
            "L.G",
            "Ipad",
            "Microsoft"


    } ;
    int[] imageId = {
            R.drawable.mobile1,
            R.drawable.mobile2,
            R.drawable.mobile3,
            R.drawable.mobile4,
            R.drawable.mobile5,
            R.drawable.tab1,
            R.drawable.tab2,
            R.drawable.tab3,
            R.drawable.tab4,
            R.drawable.tab5







    };


    public mobile_tablets_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ve = inflater.inflate(R.layout.fragment_mobile_tablets_fragment, container, false);
        ImageAdapter adapter = new ImageAdapter(getActivity(), web, imageId);
        grid=(GridView)ve.findViewById(R.id.gridview);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();

            }
        });
        return ve;
    }
    }



