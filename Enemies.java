
public abstract class Enemies {
	private String name;
	private int worth;
	private int health;
	private int attackAccuracy;
	private int attackDamage;
	private int maxHealth;

	public Enemies(String name, int worth, int health, int attackAccuracy, int attackDamage) {
		this.name = name;
		this.worth = worth;
		this.health = health;
		this.attackAccuracy = attackAccuracy;
		this.attackDamage = attackDamage;
		this.maxHealth = health;
	}

	public void attackPerson(Enemies number) {
		number.minusHealth(attackDamage());
		System.out.println(number.getName() + "'s Current Health " + number.getHealth());

	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	public void drops(Enemies sekiro) {
		((Sekiro) sekiro).plusMoney(this.getWorth());
		System.out.println("\nCurrent Money:" + ((Sekiro) sekiro).getMoney() + "\n");
	}

	public int attackDamage() {
		if (hitChance()) {
			System.out.println("\nhit!\n");
			return attackDamage;
		}
		System.out.println("\nmiss!\n");
		return 0;
	}

	public boolean hitChance() {
		int chance = (int) (Math.random() * 100) + 1;
		if (chance <= this.getAttackAccuracy()) {
			return true;
		}
		return false;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWorth() {
		return worth;
	}

	public void setWorth(int worth) {
		this.worth = worth;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void minusHealth(int health) {
		if (health > getHealth()) {
			health = getHealth();
		}
		this.health -= health;
	}

	public void plusHealth(int health) {
		this.health += health;
	}

	public int getAttackAccuracy() {
		return attackAccuracy;
	}

	public void setAttackAccuracy(int attackAccuracy) {
		this.attackAccuracy = attackAccuracy;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}

	public String toString() {
		String sentence = "Stats \n" + "Name: " + getName() + "\n" + "Worth: " + getWorth() + "\n" + "Health: "
				+ getHealth() + "\n" + "Attack Damage: " + getAttackDamage() + "\n" + "Attack Accuracy: "
				+ getAttackAccuracy() + "%";
		return sentence;
	}
}
