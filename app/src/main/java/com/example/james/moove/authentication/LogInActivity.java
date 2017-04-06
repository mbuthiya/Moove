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

public class LogInActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.ed_loginEmail)EditText mLoginEmail;
    @Bind(R.id.ed_loginPassword)EditText mLoginPassword;
    @Bind(R.id.btn_loginBtn)Button mLoginButton;
    @Bind(R.id.tv_goToSignUp)TextView mGoToSignUpTextView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);
        mGoToSignUpTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==mGoToSignUpTextView){
            intent=new Intent(LogInActivity.this,SignInActivity.class);
            startActivity(intent);
        }
    }
}
