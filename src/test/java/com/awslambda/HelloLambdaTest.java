package com.awslambda;

import org.junit.jupiter.api.Test;

import com.amazonaws.services.lambda.runtime.Context;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;

/**
 * Unit test for simple App.
 */
public class HelloLambdaTest {
    @Test
    public void test1() {
        HelloLambda helloLambda = new HelloLambda();

        APIGatewayProxyRequestEvent input = new APIGatewayProxyRequestEvent();

        Context context = null;

        helloLambda.handleRequest(input, context);
    }
}
