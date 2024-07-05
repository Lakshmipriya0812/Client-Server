import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientMethods {
	private int PORT = 3000;

	public void run(String[] lines) {
		try (Socket socket = new Socket()) {
			socket.connect(new InetSocketAddress("localhost", PORT));

			List<String> resultLines = inputOutputStreams(socket, lines);

			for (String resultLine : resultLines) {
				System.out.println(resultLine);
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private List<String> inputOutputStreams(Socket socket, String[] lines) throws IOException, ClassNotFoundException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());

		List<String> inputLines = inputLines(lines);
		objectOutputStream.writeObject(new Message(inputLines));

		ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
		Message resultMessage = (Message) objectInputStream.readObject();

		return resultMessage.getLines();
	}

	private List<String> inputLines(String[] lines) {
		List<String> inputLines = new ArrayList<>();
		for (String line : lines) {
			inputLines.add(line);
		}
		return inputLines;
	}
}
