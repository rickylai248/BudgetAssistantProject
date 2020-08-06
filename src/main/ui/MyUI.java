package ui;

import java.io.*;
import java.util.ArrayList;

import model.Budget;
import model.BudgetList;

import java.util.Scanner;

// Budget application
public class MyUI {
    private ArrayList<Budget> budgetLog;
    private static final String Budget_File = "./data/Budget.txt";
    private Scanner scanner;
    double value = 0;
    String month = "";
    String value2 = "";
    String value3 = "";
    Budget budget = new Budget(month, value);
    BudgetList budgetList = new BudgetList();

    // EFFECTS: runs the budget assistant application
    public MyUI() throws IOException, ClassNotFoundException {
        budgetLog = new ArrayList<>();
        scanner = new Scanner(System.in);
        runUI();
    }

    // MODIFIES: this
    // EFFECTS: loads the previous budget from Budget.txt if selected

    // MODIFIES: this
    // EFFECTS: processes user input
    public void runUI() throws IOException, ClassNotFoundException {
        boolean going = true;

        while (going) {
            System.out.println("\nChoose from:");
            System.out.println("\tb -> create new budget");
            System.out.println("\tl -> load previous budget");
            value2 = scanner.next();
            if (value2.equals("l")) {
                ObjectInputStream in = new ObjectInputStream(new FileInputStream(Budget_File));
                //BudgetList budgetArrayList = BudgetList in.readObject();
                ArrayList<Budget> budgetArrayList = (ArrayList<Budget>) in.readObject();
                for (Budget budget1 : budgetArrayList) {
                    System.out.println("Month : " + budget1.getMonth());
                    budget1.overBudget();
                }
            } else {
                value3 = scanner.nextLine();
                System.out.println("Please enter the month.");
                month = scanner.nextLine();
                budget.setMonth(month);

                runUI2();
            }
            going = false;
        }
    }

    //Separated runUI into three parts due to the line checkstyle constraint
    public void runUI2() throws IOException {
        System.out.println("Please enter your monthly budget.");
        value = scanner.nextDouble();

        System.out.println("Your budget for " + month + " is $ " + value);
        budget.setBudget(value);

        System.out.println("Please enter your Living Expenses for " + month + " (e.g. Rent, Insurance).");
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

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Budget_File));
        //budgetList.addBudget(budget);
        budgetLog.add(budget);
        out.writeObject(budgetLog);
    }
}
