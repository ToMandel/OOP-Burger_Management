package Model;

public class BonusException extends Exception {
	private static final long serialVersionUID = 1L;
	private int bonus;

	public BonusException(int bonus) {
		super("!! Owner bonus is too high !!");
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}
}
