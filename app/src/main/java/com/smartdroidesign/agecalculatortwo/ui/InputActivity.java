package com.smartdroidesign.agecalculatortwo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.smartdroidesign.agecalculatortwo.R;
import com.smartdroidesign.agecalculatortwo.model.User;
import com.smartdroidesign.agecalculatortwo.presenter.CalculateActivity;

public class InputActivity extends AppCompatActivity {

    private TextView birthdayHeaderInput;
    private TextView currentFooterInput;

    private EditText birthdayFieldInput;
    private EditText currentFieldInput;

    private String birthdayDate;
    private String currentDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        birthdayHeaderInput = findViewById(R.id.header_txt_input);
        currentFooterInput = findViewById(R.id.header_two_txt_input);

        birthdayFieldInput = findViewById(R.id.birthday_txt_input);
        currentFieldInput = findViewById(R.id.current_txt_input);

        Button calculateButtonInput = findViewById(R.id.calculateBtnInput);

        calculateButtonInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InputActivity.this, CalculateActivity.class);
                birthdayDate = birthdayFieldInput.getText().toString().trim();
                currentDate = currentFieldInput.getText().toString().trim();
                User user = new User(birthdayDate, currentDate);
                intent.putExtra("userData", user);
                startActivity(intent);
            }
        });
    }
}
