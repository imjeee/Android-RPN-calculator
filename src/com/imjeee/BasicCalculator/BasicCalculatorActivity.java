package com.imjeee.BasicCalculator;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class BasicCalculatorActivity extends Activity {

  public TextView solution;
  public EditText toCalculate;
  public static Double x;
  public static Double y;
  RpnExtended calculator;
  

  private int[] savedVarButtons = {R.id.SaveX, R.id.SaveY, R.id.UseX, R.id.UseY};
  private int[] specialButtons = {R.id.Equal, R.id.Clear, R.id.Space};
  private int[] buttons = {R.id.Sin, R.id.Cos, R.id.Tan, R.id.Sqrt, 
                           R.id.Number7, R.id.Number8, R.id.Number9, R.id.Plus,
                           R.id.Number4, R.id.Number5, R.id.Number6, R.id.Minus,
                           R.id.Number1, R.id.Number2, R.id.Number3, R.id.Multiply,
                           R.id.Number0, R.id.Dot, R.id.Pi, R.id.Divide};

  /** Called when the activity is first created. */
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.setContentView(R.layout.main);

    initSavedVarButtons();
    initScreenButtons();
    initSpecialButton();
    initToCalculate();
    calculator = new RpnExtended();
  }

  private void initSavedVarButtons(){
    x = 0.0;
    y = 0.0;

    for (int i : savedVarButtons){
      final Button btn = (Button) findViewById(i);
      btn.setOnClickListener(new OnClickListener() {
          public void onClick(View v){
            String btnString = btn.getText().toString();
            if (btnString.equals("Save x"))
              x = Double.valueOf(solution.getText().toString());
            else if (btnString.equals("x"))
              toCalculate.append(" x ");
            else if (btnString.equals("Save y"))
              y = Double.valueOf(solution.getText().toString());
            else if (btnString.equals("y"))
              toCalculate.append(" y ");
            else 
              System.out.println("error");
          }         
        });
    }
  }

  private void initToCalculate(){
    toCalculate = (EditText) findViewById(R.id.ToCalculate);
    solution = (EditText) findViewById(R.id.Solution);
    solution.setText("0.0");
  }

  private void initSpecialButton(){
    for (int i : specialButtons){
      final Button btn = (Button) findViewById(i);
      btn.setOnClickListener(new OnClickListener() {
          public void onClick(View v){
            String btnString = btn.getText().toString();
            if (btnString.equals("=")){
              double result = calculator.solve(toCalculate.getText().toString());
              solution.setText(Double.toString(result));
            } else if (btnString.equals("Space"))
              toCalculate.append(" ");
            else if (btnString.equals("C"))
              toCalculate.setText("");
            else 
              System.out.println("error");
          }         
        });
    }
  }

  private void initScreenButtons(){
    for (int i : buttons){
      final Button btn = (Button) findViewById(i);
      btn.setOnClickListener(new OnClickListener() {
          public void onClick(View v){
            toCalculate.append(btn.getText().toString());
          }         
        });
    }
  }

}