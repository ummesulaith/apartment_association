package info.androidhive.listviewfeed.Frag_ment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import info.androidhive.listviewfeed.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Feedback.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Feedback#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Feedback extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    public Feedback() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Feedback newInstance(String param1, String param2) {
        Feedback fragment = new Feedback();
        Bundle args = new Bundle();
        //args.putString( ARG_PARAM1, param1 );
        //args.putString( ARG_PARAM2, param2 );
        fragment.setArguments( args );
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate( R.layout.fragment_feedback, container, false );
        return rootView;
    }





}
