package com.example.calculater_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private Button btn_share;
    private Integer firstVar;
    private Integer secondVar;
    private Boolean isOperationClick;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = findViewById(R.id.textView);
        btn_share = findViewById(R.id.share_btn);
        btn_share.setVisibility(View.GONE);
    }

    public void OnNumberClick(View view) {
        switch (view.getId()) {
            case R.id.numberOfZero:
                setNumber("0");
                break;

            case R.id.numberOfOne:
                setNumber("1");
                break;
            case R.id.numberOfTwo:
                setNumber("2");
                break;

            case R.id.numberOfThree:
                setNumber("3");
                break;

            case R.id.numberOfFour:
                setNumber("4");
                break;
            case R.id.numberOfFive:
                setNumber("5");
                break;

            case R.id.numberOfSix:
                setNumber("6");
                break;

            case R.id.numberOfSeven:
                setNumber("7");
                break;

            case R.id.numberOfEight:
                setNumber("8");
                break;

            case R.id.numberOfNine:
                setNumber("9");
                break;

            case R.id.tochka:
                setNumber(".");
                break;

            case R.id.btn_plusAndMinus:
                setNumber("-");
                break;

            case R.id.btn_clearText:
                tvResult.setText("0");
                firstVar = 0;
                secondVar = 0;
                break;
        }
    }


    private void setNumber(String number) {
        if (tvResult.getText().toString().equals("0")) {
            tvResult.setText(number);
        } else if (isOperationClick) {
            tvResult.setText(number);
        } else {
            tvResult.append(number);
        }
        isOperationClick = false;
    }

    public void OnOperationClick(View view) {
        switch (view.getId()) {
            case R.id.summa:
                //11
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isOperationClick = true;
                operation = "+";
                break;

            case R.id.minus:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isOperationClick = true;
                operation = "-";
                break;


            case R.id.btn_ymnojenie:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isOperationClick = true;
                operation = "X";
                break;

            case R.id.btn_delenie:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isOperationClick = true;
                operation = "/";
                break;

            case R.id.btn_procent:
                firstVar = Integer.parseInt(tvResult.getText().toString());
                isOperationClick = true;
                operation = "%";
                break;


            case R.id.rovno:
                secondVar = Integer.parseInt(tvResult.getText().toString());
                Integer result = 0;
                if (isOperationClick = true) {
                    btn_share.setVisibility(View.VISIBLE);


                    btn_share.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                            String text = tvResult.getText().toString();
                            intent.putExtra("key", text);
                            startActivity(intent);
                            finishActivity(123);
                        }
                    });

                }


                switch (operation) {
                    case "+":
                        result = firstVar + secondVar;
                        break;

                    case "-":
                        result = firstVar - secondVar;
                        break;

                    case "X":
                        result = firstVar * secondVar;
                        break;

                    case "/":
                        result = firstVar / secondVar;
                        break;

                    case "%":
                        result = (secondVar * 100) / firstVar;
                        break;
                }

                tvResult.setText(result.toString());
                break;


        }
    }
}


