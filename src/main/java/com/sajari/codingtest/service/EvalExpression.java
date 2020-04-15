package com.sajari.codingtest.service;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.stereotype.Service;
/**
 * Service class to evaluate a given mathematical expression
 * @author Mamata
 *
 */
@Service
public class EvalExpression {
	
	/**
	 * This method accepts an expression and evaluates it using javascript engine
	 * For more information on ScriptEngine, please see https://docs.oracle.com/javase/8/docs/api/javax/script/ScriptEngine.html
	 * @param exp mathematical expression to be evaluated
	 * @return integer result
	 */
	
	public int evaluate(String exp) {
		int result = 0;
		try {
			ScriptEngineManager mgr = new ScriptEngineManager();
		    ScriptEngine engine = mgr.getEngineByName("JavaScript");
		    Object value = engine.eval(exp);
		    if(value instanceof Number)
		    	result = ((Number)value).intValue();
		}catch(ScriptException e) {
			e.printStackTrace();
		}
		return result;
	}

}

