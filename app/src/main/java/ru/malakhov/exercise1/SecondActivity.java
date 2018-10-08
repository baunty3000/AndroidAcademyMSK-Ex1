package ru.malakhov.exercise1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String KEY_TV2 = "KEY_TV2";
    private Button mBtnEmail;
    private TextView mTv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mTv2 = findViewById(R.id.tv2);
        mTv2.setText(getIntent().getStringExtra(KEY_TV2));
        mBtnEmail = findViewById(R.id.btnEmail);
        mBtnEmail.setOnClickListener(this);
    }

    public static void start(Activity activity, String text){
        Intent secondActivityIntent = new Intent(activity, SecondActivity.class);
        secondActivityIntent.putExtra(KEY_TV2, text);
        activity.startActivity(secondActivityIntent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEmail :
                sendEmail(this,new String[] {"baunty3000@gmail.com"},"subject");
                break;
        }
    }

    public void sendEmail(Activity activity,String[] to, String subject){
        Intent sendEmailIntent = new Intent(Intent.ACTION_SENDTO);
        sendEmailIntent.setData(Uri.parse("mailto:"));
        sendEmailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        sendEmailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        sendEmailIntent.putExtra(Intent.EXTRA_TEXT, getIntent().getStringExtra(KEY_TV2));
        if (sendEmailIntent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(sendEmailIntent);
        } else{
            Toast.makeText(activity, "Для отправки почты нужен почтовый клиент", Toast.LENGTH_SHORT).show();
        }
    }
}
