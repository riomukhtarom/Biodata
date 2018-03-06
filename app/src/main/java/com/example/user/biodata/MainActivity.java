package com.example.user.biodata;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    EditText editTextName, editTextAge, editTextBirthdayPlace;
    ToggleButton toggleButtonOnOf;
    Spinner spinnerDate, spinnerMonth, spinnerYear;
    CheckBox checkBoxEnglish, checkBoxIndonesia, checkBoxBugis, checkBoxMakassar;
    RadioGroup radioGroupGender;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButtonOnOf = (ToggleButton) findViewById(R.id.btn_off);
        checkBoxEnglish = (CheckBox) findViewById(R.id.cBtn_english);
        checkBoxIndonesia = (CheckBox) findViewById(R.id.cBtn_Indonesia);
        checkBoxBugis = (CheckBox) findViewById(R.id.cBtn_Bugis);
        checkBoxMakassar = (CheckBox) findViewById(R.id.cBtn_Makassar);

        // Birthday
        spinnerDate = (Spinner) findViewById(R.id.spin_date);
        spinnerMonth = (Spinner) findViewById(R.id.spin_month);
        spinnerYear = (Spinner) findViewById(R.id.spin_year);

        editTextName = (EditText) findViewById(R.id.et_nama);
        editTextAge = (EditText) findViewById(R.id.et_umur);
        editTextBirthdayPlace = (EditText) findViewById(R.id.et_tempatLahir);

        radioGroupGender = (RadioGroup) findViewById(R.id.radioGroup_gender);


        // Birthday
        final ArrayAdapter<CharSequence> spinnerDateAdapter = ArrayAdapter.createFromResource(this, R.array.date, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> spinnerMonthAdapter = ArrayAdapter.createFromResource(this, R.array.month, android.R.layout.simple_spinner_item);
        final ArrayAdapter<CharSequence> spinnerYearAdapter = ArrayAdapter.createFromResource(this, R.array.year, android.R.layout.simple_spinner_item);

        spinnerDateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerDate.setAdapter(spinnerDateAdapter);
        spinnerMonth.setAdapter(spinnerMonthAdapter);
        spinnerYear.setAdapter(spinnerYearAdapter);

        spinnerDate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, spinnerDateAdapter.getItem(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Nothing Select", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, spinnerMonthAdapter.getItem(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Nothing Select", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerYear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, spinnerYearAdapter.getItem(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MainActivity.this, "Nothing Select", Toast.LENGTH_SHORT).show();
            }
        });


        /**********            Toggle               **********/
        toggleButtonOnOf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            String onOff = null;

            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    onOff = "ON";
                } else {
                    onOff = "OF";
                }
                Toast.makeText(MainActivity.this, onOff, Toast.LENGTH_SHORT).show();
            }
        });

        checkBoxEnglish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean status) {
                if(status){
                    Toast.makeText(MainActivity.this, "English", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBoxIndonesia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean status) {
                if(status){
                    Toast.makeText(MainActivity.this, "Indonesia", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBoxBugis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean status) {
                if(status){
                    Toast.makeText(MainActivity.this, "Bugis", Toast.LENGTH_SHORT).show();
                }
            }
        });

        checkBoxMakassar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean status) {
                if(status){
                    Toast.makeText(MainActivity.this, "Makassar", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    /**********            Jenis Kelamin               **********/
    public void radioButtonChecked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.rBtn_male:
                if(checked){
                    Toast.makeText(MainActivity.this, "male", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rBtn_female:
                if(checked){
                    Toast.makeText(MainActivity.this, "female", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        gender = ((RadioButton)findViewById(radioGroupGender.getCheckedRadioButtonId())).getText().toString();
    }

    /**********            Exit               **********/
    public void onClickExit(View view){
        AlertDialog.Builder exitAlert = new AlertDialog.Builder(this);
        exitAlert.setTitle("Exit");
        exitAlert.setMessage("Are You Sure?");
        exitAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        exitAlert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        exitAlert.setCancelable(false);
        exitAlert.show();
    }

    public void onClickProcess(View view){
        Intent intentToDetailActivity = new Intent(this, DetailActivity.class);
        intentToDetailActivity.putExtra("name", editTextName.getText().toString());
        intentToDetailActivity.putExtra("age", editTextAge.getText().toString());
        intentToDetailActivity.putExtra("birthdayPlace", editTextBirthdayPlace.getText().toString());
        intentToDetailActivity.putExtra("birthdayDay", spinnerDate.getSelectedItem().toString());
        intentToDetailActivity.putExtra("birthdayMonth", spinnerMonth.getSelectedItem().toString());
        intentToDetailActivity.putExtra("birthdayYear", spinnerYear.getSelectedItem().toString());

        if(checkBoxEnglish.isChecked()){
            intentToDetailActivity.putExtra("english", "English");
        }
        if(checkBoxIndonesia.isChecked()){
            intentToDetailActivity.putExtra("indonesia", "Indonesia");
        }
        if(checkBoxBugis.isChecked()){
            intentToDetailActivity.putExtra("bugis", "Bugis");
        }
        if(checkBoxMakassar.isChecked()){
            intentToDetailActivity.putExtra("makassar", "Makassar");
        }

        intentToDetailActivity.putExtra("gender", gender);
        startActivity(intentToDetailActivity);
    }

}
