package com.android.course.tripapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.course.tripapp.navigation_drawer.NavigationDrawerActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText email, password, username;
    private Button registerButton;
    private TextView singIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        username  = findViewById(R.id.username);
        registerButton = findViewById(R.id.register);
        singIn = findViewById(R.id.signIn);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailText, passwordText, usernameText;
                emailText = email.getText().toString();
                passwordText = password.getText().toString();
                usernameText = username.getText().toString();

                if(emailText.equals("")) {
                    Toast.makeText(RegisterActivity.this,"Email is blank!",Toast.LENGTH_SHORT).show();
                }
                else if(passwordText.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Password is blank!", Toast.LENGTH_SHORT).show();
                }  else if(usernameText.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Username is blank!", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(view.getContext(), NavigationDrawerActivity.class);
                    startActivity(intent);
                }
            }
        });

        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }
}