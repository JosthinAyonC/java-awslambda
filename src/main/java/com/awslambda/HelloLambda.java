package com.awslambda;

import java.util.Date;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.JsonObject;

/**
 * First hello world
 *
 */
public class HelloLambda
        implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();

    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        if ("GET".equals(input.getHttpMethod())) {

            Map<String, String> parameters = input.getPathParameters();

            JsonObject objectResponse = new JsonObject();
            objectResponse.addProperty("path_param", parameters.get("id"));
            objectResponse.addProperty("code", 200);
            objectResponse.addProperty("path", input.getPath());
            objectResponse.addProperty("date", new Date().toString());

            return response
                    .withStatusCode(200)
                    .withBody(objectResponse.toString());
        } else {
            return response
                    .withStatusCode(400)
                    .withBody("Metodo no aceptado, pruebe con get");
        }
    }
}
