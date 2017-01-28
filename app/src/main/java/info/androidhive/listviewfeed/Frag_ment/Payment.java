package info.androidhive.listviewfeed.Frag_ment;

import android.content.Context;
import android.net.Uri;
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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Payment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Payment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Payment extends Fragment {
    Button b;

    //  ArrayAdapter<String> abb;
    public Payment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Payment newInstance(String param1, String param2) {
        Payment fragment = new Payment();
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
        View view1 = inflater.inflate( R.layout.fragment_payment, container, false );
        // abb = new ArrayAdapter<String>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1);
        b = (Button) view1.findViewById( R.id.payy );
        b.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                Payment_mode f2 = new Payment_mode();
                fragmentTransaction.replace( R.id.Container, f2 );
               // fragmentTransaction.setTransition( FragmentTransaction.TRANSIT_FRAGMENT_FADE );
                fragmentTransaction.addToBackStack( null );
                fragmentTransaction.commit();
                fragmentTransaction.addToBackStack( "Payment" );
                Home.title.setText( " Payment done here !! " );
            }
        } );

        return view1;
    }
}




