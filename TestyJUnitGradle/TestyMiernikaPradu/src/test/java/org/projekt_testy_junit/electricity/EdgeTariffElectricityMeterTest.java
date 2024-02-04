package org.projekt_testy_junit.electricity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

/**
 * Created by Adam Seweryn
 */
public class EdgeTariffElectricityMeterTest {

    static ElectricityMeter electricityMeter;
    static TariffProvider tp;

    @BeforeAll
    static void init() {
        tp = Mockito.mock(TariffProvider.class);
        electricityMeter = new ElectricityMeter(tp);
        electricityMeter.setTariffOn(true);
    }
    @BeforeEach
    void setUp() {


    }
    @ParameterizedTest
    @MethodSource("inputData")
    public void GivenDependOnTariffWhenKwhAdditionThenSpecificCounterIsIncreased(int kwhUsedInCase, boolean isTariffInCase, float sumKwhInCase, float sumKwhTariffInCase) {
//        Given
        Mockito.when(tp.isTariffNow()).thenReturn(isTariffInCase);
//        When
        electricityMeter.addKwhNotTariff(kwhUsedInCase);
//        Then
        Assumptions.assumeFalse(isTariffInCase);
        Assertions.assertEquals(sumKwhInCase, electricityMeter.getKWh(), 0.01);
    }
    @ParameterizedTest
    @MethodSource("inputData")
    public void GivenDependOnTariffWhenKwhAdditionThenTariffCounterIsIncreased(int kwhUsedInCase, boolean isTariffInCase, float sumKwhInCase, float sumKwhTariffInCase) {
//        Given
        Mockito.when(tp.isTariffNow()).thenReturn(isTariffInCase);
//        When
        electricityMeter.addKwhTariff(kwhUsedInCase);
//        Then
        Assumptions.assumeTrue(isTariffInCase);
        Assertions.assertEquals(sumKwhTariffInCase, electricityMeter.getKWhTariff(), 0.01);
    }

    public static Stream<Arguments> inputData() {
        return Stream.of(
                Arguments.of(100, false, 100, 0),
                Arguments.of(100, false, 200, 0),
                Arguments.of(100, false, 300, 0),
                Arguments.of(100, false, 400, 0),
                Arguments.of(100, false, 500, 0),
                Arguments.of(100, false, 600, 0),
                Arguments.of(100, false, 700, 0),
                Arguments.of(100, false, 800, 0),
                Arguments.of(100, false, 900, 0),
                Arguments.of(100, false, 1000, 0),
                Arguments.of(100, false, 1100, 0),
                Arguments.of(100, false, 1200, 0),
                Arguments.of(150, false, 1350, 0),
                Arguments.of(200, false, 1550, 0),
                Arguments.of(200, false, 1750, 0),
                Arguments.of(400, false, 2150, 0),
                Arguments.of(150, false, 2300, 0),
                Arguments.of(100, false, 2400, 0),
                Arguments.of(100, false, 2500, 0),
                Arguments.of(100, false, 2600, 0),
                Arguments.of(100, false, 2700, 0),
                Arguments.of(100, false, 2800, 0),
                Arguments.of(100, false, 2900, 0),
                Arguments.of(100, false, 3000, 0),
                Arguments.of(100, false, 3100, 0),
                Arguments.of(100, false, 3200, 0),
                Arguments.of(100, true, 3200, 100),
                Arguments.of(100, true, 3200, 200),
                Arguments.of(1800, true, 3200, 2000),
                Arguments.of(2000, true, 3200, 4000),
                Arguments.of(100, false, 3300, 4000),
                Arguments.of(100, false, 3400, 4000),
                Arguments.of(100, false, 3500, 4000),
                Arguments.of(300, false, 3800, 4000),
                Arguments.of(300, false, 4100, 4000),
                Arguments.of(300, false, 4400, 4000),
                Arguments.of(300, false, 4700, 4000),
                Arguments.of(3000, false, 7700, 4000),
                Arguments.of(3200, false, 10900, 4000),
                Arguments.of(3000, false, 13900, 4000),
                Arguments.of(450, false, 14350, 4000),
                Arguments.of(550, false, 14900, 4000),
                Arguments.of(300, false, 15200, 4000),
                Arguments.of(250, false, 15450, 4000),
                Arguments.of(200, false, 15650, 4000),
                Arguments.of(200, false, 15850, 4000),
                Arguments.of(300, false, 16150, 4000),
                Arguments.of(100, false, 16250, 4000),
                Arguments.of(100, false, 16350, 4000)
        );
    }
}