
public class MissionList {

	private int averageSwordBearer;
	private int averageSpearBearer;
	private int eliteSamurai;
	private boolean theAshinaSword;
	private boolean theAshinaSpear;
	private boolean genichiroBodyguard;

	public MissionList() {
		averageSwordBearer = 3;
		averageSpearBearer = 3;
		eliteSamurai = 3;
		theAshinaSword = true;
		theAshinaSpear = true;
		genichiroBodyguard = true;
	}

	public int getAverageSwordBearer() {
		return averageSwordBearer;
	}

	public void setAverageSwordBearer(int averageSwordBearer) {
		this.averageSwordBearer = averageSwordBearer;
	}

	public int getAverageSpearBearer() {
		return averageSpearBearer;
	}

	public void setAverageSpearBearer(int averageSpearBearer) {
		this.averageSpearBearer = averageSpearBearer;
	}

	public int getEliteSamurai() {
		return eliteSamurai;
	}

	public void setEliteSamurai(int eliteSamurai) {
		this.eliteSamurai = eliteSamurai;
	}

	public boolean isTheAshinaSword() {
		return theAshinaSword;
	}

	public void setTheAshinaSword(boolean theAshinaSword) {
		this.theAshinaSword = theAshinaSword;
	}

	public boolean isTheAshinaSpear() {
		return theAshinaSpear;
	}

	public void setTheAshinaSpear(boolean theAshinaSpear) {
		this.theAshinaSpear = theAshinaSpear;
	}

	public boolean isGenichiroBodyguard() {
		return genichiroBodyguard;
	}

	public void setGenichiroBodyguard(boolean genichiroBodyguard) {
		this.genichiroBodyguard = genichiroBodyguard;
	}

	public String completed(boolean boss) {
		String complete = "";
		if (boss) {
			complete = "Incomplete";
			return complete;
		}
		complete = "Complete";
		return complete;
	}

	public boolean missionListCompleted() {
		if (averageSwordBearer == 0 && averageSpearBearer == 0 && eliteSamurai == 0 && theAshinaSword == false
				&& theAshinaSpear == false && genichiroBodyguard == false) {
			return true;
		} else {
			return false;
		}
	}

	public String toString() {
		String sentence = "   **Mission List** \nAshina Swordsmen: " + getAverageSwordBearer()
				+ "\nAshina Spearbearer: " + getAverageSpearBearer() + "\nAshina Elite: " + getEliteSamurai()
				+ "\n*Boss* Ashina Sword: " + completed(theAshinaSword) + "\n*Boss* Ashina Spear: "
				+ completed(theAshinaSpear) + "\n*Boss* Genichiro Body Guard: " + completed(genichiroBodyguard);
		return sentence;
	}

}
