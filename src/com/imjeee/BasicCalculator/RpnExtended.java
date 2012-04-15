package com.imjeee.BasicCalculator;

import java.util.Stack;
/**
 * 
 * @author g
 *
 * RpnExtended adds sin, cos, tan, sqrt, custom x, custom y, and ¹ support
 */
public class RpnExtended extends Rpn {
	
	protected static double evalrpn(Stack<String> tks) throws Exception  {
    double result;
    String tk = tks.pop();
    if (tk.equals("Sin") || tk.equals("Cos") || tk.equals("Sqrt") || tk.equals("Tan")){
      double x = evalrpn(tks);
      result = unaryOp(x, tk);
    } else if (tk.equals("+") || tk.equals("-") || tk.equals("*") || tk.equals("/")) {
      double y = evalrpn(tks);
      double x = evalrpn(tks);
      result = binaryOp(x, y, tk);
    } else if (tk.equals("x")){
      result = BasicCalculatorActivity.x;
    } else if (tk.equals("y")){
      result = BasicCalculatorActivity.y;
    } else if (tk.equals("¹")){
      result = Math.PI;
    } else {
      result = Double.parseDouble(tk);
    }
    return result;
  }
     
  private static double unaryOp(double x, String op) {
    
    if (op.equals("Cos"))
      return Math.acos(x);
    else if (op.equals("Sin"))
      return Math.asin(x);
    else if (op.equals("Sqrt"))
      return Math.sqrt(x);
    else if (op.equals("Tan"))
      return Math.atan(x);
    else 
      System.out.println("unrecognized unary operation");
    return 0;
  }
     
  private static double binaryOp(double x, double y, String op) {
    if (op.equals("+"))
      return x + y;
    else if (op.equals("-"))
      return x - y;
    else if (op.equals("*"))
      return x * y;
    else if (op.equals("/")){
      return x / y;
    } else {
      System.out.println("unrecognized binary operation");
    }
    return 0;
  }
}

