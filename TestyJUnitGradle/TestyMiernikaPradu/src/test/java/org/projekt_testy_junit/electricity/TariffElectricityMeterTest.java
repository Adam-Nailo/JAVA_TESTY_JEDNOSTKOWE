package org.projekt_testy_junit.electricity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Created by Adam Seweryn
 */
public class TariffElectricityMeterTest {

    ElectricityMeter electricityMeter;

    @BeforeEach
    void setUp() {
        electricityMeter = new ElectricityMeter();
        electricityMeter.setTariffOn(true);
        electricityMeter.setElectricityTariffStartHour(12);
        electricityMeter.setElectricityTariffEndHour(14);
    }

    @Test
    public void GivenOnTariffWhenKwhAdditionThenCounterTariffIsIncreased() {
//        Given
        // todo setTariff Time mock isTariffNow() !
//        When
        electricityMeter.addKwh(100);
//        Then
        Assertions.assertEquals(100, electricityMeter.getKWhTariff(),0.01);
    }

    @Test
    public void GivenNotOnTariffWhenKwhAdditionThenCounterIsIncreased() {
//        Given
        // todo setTariff Time mock isTariffNow() NOT TARIFF!
//        When
        electricityMeter.addKwh(100);
//        Then
        Assertions.assertEquals(100, electricityMeter.getKWh(),0.01);
    }
}
