
public class GenichiroBodyguard extends Enemies {
	public GenichiroBodyguard(String name) {
		super(name, 300, 200, 40, 30); // Worth, Health, Accuracy, Damage
	}

	public void drops(Enemies sekiro) {
		((Sekiro) sekiro).plusMoney(this.getWorth());
		System.out.println("Current Money:" + ((Sekiro) sekiro).getMoney());
		System.out.println("**Wolf has gained two beads of Health and two beads of Damage**");
		sekiro.setAttackDamage(getAttackDamage() + 20);
		((Sekiro) sekiro).changeMaxHealth(50);
		System.out.println("Total Health: " + sekiro.getMaxHealth());
		System.out.println("Attack Damage: " + sekiro.getAttackDamage());
	}

}
