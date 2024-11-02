package Model;

public class Manager extends Worker {
	/* The manager's bonus */
	private int bonus;

	public Manager(String name, int salary, int bonus) {
		super(name, salary);
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	@Override
	public boolean equals(Object obj) {
		boolean flag = false;

		if (getClass() != obj.getClass())
			flag = false;
		else if (getClass() == obj.getClass()) {
			Manager other = (Manager) obj;
			if (getBonus() + getSalary() == other.getBonus() + other.getSalary())
				flag = true;
		}
		return flag;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("+ %7d ", bonus);
	}
}
