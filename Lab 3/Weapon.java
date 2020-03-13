package com.lab3;

public class Weapon implements Item {
    private WeaponType type;
    private int weight;
    private int value;

    public Weapon(WeaponType type, int weight, int value) {
        this.type = type;
        this.weight = weight;
        this.value = value;
    }

    public void setWeaponType(WeaponType type) {
        this.type = type;
    }

    public WeaponType getWeaponType() {
        return type;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public  String getName() {
        return type.name();
    }

    @Override
    public String toString() {
        StringBuilder obj = new StringBuilder();
        obj.append(getName()).append(", ").append("weight = ").append(weight).append(", ").append("value = ").append(getValue());
        return obj.toString();
    }
}
