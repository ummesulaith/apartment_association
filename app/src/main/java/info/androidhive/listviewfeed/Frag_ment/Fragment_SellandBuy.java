package info.androidhive.listviewfeed.Frag_ment;

import android.content.Context;
import android.content.Intent;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.activity.Home;
import info.androidhive.listviewfeed.data.AddComplaint;
import info.androidhive.listviewfeed.data.AddSell;
import info.androidhive.listviewfeed.fragment.Fragment_AddEvent;

import static android.R.attr.button;
import static android.app.Activity.RESULT_OK;


public class Fragment_SellandBuy extends Fragment {
    String[] items = {"Books","Furniture","Flat","Vehicles","Machinery","Equipments"};
    String[] type={"New","Used"};
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    EditText titl,pric,desc;
    Button btnsub,btnpic;
    private StorageReference mStorage;
    private static final int GALLERY_INTENT=2;


    Spinner sp,spin;


    public Fragment_SellandBuy() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_fragmet__sell, container, false);
         sp = (Spinner) rootView.findViewById(R.id.sp);
        spin = (Spinner) rootView.findViewById(R.id.spp);
        ArrayAdapter<String> ab = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,items);
        ArrayAdapter<String> adap = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,type);
        sp.setAdapter(ab);
        spin.setAdapter(adap);
        titl=(EditText)rootView.findViewById(R.id.addtitle);
        pric=(EditText)rootView.findViewById(R.id.price);
        desc=(EditText)rootView.findViewById(R.id.sep1);
        btnsub=(Button)rootView.findViewById(R.id.submitad);
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Sell");
        FirebaseUser user = firebaseAuth.getCurrentUser();
        btnpic=(Button) rootView.findViewById(R.id.addphoto);
        mStorage= FirebaseStorage.getInstance().getReference();
        addpicture();
        submit();
        return rootView;

    }
    public void submit(){
        btnsub.setOnClickListener( new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           //Getting values from database
                                           String title = titl.getText().toString().trim();
                                           String cost = pric.getText().toString().trim();
                                           String describ = desc.getText().toString().trim();
                                           String category =  sp.getSelectedItem().toString().trim();
                                           String condition =  spin.getSelectedItem().toString().trim();


                                           //creating a userinformation object
                                           final AddSell addSell = new AddSell(title,cost,describ,category,condition);

                                           //getting the current logged in user
                                           FirebaseUser user = firebaseAuth.getCurrentUser();


                                           databaseReference.child(user.getUid()).setValue(addSell);

                                           //displaying a success toast
                                           Toast.makeText(getActivity(), "Information Saved...", Toast.LENGTH_LONG).show();

                                       }
                                   }
        );
    }
    public void addpicture(){


        btnpic.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/.");
                startActivityForResult(intent,GALLERY_INTENT);
            }

        });
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode,data);
        if (requestCode== GALLERY_INTENT && resultCode == RESULT_OK)
        {
            Uri uri = data.getData();
            StorageReference filepath=mStorage.child("Sell").child(uri.getLastPathSegment());
            FirebaseUser user = firebaseAuth.getCurrentUser();
            databaseReference.child(user.getUid());
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(getActivity(),"Uploading..",Toast.LENGTH_LONG).show();

                }
            });
        }
    }
}


