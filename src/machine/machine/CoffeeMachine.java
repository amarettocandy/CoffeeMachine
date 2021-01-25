package 0machine;
import java.util.*;

public class CoffeeMachine {

    public static void printAll(int curWater, int curMilk, int curCoffee, int curCups, int curmoney) {
        System.out.println("\nThe coffee machine has:");
        System.out.println(curWater + " of water");
        System.out.println(curMilk + " of milk");
        System.out.println(curCoffee + " of coffee beans");
        System.out.println(curCups + " of disposable cups");
        System.out.println(curmoney + " of money\n");
    }

    public static boolean itCheck(String chooseCoffee, int curWater, int curMilk, int curCoffee, int curCups, int curmoney) {
        boolean check = false;

        int limitWater;
        int limitMilk;
        int limitCoffee;

        switch (chooseCoffee) {
            case "1":    //espresso
                limitWater = 250;
                limitMilk = 0;
                limitCoffee = 16;
                break;
            case "2":     //latte
                limitWater = 350;
                limitMilk = 75;
                limitCoffee = 20;
                break;
            case "3":     //cappuccino
                limitWater = 200;
                limitMilk = 100;
                limitCoffee = 12;
                break;
            default:
                return false;
        }
        if (curWater < limitWater) {
            System.out.println("Sorry , not enough water!");
        } else if (curMilk < limitMilk) {
            System.out.println("Sorry, not enough milk!");
        } else if (curCoffee < limitCoffee) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (curCups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else {
            check = true;
            System.out.println("I have enough resources, making you a coffee!");
        }
        return check;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int curWater = 400;
        int curMilk = 540;
        int curCoffee = 120;
        int curCups = 9;
        int curmoney = 550;
        while (true) {
            System.out.print("Write action (buy, fill, take, remaining, exit): ");
            String chooseAction = scanner.nextLine();
            System.out.println();

            switch (chooseAction) {
                case "buy":
                    System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                            "back - to main menu: ");
                    String chooseCoffee = scanner.next();
                    boolean check = itCheck(chooseCoffee, curWater, curMilk, curCoffee, curCups, curmoney);

                    switch (chooseCoffee) {
                        case "1": // espresso
                            if (check) {
                                curWater -= 250;
                                curCoffee -= 16;
                                curCups -= 1;
                                curmoney += 4;
                            }
                            break;
                        case "2": // latte
                            if (check) {
                                curWater -= 350;
                                curMilk -= 75;
                                curCoffee -= 20;
                                curCups -= 1;
                                curmoney += 7;
                            }
                            break;
                        case "3": // cappuccino
                            if (check) {
                                curWater -= 200;
                                curMilk -= 100;
                                curCoffee -= 12;
                                curCups -= 1;
                                curmoney += 6;
                            }
                            break;
                        case "back":
                            break;
                        default:
                            System.out.println("Unknown coffee type");
                            break;
                    }
                    break;
                case "fill":
                    System.out.print("Write how many ml of water do you want to add: ");
                    curWater += scanner.nextInt();
                    System.out.print("Write how many ml of milk do you want to add: ");
                    curMilk += scanner.nextInt();
                    System.out.print("Write how many grams of coffee beans do you want to add: ");
                    curCoffee += scanner.nextInt();
                    System.out.print("Write how many disposable cups of coffee do you want to add: ");
                    curCups += scanner.nextInt();
                    break;
                case "take":
                    System.out.printf("I gave you $%s\n", curmoney);
                    curmoney = 0;
                    break;
                case "remaining":
                    printAll(curWater, curMilk, curCoffee, curCups, curmoney);
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown command");
                    break;
            }
            System.out.println();
        }
    }
}