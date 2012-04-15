package com.imjeee.BasicCalculator;

import java.util.*;

public class Rpn  {
	
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
  
  protected static double evalrpn(Stack<String> tks) throws Exception {
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
  }
}
  