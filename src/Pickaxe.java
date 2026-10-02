// author: waturn

// HEAVILY UNIMPLEMENTED
// VERY WIP

public class Pickaxe {
    private static String name;
    private static int level;
    private static double xp;
    private static double miningPower;
    private static double miningEfficiency;
    private static final double XP_PER_LEVEL = 200.0;

    public Pickaxe() {
        this.name = "Default Pickaxe";
        this.level = 0;
        this.xp = 0.0;
        this.miningPower = 1.0;
        this.miningEfficiency = 100.0;
    }
    
    // ADD XP METHODS
    // This should be the only way for this class to modify the XP and level of the pickaxe.
    private double getXPForNextLevel(int level) {
        return XP_PER_LEVEL * Math.pow(2, level);
    }
    public void addPickaxeXP(double newXP) {
        this.xp += newXP;
        while (this.xp >= getXPForNextLevel(this.level)) {
            this.xp -= getXPForNextLevel(this.level);
            this.level++;
            this.miningPower *= 1.05; // Increase mining power by 5% with each level up
            this.miningEfficiency *= 1.15; // Increase mining efficiency by 15% with each level up
        }
    }

    // BASIC GETTERS
    public String getName() {
        return this.name;
    }
    public int getLevel() {
        return this.level;
    }
    public double getXP() {
        return this.xp;
    }
    public double getMiningPower() {
        return this.miningPower;
    }
    public double getEfficiency() {
        return this.miningEfficiency;
    }

    // BASIC SETTERS
    // For this logic, the Pickaxe instance's double miningPower, int miningEfficiency, and String name should ONLY be SET when a new pickaxe is crafted.
    public void setMiningPower(double newMiningPower) {
        this.miningPower = newMiningPower;
    }
    public void setEfficiency(double newEfficiency) {
        this.miningEfficiency = newEfficiency;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    // HELPERS
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String tempXP = String.format("%.2f XP", this.xp);
        String tempMiningPower = String.format("%.2f Mining Power", this.miningPower);
        String tempMiningEfficiency = String.format("%.2f Mining Efficiency", this.miningEfficiency);

        sb.append("Level: ").append(this.level).append("\n");
        sb.append(tempXP).append("\n");
        sb.append(tempMiningPower).append("\n");
        sb.append(tempMiningEfficiency);
        return sb.toString();
    }

}
