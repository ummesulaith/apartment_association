package info.androidhive.listviewfeed.Frag_ment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.data.AddComplaint;
import info.androidhive.listviewfeed.data.AddFeedback;

public class Feedback extends Fragment {
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    EditText descr;
    Button btnsubmit;
Spinner spin;
    String[] items = {"Comment","Report"};



    public Feedback() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView= inflater.inflate( R.layout.fragment_feedback, container, false );
        spin = (Spinner) rootView.findViewById(R.id.spinner);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        spin.setAdapter(aa);
        descr=(EditText)rootView.findViewById(R.id.description);
        btnsubmit=(Button) rootView.findViewById(R.id.submitfeedback);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Feedback");
        FirebaseUser user = firebaseAuth.getCurrentUser();
        submit();
        return rootView;
    }
    public void submit() {
        btnsubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Getting values from database
                        String describee = descr.getText().toString().trim();
                        String feedback_type =  spin.getSelectedItem().toString().trim();


                        //creating a userinformation object
                        final AddFeedback addFeedback = new AddFeedback(describee,feedback_type);

                        //getting the current logged in user
                        FirebaseUser user = firebaseAuth.getCurrentUser();

                        databaseReference.child(user.getUid()).setValue(addFeedback);

                        //displaying a success toast
                        Toast.makeText(getActivity(), "Information Saved...", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }





}
