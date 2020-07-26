package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {
    Budget january;
    Budget february;
    Budget march;
    Budget april;
    Budget may;

    @BeforeEach
    void runBefore() {
        january = new Budget("january", 0);
        january.setLivingExpenses(500);
        january.setGroceries(300);
        january.setTotalExpenses();
        january.setBalance();
        february = new Budget("february", 1000);
        march = new Budget("march", 2500);
        april = new Budget("april", 0);
        may = new Budget("may",10000);
    }

    @Test
    void testGetMonth() {
        assertEquals("january", january.getMonth());
    }

    @Test
    void testGetBudget() {
        assertEquals(0,january.getBudget());
    }

    @Test
    void testGetLivingExpenses() {
        assertEquals(500, january.getLivingExpenses());
    }

    @Test
    void testGetGroceries() {
        assertEquals(300,january.getGroceries());
    }

    @Test
    void testGetTotalExpenses() {
        assertEquals(800,january.getTotalExpenses());
    }

    @Test
    void testGetBalance() {
        assertEquals(-800,january.getBalance());
    }
}