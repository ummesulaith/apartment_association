package info.androidhive.listviewfeed.Frag_ment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.androidhive.listviewfeed.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Query extends Fragment {


    public Query() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootv1= inflater.inflate( R.layout.fragment_query, container, false );
        return rootv1;
    }

}
