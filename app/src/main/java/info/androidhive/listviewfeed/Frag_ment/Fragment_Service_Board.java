package info.androidhive.listviewfeed.Frag_ment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import info.androidhive.listviewfeed.activity.Home;
import info.androidhive.listviewfeed.data.AddComplaint;
import info.androidhive.listviewfeed.data.AddService;

public class Fragment_Service_Board extends Fragment {


    Button s;
    String[] items = {"Electrician","plumber","carpenter"," laundry","repairs", "Painters"};
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    EditText namee,phone,floor,flatt,desc;
    Spinner sp1;

    public Fragment_Service_Board() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_service_board, container, false);
        s = (Button) rootView.findViewById(R.id.service_submit);
         sp1 = (Spinner) rootView.findViewById(R.id.sp);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        sp1.setAdapter(aa);
        namee = (EditText) rootView.findViewById(R.id.name);
        phone = (EditText) rootView.findViewById(R.id.pno);
        floor = (EditText) rootView.findViewById(R.id.floor);
        flatt = (EditText) rootView.findViewById(R.id.flat);
        desc = (EditText) rootView.findViewById(R.id.des);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Service");
        FirebaseUser user = firebaseAuth.getCurrentUser();
        sub();
        return rootView;
    }
    public void sub(){
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String n = namee.getText().toString().trim();
                String ph = phone.getText().toString().trim();
                String fl = floor.getText().toString().trim();
                String fla = flatt.getText().toString().trim();
                String describ = desc.getText().toString().trim();
                String department =  sp1.getSelectedItem().toString().trim();
            //creating a userinformation object
            final AddService addService = new AddService(n,ph,fl,fla,describ,department);

            //getting the current logged in user
            FirebaseUser user = firebaseAuth.getCurrentUser();


            databaseReference.child(user.getUid()).setValue(addService);

            //displaying a success toast
            Toast.makeText(getActivity(), "Information Saved...", Toast.LENGTH_LONG).show();

        };


    });
}}

