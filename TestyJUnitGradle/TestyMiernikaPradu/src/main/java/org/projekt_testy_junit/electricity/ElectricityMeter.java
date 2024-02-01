package org.projekt_testy_junit.electricity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

/**
 * Created by Adam Seweryn
 */

public class ElectricityMeter {

    @Getter
    private float kWh = 0;

    @Setter(AccessLevel.PACKAGE)
    private int centsForKwh = 0;

    @Setter(AccessLevel.PACKAGE)
    private boolean tariffOn = false;
    private float kWhTariff = 0;

    @Setter(AccessLevel.PACKAGE)
    private int centsForKwhTariff = 0;

    @Setter(AccessLevel.PACKAGE)
    private int electricityTariffStartHour = 0;

    @Setter(AccessLevel.PACKAGE)
    private int electricityTariffEndHour = 0;

    public void addKwh(float kWhToAdd) {
        if (isTariffNow()) {
            kWhTariff += kWhToAdd;
        } else {
            kWh += kWhToAdd;
        }
    }

    private boolean isTariffNow() {
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR_OF_DAY);
        return hour > electricityTariffStartHour && hour < electricityTariffEndHour;
    }

    public int getHowMuchMoreExpensiveNormalIs() {
        return (centsForKwh * 100 / centsForKwhTariff) - 100;
    }

    public void reset() {
        this.kWh = 0;
        this.centsForKwh = 0;
        this.tariffOn = false;
        this.kWhTariff = 0;
        this.centsForKwhTariff = 0;
        this.electricityTariffStartHour = 0;
        this.electricityTariffEndHour = 0;
    }
}
