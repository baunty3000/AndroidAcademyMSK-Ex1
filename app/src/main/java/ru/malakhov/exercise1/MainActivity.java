package ru.malakhov.exercise1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnPreview;
    EditText etMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPreview = findViewById(R.id.btnPreview);
        etMain = findViewById(R.id.etMain);
        btnPreview.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPreview :
                openSecondActivity();
                break;
        }
    }

    public void openSecondActivity(){
        SecondActivity.start(this,etMain.getText().toString());
    }
}
