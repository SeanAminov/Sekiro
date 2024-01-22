
public class TheAshinaSpear extends Enemies {
	public TheAshinaSpear(String name) {
		super(name, 250, 200, 60, 30); // Worth, Health, Accuracy, Damage
	}

	public void drops(Enemies sekiro) {
		((Sekiro) sekiro).plusMoney(this.getWorth());
		System.out.println("Current Money:" + ((Sekiro) sekiro).getMoney());
		System.out.println("**Wolf has gained a bead of damage**");
		sekiro.setAttackDamage(getAttackDamage() + 10);
		System.out.println("Attack Damage: " + sekiro.getAttackDamage());
	}

}
