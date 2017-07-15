package com.example.denfox.supermegaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button btnClear;
    private Button btnSend;
    private CheckBox checkBox;

    String nameFromEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing buttons, edit text, checkbox

        editText = (EditText) findViewById(R.id.editText);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnSend = (Button) findViewById(R.id.btnSend);
        checkBox = (CheckBox) findViewById(R.id.chBox);

        checkBox.setChecked(true);

        btnSend.setOnClickListener(this);
        btnClear.setOnClickListener(this);
        editText.setOnClickListener(this);
        checkBox.setOnClickListener(this);

        nameFromEditText = editText.getText().toString();


    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.btnClear:
                editText.setText("");
                break;
            case R.id.btnSend:
                if (editText.getText().toString().equals("")
                        | !editText.getText().toString().contains("@")
                        | !checkBox.isChecked()) {
                    break;
                }
                Intent intent = new Intent(this, SecondActivity.class);
                intent.putExtra("text", editText.getText().toString());
                startActivityForResult(intent, 1);
                break;
            default:
                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data == null) {
            return;
        } else if (data.equals("")) {
            editText.setHint(nameFromEditText);
        }
    }
}
