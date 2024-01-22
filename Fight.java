import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.w3c.dom.Text;

public class Fight {
	private Enemies[] enemies = new Enemies[8];
	private int currentOpponent;
	private int userInput;
	private SekiroGame game;
	private Object which;
	private MissionList missionList;

	public Fight(SekiroGame game) throws InterruptedException {
		enemies[0] = new Sekiro("Wolf");
		enemies[1] = new AverageSwordBearer("AverageSwordBearer");
		enemies[2] = new AverageSpearBearer("AverageSpearBearer");
		enemies[3] = new EliteSamurai("EliteSamurai");
		enemies[4] = new TheAshinaSword("Sword of Ashina");
		enemies[5] = new TheAshinaSpear("Spear of Ashina");
		enemies[6] = new GenichiroBodyguard("Genichiro's BodyGuard The Sword Saint");
		enemies[7] = new Genichiro("Genichiro Ashina");
		this.game = game;
		this.missionList = new MissionList();
		game.beginningFight(enemies, missionList, this);
	}

	public void fight(int currentOpponent) throws InterruptedException {
		this.currentOpponent = currentOpponent;
		System.out.println("What do you wish to do?");
		System.out.println(" \n" + "1. Fight" + "\n" + "2. Take Potion" + "\n3. Take Candy" + "\n4. Run Away");
		userInput = TextIO.getInt();
		if (userInput == 1) {
			while (enemies[currentOpponent].getHealth() != 0 && enemies[0].getHealth() != 0) {
				if (enemies[0].getHealth() != 0 && enemies[currentOpponent].getHealth() != 0) {
					enemies[0].attackPerson(enemies[currentOpponent]);
				}

				if (enemies[0].getHealth() != 0 && (enemies[currentOpponent].getHealth() != 0)) {
					System.out.println("\n Their turn to attack");
					Thread.sleep(1000);
					enemies[currentOpponent].attackPerson(enemies[0]);
				}

				if (enemies[0].getHealth() == 0) {
					System.out.println("You're jabbed into the heart and die \n");
					if (currentOpponent == 7) {
						System.out.println("\"You dissapoint me Shinobi\"");
					}
					if (((Sekiro) enemies[0]).getRevive()) {
						Thread.sleep(3000);
						((Sekiro) enemies[0]).useRevive();
						if (currentOpponent == 7) {
							System.out.println("\"So that's your trick,\" he spits");
						}
					} else {
						game.deathScreen();
					}
				}

				if (enemies[currentOpponent].getHealth() == 0) {
					System.out.println("\n You beat him\n");
					Thread.sleep(2000);
					if (currentOpponent == 7) {
						System.out.println(
								"\"Congratulations... Shinobi,\"Genichiro whispers as he slumps to the floor bleeding");
						Thread.sleep(5000);
						System.out.println("You beat Genichiro and saved Kuro, ultimatly winning the game!");
						System.out
								.println("\n **You can continue playing the game to stack up stats, but you've won!**");
						System.out.println("Press 1 to continue playing or close the game to stop");
						game.gameOver();
						userInput = TextIO.getlnInt();
					}
					enemies[currentOpponent].drops(enemies[0]);
					missionChecker();
				} else {
					fight(currentOpponent);
				}
			}
		}

		if (userInput == 2) {
			((Sekiro) enemies[0]).minusPotion();
			fight(currentOpponent);
		}

		if (userInput == 3) {
			System.out.println("Which Candy? \n 1. Red Candy: " + ((Sekiro) enemies[0]).getRedCandy()
					+ "\n 2. Blue Candy: " + ((Sekiro) enemies[0]).getBlueCandy() + "\n 3. Leave Option");
			int candyInput = 0;
			candyInput = TextIO.getlnInt();
			if (candyInput == 1) {
				((Sekiro) enemies[0]).useRedCandy();
				fight(currentOpponent);
			}

			if (candyInput == 2) {
				((Sekiro) enemies[0]).useBlueCandy();
				fight(currentOpponent);
			}
			if (candyInput == 3) {
				fight(currentOpponent);
			}
		}

		if (userInput == 4) {
			System.out.println("You have a 25% chance to runaway\n");
			Thread.sleep(1000);
			System.out.println("Do you still wish to runaway?");
			System.out.println("\n  1 for yes, 2 for no");
			int newUserInput = 0;
			newUserInput = TextIO.getlnInt();
			if (newUserInput == 1) {
				runAway();
			} else {
				fight(currentOpponent);
			}
		}

	}

	public void missionChecker() {
		if (currentOpponent == 1) {
			if (missionList.getAverageSwordBearer() > 0)
				missionList.setAverageSwordBearer(missionList.getAverageSwordBearer() - 1);
		}

		if (currentOpponent == 2) {
			if (missionList.getAverageSpearBearer() > 0)
				missionList.setAverageSpearBearer(missionList.getAverageSpearBearer() - 1);
		}

		if (currentOpponent == 3) {
			if (missionList.getEliteSamurai() > 0)
				missionList.setEliteSamurai(missionList.getEliteSamurai() - 1);
		}

		if (currentOpponent == 4) {
			missionList.setTheAshinaSword(false);
		}

		if (currentOpponent == 5) {
			missionList.setTheAshinaSpear(false);
		}
		if (currentOpponent == 6) {
			missionList.setGenichiroBodyguard(false);
		}
	}

	public void afterFight() {
		if (((Sekiro) enemies[0]).isRedCandyInUse()) {
			((Sekiro) enemies[0]).setAttackDamage(((Sekiro) enemies[0]).getOriginalAttackDamage());
			((Sekiro) enemies[0]).setRedCandyInUse(false);
		}

		if (((Sekiro) enemies[0]).isBlueCandyInUse()) {
			((Sekiro) enemies[0]).setMaxHealth(((Sekiro) enemies[0]).getOriginalMaxHealth());
			((Sekiro) enemies[0]).setHealth((int) (enemies[0].getHealth() / 1.5));
			((Sekiro) enemies[0]).setBlueCandyInUse(false);
		}
		enemies[currentOpponent].setHealth(enemies[currentOpponent].getMaxHealth());
	}

	public void showAllEnemies(int a) {
		for (int i = 1; i < enemies.length - a; i++) {
			System.out.println(i + ". " + enemies[i].getName());
		}

	}

	public void runAway() throws InterruptedException {
		if (25 <= (int) (Math.random() * 100) + 1) {
			System.out.println("\nYou were succesful at running away");
			int moneyChange = (int) (Math.random() * 100) + 1;
			System.out.println("\nThe gods frown upon that decision");
			System.out.println("\nMoney decreased by " + moneyChange);
			((Sekiro) enemies[0]).minusMoney(moneyChange);
			System.out.println("Current Money: " + ((Sekiro) enemies[0]).getMoney());
		} else {
			System.out.println("You were unsuccesful at running away");
			enemies[currentOpponent].attackPerson(enemies[0]);
			fight(currentOpponent);
		}
	}

}
