package com.example.denfox.supermegaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private Button buttonApprove;
    private Button buttonReject;

    private String nameToPrint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = (TextView) findViewById(R.id.textView);
        buttonApprove = (Button) findViewById(R.id.btnApprove);
        buttonReject = (Button) findViewById(R.id.btnReject);

        buttonApprove.setOnClickListener(this);
        buttonReject.setOnClickListener(this);

        if (!TextUtils.isEmpty(getIntent().getStringExtra("text"))) {

            nameToPrint = getIntent().getStringExtra("text");
            textView.setText(nameToPrint);
        }

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnApprove:
                Intent intent = new Intent();
                intent.putExtra("text2", "");
                setResult(RESULT_OK, intent);
                Toast.makeText(this, "Действие подтверждено", Toast.LENGTH_SHORT).show();
                finish();
                break;


            case R.id.btnReject:
                Intent intent2 = new Intent();
                intent2.putExtra("text2", textView.getText().toString());
                setResult(RESULT_OK, intent2);
                Toast.makeText(this, "Действие отменено", Toast.LENGTH_SHORT).show();
                finish();
                break;

            default:
                break;


        }

    }
}
