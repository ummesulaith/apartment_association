package info.androidhive.listviewfeed.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import info.androidhive.listviewfeed.Database.DatabaseHelper;
import info.androidhive.listviewfeed.R;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button login, register;
    private EditText etEmail, etPass;
    private DatabaseHelper db;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );
        db = new DatabaseHelper(this);
        session = new Session(this);

        login = (Button)findViewById(R.id.blogin);
        register = (Button)findViewById(R.id.bregister);
        etEmail = (EditText)findViewById(R.id.textuser);
        etPass = (EditText)findViewById(R.id.textpasswd);
        login.setOnClickListener(this);
        register.setOnClickListener(this);
        if(session.loggedin()){
            startActivity(new Intent(Login.this,Home.class));
            finish();
        }

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.blogin:
                login();
                break;
            case R.id.bregister:
                startActivity(new Intent(Login.this,Register.class));
                break;
            default:

        }

    }
    private void login(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        if(db.getUser(email,pass)){

            session.setLoggedin(true);
            startActivity(new Intent(Login.this, Home.class));
            finish();
        }else{
            Toast.makeText(Login.this, "Wrong email/password",Toast.LENGTH_SHORT).show();
        }
    }
}
