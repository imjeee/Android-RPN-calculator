package com.imjeee.BasicCalculator;

import java.io.*;
import java.util.*;

public class Rpn  {
    public static void main(String[] args) throws IOException  {
    }

    public static double solve(String s){
        Stack<String> tks = new Stack<String>();
        tks.addAll(Arrays.asList(s.trim().split("[ \t]+")));
        try  {
            double r = evalrpn(tks);
            if (!tks.empty())  throw new Exception();
            return r;
        } catch (Exception e)  {
            System.out.println("error");
        }
        return 0;
    }
  
    private static double evalrpn(Stack<String> tks) throws Exception  {
      
        double result;
        String tk = tks.pop();
        if (tk.equals("Sin") || tk.equals("Cos") || tk.equals("Sqrt") || tk.equals("Tan")){
            double x = evalrpn(tks);
            result = unaryOp(x, tk);
        } else if (tk.equals("+") || tk.equals("-") || tk.equals("*") || tk.equals("/")) {
            double y = evalrpn(tks);
            double x = evalrpn(tks);
            result = binaryOp(x, y, tk);
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
            return Math.pow(x, 2);
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

    /*
      String tk = tks.pop();
      double x,y;
      try  {
    	x = Double.parseDouble(tk);
      } catch (Exception e)  {
    	y = evalrpn(tks);
    	x = evalrpn(tks);
      if      (tk.equals("+"))  x += y;
      else if (tk.equals("-"))  x -= y;
      else if (tk.equals("*"))  x *= y;
      else if (tk.equals("/"))  x /= y;
      else throw new Exception();
      }
      return x;
      }*/
}
  