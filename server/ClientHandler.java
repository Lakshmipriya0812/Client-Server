import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ClientHandler implements Runnable {
	private Socket clientSocket;

	public ClientHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());

			Message message = (Message) objectInputStream.readObject();
			List<String> inputLines = message.getLines();

			MediatorMasterControl mediatorMasterControl = new MediatorMasterControl();

			List<String> result = mediatorMasterControl.processLines(inputLines);

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			objectOutputStream.writeObject(new Message(result));

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
