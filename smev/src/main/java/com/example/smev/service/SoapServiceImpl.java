package com.example.smev.service;

import com.example.smev.models.Request;
import com.example.smev.models.Response;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;


@Service
public class SoapServiceImpl implements SoapService{
    private final WebServiceTemplate webServiceTemplate;

    public SoapServiceImpl(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    @Override
    public Response sendMessage(Request request) {
        // отправка SOAP-запроса и получение SOAP-ответа
        return (Response) webServiceTemplate.
                marshalSendAndReceive("http://localhost:7575/ws/SMEVServiceAdapterService?wsdl", request);
    }
}
