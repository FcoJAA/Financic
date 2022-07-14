package com.example.financic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
    }

    public void changeToSignUp(View view){
        Intent i = new Intent(this,signup.class);
        startActivity(i);
    }

    public void changeToLogIn(View view){
        Intent i = new Intent(this,login.class);
        startActivity(i);
    }

    public void changeToProfile(View view){
        if(mAuth.getCurrentUser() != null){
            Intent i = new Intent(this, MyProfile.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Debe iniciar sesion primero", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, login.class);
            startActivity(i);
        }
    }
}