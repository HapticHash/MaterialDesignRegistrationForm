package com.example.harshit.form;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class showDetails extends AppCompatActivity {

    TextView username, password, email, phone, interest, dob, tob, state, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);


        username = (TextView) findViewById(R.id.name);
        password = (TextView) findViewById(R.id.password);
        email = (TextView) findViewById(R.id.email);
        phone = (TextView) findViewById(R.id.number);
        interest = (TextView) findViewById(R.id.interest);
        dob = (TextView) findViewById(R.id.date);
        tob = (TextView) findViewById(R.id.time);
        state = (TextView) findViewById(R.id.state);
        gender = (TextView) findViewById(R.id.gender);

        Intent i = getIntent();
        String username1 = i.getExtras().getString("username");
        String password1 = i.getExtras().getString("password");
        String email1 = i.getExtras().getString("email");
        String phone1 = i.getExtras().getString("phone");
        String intrest1 = i.getExtras().getString("interest");
        String TOB1 = i.getExtras().getString("tob");
        String DOB1 = i.getExtras().getString("dob");
        String state1 = i.getExtras().getString("state");
        String gender1 = i.getExtras().getString("gender");

        username.setText(username1);
        password.setText(password1);
        email.setText(email1);
        phone.setText(phone1);
        interest.setText(intrest1);
        tob.setText(TOB1);
        dob.setText(DOB1);
        state.setText(state1);
        gender.setText(gender1);
    }
}
