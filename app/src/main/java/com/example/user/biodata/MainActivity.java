package com.example.user.biodata;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButtonOnOf;
    CheckBox checkBoxEnglish, checkBoxIndonesia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "On Create", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "OnCreate");

        toggleButtonOnOf = (ToggleButton) findViewById(R.id.btn_off);
        checkBoxEnglish = (CheckBox) findViewById(R.id.cBtn_english);
        checkBoxIndonesia = (CheckBox) findViewById(R.id.cBtn_Indonesia);

        /**********            Toggle               **********/
        toggleButtonOnOf.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            String onOff=null;
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    onOff = "ON";
                }else{
                    onOff = "OF";
                }
                Toast.makeText(MainActivity.this, onOff, Toast.LENGTH_SHORT).show();
            }
        });




    }

    public void onClickBahasa(View view){
        checkBoxEnglish.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "English", Toast.LENGTH_SHORT).show();
            }
        });

        checkBoxIndonesia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "Indonesia", Toast.LENGTH_SHORT).show();
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
    }

    /**********            Exit               **********/
    public void exit(View view){
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

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "On Start", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "OnStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "On Pause", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "On Resume", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "OnResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "On Restart", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "OnRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "On Stop", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "On Destroy", Toast.LENGTH_SHORT).show();
        Log.i("MainActivity", "OnDestroy");
    }

}
