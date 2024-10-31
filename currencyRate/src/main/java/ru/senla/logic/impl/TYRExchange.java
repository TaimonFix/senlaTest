package ru.senla.logic.impl;

import ru.senla.logic.Currency;
import ru.senla.logic.Exchange;

import java.util.LinkedHashMap;
import java.util.Map;

public class TYRExchange extends Exchange {

    public TYRExchange(double count, Map<Currency, Double> exchangeMap) {
        super(Currency.TRY, count, exchangeMap);
    }

    public TYRExchange(double count) {
        super(Currency.TRY, count);
    }

    public TYRExchange() {
        super();
    }

    @Override
    public Map<Currency, Double> initExchangeMap() {
        Map<Currency, Double> exchangeMap = new LinkedHashMap<>();
        exchangeMap.put(Currency.RUB, 2.84);
        exchangeMap.put(Currency.USD, 0.029199);
        exchangeMap.put(Currency.EUR, 0.026847);
        exchangeMap.put(Currency.CNY, 0.207863);

        return exchangeMap;
    }
}
