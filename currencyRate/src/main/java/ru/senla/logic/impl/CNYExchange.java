package ru.senla.logic.impl;

import ru.senla.logic.Currency;
import ru.senla.logic.Exchange;

import java.util.LinkedHashMap;
import java.util.Map;

public class CNYExchange extends Exchange {

    public CNYExchange(double count, Map<Currency, Double> exchangeMap) {
        super(Currency.CNY, count, exchangeMap);
    }

    public CNYExchange(double count) {
        super(Currency.CNY, count);
    }

    public CNYExchange() {
        super();
    }

    @Override
    public Map<Currency, Double> initExchangeMap() {
        Map<Currency, Double> exchangeMap = new LinkedHashMap<>();
        exchangeMap.put(Currency.RUB, 13.59);
        exchangeMap.put(Currency.USD, 0.140475);
        exchangeMap.put(Currency.EUR, 0.12916);
        exchangeMap.put(Currency.TYR, 4.81);

        return exchangeMap;
    }
}
