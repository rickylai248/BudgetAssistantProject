package model;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class BudgetTest {
    Budget january;
    Budget february;
    Budget march;

    @BeforeEach
    void runBefore() {
        january = new Budget("january", 0);
        february = new Budget("february", 1000);
        march = new Budget("march", 2500);
    }
}