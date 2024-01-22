
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SekiroGame extends JPanel {

	private Enemies sekiro;
	private int userInput = 0;
	private String jFrameString;
	private int FontSize = 24;
	private Color color = Color.BLACK;
	private int textX = 50;
	private int textY = 50;
	private Shop shop;
	private MissionList missionList;
	private Enemies[] enemies;
	private Fight fight;
	private boolean gameOver;
	private int a;

	public void startGame() throws InterruptedException {
		System.out.println("***Remember to Close out of the Jpanels to Continue Game***");
		Thread.sleep(4000);
		beginning();
	}

	public void beginning() throws InterruptedException {
		jFrameString = "17th Century Japan, Following The Sengoku Period";
		JFrame dates = new JFrame("Overview");
		dates.setSize(700, 400);
		dates.setLocation(100, 200);
		dates.setContentPane(this);
		dates.setVisible(true);
		while (dates.isVisible()) {
			Thread.sleep(1);
		}
		System.out.println("\nYou awaken at the bottom of the well, a piece of paper floats down from above \n");
		System.out.println("Do you wish to catch the letter?");

		if (basicQuestion() == 1) {
			System.out.println("You read the letter and it states");
			jFrameString = "My Shinobi Wolf, it's time for you to return, listen for my whistle";
			JFrame letter = new JFrame("Mysterious Letter");
			letter.setSize(700, 400);
			letter.setLocation(100, 200);
			letter.setContentPane(this);
			letter.setVisible(true);
			while (letter.isVisible()) {
				Thread.sleep(1);
			}
		} // else something something another story
		System.out.println("\n You pick up your sword (Kusabimaru) and make your way out through an opening \n");
		Thread.sleep(4000); // Set to 4000 when playing
		System.out.println("\n\"Hey! where did you come from\"");
		System.out.println("\n  Do you wish to fight?");
		if (basicQuestion() == 1) {
			fight = new Fight(this);
		} else {
			System.out.println("The man comes closer with a sword wielded forcing you into the fight");
			fight = new Fight(this);
		}
	}

	public void beginningFight(Enemies[] enemies, MissionList missionList, Fight fight) throws InterruptedException {
		this.missionList = missionList;
		this.enemies = enemies;
		this.fight = fight;
		sekiro = enemies[0];
		System.out.println("\n" + "Your stats" + "\n\n" + enemies[0] + "\n");
		System.out.println("His stats" + "\n\n" + enemies[1]);
		System.out.println("\n" + "do you wish to attack?");
		userInput = basicQuestion();
		if (userInput == 1) {
			while (userInput == 1 && enemies[1].getHealth() != 0) {
				if (enemies[1].getHealth() != 0 && enemies[0].getHealth() != 0) {
					enemies[0].attackPerson(enemies[1]);
				}

				if (enemies[0].getHealth() != 0 && (enemies[1].getHealth() != 0)) {
					System.out.println("\n Their turn to attack");
					Thread.sleep(1000);
					enemies[1].attackPerson(enemies[0]);
				}

				if (enemies[1].getHealth() == 0) {
					System.out.println("\n You beat him!");
					System.out.println("Your current money is 110");
					((Sekiro) enemies[0]).setMoney(110);
				} else {
					System.out.println("attack again?");
					userInput = basicQuestion();
				}
			}
		} else {
			System.out.println("\"Where do you think you're going?\"");
			System.out.println("\n" + "do you wish to attack?");
			userInput = basicQuestion();
			if (userInput == 2) {
				System.out.println("The swordsman comes at you and you must fight");
			}
			while (enemies[1].getHealth() != 0) {
				if (enemies[1].getHealth() != 0 && enemies[0].getHealth() != 0) {
					enemies[0].attackPerson(enemies[1]);
				}

				if (enemies[0].getHealth() != 0 && (enemies[1].getHealth() != 0)) {
					System.out.println("Their turn to attack");
					Thread.sleep(2000);
					enemies[1].attackPerson(enemies[0]);
				}

				if (enemies[1].getHealth() == 0) {
					System.out.println("\n You beat him!");
					System.out.println("\nYour current money is 110");
					((Sekiro) enemies[0]).setMoney(110);

				} else {
					System.out.println("attack again?");
					userInput = basicQuestion();
					if (userInput == 2) {
						System.out.println("The swordsman comes at you and you must attack");
					}
				}
			}
		}
		Thread.sleep(2000);
		System.out.println("  \n *FWEEEEET!*");
		Thread.sleep(2000);
		System.out.println("\n You follow the whistle towards a broken down gate where you spot Kuro\n");
		Thread.sleep(2000);
		System.out.println("\"Let us go Wolf,\" he whispers");
		Thread.sleep(2200);
		System.out.println("\n\"Yes my lord\"");
		Thread.sleep(2000);
		System.out.println("\nYou make your way down the gate's pathway\n");
		Thread.sleep(3000);
		System.out.println("Suddenly, a shadow of a warrior appears.");
		Thread.sleep(2000);
		System.out.println("\n\"Wolf! Where do you think you're bringing the Divine Heir!?\" \n");
		Thread.sleep(2000);
		System.out.println("\n   Fight the warrior? \n ");
		System.out.println(enemies[7]);
		userInput = basicQuestion();
		if (userInput == 1) {
			System.out.println("\"Come forth Shinobi he bellows\"");
			while (enemies[7].getHealth() != 0 && enemies[0].getHealth() != 0) {
				if (enemies[0].getHealth() != 0 && enemies[7].getHealth() != 0) {
					enemies[0].attackPerson(enemies[7]);
				}

				if (enemies[0].getHealth() != 0 && (enemies[7].getHealth() != 0)) {
					System.out.println("\n Their turn to attack");
					Thread.sleep(100);
					enemies[7].attackPerson(enemies[0]);
				}

				if (enemies[0].getHealth() == 0) {
					System.out.println("\n\"The Divine Heir is mine\"");
					System.out.println("\nYou're jabbed into the heart and die \n");
					endOfBeginning();
				} else {
					System.out.println("attack again?");
					userInput = basicQuestion();
					if (userInput == 2) {
						System.out.println("\n \"Just a Coward\"");
						deathScreen();
					}
				}
			}
		} else {
			System.out.println("\n \"Just a Coward\"");
			deathScreen();
		}
	}

	public void endOfBeginning() throws InterruptedException {
		enemies[7].setHealth(1000);
		enemies[1].setHealth(20);
		enemies[0].setHealth(100);
		Thread.sleep(5000);
		System.out.println("You awaken to the sounds of metal on wood \n");
		System.out.println("  \n \n  Skip Introduction?");
		userInput = basicQuestion();
		if (userInput == 2) {
			System.out.println("\"You're finally awake\" a gruff voices appears\n");
			Thread.sleep(5000);
			System.out.println("\"Where am I, and who are you?\" you ask\n");
			Thread.sleep(5000);
			System.out.println("\"I'm just a carpenter,\" he replies\n");
			Thread.sleep(5000);
			System.out.println("\"What happened to me?\"\n");
			Thread.sleep(5000);
			System.out.println(
					"\"I saw you lying on a pathway covered in blood but without a wound, it seems the heavens don't wish for you to die.\"\n");
			Thread.sleep(5000);
			System.out.println("\"Kuro's blood must have revived me,\" you ponder\n");
			Thread.sleep(5000);
			System.out.println("\"How far away are we from Ashina's castle?\" you ask\n");
			Thread.sleep(5000);
			System.out
					.println("\"Not far but the areas are littered with warriors as if they're preparing for war\"\n");
			Thread.sleep(5000);
			System.out.println("\"I must hurry,\" as you get up the carpenter's hand stops you\n");
			Thread.sleep(5000);
			System.out.println("\"Talk to Emma outside for help on your journey\"\n");
			Thread.sleep(5000);
			System.out.println(
					"\"Following his advice you spot a women almost in her 30s peacefully waiting outside\"\n");
			Thread.sleep(5000);
			System.out.println("\"You're finally awake, I'm glad,\" she softly mentions\n");
			Thread.sleep(5000);
			System.out.println("\"The carpenter said you can help me on my journey\"\n");
			Thread.sleep(5000);
			System.out.println("\"Oh yes,\" she exclaims grabbing an object from her cloak\n");
			Thread.sleep(5000);
			System.out.println("\"You'll need this healing gourd if you're challenging Genichiro\"\n");
			Thread.sleep(5000);
			System.out.println("\"How do you know about that?\" you demand\n");
			Thread.sleep(5000);
			System.out.println(
					"\"Word travels when you boast of resurrection, and you're the Divine Heir's Shinobi. It's obvious what you must do\"\n");
			Thread.sleep(5000);
			System.out.println("You Nod and begin to set out\n");
			Thread.sleep(5000);
			System.out.println(
					"She yells towards you, \"You can increase the size of your gourd through gourd seeds, so be sure to refill at the Sculpture Idols\"\n");
			Thread.sleep(5000);
		}
		System.out.println(
				"\n\nAs you set out towards the gate a man whispers towards you, \"would you like to buy any goods Shinobi?\"");
		Thread.sleep(5000);
		System.out.println("You take a look inside at the contents");
		shop = new Shop(sekiro);
		System.out.println("A crow flies over and a letter drops into your hands");
		jFrameString = "Sekiro, find me at the top of Ashina's castle after you defeat the enemies surrounding the castle";
		JFrame crowLetter = new JFrame("Crow's Letter");
		crowLetter.setSize(1100, 400);
		crowLetter.setLocation(100, 200);
		crowLetter.setContentPane(this);
		crowLetter.setVisible(true);
		while (crowLetter.isVisible()) {
			Thread.sleep(1);
		}
		System.out.println("\n      **New Item*** \n  Mission List\n");
		System.out.println("Open Mission List?");
		userInput = basicQuestion();
		if (userInput == 1) {
			System.out.println(missionList);
			System.out.println("Type 1 to continue");
			userInput = TextIO.getInt();
		}
		System.out.println("\n\"hmmm,\" you wonder");
		Thread.sleep(5000);
		System.out.println("\nYou turn towards the merchant and ask, \"Do you own a map of Ashina castle?\"");
		Thread.sleep(5000);
		System.out.println("\n\"Since you bought from my store, consider this a gift\"");
		Thread.sleep(5000);
		System.out.println("\nHe tosses you a map which lists the areas of the enemies and the top of Ashina Castle");
		Thread.sleep(5000);
		System.out.println("\n\nYou're now officially able to start your journey");
		Thread.sleep(5000);
		startOfPlayThrough();
	}

	public void startOfPlayThrough() throws InterruptedException {
		this.a = 1;
		gameOver = false;
		boolean missionsCompleted = false;
		while (!gameOver) {
			if (missionList.missionListCompleted()) {
				if (!missionsCompleted) {
					System.out.println("**Missions Completed**");
					Thread.sleep(5000);
					System.out.println("You can now challenge Genichiro at the top of the tower");
					this.a = 0;
					missionsCompleted = true;
				}
			}
			whichDecision();
		}

		while (gameOver) {
			whichDecision();
		}
	}

	public void finalBattle() throws InterruptedException {
		System.out.println("\nYou climb to the top of Ashina Castle");
		Thread.sleep(4000);
		System.out.println("\nYou begin to overhear a conversation between Genichiro and Kuro");
		Thread.sleep(5000);
		System.out.println("\n\"Why must you be so ignorant Kuro,\" Genichiro questions");
		Thread.sleep(5000);
		System.out.println("\n\"Why do you risk Ashina over some blood?!\" he booms");
		Thread.sleep(5000);
		System.out.println("\n\"If I can't have your heritage, no one can\"");
		Thread.sleep(5000);
		System.out.println("\n\"The stomps of his feet shake the flooring");
		Thread.sleep(5000);
		System.out.println("\n\"You can't do this,\" Kuro squeals");
		Thread.sleep(5000);
		System.out.println("\n\"I have no use for you anymore\"");
		Thread.sleep(7000);
		System.out.println("\n\n*CLANG*");
		Thread.sleep(5000);
		System.out.println(
				"\n\"You will not be harming Kuro, Genichiro,\" you growl whilst the swords of you and Genichiro lock");
		Thread.sleep(5000);
		System.out.println("\nHe steps back shocked");
		Thread.sleep(2000);
		System.out.println("\n\"Shinobi, I thought I killed you\"");
		Thread.sleep(5000);
		System.out.println("\n\"This rat of a heir must've had some part in this\"");
		Thread.sleep(5000);
		System.out.println("\n\"Step back Kuro!\" you yell");
		Thread.sleep(5000);
		System.out.println("\nGenichiro springs towards you, as light as a feather");
		Thread.sleep(5000);
		System.out.println("\n*CLANG*");
		Thread.sleep(2000);
		System.out.println("\n\"Don't dissapoint me this time Shinobi\"");
		Thread.sleep(5000);
		fight.fight(7);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setFont(new java.awt.Font("Times New Roman", 2, FontSize));
		// System.out.println(jFrameString);
		g.setColor(color);
		g.drawString(jFrameString, textX, textY);
	}

	public int basicQuestion() {
		int userInput = 0;
		System.out.println("\n  1 for yes, 2 for no");
		userInput = TextIO.getlnInt();
		return userInput;
	}

	public void whichDecision() throws InterruptedException {
		fight.afterFight();
		int userInput = 0;
		int newUserInput = 0;
		System.out.println("\n What do you wish to do?");
		System.out.println("\n" + "1. Show your stats" + "\n" + "2. Fight" + "\n"
				+ "3. Visit Sculptor's Idol (Full Heal)" + "\n4. Check Mission List" + "\n5. Go to Shop");
		userInput = TextIO.getlnInt();
		if (userInput == 1) {
			System.out.println(enemies[0]);
		}
		if (userInput == 2) {
			System.out.println("Who do you wish to fight?");
			fight.showAllEnemies(a);
			newUserInput = TextIO.getlnInt();
			System.out.println(enemies[newUserInput]);
			System.out.println("\nAre you sure?");
			userInput = basicQuestion();
			if (userInput == 1) {
				if (newUserInput == 7) {
					finalBattle();
				} else {
					fight.fight(newUserInput);
				}
			}

		}
		if (userInput == 3) {
			enemies[0].setHealth(((Sekiro) enemies[0]).getMaxHealth()); // I think works
			((Sekiro) enemies[0]).setPotions(((Sekiro) enemies[0]).getMaxPotions());
			((Sekiro) enemies[0]).resetRevive();
			System.out.println("Health restored, potions restored, and revive possible again");
		}
		if (userInput == 4) {
			System.out.println(missionList);
		}

		if (userInput == 5) {
			shop = new Shop(sekiro);
		}
	}

	public void deathScreen() throws InterruptedException {
		jFrameString = "D E A T H";
		color = Color.RED;
		textX = 150;
		textY = 200;
		FontSize = 60;
		JFrame death = new JFrame("Death Screen");
		death.setSize(700, 400);
		death.setLocation(100, 200);
		death.setContentPane(this);
		death.setVisible(true);
		while (death.isVisible()) {
			Thread.sleep(1);
		}
		System.exit(1);
	}

	public void gameOver() {
		gameOver = true;
	}

}
