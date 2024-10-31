package ru.senla.logic.impl;

import ru.senla.logic.Currency;
import ru.senla.logic.Exchange;

import java.util.LinkedHashMap;
import java.util.Map;

public class EURExchange extends Exchange {

    public EURExchange(double count, Map<Currency, Double> exchangeMap) {
        super(Currency.EUR, count, exchangeMap);
    }

    public EURExchange(double count) {
        super(Currency.EUR, count);
    }

    public EURExchange() {
        super();
    }

    @Override
    public Map<Currency, Double> initExchangeMap() {
        Map<Currency, Double> exchangeMap = new LinkedHashMap<>();
        exchangeMap.put(Currency.RUB, 105.22);
        exchangeMap.put(Currency.USD, 1.09);
        exchangeMap.put(Currency.CNY, 7.74);
        exchangeMap.put(Currency.TYR, 37.25);

        return exchangeMap;
    }
}
