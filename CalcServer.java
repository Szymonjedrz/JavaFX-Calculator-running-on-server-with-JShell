import jdk.jshell.JShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CalcServer {
	private ServerSocket serverSocket;
	private int port;
	private Calc calc;

	public CalcServer(int port) {
		this.port = port;
		calc = new Calc(JShell.create());
		System.out.println("CalcServer is created");
	}

	public void start() throws IOException {
		serverSocket = new ServerSocket(port);
		System.out.println("ServerSocket is created");
		System.out.println("The server is running.");
		while (true) {
			System.out.println("Waiting for a new client");
			Socket socket = serverSocket.accept();
			System.out.println("New client. Starting a new thread");
			new UserHandler(socket).start();
		}
	}

	private class UserHandler extends Thread {
		private Socket userSocket;
		private BufferedReader inputBufferedReader;
		private PrintWriter outputPrintWriter;

		public UserHandler(Socket socket) throws IOException {
			userSocket = socket;
			this.inputBufferedReader = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));
			this.outputPrintWriter =  new PrintWriter(userSocket.getOutputStream(), true);
			System.out.println("New thread created");
		}

		@Override
		public void run() {
			System.out.println("Run method is executed");
			try {
				while (true) {
					String expression = inputBufferedReader.readLine();
					System.out.println("Received expresion: " + expression);
					if (expression == null) {
						throw new IOException();
					}
					if (!expression.isEmpty()) {
						sendMessage(calc.eval(expression));
					}
				}
			} catch (IOException e) {
				System.out.println("User reset connection.");
			} finally {
				try {
					userSocket.close();
					System.out.println("Socket closed.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Thread ended.");
			return;
		}

		private void sendMessage(String expression) {
			System.out.println("Sending the result: " + expression);
			outputPrintWriter.println(expression);
		}
	}
}
