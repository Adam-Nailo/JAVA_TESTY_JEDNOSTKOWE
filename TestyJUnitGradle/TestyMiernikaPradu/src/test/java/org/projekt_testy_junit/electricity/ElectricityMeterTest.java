package org.projekt_testy_junit.electricity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Adam Seweryn
 */
class ElectricityMeterTest {

    @Test
    void addKwh_newMeter_properAddition() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        Assertions.assertTrue(electricityMeter.getKWh() == 1);
    }

    @Test
    void addKwh_newMeter2_properAddition() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(4);
        Assertions.assertTrue(electricityMeter.getKWh() == 5);
    }

    @Test
    void addKwh_newMeter5_properAddition() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        electricityMeter.addKwh(4);
        electricityMeter.addKwh(4);
        electricityMeter.addKwh(4);
        electricityMeter.addKwh(4);
        Assertions.assertTrue(electricityMeter.getKWh() == 17);
    }

    @Test
    void kwhCounterIncreaseIfNew() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        Assertions.assertTrue(electricityMeter.getKWh() == 1);
    }

    @Test
    void givenNewMeterWhenFirstAdditionThenProperCounter() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
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