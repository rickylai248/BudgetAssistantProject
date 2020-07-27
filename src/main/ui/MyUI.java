package ui;

import java.util.ArrayList;

import model.Budget;

import java.util.Scanner;

public class MyUI {
    private ArrayList<Budget> budgetLog;
    private Scanner scanner;
    double value = 0;
    String value1 = "";
    Budget budget = new Budget(value1, value);

    public MyUI() {
        budgetLog = new ArrayList<>();
        scanner = new Scanner(System.in);
        runUI();
    }

    public void runUI() {
        while (true) {

            System.out.println("Please enter the month");
            value1 = scanner.nextLine();
            System.out.println(value1);
            budget.setMonth(value1);

            System.out.println("Please enter your monthly budget");
            value = scanner.nextDouble();
            System.out.println("Your budget for " + value1 + " is $ " + value);
            budget.setBudget(value);

            runUI2();
        }
    }

    public void runUI2() {
        System.out.println("Please enter your Living Expenses for " + value1);
        value = scanner.nextDouble();
        System.out.println("Your Living Expenses this month is $ " + value);
        budget.setLivingExpenses(value);

        System.out.println("Please enter your Grocery Expenses for " + value1);
        value = scanner.nextDouble();
        System.out.println("Your grocery expense this month is $ " + value);
        budget.setGroceries(value);

        System.out.println("Please enter your Restaurant Expenses for " + value1);
        value = scanner.nextDouble();
        System.out.println("Your Living Expense budget this month is $ " + value);
        budget.setRestaurants(value);

        System.out.println("Please enter your Transportation Expenses for " + value1);
        value = scanner.nextDouble();
        System.out.println("Your transportation expense this month is $ " + value);
        budget.setTransportation(value);

        System.out.println("Please enter your Entertainment Expenses for " + value1);
        value = scanner.nextDouble();
        System.out.println("Your entertainment expense this month is $ " + value);
        budget.setEntertainment(value);

        runUI3();
    }

    public void runUI3() {
        System.out.println("Please enter your Additional Expenses for " + value1);
        value = scanner.nextDouble();
        System.out.println("Your miscellaneous expense this month is $ " + value);
        budget.setMiscellaneous(value);

        budget.setTotalExpenses();
        budget.setBalance();

        if (budget.getBalance() < 0) {
            System.out.println("You are going over your monthly budget by $" + budget.getBalance());
        } else {
            System.out.println("Keep it up! You are over your total expenses by $"
                    + budget.getBalance());
        }
    }

}
