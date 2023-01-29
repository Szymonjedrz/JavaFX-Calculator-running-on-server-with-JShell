package com.example.prp.model;

public interface ICalcClient {

    void run() throws Exception;

    void sendMessage(String message);

    String getResult() throws Exception;
}
