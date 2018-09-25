package com.ilgonmic.horoscope.data;

public enum PersonalNumberTab implements NamedEnum {
    DAY("Дня"),
    MONTH("Месяца"),
    YEAR("Года");

    private final String name;

    PersonalNumberTab(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
