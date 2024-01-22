
public class Sekiro extends Enemies {
	private int health;
	private int attackDamage;
	private int originalAttackDamage;
	private int attackAccuracy;
	private int money;
	private int potions;
	private int maxHealth;
	private int redCandy;
	private int blueCandy;
	private int greenCandy;
	private int maxPotions;
	private boolean revive;
	private boolean firstDeath;
	private boolean redCandyInUse;
	private int originalMaxHealth;

	private boolean blueCandyInUse;
	private int maxGourdSize;

	public Sekiro(String name) {
		super(name, 0, 100, 50, 20); // name, worth, health, attackAccuracy, attackDamage
		this.money = 100;
		this.potions = 1;
		this.maxPotions = 1;
		this.maxHealth = 100;
		this.redCandy = 0;
		this.blueCandy = 0;
		this.greenCandy = 0;
		this.revive = true;
		this.firstDeath = true;
		redCandyInUse = false;
		blueCandyInUse = false;
	}

	public boolean getRevive() {
		return revive;
	}

	public void useRevive() throws InterruptedException {
		revive = false;
		setHealth(50);
		System.out.println("Current Health: 50");
		if (firstDeath) {
			System.out.println("\nIt's not your time to die, rise up and fight again");
			Thread.sleep(5000);
			System.out.println("\nRefresh this ability at the sculptors Idol");
			firstDeath = false;
		} else {
			System.out.println("It's not your time to die, rise up and fight again");
		}
	}

	public void resetRevive() {
		revive = true;
	}

	public int getRedCandy() {
		return redCandy;
	}

	public void setRedCandy(int redCandy) {
		this.redCandy = redCandy;
	}

	public void useRedCandy() {
		if (redCandyInUse) {
			System.out.println("Cannot stack candy");
		} else {
			setRedCandy(getRedCandy() - 1);
			System.out.println("Red Candy: " + getRedCandy());
			setOriginalAttackDamage(this.getAttackDamage());
			setAttackDamage((getAttackDamage() * 2));
			setRedCandyInUse(true);
			System.out.println("Attack Damage: " + this.getAttackDamage());
		}
	}

	public int getOriginalAttackDamage() {
		return originalAttackDamage;
	}

	public void setOriginalAttackDamage(int originalAttackDamage) {
		this.originalAttackDamage = originalAttackDamage;
	}

	public boolean isRedCandyInUse() {
		return redCandyInUse;
	}

	public void setRedCandyInUse(boolean redCandyInUse) {
		this.redCandyInUse = redCandyInUse;
	}

	public int getBlueCandy() {
		return blueCandy;
	}

	public void setBlueCandy(int blueCandy) {
		this.blueCandy = blueCandy;
	}

	public void useBlueCandy() {
		if (blueCandyInUse) {
			System.out.println("Cannot stack candy");
		} else {
			setBlueCandy(getBlueCandy() - 1);
			System.out.println("Blue Candy: " + getBlueCandy());
			setOriginalMaxHealth(getMaxHealth());
			setMaxHealth((int) (getMaxHealth() * 1.5));
			setHealth((int) (getHealth() * 1.5));
			setBlueCandyInUse(true);
			System.out.println("Total Health: " + getHealth());
			System.out.println("\nMax Health: " + getMaxHealth());
		}
	}

	public boolean isBlueCandyInUse() {
		return blueCandyInUse;
	}

	public void setBlueCandyInUse(boolean blueCandyInUse) {
		this.blueCandyInUse = blueCandyInUse;
	}

	public int getOriginalMaxHealth() {
		return originalMaxHealth;
	}

	public void setOriginalMaxHealth(int originalMaxHealth) {
		this.originalMaxHealth = originalMaxHealth;
	}

	public int getMaxPotions() {
		return maxPotions;
	}

	public void setMaxPotions(int maxPotions) {
		this.maxPotions = maxPotions;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void minusMoney(int money) {
		this.money -= money;
	}

	public void plusMoney(int money) {
		this.money += money;
	}

	public int getPotions() {
		return potions;
	}

	public void setPotions(int potions) {
		this.potions = potions;
	}

	public void minusPotion() {
		if (this.potions != 0) {
			this.potions = potions - 1;
			if ((getHealth() + 100) > getMaxHealth()) {
				setHealth(this.maxHealth);
				System.out.println(
						"You took a potion restoring your health to full \n Remaining Potions: " + getPotions());
			} else {
				setHealth(getHealth() + 100);
				System.out.println("You took a potion restoring 100 health \n Remaining Potions: " + getPotions());
				System.out.println("Current Health:" + getHealth());
			}
		} else {
			System.out.println("You are out of potions, unable to heal");
		}
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public void changeMaxHealth(int health) {
		maxHealth += health;
	}

	public void setMaxHealth(int health) {
		maxHealth = health;
	}

	public String toString() {
		String sentence = "Stats \n" + "Name: " + getName() + "\n" + "Money: " + getMoney() + "\n" + "Health: "
				+ getHealth() + "\n" + "Attack Damage: " + getAttackDamage() + "\n" + "Attack Accuracy: "
				+ getAttackAccuracy() + "%" + "\n" + "Potions: " + getPotions();
		return sentence;
	}

}
