package model;

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

    public Budget(String month, double budget) {
        this.month = month;
        this.budget = budget;
    }

    public String getMonth() {
        return month;
    }

    public double getBudget() {
        return budget;
    }

    public double getLivingExpenses() {
        return livingExpenses;
    }

    public double getGroceries() {
        return groceries;
    }

    public double getRestaurants() {
        return restaurants;
    }

    public double getTransportation() {
        return transportation;
    }

    public double getEntertainment() {
        return entertainment;
    }

    public double getMiscellaneous() {
        return miscellaneous;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public void setMonth(String month1) {
        month = month1;
    }

    public void setBudget(double budget1) {
        budget = budget1;
    }

    public void setLivingExpenses(double livingExpenses1) {
        livingExpenses = livingExpenses1;
    }

    public void setGroceries(double groceries1) {
        groceries = groceries1;
    }

    public void setRestaurants(double restaurants1) {
        restaurants = restaurants1;
    }

    public void setTransportation(double transportation1) {
        transportation = transportation1;
    }

    public void setEntertainment(double entertainment1) {
        entertainment = entertainment1;
    }

    public void setMiscellaneous(double miscellaneous1) {
        miscellaneous = miscellaneous1;
    }

    public void setTotalExpenses() {
        totalExpenses = getEntertainment() + getGroceries() + getLivingExpenses() + getMiscellaneous()
                + getRestaurants() + getTransportation();
    }
}
