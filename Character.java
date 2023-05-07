/**
 * This class defines the Character class which is a parent class of SecurityGuard and Student.
 *
 * @author Changmin Han
 */
public class Character {
    private String characterName;
    private int power;
    private int energyLevel;

    /**
     * This method initializes the name, power, and energy level of a character.
     *
     * @param name character name.
     * @param power character power level.
     * @param energyLevel character energy level.
     */
    public Character(String name, int power, int energyLevel) {
        this.characterName = name;
        this.power = power;
        this.energyLevel = energyLevel;
    }

    /**
     * This method returns the character name.
     *
     * @return character name.
     */
    public String getName() {
        return this.characterName;
    }

    /**
     * This method returns the character power level.
     *
     * @return character power level.
     */
    public int getPower() {
        return this.power;
    }

    /**
     * This method returns the character energy level.
     *
     * @return character energy level.
     */
    public int getEnergyLevel() {
        return this.energyLevel;
    }

    /**
     * This method takes a value a parameter and set it to the character energy level
     *
     * @param value new character energy level.
     */
    public void setEnergyLevel(int value) {
        this.energyLevel = value;
    }

    /**
     * This method takes a parameter and deduct it from the character energy level.
     *
     * @param amount amount deducted from the character energy level
     */
    public void hurt(int amount) {
        this.energyLevel -= amount;
        String msg = (this.characterName + " takes a hurt of " + amount + "! Remaining energy becomes " + this.energyLevel + ".");
        System.out.println(msg);
    }

    /**
     * This method handles the "attack".
     *
     * @return power level being attacked to the opponent.
     */
    public int attack() {
        String msg = (this.characterName + " launches an attack!");
        System.out.println(msg);
        return this.power;
    }

    /**
     * This method determines whether the current player lost.
     *
     * @return Whether the current character lost or not
     */
    public boolean isLose() {
        return this.energyLevel <= 0;
    }

}
