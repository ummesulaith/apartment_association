package info.androidhive.listviewfeed.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import info.androidhive.listviewfeed.Database.DatabaseHelper;
import info.androidhive.listviewfeed.R;


public class Register extends AppCompatActivity implements View.OnClickListener {
    private Button reg;
    private TextView tvLogin;
    private EditText etEmail, etPass;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db = new DatabaseHelper(this);
        reg = (Button)findViewById(R.id.bregister);
        tvLogin = (TextView)findViewById(R.id.tvLogin);
        etEmail = (EditText)findViewById(R.id.txtu);
        etPass = (EditText)findViewById(R.id.txtp);
        reg.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bregister:
                register();
                break;
            case R.id.tvLogin:
                startActivity(new Intent(Register.this, Login.class));
                finish();
                break;
            default:

        }
    }
    private void register(){
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();
        if(email.isEmpty() && pass.isEmpty()){
            Toast.makeText(Register.this, "Username/password field empty", Toast.LENGTH_SHORT).show();
        }else{
            db.addUser(email,pass);
            Toast.makeText(Register.this,"User registered", Toast.LENGTH_SHORT).show();
            finish();
        }
    }


}



