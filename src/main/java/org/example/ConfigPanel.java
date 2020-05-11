package org.example;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JComboBox<String> type;
    JButton addBtn = new JButton("Add");

    /**
     * intializeaza JPanel-ul
     * @param frame
     */
    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    /**
     * se intializeaza obiectul JComboBox prin care se va face alegerea obiectelor JComponent ce vor fi create
     * se adauga ActionListner la butonul addBtn
     */
    private void init() {
        label = new JLabel("Type:");
        type = new JComboBox<>(new String[]{"JLabel", "JComboBox", "JTextField", "JSpinner", "JButton"});
        add(label);
        add(type);
        add(addBtn);

        addBtn.addActionListener(actionEvent -> {
            try {
                add2();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * se instaltiaza dinamic obiectul
     * se seteaza dimensiunea
     * in fucntie de ce este setat in JComboBox se adauga (dupa ce se face cast la tipul selectat)text sau iteme sau valori
     * se adauga la DrawingPanel
     * se apeleaza revalidate() ca componentele adaugate sa fie vizibile
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    private void add2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class classX = Class.forName("javax.swing." + type.getSelectedItem());
        JComponent element = (JComponent) classX.getDeclaredConstructor().newInstance();
        element.setPreferredSize(new Dimension(90,30));

        if (type.getSelectedItem() == "JLabel") {
            ((JLabel) element).setText("jlabel");
        }
        else if (type.getSelectedItem() == "JComboBox") {
            ((JComboBox) element).addItem("option1");
            ((JComboBox) element).addItem("option2");

        } else if (type.getSelectedItem() == "JTextField") {
            ((JTextField)element).setText("textField");

        } else if (type.getSelectedItem() == "JSpinner") {
            SpinnerModel value = new SpinnerNumberModel(5, 0,10, 1);
            ((JSpinner) element).setModel(value);

        } else if (type.getSelectedItem() == "JButton") {
            ((JButton) element).setText("this is a button");
        }

        this.frame.canvas.add(element);
        revalidate();


    }

}
