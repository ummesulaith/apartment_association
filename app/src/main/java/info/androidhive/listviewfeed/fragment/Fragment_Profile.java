package info.androidhive.listviewfeed.fragment;


import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.data.UserInformation;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Profile extends Fragment
{
    private static final String TAG = Fragment_Profile.class.getSimpleName();
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
   // private DatabaseHelper myDb;
    private EditText editTextname, editTextusername, editTextemail, editTextcontactno, editTextflatno;
    private Button btnsave, btnpic;
    // String testdata="myname";
    ImageView imageView;


    private static int RESULT_LOAD_IMAGE = 1;

    public Fragment_Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_fragment__profile, container, false);


        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("users");
        FirebaseUser user = firebaseAuth.getCurrentUser();

        editTextname = (EditText) v.findViewById(R.id.edname);
        editTextusername = (EditText) v.findViewById(R.id.editTextusername);
        editTextemail = (EditText) v.findViewById(R.id.editTextemail);
        editTextcontactno = (EditText) v.findViewById(R.id.editTextcontactno);
        editTextflatno = (EditText) v.findViewById(R.id.editTextflatno);
        btnsave = (Button) v.findViewById(R.id.btnsave);
        btnpic = (Button) v.findViewById(R.id.changepic);
        imageView = (ImageView) v.findViewById(R.id.pic);
        change();
        AddData();




        return v;
    }


    public void change() {
        btnpic.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            Cursor cursor = this.getActivity().getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();


            imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

        }


    }
    public void AddData() {
        btnsave.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        //Getting values from database
                        String name = editTextname.getText().toString().trim();
                        String username = editTextusername.getText().toString().trim();
                        String email = editTextemail.getText().toString().trim();
                        String contact = editTextcontactno.getText().toString().trim();
                        String flatno = editTextflatno.getText().toString().trim();
                        //creating a userinformation object
                        final UserInformation userInformation = new UserInformation(name,username,flatno,email,contact);

                        //getting the current logged in user
                        FirebaseUser user = firebaseAuth.getCurrentUser();


                        databaseReference.child(user.getUid()).setValue(userInformation);

                        //displaying a success toast
                        Toast.makeText(getActivity(), "Information Saved...", Toast.LENGTH_LONG).show();

                        databaseReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {


                                String username = dataSnapshot.getValue().toString();


                                // Display newly updated name and email
                                editTextname.setText(userInformation.name + ", " );
                                editTextusername.setText(userInformation.username + ", ");
                                editTextflatno.setText(userInformation.flatno + ", ");
                                editTextemail.setText(userInformation.email + ", ");
                                editTextcontactno.setText(userInformation.contact + ", ");
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });


                    }});}
}


