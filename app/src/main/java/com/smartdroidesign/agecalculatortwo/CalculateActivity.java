package com.smartdroidesign.agecalculatortwo;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CalculateActivity extends AppCompatActivity {

    private TextView ageResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        ageResult = findViewById(R.id.age_txt_result);

        User user = getIntent().getParcelableExtra("userData");
        ageResult.setText(String.format("%s %s", user.getUserBirthday(), user.getCurrentDate()));

    }
}
