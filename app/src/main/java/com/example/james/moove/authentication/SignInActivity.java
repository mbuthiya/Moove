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
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.ed_signUpName) EditText mSignUpName;
    @Bind(R.id.ed_signUpEmail)EditText mSignUpEmail;
    @Bind(R.id.ed_signUpPassword)EditText mSignUpPassword;
    @Bind(R.id.ed_signUpPasswordConfirm)EditText mSignUpPasswordConfirm;
    @Bind(R.id.btn_SignUpBtn) Button mSignUpButton;
    @Bind(R.id.tv_goToLogIn) TextView mGoToLogin;
    Intent intent;
   private FirebaseAuth mFirebaseAuth;
    private ProgressDialog mAuthProgressDialog;
    private  FirebaseAuth.AuthStateListener mFireBaseAuthCheck;
    String mName;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        ButterKnife.bind(this);
        mGoToLogin.setOnClickListener(this);
        mSignUpButton.setOnClickListener(this);
      mFirebaseAuth=FirebaseAuth.getInstance();
        checkAuthentication();
        createAuthDialog();


    }
    //progress dialog
    public  void createAuthDialog(){
        mAuthProgressDialog=new ProgressDialog(this);
        mAuthProgressDialog.setTitle("Building Your Account");
        mAuthProgressDialog.setMessage("Prepare To Be Amazed");
        mAuthProgressDialog.setCancelable(false);

    }
    //method to check authentication

    private void checkAuthentication() {
        mFireBaseAuthCheck=new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user=firebaseAuth.getCurrentUser();
                if(user!=null){
                    intent=new Intent(SignInActivity.this,MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();

                }

            }
        };
    }

    @Override
    public void onClick(View v) {
        if (v==mGoToLogin){
            intent=new Intent(SignInActivity.this,LogInActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }else if(v==mSignUpButton){
            createUser();
        }
    }
    //method to create a new user
    private void createUser() {
        mName=mSignUpName.getText().toString();
        String email=mSignUpEmail.getText().toString();
        String password=mSignUpPassword.getText().toString();
        String passwordConfirm=mSignUpPasswordConfirm.getText().toString();


        if (validatePassword(password,passwordConfirm)){
            mAuthProgressDialog.show();
            mFirebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    mAuthProgressDialog.dismiss();
                    if (task.isSuccessful()){
                        Log.d("Log This PLease","Authenticated");
                        createUserProfile(task.getResult().getUser());
                    }else{
                        Toast.makeText(SignInActivity.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                    }


                }
            });

        }
    }
    //method to validate password

    private boolean validatePassword(String password, String passwordConfirm) {
        if (password.equals(passwordConfirm)){
            return  true;
        }else {
            mSignUpPassword.setError("Passwords do not match");
            mSignUpPasswordConfirm.setText("");
            return false;
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mFireBaseAuthCheck);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAuth!=null){
            mFirebaseAuth.removeAuthStateListener(mFireBaseAuthCheck);
        }
    }
    private void createUserProfile(final FirebaseUser user){
        UserProfileChangeRequest addProfileName=new UserProfileChangeRequest.Builder()
                .setDisplayName(mName)
                .build();
        user.updateProfile(addProfileName).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Log.d("Log this Name",user.getDisplayName());
                }
            }
        });
    }
}
