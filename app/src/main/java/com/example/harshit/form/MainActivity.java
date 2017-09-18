package com.example.harshit.form;

import android.content.Intent;
import android.support.annotation.IdRes;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import static android.R.attr.checked;
import static android.R.attr.checkedButton;

public class MainActivity extends AppCompatActivity {

    private EditText username, password, email, phone, dob, tob, state, interest;
    private Button submit;
    private RadioButton male, female;
    private RadioGroup radiogp;
    private String selectedType="";

    String[] spinnerList = {"Australia", "Bangladesh", "China", "Denmark", "Egypt", "France", "Germany", "Hong Kong", "India", "Japan" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.input_username);
        password = (EditText)findViewById(R.id.input_password);
        email = (EditText)findViewById(R.id.input_email);
        phone = (EditText)findViewById(R.id.input_phone);
        dob = (EditText)findViewById(R.id.input_dob);
        tob = (EditText)findViewById(R.id.input_tob);
        state = (EditText)findViewById(R.id.input_state);
        interest = (EditText)findViewById(R.id.input_interest);
        submit = (Button)findViewById(R.id.btn_submit);
        male = (RadioButton) findViewById(R.id.male_radio_btn);
        female = (RadioButton) findViewById(R.id.female_radio_btn);
        radiogp = (RadioGroup) findViewById(R.id.radio_group);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, spinnerList);
        MaterialBetterSpinner materialDesignSpinner = (MaterialBetterSpinner)
                findViewById(R.id.country);
        materialDesignSpinner.setAdapter(arrayAdapter);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1 = username.getText().toString();
                String password1 = password.getText().toString();
                String email1 = email.getText().toString();
                String phone1 = phone.getText().toString();
                String interest1 = interest.getText().toString();
                String tob1 = tob.getText().toString();
                String dob1 = dob.getText().toString();
                String state1 = state.getText().toString();

                int selectedId = radiogp.getCheckedRadioButtonId();

                RadioButton radiobtn = (RadioButton) findViewById(selectedId);

                selectedType = radiobtn.getText().toString();

                if( username1.equals("") || password1.equals("") || email1.equals("") || phone1.equals("") || interest1.equals("") || dob1.equals("") || tob1.equals("") || state1.equals(""))
                {
                    Toast.makeText(MainActivity.this,"Please fill missing details!!!",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Intent i = new Intent(MainActivity.this, showDetails.class);

                    i.putExtra("username", username1);
                    i.putExtra("password", password1);
                    i.putExtra("email", email1);
                    i.putExtra("phone", phone1);
                    i.putExtra("interest", interest1);
                    i.putExtra("tob", tob1);
                    i.putExtra("dob",dob1);
                    i.putExtra("state", state1);
                    i.putExtra("gender",selectedType);
                    startActivity(i);
                }

            }
        });

    }

}
