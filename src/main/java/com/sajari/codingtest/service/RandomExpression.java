package com.sajari.codingtest.service;

import java.util.Random;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Service class to generate random mathematical expression
 * @author Mamata
 */
@Service
@RequestScope
public class RandomExpression {
 
    static int j = 0;
    String exp = null;
    private Random randomOpGenerator = new Random();
    private Random randomDigitGenerator = new Random();
    private int digitCounter = 0;
 
    private String getRandomOp(String[] arr) {
        int rdm = randomOpGenerator.nextInt(arr.length);  
        return arr[rdm];  
    }
    
    private int getRandomDigit() {
        int digit = randomDigitGenerator.nextInt(100);
        digitCounter++;
        return digit;  
    }
 
    public String getRandomExpression() {
        String[] randOpr = {"+","-","*","/"};
        while(digitCounter < 3) {
            String operator = getRandomOp(randOpr);
            if(exp == null){
                exp = "(" + getRandomDigit() + operator+getRandomDigit() + ")";
            }else{
                exp = exp+operator+getRandomDigit();
            }
        }
        return exp;
    }
}

