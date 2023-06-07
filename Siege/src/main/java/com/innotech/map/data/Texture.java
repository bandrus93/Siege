package com.innotech.map.data;

import java.util.Comparator;

public class Texture {
    private byte byteValue;
    private int weight;
    private double seedValue;
    private int seedRadius;

    public Texture() {}

    public byte getByteValue() {
        return byteValue;
    }

    public void setByteValue(byte byteValue) {
        this.byteValue = byteValue;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getSeedValue() {
        return seedValue;
    }

    public void setSeedValue(double seedValue) {
        this.seedValue = seedValue;
    }

    public int getSeedRadius() {
        return seedRadius;
    }

    public void setSeedRadius(int seedRadius) {
        this.seedRadius = seedRadius;
    }
}
