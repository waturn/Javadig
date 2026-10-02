// author: waturn

// HEAVILY UNIMPLEMENTED
// VERY WIP

public class Bag {
    protected static final int NUM_ORES = 4;
    protected static int []ores;
    // ores[NUM_ORES] = [common ore, ..., rarest ore]

    public Bag() {
        ores = new int[NUM_ORES];
    }

    // STONE
    public void addStone() {
        ores[0]++;
    }
    public void removeStone() {
        ores[0]--;
    }
    public int getStone() {
        return ores[0];
    }

    // IRON
    public void addIron() {
        ores[1]++;
    }
    public void removeIron() {
        ores[1]--;
    }
    public int getIron() {
        return ores[1];
    }

    // COPPER
    public void addCopper() {
        ores[2]++;
    }
    public void removeCopper() {
        ores[2]--;
    }
    public int getCopper() {
        return ores[2];
    }

    // GOLD
    public void addGold() {
        ores[3]++;
    }
    public void removeGold() {
        ores[3]--;
    }
    public int getGold() {
        return ores[3];
    }



    // HELPERS
    public int getTotalOres() {
        int total = 0;
        for (int i = 0; i < NUM_ORES; i++) {
            total += ores[i];
        }
        return total;
    }

    public int getBagMaxCapacity() {
        return NUM_ORES;
    }

    public void clear() {
        ores = new int[NUM_ORES];
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Gold: ").append(getGold()).append("\n");
        sb.append("Copper: ").append(getCopper()).append("\n");
        sb.append("Iron: ").append(getIron()).append("\n");
        sb.append("Stone: ").append(getStone());
        return sb.toString();
    }
}
