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
 * {@link Itsoktocomplain.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Itsoktocomplain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Itsoktocomplain extends Fragment {
    String[] type = {"Water","Electricity","Neighbours","Others"};
    String[] priority = {"High","Medium","Low"};

    public Itsoktocomplain() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_itsoktocomplain, container, false);
        Spinner sper = (Spinner) rootView.findViewById(R.id.sper);
        Spinner sper1 = (Spinner) rootView.findViewById(R.id.sper1);
        ArrayAdapter<String> ac = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,type);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,priority);
        sper.setAdapter(ac);
        sper1.setAdapter(ad);
        return rootView;

    }
    }






    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */


