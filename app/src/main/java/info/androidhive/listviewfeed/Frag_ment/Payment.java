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


public class Payment extends Fragment {
    Button b;

    //  ArrayAdapter<String> abb;
    public Payment() {
        // Required empty public constructor
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
            }
        } );

        return view1;
    }
}




