// author: waturn

// HEAVILY UNIMPLEMENTED
// VERY WIP

import java.io.*;
import java.util.Random;

public class Javadig {
    static BufferedReader stdin;
    static Player player;
    public static void main(String[] args) throws IOException {
        stdin = new BufferedReader(new InputStreamReader(System.in));

        player = new Player();

        String welcome = """
                ====================
                 WELCOME TO JAVADIG
                ====================
                """;
        System.out.println(welcome);

        int choice = -1;

        displayUI();

        do {
            System.out.print("MAKE A SELECTION: ");
            choice = Integer.parseInt(readAndEcho());

            switch (choice) {
                case 0:
                    System.out.println("BETTER LUCK NEXT TIME\n\n");
                    break;
                case 1:
                    mine(player.getPickaxe());
                    displayUI();
                    break;
                case 2:
                    // NOT IMPLEMENTED YET
                    //displayUI();
                    //displayShop();
                    break;
                case 3:
                    // NOT IMPLEMENTED YET
                    //displayUI();
                    //sellOres();
                    break;
                default:
                    System.out.println("INVALID SELECTION.");
                    break;
                }
            } while (choice != 0);
    }

    private static String readAndEcho() throws IOException {
        String input = stdin.readLine().trim();
        System.out.println(input);
        return input;
    }

    private static void displayUI() {
        System.out.println("-=-BAG STATS-=-");
        System.out.println(player.getBag().toString());
        System.out.println();

        System.out.println("-=-PICKAXE STATS-=-");
        System.out.println(player.getPickaxe().toString());
        System.out.println();

        System.out.printf("BALANCE: $%.2f%n", player.getBalance());
        System.out.println();

        System.out.println("-=====-MAIN MENU-=====-");
        System.out.println("1. Mine");
        System.out.println("2. Shop");
        System.out.println("3. Sell Ores");
        System.out.println("0. Exit");
    }

    private static void mine(Pickaxe pickaxe) {
        // Pickaxe efficiency is calculated by a random number of ore rolls based on its efficiency stat
        double topRange = pickaxe.getEfficiency();
        double bottomRange = pickaxe.getEfficiency() * 0.75;

        Random randMine = new Random();
        Random randLoop = new Random();

        double roll = randMine.nextDouble() * (topRange - bottomRange) + bottomRange; // Random double between bottomRange and topRange to represent the mine amount
        int mineSize = (int) roll;

        for (int i = 0; i < mineSize; i++) {
            int randLoopValue = randLoop.nextInt(player.getBag().getBagMaxCapacity()) + 1;
            switch (randLoopValue) {
                case 1:
                    player.getBag().addStone();
                    break;
                case 2:
                    player.getBag().addIron();
                    break;
                case 3:
                    player.getBag().addCopper();
                    break;
                case 4:
                    player.getBag().addGold();
                    break;
            }
        }


        player.getPickaxe().addPickaxeXP(roll);
    }
}
