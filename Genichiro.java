
public class Genichiro extends Enemies {

	public Genichiro(String name) {
		super(name, 10000, 1000, 70, 30);
	}
	
	public void drops(Enemies sekiro) {
		((Sekiro) sekiro).plusMoney(this.getWorth());
		System.out.println("Current Money:" + ((Sekiro) sekiro).getMoney());
		System.out.println("**Wolf has gained five beads of Health and five beads of Damage**");
		sekiro.setAttackDamage(getAttackDamage() + 50);
		((Sekiro) sekiro).changeMaxHealth(125);
		System.out.println("Total Health: " + sekiro.getMaxHealth());
		System.out.println("Attack Damage: " + sekiro.getAttackDamage());
	}
}
