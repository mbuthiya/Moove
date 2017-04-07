package com.example.james.moove.authentication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.james.moove.MainActivity;
import com.example.james.moove.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.ed_loginEmail)EditText mLoginEmail;
    @Bind(R.id.ed_loginPassword)EditText mLoginPassword;
    @Bind(R.id.btn_loginBtn)Button mLoginButton;
    @Bind(R.id.tv_goToSignUp)TextView mGoToSignUpTextView;
    Intent intent;

    ProgressDialog pb;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);
        mGoToSignUpTextView.setOnClickListener(this);
        mLoginButton.setOnClickListener(this);
        mAuth=FirebaseAuth.getInstance();
        checkAuth();

    }

    @Override
    public void onClick(View v) {
        if(v==mGoToSignUpTextView){
            intent=new Intent(LogInActivity.this,SignInActivity.class);
            startActivity(intent);
        }else if(v==mLoginButton){
            loginWithPassword();
        }
    }

    private void loginWithPassword() {
        createDialog();
        String email=mLoginEmail.getText().toString().trim();
        String password=mLoginPassword.getText().toString().trim();

        if(email.equals("")){
            mLoginEmail.setError("This field cant be empty");
            return;
        }
        if (password.equals("")){
            mLoginPassword.setError("This field cant be empty");
            return;
        }
        pb.show();
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

               if (!task.isSuccessful()){
                   Toast.makeText(LogInActivity.this, "Log In failed", Toast.LENGTH_SHORT).show();
                   pb.dismiss();
               }

            }
        });

    }
    public void checkAuth(){
        mAuthStateListener=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user=firebaseAuth.getCurrentUser();
                if (user!=null){
                    intent=new Intent(LogInActivity.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                    startActivity(intent);
                    finish();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mAuth!=null) {
            mAuth.removeAuthStateListener(mAuthStateListener);
        }
    }
    public void createDialog(){
        pb=new ProgressDialog(this);
        pb.setTitle("So you are back.");
        pb.setMessage("Well took you long enough");
        pb.setCancelable(false);
    }
}
