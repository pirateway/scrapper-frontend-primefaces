package com.pirateway.scrapper.frontend.primefaces.util;

public class ElementsPath {
    public static final String FORK_TYPE = ".//td[1]/a[3]/img"; // - вид спорта
    public static final String FORK_AGE = ".//td[1]/div/a"; // - возраст вилки

    public static final String PROFIT_PERCENT = ".//td[2]/nobr"; // - процент дохода с вилки

    public static final String EVENT_ONE_BK_NAME = ".//td[3]/div[1]"; // - бк 1 события
    public static final String EVENT_TWO_BK_NAME = ".//td[3]/div[2]"; // - бк 2 события

    public static final String EVENT_ONE_DESCRIPTION_PART_ONE = ".//td[4]/div[1]"; // -  1 половина 1 события
    public static final String EVENT_ONE_DESCRIPTION_PART_TWO = ".//td[4]/small[1]"; // - 2 половина 1 события

    public static final String EVENT_TWO_DESCRIPTION_PART_ONE = ".//td[4]/div[2]"; // -  1 половина 2 события
    public static final String EVENT_TWO_DESCRIPTION_PART_TWO = ".//td[4]/small[2]"; // - 2 половина 2 события

    public static final String EVENT_ONE_LINK = ".//td[5]/nobr[1]/a"; // - ссылка на 1 событие

    public static final String EVENT_TWO_LINK = ".//td[5]/nobr[2]/a"; // - ссылка на 2 событие


    public static final String EVENT_ONE_MOVING = ".//td[6]/nobr[1]/a/img"; // - движение коэффициента 1 события
    public static final String EVENT_ONE_COEFFICIENT = ".//td[6]/nobr[1]";// - значение коэффициента 1 события
    public static final String EVENT_ONE_FORKS_COUNT=".//td[6]/nobr[1]/a/sub/span";// - показатель в скольких вилках учавствует 1 событие

    public static final String EVENT_TWO_MOVING = ".//td[6]/nobr[2]/a/img"; // - движение коэффициента 2 события
    public static final String EVENT_TWO_COEFFICIENT = ".//td[6]/nobr[2]";// - значение коэффициента 2 события
    public static final String EVENT_TWO_FORKS_COUNT=".//td[6]/nobr[2]/a/sub/span";// - показатель в скольких вилках учавствует 2 событие
}
