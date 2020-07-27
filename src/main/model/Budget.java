package model;

import ui.MyUI;

public class Budget {
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

    // EFFECTS: constructs a monthly budget with given month name and budget amount
    public Budget(String month, double budget) {
        this.month = month;
        this.budget = budget;
    }

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

    // EFFECTS: if the balance is in the negative then
    // print statement where they are going over monthly budget by balance
    // else they are not over budget, and are told to keep it up! Excess budget/income by balance()
    public void overBudget() {
        if (getBalance() < 0) {
            System.out.println("You are going over your monthly budget by $" + getBalance() + "!");
            overBalance = true;
        } else {
            System.out.println("Keep it up! You are over your total expenses by $"
                    + getBalance());
            overBalance = false;
        }
    }

    // EFFECTS: returns true if over the budget, false otherwise
    public boolean getOverBalance() {
        return overBalance;
    }
}
