package com.mostovoi.labwork2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {
    private final int REQUEST_CODE_B = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        Button btn = (Button) findViewById(R.id.AnswerBtn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                EditText message = (EditText) findViewById(R.id.answer);
                String messageText = message.getText().toString();

                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("DataFromSecondaryActivity", messageText);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        // Getting data from MainActivity
        Bundle data =  getIntent().getExtras();
        if(data != null)
        {
            String message = data.getString("DataFromMainActivity");
            TextView textView = (TextView) findViewById(R.id.question);
            textView.setText(message);
        }
    }
}