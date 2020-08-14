package ui;

import model.Budget;
import model.BudgetList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleUI {
    ArrayList<Budget> budgetLog = new ArrayList<>();
    private static final String Budget_File = "./data/Budget.txt";
    private Scanner scanner;
    double value = 0;
    String month = "";
    String value2 = "";
    String value3 = "";
    Budget budget = new Budget(month, value);
    BudgetList budgetList;

    public ConsoleUI() throws IOException, ClassNotFoundException {
        budgetList = new BudgetList();
        scanner = new Scanner(System.in);
        runUI();
        ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(Paths.get(Budget_File)));
        out.writeObject(budgetLog);

        out.close();
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
                ObjectInputStream in = new ObjectInputStream(Files.newInputStream(Paths.get(Budget_File)));
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
    public void runUI2() {
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

    public void runUI3() {
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

        budgetList.addBudget(budget);
        budgetLog.add(budget);
    }
}
