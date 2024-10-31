package ru.senla.logic.impl;

import ru.senla.logic.Currency;
import ru.senla.logic.Exchange;

import java.util.LinkedHashMap;
import java.util.Map;

public class RUBExchange extends Exchange {

    public RUBExchange(double count, Map<Currency, Double> exchangeMap) {
        super(Currency.RUB, count, exchangeMap);
    }

    public RUBExchange(double count) {
        super(Currency.RUB, count);
    }

    public RUBExchange() {
        super();
    }

    @Override
    public Map<Currency, Double> initExchangeMap() {
        Map<Currency, Double> exchangeMap = new LinkedHashMap<>();
        exchangeMap.put(Currency.USD, 0.010304);
        exchangeMap.put(Currency.EUR, 0.009477);
        exchangeMap.put(Currency.CNY, 0.073596);
        exchangeMap.put(Currency.TYR, 0.352588);

        return exchangeMap;
    }
}
