package Model;

public class Person {
	/* Person's name */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("%-7s: %-10s,", getClass().getSimpleName(), name);
	}

}
