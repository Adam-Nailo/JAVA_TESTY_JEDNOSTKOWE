package org.projekt_testy_junit.electricity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.mockito.Mockito;

/**
 * Created by Adam Seweryn
 */
public class ElectricityMeterRepeatedTest {
    static ElectricityMeter electricityMeter;
    static TariffProvider tp;

    @BeforeAll
    static void init() {
        tp = Mockito.mock(TariffProvider.class);
        electricityMeter = new ElectricityMeter(tp);
        electricityMeter.setTariffOn(true);
    }
    @RepeatedTest(85)
    public void givenMuchAdditionsWhenAdditionThenNoTariffChange(RepetitionInfo repetitionInfo){
//        Given/Arrange
        Mockito.when(tp.isTariffNow()).thenReturn(false);
//        When/Act
        electricityMeter.addKwh(50);
//        Then/Assert
        Assertions.assertEquals(repetitionInfo.getCurrentRepetition()*50, electricityMeter.getKWh());
    }
}
