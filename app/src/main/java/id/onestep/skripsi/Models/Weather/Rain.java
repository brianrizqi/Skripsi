package id.onestep.skripsi.Models.Weather;

import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("UnitType")
    private int unitType;

    @SerializedName("Value")
    private double value;

    @SerializedName("Unit")
    private String unit;

    public void setUnitType(int unitType) {
        this.unitType = unitType;
    }

    public int getUnitType() {
        return unitType;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return
                "Rain{" +
                        "unitType = '" + unitType + '\'' +
                        ",value = '" + value + '\'' +
                        ",unit = '" + unit + '\'' +
                        "}";
    }
}