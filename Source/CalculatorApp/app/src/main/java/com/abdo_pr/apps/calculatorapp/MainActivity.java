package com.abdo_pr.apps.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

  private EditText equation_ent;
  private TextView displayResult;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    ///////// remove title bar //////////
    try {
      this.getSupportActionBar().hide();
    } catch (NullPointerException e){}
    /////////////////////////////////////

    displayResult = findViewById(R.id.displayResult);

    equation_ent = findViewById(R.id.equation_ent);
    equation_ent.setShowSoftInputOnFocus(false);
    equation_ent.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        if (getString(R.string.display).equals(equation_ent.getText().toString())) {
          equation_ent.setText("");
        }
      }
    });
  }

  public void updateText(String stradd) {
    String oldstr = equation_ent.getText().toString();
    int curpos = equation_ent.getSelectionStart();
    String leftstr = oldstr.substring(0, curpos);
    String rightstr = oldstr.substring(curpos);
    if (getString(R.string.display).equals(oldstr)) {
      equation_ent.setText(stradd);
    }else {
      equation_ent.setText(String.format("%s%s%s", leftstr, stradd, rightstr));
    }
    equation_ent.setSelection(curpos+1);
  }

  public void ButtonClick(View view ) {
    int curpos = equation_ent.getSelectionStart();
    int textlen = equation_ent.getText().length();
    String equation = equation_ent.getText().toString();
    switch (view.getId()) {
      case R.id.zero_btn:
        updateText("0");
        break;
      case R.id.one_btn:
        updateText("1");
        break;
      case R.id.two_btn:
        updateText("2");
        break;
      case R.id.three_btn:
        updateText("3");
        break;
      case R.id.four_btn:
        updateText("4");
        break;
      case R.id.five_btn:
        updateText("5");
        break;
      case R.id.six_btn:
        updateText("6");
        break;
      case R.id.seven_btn:
        updateText("7");
        break;
      case R.id.eight_btn:
        updateText("8");
        break;
      case R.id.nine_btn:
        updateText("9");
        break;
      case R.id.clear_btn:
        equation_ent.setText("");
        displayResult.setText(getString(R.string.display));
        equation_ent.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
        break;
      case R.id.exponent_btn:
        updateText("^");
        break;
      case R.id.parentheses_btn:
        int openpar = 0;
        int closepar = 0;
        for (int i = 0; i < curpos; i++) {
          if (equation.substring(i, i+1).equals("(")){
            openpar += 1;
          }else if (equation.substring(i, i+1).equals(")")){
            closepar += 1;
          }
        }
        if (openpar == closepar || equation.substring(textlen-1, textlen).equals("(")) {
          updateText("(");
        }else if (openpar > closepar && !equation.substring(textlen-1, textlen).equals("(")) {
          updateText(")");
        }
        equation_ent.setSelection(curpos+1);
        break;
      case R.id.divide_btn:
        updateText("/");
        break;
      case R.id.multiply_btn:
        updateText("×");
        break;
      case R.id.add_btn:
        updateText("+");
        break;
      case R.id.subtract_btn:
        updateText("-");
        break;
      case R.id.point_btn:
        updateText(".");
        break;
      case R.id.equals_btn:
        equation = equation.replace("÷", "/");
        equation = equation.replace("×", "*");
        equation = equation.replace("(", "*(");
        Expression exp = new Expression(equation);
        String res = String.valueOf(exp.calculate());
        if (res == "NaN"){
          equation_ent.getBackground().setColorFilter(Color.RED, PorterDuff.Mode.SRC_ATOP);
          displayResult.setText("Error");
        }else {
          equation_ent.getBackground().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_ATOP);
          displayResult.setText(res);
        }
        break;
      case R.id.backspase_btn:
        if (curpos != 0 && textlen != 0) {
          SpannableStringBuilder selection = (SpannableStringBuilder) equation_ent.getText();
          selection.replace(curpos-1, curpos, "");
          equation_ent.setText(selection);
          equation_ent.setSelection(curpos-1);
        }
        break;
    }
  }
}