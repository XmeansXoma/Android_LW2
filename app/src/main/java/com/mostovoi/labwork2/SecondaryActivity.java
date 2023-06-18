package com.mostovoi.labwork2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

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
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                intent.putExtra("DataFromSecondaryActivity", message.getText().toString());
                startActivity(intent);
            }
        });

        Bundle data = getIntent().getExtras();
        if(data != null){
            String message = data.getString("DataFromMainActivity");
            TextView textView = (TextView) findViewById(R.id.question);
            textView.setText(message);
        }
    }
}