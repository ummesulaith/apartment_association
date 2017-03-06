package info.androidhive.listviewfeed.Frag_ment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.data.AddCard;
import info.androidhive.listviewfeed.data.AddComplaint;

/**
 * A simple {@link Fragment} subclass.
 */
public class CardPayment_Fragment extends Fragment {

    EditText crd,name,expdate,cvv;
    Button btnpay;
    Spinner type;
    String[] card_type = {"Debit","Credit"};
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    public CardPayment_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View r= inflater.inflate(R.layout.fragment_card_payment_, container, false);
        crd=(EditText)r.findViewById(R.id.cardno);
        name=(EditText)r.findViewById(R.id.noc);
        expdate=(EditText)r.findViewById(R.id.expiry);
        cvv=(EditText)r.findViewById(R.id.cvvn);
        btnpay=(Button) r.findViewById(R.id.button4);
        type=(Spinner) r.findViewById(R.id.typee);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,card_type);
        type.setAdapter(ad);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Card Payment");
        FirebaseUser user = firebaseAuth.getCurrentUser();
        pay();
        return r;
    }

    public void pay() {
        btnpay.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Getting values from database
                        String cardtype =  type.getSelectedItem().toString().trim();
                        String cardnumber = crd.getText().toString().trim();
                        String nameoncard = name.getText().toString().trim();
                        String expirydate = expdate.getText().toString().trim();
                        String cvvnumber = cvv.getText().toString().trim();


                        //creating a userinformation object
                        final AddCard addCard = new AddCard(cardtype,cardnumber,nameoncard,expirydate,cvvnumber);

                        //getting the current logged in user
                        FirebaseUser user = firebaseAuth.getCurrentUser();


                        databaseReference.child(user.getUid()).setValue(addCard);

                        //displaying a success toast
                        Toast.makeText(getActivity(), "Information Saved...", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
}




