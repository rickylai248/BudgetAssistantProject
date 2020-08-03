package model;

import ui.MyUI;

import java.io.PrintWriter;
import java.io.Serializable;

public class Budget implements Serializable {
    private String month;
    private double livingExpenses;
    private double groceries;
    private double restaurants;
    private double transportation;
    private double entertainment;
    private double miscellaneous;
    private double budget;
    private double totalExpenses;
    private double balance;
    private boolean overBalance;
    private double balancePercent;

    // REQUIRES: month has a non-zero length
    // EFFECTS: constructs a monthly budget with given month name and budget amount
    public Budget(String month, double budget) {
        this.month = month;
        this.budget = budget;
    }

    /*
     * REQUIRES: month has a non-zero length
     * EFFECTS: constructs a monthly budget with given month name, budget amount, and amount spent per category
     * NOTE: this constructor is to be used only when constructing
     * an account from data stored in file
     */
/*    public Budget(String month, double budget, double balance, double livingExpenses, double groceries,
                  double restaurants, double transportation, double entertainment, double miscellaneous,
                  double totalExpenses, double balancePercent) {
        this.month = month;
        this.budget = budget;
        this.balance = balance;
        this.livingExpenses = livingExpenses;
        this.groceries = groceries;
        this.restaurants = restaurants;
        this.transportation = transportation;
        this.entertainment = entertainment;
        this.miscellaneous = miscellaneous;
        this.totalExpenses = totalExpenses;
        this.balancePercent = balancePercent;
    }*/

    // MODIFIES: this
    // EFFECTS: sets input to the month of provided budget
    public void setMonth(String month1) {
        month = month1;
    }

    // MODIFIES: this
    // EFFECTS: sets input to the budget of provided Budget object
    public void setBudget(double budget1) {
        budget = budget1;
    }

    // MODIFIES: this
    // EFFECTS: sets input to the the monthly living expense
    public void setLivingExpenses(double livingExpenses1) {
        livingExpenses = livingExpenses1;
    }

    // MODIFIES: this
    // EFFECTS: sets input to the the grocery expenses
    public void setGroceries(double groceries1) {
        groceries = groceries1;
    }

    // MODIFIES: this
    // EFFECTS: sets input to the the restaurant expenses
    public void setRestaurants(double restaurants1) {
        restaurants = restaurants1;
    }

    // MODIFIES: this
    // EFFECTS: sets input to the the transportation expenses
    public void setTransportation(double transportation1) {
        transportation = transportation1;
    }

    // MODIFIES: this
    // EFFECTS: sets input to the the entertainment expenses
    public void setEntertainment(double entertainment1) {
        entertainment = entertainment1;
    }

    // MODIFIES: this
    // EFFECTS: sets input to the the miscellaneous expenses
    public void setMiscellaneous(double miscellaneous1) {
        miscellaneous = miscellaneous1;
    }

    // MODIFIES: this
    // EFFECTS: retrieves all of the inputted costs (grocery, living expenses) and sums them up to get total expense
    public void setTotalExpenses() {
        totalExpenses = getEntertainment() + getGroceries() + getLivingExpenses() + getMiscellaneous()
                + getRestaurants() + getTransportation();
    }

    // MODIFIES: this
    // EFFECTS: subtracts the total budget from the summed total expenses to get the end of month balance
    public void setBalance() {
        balance = budget - totalExpenses;
    }

    // REQUIRES: budget > 0
    // MODIFIES: this
    // EFFECTS: divides the input total expenses by budget then multiply by 100 to get the percentage spent on budget
    public void setBalancePercent() {
        balancePercent = totalExpenses / budget;
        balancePercent *= 100;
    }

    // EFFECTS: returns entered month
    public String getMonth() {
        return month;
    }

    // EFFECTS: returns the monthly budget
    public double getBudget() {
        return budget;
    }

    // EFFECTS: returns entered living expenses
    public double getLivingExpenses() {
        return livingExpenses;
    }

    // EFFECTS: returns entered groceries expenses
    public double getGroceries() {
        return groceries;
    }

    // EFFECTS: returns entered restaurant expenses
    public double getRestaurants() {
        return restaurants;
    }

    // EFFECTS: returns entered transportation costs
    public double getTransportation() {
        return transportation;
    }

    // EFFECTS: returns entered entertainment costs
    public double getEntertainment() {
        return entertainment;
    }

    // EFFECTS: returns entered additional expenses
    public double getMiscellaneous() {
        return miscellaneous;
    }

    // EFFECTS: returns the overall total expense
    public double getTotalExpenses() {
        return totalExpenses;
    }

    // EFFECTS: returns the balance or difference between the given budget and total expense
    public double getBalance() {
        return balance;
    }

    // EFFECTS: returns the percentage spent of total expenses by the budget
    public double getBalancePercent() {
        return balancePercent;
    }

    // EFFECTS: if the balance is in the negative then
    // print statement where they are going over monthly budget by balance
    // else they are not over budget, and are told to keep it up! Excess budget/income by balance()
    public void overBudget() {
        if (getBalance() < 0) {
            System.out.println("You are going over your monthly budget by $" + getBalance() + "! ("
                    + getBalancePercent() + "% Spent)");
            categorySpent();
            overBalance = true;
        } else if (getBalance() > 0) {
            System.out.println("Keep it up! You are in the green for your total expenses by $"
                    + getBalance() + " (" + getBalancePercent() + "% Spent)");
            categorySpent();
            overBalance = false;
        } else {
            System.out.println("Your budget perfectly fits your current expense of " + getBalance()
                    + " ! Still in the clear (" + getBalancePercent() + "% Spent)");
            categorySpent();
            overBalance = false;
        }
    }

    // EFFECTS: returns true if over the budget, false otherwise
    public boolean getOverBalance() {
        return overBalance;
    }

    // Helper method for overBudget where it prints out the specific category and expense
    public void categorySpent() {
        System.out.println("- Categories -");
        System.out.println("Living Expenses: $" + getLivingExpenses());
        System.out.println("Grocery Expenses: $" + getGroceries());
        System.out.println("Restaurant Expenses: $" + getRestaurants());
        System.out.println("Transportation Expenses: $" + getTransportation());
        System.out.println("Entertainment Expenses: $" + getEntertainment());
        System.out.println("Miscellaneous Expenses: $" + getMiscellaneous());
        System.out.println("- End -");
    }

/*    @Override
    public void save(PrintWriter printWriter) {
        printWriter.print(nextAccountId);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(id);
        printWriter.print(Reader.DELIMITER);
        printWriter.print(name);
        printWriter.print(Reader.DELIMITER);
        printWriter.println(balance);
    }*/
}
