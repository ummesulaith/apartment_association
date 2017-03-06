package info.androidhive.listviewfeed.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import info.androidhive.listviewfeed.R;

public class Login extends AppCompatActivity  {
    private EditText eEmail, epassword;
    private FirebaseAuth mAuth;
    private Button bloginn;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eEmail = (EditText) findViewById(R.id.textuser);
        epassword = (EditText) findViewById(R.id.textpasswd);

        bloginn = (Button) findViewById(R.id.blogin);
        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null) {
                    startActivity(new Intent(Login.this, Home.class));
                }
            }
        };
        bloginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startsignin();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void startsignin() {
        String Email = eEmail.getText().toString();
        String Password = epassword.getText().toString();
        if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Password)) {
            Toast.makeText(Login.this, " Fields Are Empty ", Toast.LENGTH_LONG).show();
        }
        final ProgressDialog progressDialog = ProgressDialog.show(Login.this, "Please wait...", "Proccessing...", true);

        mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();

                if (!task.isSuccessful()) {
                    Toast.makeText(Login.this, "signin problem", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}