package ui;

import java.io.*;
import java.util.ArrayList;

import model.Budget;

import java.util.Scanner;

public class MyUI {
    private ArrayList<Budget> budgetLog;
    private Scanner scanner;
    double value = 0;
    String month = "";
    String value2 = "";
    String value3 = "";
    Budget budget = new Budget(month, value);

    public MyUI() throws IOException, ClassNotFoundException {
        budgetLog = new ArrayList<>();
        scanner = new Scanner(System.in);
        runUI();
    }

    public void runUI() throws IOException, ClassNotFoundException {
        boolean going = true;

        while (going) {
            System.out.println("\nSelect from:");
            System.out.println("\tb -> create new budget");
            System.out.println("\tl -> load previous budget");
            value2 = scanner.next();
            if (value2.equals("l")) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("./data/Budget.txt"));
                Budget budget1 = (Budget) in.readObject();
                System.out.println("Month : " + budget1.getMonth());
                budget1.overBudget();
                going = false;
            } else {
                value3 = scanner.nextLine();
                System.out.println("Please enter the month");
                month = scanner.nextLine();
                budget.setMonth(month);
                System.out.println("Please enter your monthly budget");
                value = scanner.nextDouble();
                runUI2();
                going = false;
            }
        }
    }

    //Separated runUI into three parts due to the line checkstyle constraint
    public void runUI2() throws IOException {
        System.out.println("Your budget for " + month + " is $ " + value);
        budget.setBudget(value);

        System.out.println("Please enter your Living Expenses for " + month);
        value = scanner.nextDouble();

        System.out.println("Your Living Expenses this month is $ " + value);
        budget.setLivingExpenses(value);

        System.out.println("Please enter your Grocery Expenses for " + month);
        value = scanner.nextDouble();
        System.out.println("Your grocery expense this month is $ " + value);
        budget.setGroceries(value);

        System.out.println("Please enter your Restaurant Expenses for " + month);
        value = scanner.nextDouble();
        System.out.println("Your Living Expense budget this month is $ " + value);
        budget.setRestaurants(value);

        System.out.println("Please enter your Transportation Expenses for " + month);
        value = scanner.nextDouble();
        System.out.println("Your transportation expense this month is $ " + value);
        budget.setTransportation(value);

        runUI3();
    }

    public void runUI3() throws IOException {
        System.out.println("Please enter your Entertainment Expenses for " + month);
        value = scanner.nextDouble();

        System.out.println("Your entertainment expense this month is $ " + value);
        budget.setEntertainment(value);

        System.out.println("Please enter your Additional Expenses for " + month);
        value = scanner.nextDouble();
        System.out.println("Your miscellaneous expense this month is $ " + value);

        budget.setMiscellaneous(value);

        budget.setTotalExpenses();

        budget.setBalance();

        budget.setBalancePercent();

        budget.overBudget();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./data/Budget"
                + ".txt"));
        out.writeObject(budget);

    }
/*        System.out.println("Would you like to save this month's budget? (Yes or No)");
        value2 = scanner.nextLine();

        if (value2.equals("Yes")) {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./data/Budget"
                    + ".txt"));
            out.writeObject(budget);
        } else {
            System.out.println("\nGoodbye!");
        }*/
}
