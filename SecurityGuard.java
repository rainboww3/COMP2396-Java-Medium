/**
 * This class defines the security guard character, inherited from Character class.
 *
 * @author Changmin Han
 */
public class SecurityGuard extends Character {
    private boolean boosted = false;
    /**
     * This method initializes the name, power, and energy level of a security guard, which are defined in the parent class Character.
     *
     * @param name security guard name.
     * @param power security guard power level.
     * @param energyLevel security guard energy level.
     */
    public SecurityGuard(String name, int power, int energyLevel) {
        super(name, power, energyLevel);
    }

    /**
     * This method sets that the current character is "boosted"
     */
    public void boost() {
        String msg = (this.getName() + " boosts its laser gun!");
        System.out.println(msg);
        this.boosted = true;
    }

    /**
     * This method simulates the "attack". The power level depends on whether the character is boosted or not
     *
     * @return two times the current power if boosted, otherwise the current power.
     */
    public int attack() {
        if (this.boosted) {
            String msg = (this.getName() + " makes a heavy strike!");
            System.out.println(msg);
            this.boosted = false;
            return 2 * this.getPower();
        } else {
            String msg = (this.getName() + " strikes hard!");
            System.out.println(msg);
            return this.getPower();
        }
    }
}
