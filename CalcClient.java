package com.example.prp.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CalcClient implements AutoCloseable, ICalcClient {

	private String host;
	private int port;
	private Socket socket;
	private BufferedReader inputBufferedReader;
	private PrintWriter outputPrintWriter;

	private String result;

	private ICalcClient iCalcClient;

	public CalcClient(ICalcClient iCalcClient) {
		this.iCalcClient = iCalcClient;
	}

	public CalcClient(String host, int port) {
		this.host = host;
		this.port = port;
		System.out.println("CalcClient created");
	}

	@Override
	public void close() throws Exception {
		socket.close();
	}

	public void run() throws Exception {
		socket = new Socket(host, port);
		System.out.println("Client socket created");
		inputBufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		outputPrintWriter = new PrintWriter(socket.getOutputStream(), true);
		System.out.println("Input and output bufers catched");

		Runnable task = () -> {
			System.out.println("Run method executed");
			try {
				while (true) {
					result = inputBufferedReader.readLine();
					System.out.println("Result from server: " + result);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		};
		new Thread(task).start();
	}


	public void sendMessage(String message) {
		outputPrintWriter.println(message);
		System.out.println("Message to server was sent: " + message);
	}

	public String getResult() throws Exception {
		Thread.sleep(200);
		return result;
	}
}
