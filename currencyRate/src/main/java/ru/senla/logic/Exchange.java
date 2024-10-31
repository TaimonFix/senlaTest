package ru.senla.logic;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class Exchange {
    private Currency name;
    private double count;
    protected Map<Currency, Double> exchangeMap;

    public Exchange(Currency name, double count, Map<Currency, Double> exchangeMap) {
        this.name = name;
        this.count = count;
        this.exchangeMap = exchangeMap;
    }

    public Exchange(Currency name, double count) {
        this.name = name;
        this.count = count;
        this.exchangeMap = initExchangeMap();
    }

    public Exchange() {
        this.exchangeMap = initExchangeMap();
    }

     public abstract Map<Currency, Double> initExchangeMap();

    public Map<Currency, Double> calculateCurrencyTransfer() {
        Map<Currency, Double> currencyTransferMap = new LinkedHashMap<>();

        for (Currency cur : exchangeMap.keySet()) {
            currencyTransferMap.put(cur, exchangeMap.get(cur) * count);
        }

        return currencyTransferMap;
    }

    public Currency getName() {
        return name;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public Map<Currency, Double> getExchangeMap() {
        return exchangeMap;
    }

    public void setExchangeMap(Map<Currency, Double> exchangeMap) {
        this.exchangeMap = exchangeMap;
    }
}
