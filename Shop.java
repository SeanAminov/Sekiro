
public class Shop {
	private int redCandy;
	private int blueCandy;
	// private int greenCandy;
	private int gourdSeeds;
	private int beadOfHealth;
	private int beadOfDamage;
	private int money;
	private boolean inShop;
	private Enemies sekiro;

	public Shop(Enemies sekiro) throws InterruptedException {
		this.money = ((Sekiro) sekiro).getMoney();
		this.inShop = true;
		this.sekiro = sekiro;
		inShop();
	}

	public void buyRedCandy() {
		if (money >= 10) {
			money -= 10;
			System.out.println(currentMoney());
			((Sekiro) sekiro).setRedCandy(((Sekiro) sekiro).getRedCandy() + 1);
			System.out.println("Number of red candies: " + ((Sekiro) sekiro).getRedCandy());
		} else {
			System.out.println("Not enough money");
		}

	}

	public void buyBlueCandy() {
		if (money >= 10) {
			money -= 10;
			System.out.println(currentMoney());
			((Sekiro) sekiro).setBlueCandy(((Sekiro) sekiro).getBlueCandy() + 1);
			System.out.println("Number of blue candies: " + ((Sekiro) sekiro).getBlueCandy());
		} else {
			System.out.println("Not enough money");
		}
	}

	/*
	 * public void buyGreenCandy() { if (money >= 25) { money -= 25;
	 * System.out.println(currentMoney()); ((Sekiro) sekiro).setGreenCandy(((Sekiro)
	 * sekiro).getGreenCandy() +1); System.out.println("Number of green candies: " +
	 * ((Sekiro) sekiro).getGreenCandy()); } else {
	 * System.out.println("Not enough money"); } }
	 */
	public void buyGourdSeed() {
		if (money >= 50) {
			money -= 50;
			System.out.println(currentMoney());
			((Sekiro) sekiro).setMaxPotions(((Sekiro) sekiro).getMaxPotions() + 1);
			System.out.println("Max Gourd size: " + ((Sekiro) sekiro).getMaxPotions());
		} else {
			System.out.println("Not enough money");
		}
	}

	public void buyBeadOfHealth() {
		if (money >= 25) {
			money -= 25;
			System.out.println(currentMoney());
			((Sekiro) sekiro).changeMaxHealth(25);
			System.out.println("Current Max Health:" + ((Sekiro) sekiro).getMaxHealth());
		} else {
			System.out.println("Not enough money");
		}
	}

	public void buyBeadOfDamage() {
		if (money >= 50) {
			money -= 50;
			System.out.println(currentMoney());
			sekiro.setAttackDamage(sekiro.getAttackDamage() + 10);
			System.out.println("Current attack damge:" + sekiro.getAttackDamage());
		} else {
			System.out.println("Not enough money");
		}
	}

	public String information() {
		// Green Candy: Makes it so Wolf can sneak attack enemies, dealing half their
		// total health
		String sentence = ("Red Candy: Increases Wolf's attack damage by 2x for the battle \n\nBlue Candy: Increases Wolf's Health by 1.5x for the battle \n\nGourd Seed: Increases the size of the Gourd by one making it possible to use it more times \n\nBead Of Health: Increases total Health by 25 \n\nBead Of Damage: Increases damage by 10");
		return sentence;
	}

	public String currentMoney() {
		String sentence = "You current money is " + money;
		return sentence;
	}

	public void whichItemToBuy() {
		int userInput = 0;
		System.out.println("What item would you like to buy?");
		System.out.println(this);
		userInput = TextIO.getlnInt();
		if (userInput == 1) {
			buyRedCandy();
		}
		if (userInput == 2) {
			buyBlueCandy();
		}
		// if (userInput == 3) {
		// buyGreenCandy();
		// }
		if (userInput == 3) {
			buyGourdSeed();
		}
		if (userInput == 4) {
			buyBeadOfHealth();
		}
		if (userInput == 5) {
			buyBeadOfDamage();
		}

	}

	public void decisions() throws InterruptedException {
		int userInput = 0;
		System.out.println("\nWhat would you like to do? \n 1. Information Sheet \n 2. Buy an Item \n 3. Leave Shop ");
		userInput = TextIO.getlnInt();
		if (userInput == 1) {
			System.out.println(information());
		}
		if (userInput == 2) {
			whichItemToBuy();
		}

		if (userInput == 3) {
			inShop = false;
			System.out.println("Thank you Shinobi, and goodluck");
			Thread.sleep(2000);
		}

	}

	public void inShop() throws InterruptedException {
		while (inShop) {
			decisions();
		}
	}

	public String toString() {
		// \n3. Green Candy: 25
		String sentence = "Your Money:" + money
				+ "\n1. Red Candy: 10 \n 2. Blue Candy: 10 \n 3. Gourd Seed: 50 \n 4. Bead of Health: 25 \n 5. Bead of Damage: 50";
		return sentence;
	}
}
