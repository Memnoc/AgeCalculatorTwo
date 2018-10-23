package com.smartdroidesign.agecalculatortwo.presenter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.smartdroidesign.agecalculatortwo.R;
import com.smartdroidesign.agecalculatortwo.model.User;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CalculateActivity extends AppCompatActivity {

    private TextView ageResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        ageResult = findViewById(R.id.age_txt_result);

        calculateTime();

    }

    private void calculateTime() {
        User user = getIntent().getParcelableExtra("userData");
        String dateStart = user.getUserBirthday();
        String dateStop = user.getCurrentDate();

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.UK);
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = format.parse(dateStart);
            date2 = format.parse(dateStop);
            DateTime dt1 = new DateTime(date1);
            DateTime dt2 = new DateTime(date2);
            ageResult.setText(String.format(Locale.UK, "%s%d hours, ", String.format(Locale.UK, "%d days, ", Days.daysBetween(dt1, dt2).getDays()), Hours.hoursBetween(dt1, dt2).getHours() % 24));
        } catch (
                ParseException e) {
            e.printStackTrace();
        }
    }
}
