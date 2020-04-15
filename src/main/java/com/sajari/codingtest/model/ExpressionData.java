package com.sajari.codingtest.model;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * The mathematical expression object stomer object which contains the expression, actual result and user result
 * @author Mamata
 */
@Component
public class ExpressionData {
	
	private String expression;
    private String userResult;
    private String actualResult;

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getUserResult() {
        return userResult;
    }

    @Nullable
    public void setUserResult(String userResult) {
        this.userResult = userResult;
    }
    
    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }


}
