package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {
    Budget january;
    Budget february;
    Budget march;
    Budget april;

    @BeforeEach
    void runBefore() {
        january = new Budget("january", 0);
        january.setLivingExpenses(500);
        january.setGroceries(300);
        january.setTotalExpenses();
        january.setBalance();
        february = new Budget("february", 1000);
        february.setLivingExpenses(500);
        february.setGroceries(300);
        february.setRestaurants(0);
        february.setTransportation(70);
        february.setEntertainment(30);
        february.setMiscellaneous(0);
        february.setTotalExpenses();
        february.setBalance();
        march = new Budget("march", 2500);
        april = new Budget("april", 10000);
    }

    @Test
    void testGetMonth() {
        assertEquals("january", january.getMonth());
        assertEquals("february", february.getMonth());
        assertEquals("march", march.getMonth());
        assertEquals("april", april.getMonth());
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
    }

    @Test
    void testGetBalance() {
        assertEquals(-800, january.getBalance());
        assertEquals(100, february.getBalance());
    }
}