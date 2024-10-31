package ru.senla;

import ru.senla.logic.ui.MainFrame;

import javax.swing.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//
//        Map<Currency, Double> exchangeMap = new HashMap<>();
//        exchangeMap.put(Currency.USD, 10.0);
//        exchangeMap.put(Currency.EUR, 100.0);
//        exchangeMap.put(Currency.CNY, 1000.0);
//        exchangeMap.put(Currency.TRY, 10000.0);
//        RUBExchange rub = new RUBExchange(10, exchangeMap);
//
//        System.out.println(rub.calculateCurrencyTransfer());
//
//        RUBExchange rub2 = new RUBExchange(10);
//        System.out.println(rub2.calculateCurrencyTransfer());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
}
