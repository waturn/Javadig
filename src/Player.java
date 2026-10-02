// author: waturn

// HEAVILY UNIMPLEMENTED
// VERY WIP

import java.util.Random;

public class Player {
    private Bag bag;
    private Pickaxe pickaxe;
    private double balance;

    public Player() {
        this.bag = new Bag();
        this.pickaxe = new Pickaxe();
        this.balance = 0.0;
    }

    public Bag getBag() {
        return bag;
    }

    public Pickaxe getPickaxe() {
        return pickaxe;
    }

    public double getBalance() {
        return balance;
    }
}
