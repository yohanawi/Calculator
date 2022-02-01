package com.example.s_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    //variables
    private TextView previousCalculation;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooks
        previousCalculation = findViewById(R.id.previous_View);
        display = findViewById(R.id.display_EditText);

        display.setShowSoftInputOnFocus(false);
    }

    private void updateText(String strToAdd){
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        display.setText(String.format("%s%s%s", leftStr,strToAdd,rightStr));
        display.setSelection(cursorPos + strToAdd.length());
    }

    public void ClearBTNPush(View view){
        display.setText("");
        previousCalculation.setText("");
    }//all clear button
    public void backspaceBTNPush(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos-1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos-1);
        }
    }//backspace button
    public void percentageBTNPush(View view){
        updateText(getResources().getString(R.string.percentage));
    }//percentage button call
    public void multiplyBTNPush(View view){
        updateText(getResources().getString(R.string.multiplyText));
    }//multiply button call
    public void divideBTNPush(View view){
        updateText(getResources().getString(R.string.divideText));
    }//divide button call
    public void subtractBTNPush(View view){
        updateText(getResources().getString(R.string.subtractText));
    }//subtract button call
    public void addBTNPush(View view){
        updateText(getResources().getString(R.string.addText));
    }//add button call
    public void equalBTNPush(View view){
        String userExp = display.getText().toString();

        previousCalculation.setText(userExp);

        userExp = userExp.replaceAll(getResources().getString(R.string.divideText), "/");
        userExp = userExp.replaceAll(getResources().getString(R.string.multiplyText), "*");

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());
    }//equal button call

    public void zeroBTNPush(View view){
        updateText(getResources().getString(R.string.zeroText));
    }//zero button call
    public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.oneText));
    }//one button call
    public void twoBTNPush(View view){
        updateText(getResources().getString(R.string.twoText));
    }//two button call
    public void threeBTNPush(View view){
        updateText(getResources().getString(R.string.threeText));
    }//there button call
    public void fourBTNPush(View view){
        updateText(getResources().getString(R.string.fourText));
    }//four button call
    public void fiveBTNPush(View view){
        updateText(getResources().getString(R.string.fiveText));
    }//five button call
    public void sixBTNPush(View view){
        updateText(getResources().getString(R.string.sixText));
    }//six button call
    public void sevenBTNPush(View view){
        updateText(getResources().getString(R.string.sevenText));
    }//seven button call
    public void eightBTNPush(View view){
        updateText(getResources().getString(R.string.eightText));
    }//eight button call
    public void nineBTNPush(View view){
        updateText(getResources().getString(R.string.nineText));
    }//nine button call
    public void decimalBTNPush(View view){
        updateText(getResources().getString(R.string.decimalText));
    }//decimal button call

}