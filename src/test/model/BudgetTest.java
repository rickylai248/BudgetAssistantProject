package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {
    Budget january;
    Budget february;
    Budget march;
    Budget april;
    Budget test;

    @BeforeEach
    void runBefore() {
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
        march = new Budget("March", 2500);
        march.setBalancePercent();
        april = new Budget("April", 10000);
        april.setLivingExpenses(10000);
        april.setTotalExpenses();
        april.setBalance();
        april.setBalancePercent();
        test = new Budget("test", 500);
    }

    @Test
    void testGetMonth() {
        assertEquals("January", january.getMonth());
        assertEquals("February", february.getMonth());
        assertEquals("March", march.getMonth());
        assertEquals("April", april.getMonth());
    }

    @Test
    void testSetBudget() {
        assertEquals(500, test.getBudget());
        test.setBudget(600);
        assertEquals(600, test.getBudget());
    }

    @Test
    void testSetMonth() {
        assertEquals("test", test.getMonth());
        test.setMonth("December");
        assertEquals("December", test.getMonth());
    }

    @Test
    void testGetBudget() {
        assertEquals(0, january.getBudget());
        assertEquals(1000, february.getBudget());
        assertEquals(2500, march.getBudget());
        assertEquals(10000, april.getBudget());
    }

    @Test
    void testGetLivingExpenses() {
        assertEquals(500, january.getLivingExpenses());
        assertEquals(500, february.getLivingExpenses());
        assertEquals(10000, april.getLivingExpenses());
    }

    @Test
    void testGetGroceries() {
        assertEquals(300, january.getGroceries());
        assertEquals(300, february.getGroceries());
    }

    @Test
    void testGetRestaurants() {
        assertEquals(0, january.getRestaurants());
        assertEquals(0, february.getRestaurants());
    }

    @Test
    void testGetTransportation() {
        assertEquals(0, january.getTransportation());
        assertEquals(70, february.getTransportation());
    }

    @Test
    void testGetEntertainment() {
        assertEquals(0, january.getEntertainment());
        assertEquals(30, february.getEntertainment());
    }

    @Test
    void testGetMiscellaneous() {
        assertEquals(0, january.getMiscellaneous());
        assertEquals(0, february.getMiscellaneous());
    }

    @Test
    void testGetTotalExpenses() {
        assertEquals(800, january.getTotalExpenses());
        assertEquals(900, february.getTotalExpenses());
        assertEquals(10000, april.getTotalExpenses());
    }

    @Test
    void testGetBalance() {
        assertEquals(-800, january.getBalance());
        assertEquals(100, february.getBalance());
        assertEquals(0, april.getBalance());
    }

    @Test
    void testGetBalancePercent() {
        assertEquals(90, february.getBalancePercent());
        assertEquals(0, march.getBalancePercent());
        assertEquals(100, april.getBalancePercent());
    }

    @Test
    void testOverBudget() {
        january.overBudget();
        assertEquals(true, january.getOverBalance());
        february.overBudget();
        assertEquals(false, february.getOverBalance());
        april.overBudget();
        assertEquals(false, april.getOverBalance());
    }
}