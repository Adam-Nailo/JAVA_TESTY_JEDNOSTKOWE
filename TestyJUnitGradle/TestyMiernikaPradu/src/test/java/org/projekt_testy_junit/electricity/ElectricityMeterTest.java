package org.projekt_testy_junit.electricity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Adam Seweryn
 */
class ElectricityMeterTest {

    @Test
    void addKwh() {
        ElectricityMeter electricityMeter = new ElectricityMeter();
        electricityMeter.addKwh(1);
        Assertions.assertTrue(electricityMeter.getKWh() == 1);
    }
}