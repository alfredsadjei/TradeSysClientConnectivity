package com.ClientConnectivity.tradeSystem.services;

import com.ClientConnectivity.tradeSystem.models.ProductOrder;
import com.example.consumingwebservice.wsdl.PostOrderRequest;
import com.example.consumingwebservice.wsdl.PostOrderResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;



public class OrderValidationClient extends WebServiceGatewaySupport {

    public PostOrderResponse validateOrder(ProductOrder productOrder){

        PostOrderRequest request = new PostOrderRequest();
        request.setID(productOrder.getID());
        request.setPrice(productOrder.getPrice());
        request.setClientId(productOrder.getClientId());
        request.setFunds(productOrder.getFunds());
        request.setQuantityOwned(productOrder.getQuantityOwned());
        request.setQuantity(productOrder.getQuantity());
        request.setSide(productOrder.getSide());
        request.setProductName(productOrder.getProductName());
        request.setDate( productOrder.getTimeCreated().toString());

        return (PostOrderResponse) getWebServiceTemplate()
                .marshalSendAndReceive("https://order-val.herokuapp.com/ws/productOrder", request ,
                        new SoapActionCallback("http://www.order.com/validate/postOrderRequest"));

    }

}
