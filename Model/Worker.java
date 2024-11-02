package Model;

public class Worker extends Person {
	/** The worker's salary */
	private int salary;

	public Worker(String name, int salary) {
		setName(name);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if (getClass() != obj.getClass())
			flag = false;
		else {
			Worker other = (Worker) obj;
			if (getSalary() == other.getSalary())
				flag = true;
		}
		return flag;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%7d ", salary);
	}

}
