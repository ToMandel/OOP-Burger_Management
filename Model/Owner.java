package Model;


public class Owner extends Manager {
	public static final int BASE = 20000; // Base income for owner

	public Owner(String name, int salary, int bonus) throws BonusException {
		super(name, salary, bonus);
		if (bonus > 10000)
			throw new BonusException(bonus);
	}

	@Override
	public String toString() {
		return super.toString() + String.format("+ %d", BASE);
	}

}
