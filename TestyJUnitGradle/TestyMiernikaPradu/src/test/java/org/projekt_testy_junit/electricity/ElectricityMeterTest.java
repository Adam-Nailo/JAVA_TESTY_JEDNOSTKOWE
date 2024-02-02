package org.projekt_testy_junit.electricity;

import org.junit.jupiter.api.*;
import org.mockito.Mock;

/**
 * Created by Adam Seweryn
 */
class ElectricityMeterTest {

    static ElectricityMeter electricityMeter;

    @BeforeAll
    static void init() {
        electricityMeter = new ElectricityMeter();
    }

    @BeforeEach
    void setUp() {
        electricityMeter.reset();

    }

    @AfterAll
    public static void release() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void addKwh_newMeter_properAddition() {
        electricityMeter.addKwh(1);
        Assertions.assertTrue(electricityMeter.getKWh() == 1);
    }

    @Disabled("Not implemented yet")
    @Test
    void addKwh_newMeter2_properAddition() {
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(3);
        Assertions.assertTrue(electricityMeter.getKWh() == 5);
    }

    @Test
    void addKwh_newMeter5_properAddition() {
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(4);
        electricityMeter.addKwh(4);
        electricityMeter.addKwh(4);
        electricityMeter.addKwh(4);
        Assertions.assertTrue(electricityMeter.getKWh() == 17);
    }

    @Test
    void kwhCounterIncreaseIfNew() {
        electricityMeter.addKwh(1);
        Assertions.assertTrue(electricityMeter.getKWh() == 1);
    }

    @Test
    void givenNewMeterWhenFirstAdditionThenProperCounter() {
//        Given/Arrange
        ElectricityMeter electricityMeter = new ElectricityMeter();
//        When/Act
        electricityMeter.addKwh(1);
//        Then/Assert
        Assertions.assertTrue(electricityMeter.getKWh() == 1);
    }

    @Test
    void getHowMuchMoreExpensiveNormalIs() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            ElectricityMeter electricityMeter = new ElectricityMeter();
            electricityMeter.setCentsForKwh(90);
            electricityMeter.getHowMuchMoreExpensiveNormalIs();
        });
    }
}