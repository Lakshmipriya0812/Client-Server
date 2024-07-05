public class ClientB {
	public static void main(String[] args) {
		ClientMethods clientB = new ClientMethods();
		System.out.println("ClientB is running");
		String[] lines = { "Descent of Man", "The Ascent of Man", "The Old Man and The Sea" };
		clientB.run(lines);
	}
}
