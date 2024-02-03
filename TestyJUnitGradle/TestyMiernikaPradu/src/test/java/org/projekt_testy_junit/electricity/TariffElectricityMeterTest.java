package org.projekt_testy_junit.electricity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

/**
 * Created by Adam Seweryn
 */
public class TariffElectricityMeterTest {

    ElectricityMeter electricityMeter;

    TariffProvider tp;
    @BeforeEach
    void setUp() {
        tp = Mockito.mock(TariffProvider.class);
        electricityMeter = new ElectricityMeter(tp);
        electricityMeter.setTariffOn(true);
        electricityMeter.setElectricityTariffStartHour(12);
        electricityMeter.setElectricityTariffEndHour(14);
    }

    @Test
    public void GivenOnTariffWhenKwhAdditionThenCounterTariffIsIncreased() {
//        Given
        Mockito.when(tp.isTariffNow()).thenReturn(true);
//        When
        electricityMeter.addKwh(100);
//        Then
        Assertions.assertEquals(100, electricityMeter.getKWhTariff(),0.01);
    }

    @Test
    public void GivenNotOnTariffWhenKwhAdditionThenCounterIsIncreased() {
//        Given
        Mockito.when(tp.isTariffNow()).thenReturn(false);
//        When
        electricityMeter.addKwh(100);
//        Then
        Assertions.assertEquals(100, electricityMeter.getKWh(),0.01);
    }
}
