package ru.senla.logic.ui;

import ru.senla.logic.Currency;
import ru.senla.logic.impl.RUBExchange;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame {

    private JPanel jPanel;
    private JComboBox comboBox1;
    private JPanel jPanelSelection;
    private JPanel jPanelCurrency;
    private JPanel JPanelTransfer;
    private JTextField jCurrencyCount;
    private JLabel jCurrencyName;
    private JTextField textFieldSum;
    private JButton buttonRun;
    private String activeCurrency = "RUB";

    public MainFrame() {
        JFrame jFrame = new JFrame("Курс валют");
        jFrame.setSize(300, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        jFrame.add(jPanel);

        addCurrenciesToComboBox();

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




        System.out.println(activeCurrency);

    }

    public void addCurrenciesToComboBox() {
        Currency[] currencies = Currency.values();

        for (Currency currency: currencies) {
            comboBox1.addItem(currency.toString());
        }
    }

    public void addCurrenciesToPanelCurrency() {
        switch (activeCurrency) {
            case "RUB":
                RUBExchange rub = new RUBExchange();

                for (Currency currency: rub.getExchangeMap().keySet()) {
                    jCurrencyName.setText(currency.toString());
                    jCurrencyCount.setText(String.valueOf(rub.getExchangeMap().get(currency)));

                    jPanelCurrency.add(jCurrencyName);
                    jPanelCurrency.add(jCurrencyCount);
                }
        }
        jPanelCurrency.repaint();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }
}
