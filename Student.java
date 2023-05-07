/**
 * This class defines the student character, inherited from Character class.
 *
 * @author Changmin Han
 */
public class Student extends Character{
    public boolean hidden = false; // whether the student is in a hidden state
    /**
     * This method initializes the name, power, and energy level of a student, which are defined in the parent class Character.
     *
     * @param name student name.
     * @param power student power level.
     * @param energyLevel student energy level.
     */
    public Student(String name, int power, int energyLevel) {
        super(name, power, energyLevel);
    }

    /**
     * This method handles the "hide" of a student.
     */
    public void hide() {
        String msg = (this.getName() + " hides itself from attacks!");
        System.out.println(msg);
        this.hidden = true;
    }

    /**
     * This method takes a parameter and deduct it from the character energy level. The student doesn't get hurt if he/she is in a hidden state, otherwise get hurt.
     *
     * @param amount amount deducted from the character energy level
     */
    public void hurt(int amount) {
        if (this.hidden) {
            String msg = (this.getName() + " hides from the attack!");
            System.out.println(msg);
            this.hidden = false;
        } else {
            this.setEnergyLevel(this.getEnergyLevel() - amount);
            String msg = (this.getName() + " takes a hurt of " + amount + "! Remaining energy becomes " + this.getEnergyLevel() + ".");
            System.out.println(msg);
        }
    }
}
