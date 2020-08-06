package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BudgetListTest {
    BudgetList budgetList;
    Budget january;
    Budget february;

    @BeforeEach
    void runBefore() {
        budgetList = new BudgetList();
        january = new Budget("January", 0);
        january.setLivingExpenses(500);
        january.setGroceries(300);
        january.setTotalExpenses();
        january.setBalance();
        february = new Budget("February", 1000);
        february.setLivingExpenses(500);
        february.setGroceries(300);
        february.setRestaurants(0);
        february.setTransportation(70);
        february.setEntertainment(30);
        february.setMiscellaneous(0);
        february.setTotalExpenses();
        february.setBalance();
        february.setBalancePercent();
        budgetList.addBudget(january);
    }

    @Test
    void TestAddBudget() {
        budgetList.addBudget(february);
        assertEquals(2, budgetList.length());
    }

    @Test
    void TestRemoveBudget() {
        budgetList.removeBudget(january);
        assertEquals(0, budgetList.length());
    }

    @Test
    void TestGetBudget() {
        assertEquals(budgetList.getBudget(0).getMonth(), "January");
    }

    @Test
    void TestLength() {
        assertEquals(budgetList.length(), 1);
    }
}
