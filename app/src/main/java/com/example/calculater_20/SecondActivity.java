package com.example.calculater_20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
    public class SecondActivity extends AppCompatActivity {
    private TextView resultText;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        resultText = findViewById(R.id.textView);
        button = findViewById(R.id.share_btn);

        resultText.setText(getIntent().getStringExtra("key"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

