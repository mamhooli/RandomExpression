package com.sajari.codingtest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.sajari.codingtest.service.EvalExpression;
import com.sajari.codingtest.service.RandomExpression;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
@SpringBootTest(classes = {RandomExpression.class, EvalExpression.class})
@EnableConfigurationProperties
class SajariCodingTestApplicationTests {
	
	@Autowired
	private EvalExpression evalExpression;

	@Test
	void getRandomExpressionTest() {
		RandomExpression randomExpr = new RandomExpression();
		String exp = randomExpr.getRandomExpression();
		assertNotNull(exp);
	}
	
	@Test
	void evalCorrectResultTest() {
		String exp = "(10+20)-5";
		int result = evalExpression.evaluate(exp);
		assertTrue("Result is Correct", result == 25);
	}
	
	@Test
	void evalIncorrectResultTest() {
		//RandomExpression randomExpr = new RandomExpression();
		String exp = "(50+30)+10";
		int result = evalExpression.evaluate(exp);
		assertFalse("Result is Incorrect", result == 80);
	}
}
