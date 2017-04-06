package com.example.james.moove.authentication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.james.moove.R;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind(this);
        mGoToLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v==mGoToLogin){
            intent=new Intent(SignInActivity.this,LogInActivity.class);
            startActivity(intent);

        }
    }
}
