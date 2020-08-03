package ui;

import java.util.ArrayList;

import model.Budget;

import java.util.Scanner;

public class MyUI {
    private ArrayList<Budget> budgetLog;
    private Scanner scanner;
    double value = 0;
    String month = "";
    Budget budget = new Budget(month, value);

    public MyUI() {
        budgetLog = new ArrayList<>();
        scanner = new Scanner(System.in);
        runUI();
    }

    public void runUI() {
        while (true) {

            System.out.println("Please enter the month");
            month = scanner.nextLine();
            budget.setMonth(month);

            System.out.println("Please enter your monthly budget");
            try {
                value = scanner.nextDouble();
                System.out.println("Your budget for " + month + " is $ " + value);
            } catch (Exception e) {
                System.out.println("Sorry, please enter a number");
            }

            budget.setBudget(value);

            runUI2();
        }
    }

    //Separated runUI into three parts due to the line checkstyle constraint
    public void runUI2() {
        try {
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
        } catch (Exception e) {
            System.out.println("Sorry, please enter a number!");
        }

        runUI3();
    }

    public void runUI3() {
        try {
            System.out.println("Please enter your Entertainment Expenses for " + month);
            value = scanner.nextDouble();
            System.out.println("Your entertainment expense this month is $ " + value);
            budget.setEntertainment(value);

            System.out.println("Please enter your Additional Expenses for " + month);
            value = scanner.nextDouble();
            System.out.println("Your miscellaneous expense this month is $ " + value);
        } catch (Exception e) {
            System.out.println("Sorry, please enter a number!");
        }

        budget.setMiscellaneous(value);

        budget.setTotalExpenses();
        budget.setBalance();
        budget.setBalancePercent();

        budget.overBudget();
    }

}
