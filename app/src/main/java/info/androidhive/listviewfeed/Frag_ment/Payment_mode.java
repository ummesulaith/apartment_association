package info.androidhive.listviewfeed.Frag_ment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import info.androidhive.listviewfeed.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Payment_mode.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Payment_mode#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Payment_mode extends Fragment {


    public Payment_mode() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view1= inflater.inflate( R.layout.fragment_payment_mode, container, false );


        return view1;
    }

    }

