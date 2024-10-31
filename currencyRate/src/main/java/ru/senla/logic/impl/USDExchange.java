package ru.senla.logic.impl;

import ru.senla.logic.Currency;
import ru.senla.logic.Exchange;

import java.util.LinkedHashMap;
import java.util.Map;

public class USDExchange extends Exchange {

    public USDExchange(double count, Map<Currency, Double> exchangeMap) {
        super(Currency.USD, count, exchangeMap);
    }

    public USDExchange(double count) {
        super(Currency.USD, count);
    }

    public USDExchange() {
        super();
    }

    @Override
    public Map<Currency, Double> initExchangeMap() {
        Map<Currency, Double> exchangeMap = new LinkedHashMap<>();
        exchangeMap.put(Currency.RUB, 97.05);
        exchangeMap.put(Currency.EUR, 0.91945);
        exchangeMap.put(Currency.CNY, 7.12);
        exchangeMap.put(Currency.TRY, 34.25);

        return exchangeMap;
    }
}
