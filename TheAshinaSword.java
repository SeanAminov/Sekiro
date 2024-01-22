
public class TheAshinaSword extends Enemies {
	public TheAshinaSword(String name) {
		super(name, 120, 300, 40, 20); // Worth, Health, Accuracy, Damage
	}

	public void drops(Enemies sekiro) {
		((Sekiro) sekiro).plusMoney(this.getWorth());
		System.out.println("Current Money:" + ((Sekiro) sekiro).getMoney());
		System.out.println("**Wolf has gained a bead of health**");
		((Sekiro) sekiro).changeMaxHealth(25);
		System.out.println("Total Health: " + sekiro.getMaxHealth());
	}
}
