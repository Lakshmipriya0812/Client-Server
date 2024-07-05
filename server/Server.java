import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private int PORT = 3000;
	private ExecutorService executorService;

	public Server() {
		this.executorService = Executors.newFixedThreadPool(10);
	}

	public static void main(String[] args) {
		Server server = new Server();
		server.run();
	}

	public void run() {
		try (ServerSocket serverSocket = new ServerSocket(PORT)) {
			System.out.println("Server is listening port " + PORT);

			while (true) {
				try {
					Socket clientSocket = serverSocket.accept();
					System.out.println("Accepted connection from client: " + clientSocket.getInetAddress());

					executorService.submit(new ClientHandler(clientSocket));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			executorService.shutdown();
		}
	}
}
