package info.androidhive.listviewfeed.Frag_ment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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

import java.io.File;
import java.io.IOException;

import info.androidhive.listviewfeed.R;
import info.androidhive.listviewfeed.data.AddComplaint;

import static android.R.attr.data;
import static android.app.Activity.RESULT_OK;


public class Itsoktocomplain extends Fragment {
    String[] type = {"Water","Electricity","Neighbours","Others"};
    String[] priority = {"High","Medium","Low"};
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    EditText impact,subj,desc;
    Button btnsubmit,btnpic,btnvoice;
    Spinner sperr,sper11;
    private StorageReference mStorage;
    private static final int GALLERY_INTENT=2;
    private MediaRecorder mRecorder;
    private static String mFileName=null;
    private static final String LOG_TAG = "Record_Log";

    public Itsoktocomplain() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_itsoktocomplain, container, false);

         sperr = (Spinner) rootView.findViewById(R.id.sper);
         sper11 = (Spinner) rootView.findViewById(R.id.sper1);
        ArrayAdapter<String> ac = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,type);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,priority);
        sperr.setAdapter(ac);
        sper11.setAdapter(ad);
        impact=(EditText)rootView.findViewById(R.id.impact);
        subj=(EditText)rootView.findViewById(R.id.subj);
        desc=(EditText)rootView.findViewById(R.id.desc);
        btnsubmit=(Button) rootView.findViewById(R.id.submit);
        btnpic=(Button) rootView.findViewById(R.id.buttonphoto);
        btnvoice=(Button)rootView.findViewById(R.id.buttonvoice);
        mFileName = Environment.getExternalStorageDirectory().getAbsolutePath();
        mFileName += "/audiorecordtest.3gp";
        firebaseAuth = FirebaseAuth.getInstance();
        mStorage= FirebaseStorage.getInstance().getReference();
        databaseReference = FirebaseDatabase.getInstance().getReference("Complaints");
        FirebaseUser user = firebaseAuth.getCurrentUser();

        btnvoice.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(motionEvent.getAction() == MotionEvent.ACTION_DOWN)

                {
                    startRecording();

                }else if (motionEvent.getAction() == MotionEvent.ACTION_UP)
                {
                    stopRecording();

                }
                return false;
            }
        });

        Submit();
        upload_picture();
       // upload_voice();
        return rootView;

    }
    private void startRecording()
    {
        mRecorder = new MediaRecorder();
        mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        mRecorder.setOutputFile(mFileName);
        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);

        try {
            mRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "prepare() failed");
        }

        mRecorder.start();
    }

    private void stopRecording()
    {
        mRecorder.stop();
        mRecorder.release();
        mRecorder = null;
    }
   /* public void upload_voice(){


        StorageReference filepath = mStorage.child("Audio").child("audiorecordtest.3gp");
        Uri uri =Uri.fromFile(new File(mFileName));

        filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(getActivity(),"Uploaded..",Toast.LENGTH_LONG).show();
            }
        });

    }*/
    public void Submit() {
        btnsubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Getting values from database
                        String imp = impact.getText().toString().trim();
                        String subject = subj.getText().toString().trim();
                        String describ = desc.getText().toString().trim();
                        String complaint_type =  sperr.getSelectedItem().toString().trim();
                        String priority =  sper11.getSelectedItem().toString().trim();

                        //creating a userinformation object
                        final AddComplaint addComplaint = new AddComplaint(imp,subject,describ,complaint_type,priority);

                        //getting the current logged in user
                        FirebaseUser user = firebaseAuth.getCurrentUser();


                        databaseReference.child(user.getUid()).setValue(addComplaint);

                        //displaying a success toast
                        Toast.makeText(getActivity(), "Information Saved...", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    public void upload_picture(){


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
            StorageReference filepath=mStorage.child("Complaint").child(uri.getLastPathSegment());
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    Toast.makeText(getActivity(),"Uploading..",Toast.LENGTH_LONG).show();

                }
            });
            }
        }




}














