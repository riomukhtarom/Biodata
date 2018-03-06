package com.example.user.biodata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView textViewName, textViewBirthday, textViewAge, textViewGender, textViewLanguange;

    String name, birthday, age, gender, languange;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textViewName = (TextView) findViewById(R.id.textView_name);
        textViewBirthday = (TextView) findViewById(R.id.textView_birthday);
        textViewAge = (TextView) findViewById(R.id.textView_age);
        textViewGender = (TextView) findViewById(R.id.textView_gender);
        textViewLanguange = (TextView) findViewById(R.id.textView_languange);

        Bundle bundle = getIntent().getExtras();

        name = "Nama Anda "+bundle.getString("name");
        birthday = "Anda lahir di "+bundle.getString("birthdayPlace")+" pada "+bundle.getString("birthdayDay")+" "+bundle.getString("birthdayMonth")+" "+bundle.getString("birthdayYear");
        age = "Anda berumur "+bundle.getString("age")+" tahun";
        gender = "Anda adalah "+bundle.getString("gender");
        languange = "Anda menguasai bahasa "+bundle.getString("english")+", "+bundle.getString("indonesia")+", "+bundle.getString("bugis")+", "+bundle.getString("makassar");

        textViewName.setText(name);
        textViewBirthday.setText(birthday);
        textViewAge.setText(age);
        textViewGender.setText(gender);
        textViewLanguange.setText(languange);
    }
}
