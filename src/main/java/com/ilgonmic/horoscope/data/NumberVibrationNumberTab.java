package com.ilgonmic.horoscope.data;

public enum NumberVibrationNumberTab implements NamedEnum {
    WORLD("Мир"),
    ASPIRATIONS("Устремления"),
    SPIRIT("Душа");

    private final String name;

    NumberVibrationNumberTab(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
