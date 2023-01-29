import jdk.jshell.JShell;
import jdk.jshell.SnippetEvent;

import java.util.List;

public class Calc {

	JShell jshell;

	public Calc(JShell jshell) {
		this.jshell = jshell;
	}

	public String eval(String expression) {
		System.out.println("JShell. Evaluating an expresion: " + expression);	
		List<SnippetEvent> events = jshell.eval(expression);
		for (SnippetEvent e : events) {
			if (e.causeSnippet() == null) {
				switch (e.status()) {
				case VALID:
					if (e.value() != null) {
						System.out.println("JShell. Value of the expresion: " + e.value());
						return e.value();
					}
					break;
				default:
					System.out.printf("Error\n");
					break;
				}
			}
		}

		return "Error";
	}
}
