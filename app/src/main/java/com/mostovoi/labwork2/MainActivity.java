package com.mostovoi.labwork2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.SendBtn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                EditText message = (EditText) findViewById(R.id.Question);
                Intent intent = new Intent(view.getContext(), SecondaryActivity.class);
                intent.putExtra("DataFromMainActivity", message.getText().toString());
                startActivity(intent);
            }
        });

        Bundle data = getIntent().getExtras();
        if(data != null)
        {
            String message = data.getString("DataFromSecondaryActivity");
            TextView textView = (TextView) findViewById(R.id.Answer);
            textView.setText(message);
        }
    }
}