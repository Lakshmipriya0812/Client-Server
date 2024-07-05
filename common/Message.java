import java.io.Serializable;
import java.util.List;

public class Message implements Serializable {
	private List<String> lines;

	public Message(List<String> lines) {
		this.lines = lines;
	}

	public List<String> getLines() {
		return lines;
	}
}
