
public class ClientA {
	public static void main(String[] args) {
		ClientMethods clientA = new ClientMethods();
		System.out.println("ClientA is running");
		String[] lines = { "hi", "hi bye", "hi bye foo" };
		clientA.run(lines);
	}
}
