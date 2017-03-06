package info.androidhive.listviewfeed.Frag_ment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.data.AddQuery;

/**
 * A simple {@link Fragment} subclass.
 */
public class Query extends Fragment {


    EditText ename,eflat,eposition,econtactno,eemail,equery;
    Button btnquery;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    public Query() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_query, container, false);
        ename=(EditText)v.findViewById(R.id.name);
        eflat=(EditText)v.findViewById(R.id.flatn);
        eposition=(EditText)v.findViewById(R.id.status);
        econtactno=(EditText)v.findViewById(R.id.contact);
        eemail=(EditText)v.findViewById(R.id.mail);
        equery=(EditText)v.findViewById(R.id.enq);
        btnquery=(Button)v.findViewById(R.id.sendquery);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Query");
        FirebaseUser user = firebaseAuth.getCurrentUser();
        SubmitQuery();
        return v;
    }

    public void SubmitQuery() {
        btnquery.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Getting values from database
                        String na = ename.getText().toString().trim();
                        String efl = eflat.getText().toString().trim();
                        String epos = eposition.getText().toString().trim();
                        String ph = econtactno.getText().toString().trim();
                        String ema = eemail.getText().toString().trim();
                        String query = equery.getText().toString().trim();


                        //creating a userinformation object
                        final AddQuery addQuery = new AddQuery(na,efl,epos,ph,ema,query);

                        //getting the current logged in user
                        FirebaseUser user = firebaseAuth.getCurrentUser();

                        databaseReference.child(user.getUid()).setValue(addQuery);

                        //displaying a success toast
                        Toast.makeText(getActivity(), "Information Saved...", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }





}
