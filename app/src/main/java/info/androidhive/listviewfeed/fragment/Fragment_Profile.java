package info.androidhive.listviewfeed.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.androidhive.listviewfeed.Database.DatabaseHelper;
import info.androidhive.listviewfeed.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Profile extends Fragment {

    private DatabaseHelper myDb;
    private EditText editTextname, editTextusername, editTextemail, editTextcontactno, editTextflatno;
    private Button btnsave;
   // String testdata="myname";

    public Fragment_Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_fragment__profile, container, false);



      // testdata= (EditText) v.findViewById(R.id.edname);
        
        editTextname = (EditText) v.findViewById(R.id.edname);
        editTextusername = (EditText) v.findViewById(R.id.editTextusername);
        editTextemail = (EditText) v.findViewById(R.id.editTextemail);
        editTextcontactno = (EditText) v.findViewById(R.id.editTextcontactno);
        editTextflatno = (EditText) v.findViewById(R.id.editTextflatno);
        btnsave = (Button) v.findViewById(R.id.btnsave);
        //AddData();
        return v;

    }

/*    public void AddData() {
        btnsave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DatabaseHelper myDb = new DatabaseHelper(getActivity());
                       // boolean isInserted = myDb.insertData(editTextname.getText().toString(),
                             //   editTextusername.getText().toString(), editTextemail.getText().toString(),
                               // editTextcontactno.getText().toString(), editTextflatno.getText().toString());
                        /*if (isInserted == true)
                            Toast.makeText(getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getActivity(), "Data not Inserted", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }*/
}






