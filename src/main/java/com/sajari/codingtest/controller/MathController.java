package com.sajari.codingtest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sajari.codingtest.model.ExpressionData;
import com.sajari.codingtest.service.EvalExpression;
import com.sajari.codingtest.service.RandomExpression;

/**
 * Controller class for this Spring application
 * @author Mamata
 */
@Controller
public class MathController {
	
	@Autowired
	private RandomExpression randomExpr;
	
	@Autowired
	private EvalExpression eval;
	
	String globalExpression = null;
	
	/**
	 * Entry point of this application. This method returns a random mathematical expression.
	 * @param expressionData
	 * @return html template
	 */
	@GetMapping("/randomExpression")
	public String getExpression(ExpressionData expressionData) {
		globalExpression = randomExpr.getRandomExpression();
		expressionData.setExpression(globalExpression);		
		return "evaluate";
	}
	
	/**
	 * Method to evaluate the mathematical expression and compare the result with user's result
	 * @param expressionData
	 * @return html template
	 */
	@PostMapping("/randomExpression")
	public String checkResult(ExpressionData expressionData) {
        int result = eval.evaluate(globalExpression);
        expressionData.setActualResult(Integer.toString(result));
        if (expressionData.getUserResult() != null && !expressionData.getUserResult().equals("") && result == Integer.parseInt(expressionData.getUserResult()))
        	return "showSlowMessage";
        else
        	return "showErrorMessage";
	  }
}
