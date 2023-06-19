package com.mostovoi.labwork2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private  static final int REQUEST_CODE_A = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.SendBtn);
        btn.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) {
                EditText message = (EditText) findViewById(R.id.Question);
                String messageText = message.getText().toString();

                Intent intent = new Intent(view.getContext(), SecondaryActivity.class);
                intent.putExtra("DataFromMainActivity", messageText);
                startActivityForResult(intent, REQUEST_CODE_A);
            }
        });
    }
    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_A)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                String result = data.getStringExtra("DataFromSecondaryActivity");
                TextView editor = (TextView) findViewById(R.id.Answer);
                editor.setText(result);
            }
        }
    }
}