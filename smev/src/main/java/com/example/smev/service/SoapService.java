package com.example.smev.service;

import com.example.smev.models.Request;
import com.example.smev.models.Response;

public interface SoapService {
    Response sendMessage(Request request);
}
