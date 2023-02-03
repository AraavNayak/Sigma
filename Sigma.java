//Araav Nayak
//Thursday Feb 2 
//5pm

import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Sigma {
	
	public static void main(String[] args) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("JavaScript");
		Scanner s = new Scanner(System.in);
		
		//Example input: i=1 sigma 5 5*i
		//Output: 15.0
		String input = s.nextLine();
		
		char varName = input.charAt(0);
		int startVal = Integer.parseInt(input.substring(input.indexOf("=")+1, input.indexOf(" ")).trim());
		int endVal = Integer.parseInt(input.substring(input.indexOf("sigma")+"sigma".length(), input.indexOf(" ", input.indexOf("sigma")+"sigma".length()+1)).trim());
		String function = input.substring(input.lastIndexOf(" ")).trim();
				
		double sum = 0;
		for(int i = startVal; i <= endVal; i++) {
			try {
				Object result = engine.eval(evaluateFunction(function, varName, i));
				if((""+result).indexOf(".") == -1) {
					//int
					sum += (Integer)result;
				} else {
					sum += (Double)result;
				}
			} catch (ScriptException e) {
				e.printStackTrace();
			}
		}
		System.out.println(sum);
		s.close();
		
	}
	
	//variable must be one character
	public static String evaluateFunction(String function, char variableName, int value) {
		for(int i = 0; i < function.length(); i++) {
			if(function.charAt(i) == variableName) {
				function = function.substring(0,i) + value + function.substring(i+1);
			}
		}
		return function;
	}
	
	
}
