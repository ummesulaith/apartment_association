package info.androidhive.listviewfeed.fragment;

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
import info.androidhive.listviewfeed.data.AddEvent;
import info.androidhive.listviewfeed.data.UserInformation;

/**
 * Created by Chanti on 12/30/2016.
 */

public class Fragment_AddEvent extends Fragment {
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    String[] items = {"Wedding","Birthday Party","Wedding Anniversary","Casual Party","Festival","Others"};
    EditText edittexttime,edittextdate,edittextvenue,edittextdes;
    Button btnsendinvite;
    Spinner sp1;
   // private DatabaseHelper myDb;

    public Fragment_AddEvent(){

}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_addevent, container, false);
        sp1 = (Spinner) rootView.findViewById(R.id.sp1);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,items);
        sp1.setAdapter(aa);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("events");
        FirebaseUser user = firebaseAuth.getCurrentUser();
        edittextdate = (EditText)rootView.findViewById(R.id.edittextdate);
        edittexttime = (EditText)rootView.findViewById(R.id.edittexttime);
        edittextdes = (EditText)rootView.findViewById(R.id.edittextdes);
        edittextvenue = (EditText)rootView.findViewById(R.id.edittextvenue);
        btnsendinvite =(Button) rootView.findViewById(R.id.invite);
        Send();
        return rootView;

    }
    public void Send() {
        btnsendinvite.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Getting values from database
                        String date = edittextdate.getText().toString().trim();
                        String time = edittexttime.getText().toString().trim();
                        String des = edittextdes.getText().toString().trim();
                        String venue = edittextvenue.getText().toString().trim();
                        String spin =  sp1.getSelectedItem().toString().trim();
                        //creating a userinformation object
                        final AddEvent addEvent = new AddEvent(date,time,des,venue,spin);
                        //getting the current logged in user
                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        databaseReference.child(user.getUid()).setValue(addEvent);
                        //displaying a success toast
                        Toast.makeText(getActivity(), "Information Saved...", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
}
