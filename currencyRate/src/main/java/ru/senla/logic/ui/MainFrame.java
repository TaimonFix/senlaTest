package ru.senla.logic.ui;

import ru.senla.logic.Currency;
import ru.senla.logic.Exchange;
import ru.senla.logic.impl.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MainFrame {

    private JPanel jPanel;
    private JComboBox comboBox1;
    private JTextField textFieldSum;
    private JTextField jCurrencyCount1;
    private JTextField jCurrencyCount2;
    private JTextField jCurrencyCount3;
    private JTextField jCurrencyCount4;
    private JLabel jCurrencyName1;
    private JLabel jCurrencyName2;
    private JLabel jCurrencyName3;
    private JLabel jCurrencyName4;
    private JButton runButton;
    private JButton saveButton;
    private String activeCurrency = "RUB";
    private Exchange exchange;
    private Map<Currency, Double> exchangeMap;

    JLabel[] labels = {jCurrencyName1, jCurrencyName2, jCurrencyName3, jCurrencyName4};
    JTextField[] fields = {jCurrencyCount1, jCurrencyCount2, jCurrencyCount3, jCurrencyCount4};

    public MainFrame() {
        JFrame jFrame = new JFrame("Курс валют");
        jFrame.setSize(380, 500);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.add(jPanel);
        jFrame.setResizable(false);

        addCurrenciesToComboBox();
        addCurrenciesToPanelCurrency();

        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox comboBox = (JComboBox) e.getSource();
                String item = (String) comboBox.getSelectedItem();
                System.out.println(item);
                activeCurrency = item;
                addCurrenciesToPanelCurrency();
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    for (int i = 0; i < 4; i++) {
                        exchangeMap.put(Currency.valueOf(labels[i].getText()),
                                Double.parseDouble(fields[i].getText()));
                    }
                    System.out.println(exchangeMap);
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(jPanel,
                            "Все поля должны быть заполнены в следующем формате '12.65' ");
                }
            }
        });

        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    exchange.setCount(Double.parseDouble(textFieldSum.getText()));
                    Map<Currency, Double> currencyTransferMap = exchange.calculateCurrencyTransfer();
                    System.out.println(currencyTransferMap);

                    String result = "Валюта: " + activeCurrency + "\nКоличество: " + textFieldSum.getText() +
                            "\nРезультат: \n";
                    for (Currency currency: currencyTransferMap.keySet()) {
                        System.out.println(currency);
                       result += currency.toString() +": " +
                               currencyTransferMap.get(currency) + "\n";
                    }
                    JOptionPane.showMessageDialog(jPanel, result);
                } catch (NumberFormatException exception) {
                    System.out.println();
                    JOptionPane.showMessageDialog(jPanel,
                            "Неверно введённое число.\nВведите в следующем формате '12.65' ");
                }
            }
        });
    }

    public void addCurrenciesToComboBox() {
        Currency[] currencies = Currency.values();

        for (Currency currency: currencies) {
            comboBox1.addItem(currency.toString());
        }
    }

    public void addCurrenciesToPanelCurrency() {
        exchange = selectExchange();
        fillCurrencyFields();
    }

    private Exchange selectExchange() {
        switch (activeCurrency) {
            case "RUB":
                exchange = new RUBExchange();
                break;
            case "USD":
                exchange = new USDExchange();
                break;
            case "EUR":
                exchange = new EURExchange();
                break;
            case "CNY":
                exchange = new CNYExchange();
                break;
            case "TYR":
                exchange = new TYRExchange();
                break;
            default:
                exchange = null;
        }
        return exchange;
    }

    private void fillCurrencyFields() {
        int i = 0;
        exchangeMap = exchange.getExchangeMap();
        for (Currency currency: exchangeMap.keySet()) {
            labels[i].setText(currency.toString());
            fields[i].setText(String.valueOf(exchange.getExchangeMap().get(currency)));
            i++;
        }
    }
}
