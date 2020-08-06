package model;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class BudgetList {
    private List<Budget> budgetList;

    // EFFECTS: constructs empty list of budgets
    public BudgetList() {
        budgetList = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds b to list of budgets
    public void addBudget(Budget b) {
        budgetList.add(b);
    }

    // REQUIRES: b to be in the list of budgets
    // MODIFIES: this
    // EFFECTS: removes b to list of budgets
    public void removeBudget(Budget b) {
        budgetList.remove(b);
    }

    public Budget getBudget(int index) {
        return budgetList.get(index);
    }

    // EFFECTS: returns number of budgets in list
    public int length() {
        return budgetList.size();
    }
}
