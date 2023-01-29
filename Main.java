import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		CalcServer calc = new CalcServer(8080);
		System.out.println("CalcServer is starting");
		calc.start();
	}
}
