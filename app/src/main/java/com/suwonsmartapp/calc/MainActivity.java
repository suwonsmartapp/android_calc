package com.suwonsmartapp.calc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.suwonsmartapp.calc.util.Calculator;

public class MainActivity extends AppCompatActivity {

    private TextView mExpressionTextView;
    private TextView mAnswerTextView;

    private StringBuilder mStringBuilder;

    private Calculator mCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mExpressionTextView = (TextView) findViewById(R.id.tv_expression);
        mAnswerTextView = (TextView) findViewById(R.id.tv_answer);

        mCalculator = new Calculator();
        mStringBuilder = new StringBuilder();
    }

    // 숫자 클릭 이벤트
    public void onNumClick(View view) {
        if (view.getId() == R.id.answer) {
            mExpressionTextView.setText(mAnswerTextView.getText().toString());
            mAnswerTextView.setText("");

            mStringBuilder = new StringBuilder();
            mStringBuilder.append(mExpressionTextView.getText().toString());
        } else {
            mStringBuilder.append(((TextView) view).getText().toString());
            mExpressionTextView.setText(mStringBuilder.toString());

            result();
        }
    }

    private void result() {
        mAnswerTextView.setText(String.valueOf(mCalculator.calculate(mCalculator.getPostfix(mStringBuilder.toString()))));
    }

    // 연산자 클릭 이벤트
    public void onOperationClick(View view) {
        switch (view.getId()) {
            case R.id.del:
                if (mStringBuilder.length() != 0) {
                    mStringBuilder.deleteCharAt(mStringBuilder.length() - 1);
                    mExpressionTextView.setText(mStringBuilder.toString());

                    result();
                }

            break;

            default:
                String op = ((TextView)view).getText().toString();
                mExpressionTextView.setText(mStringBuilder.append(op).toString());
                break;
        }
    }
}
