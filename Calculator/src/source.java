import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Font.PLAIN;
import static javax.swing.JOptionPane.showMessageDialog;

public class source {
    JFrame frame;
    JPanel panel;
    JTextField result;
    JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9;
    JButton sumar, restar, multi, div, igual, c;
    JMenuBar mVar;
    JMenu options, about;
    JMenuItem info, exit;
    Font font;
    String appendNumbers = "", operacion = null;
    double resultNumber, actualNumber;
    boolean activate = false;

    public source() {
        initFrame();
        initPanel();
        initComponents();
        eventsManagement();
        frame.setVisible(true);
    }

    private void initFrame() {
        frame = new JFrame();
        frame.setTitle("Calculator v1.1.0");
        frame.setBounds(300, 300, 290, 360);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(50, 50, 50));
        frame.getContentPane().add(panel);
    }

    private void initComponents() {
        mVar = new JMenuBar();
        frame.setJMenuBar(mVar);
        options = new JMenu("Options");
        about = new JMenu("About");
        mVar.add(options);
        mVar.add(about);
        info = new JMenuItem("Info");
        exit = new JMenuItem("Exit");
        options.add(exit);
        about.add(info);

        result = new JTextField("0");
        font = new Font("MONOSPACED", PLAIN, 30);
        result.setBounds(12, 30, 250, 40);
        result.setFont(font);
        result.setHorizontalAlignment(SwingConstants.RIGHT);
        result.setBackground(new Color(15, 15, 15));
        result.setForeground(new Color(255, 0, 0));
        result.setEditable(false);

        b1 = new JButton("1");
        b1.setBounds(12, 100, 60, 40);
        b1.setFont(font);
        b1.setBackground(new Color(30, 30, 30));
        b1.setForeground(new Color(255, 255, 255));
        b1.setFocusPainted(false);
        b2 = new JButton("2");
        b2.setBounds(75, 100, 60, 40);
        b2.setFont(font);
        b2.setBackground(new Color(30, 30, 30));
        b2.setForeground(new Color(255, 255, 255));
        b2.setFocusPainted(false);
        b3 = new JButton("3");
        b3.setBounds(138, 100, 60, 40);
        b3.setFont(font);
        b3.setBackground(new Color(30, 30, 30));
        b3.setForeground(new Color(255, 255, 255));
        b3.setFocusPainted(false);
        b4 = new JButton("4");
        b4.setBounds(12, 143, 60, 40);
        b4.setFont(font);
        b4.setBackground(new Color(30, 30, 30));
        b4.setForeground(new Color(255, 255, 255));
        b4.setFocusPainted(false);
        b5 = new JButton("5");
        b5.setBounds(75, 143, 60, 40);
        b5.setFont(font);
        b5.setBackground(new Color(30, 30, 30));
        b5.setForeground(new Color(255, 255, 255));
        b5.setFocusPainted(false);
        b6 = new JButton("6");
        b6.setBounds(138, 143, 60, 40);
        b6.setFont(font);
        b6.setBackground(new Color(30, 30, 30));
        b6.setForeground(new Color(255, 255, 255));
        b6.setFocusPainted(false);
        b7 = new JButton("7");
        b7.setBounds(12, 186, 60, 40);
        b7.setFont(font);
        b7.setBackground(new Color(30, 30, 30));
        b7.setForeground(new Color(255, 255, 255));
        b7.setFocusPainted(false);
        b8 = new JButton("8");
        b8.setBounds(75, 186, 60, 40);
        b8.setFont(font);
        b8.setBackground(new Color(30, 30, 30));
        b8.setForeground(new Color(255, 255, 255));
        b8.setFocusPainted(false);
        b9 = new JButton("9");
        b9.setBounds(138, 186, 60, 40);
        b9.setFont(font);
        b9.setBackground(new Color(30, 30, 30));
        b9.setForeground(new Color(255, 255, 255));
        b9.setFocusPainted(false);
        b0 = new JButton("0");
        b0.setBounds(75, 229, 60, 40);
        b0.setFont(font);
        b0.setBackground(new Color(30, 30, 30));
        b0.setForeground(new Color(255, 255, 255));
        b0.setFocusPainted(false);
        sumar = new JButton("+");
        sumar.setBounds(201, 100, 60, 40);
        sumar.setFont(font);
        sumar.setBackground(new Color(30, 30, 30));
        sumar.setForeground(new Color(255, 255, 255));
        sumar.setFocusPainted(false);
        restar = new JButton("-");
        restar.setBounds(201, 143, 60, 40);
        restar.setFont(font);
        restar.setBackground(new Color(30, 30, 30));
        restar.setForeground(new Color(255, 255, 255));
        restar.setFocusPainted(false);
        multi = new JButton("x");
        multi.setBounds(201, 186, 60, 40);
        multi.setFont(font);
        multi.setBackground(new Color(30, 30, 30));
        multi.setForeground(new Color(255, 255, 255));
        multi.setFocusPainted(false);
        div = new JButton("/");
        div.setBounds(201, 229, 60, 40);
        div.setFont(font);
        div.setBackground(new Color(30, 30, 30));
        div.setForeground(new Color(255, 255, 255));
        div.setFocusPainted(false);
        igual = new JButton("=");
        igual.setBounds(138, 229, 60, 40);
        igual.setFont(font);
        igual.setBackground(new Color(30, 30, 30));
        igual.setForeground(new Color(255, 255, 255));
        igual.setFocusPainted(false);
        c = new JButton("c");
        c.setBounds(12, 229, 60, 40);
        c.setFont(font);
        c.setBackground(new Color(30, 30, 30));
        c.setForeground(new Color(255, 255, 255));
        c.setFocusPainted(false);

        panel.add(result);
        panel.add(b1); panel.add(b2); panel.add(b3); panel.add(b4); panel.add(b5);
        panel.add(b6); panel.add(b7); panel.add(b8); panel.add(b9); panel.add(b0);
        panel.add(sumar); panel.add(restar); panel.add(div); panel.add(multi);
        panel.add(igual); panel.add(c);
    }

    private void eventsManagement() {
        Events events = new Events();
        b1.addActionListener(events);
        b2.addActionListener(events);
        b3.addActionListener(events);
        b4.addActionListener(events);
        b5.addActionListener(events);
        b6.addActionListener(events);
        b7.addActionListener(events);
        b8.addActionListener(events);
        b9.addActionListener(events);
        b0.addActionListener(events);
        c.addActionListener(events);
        sumar.addActionListener(events);
        restar.addActionListener(events);
        multi.addActionListener(events);
        div.addActionListener(events);
        igual.addActionListener(events);
        info.addActionListener(events);
        exit.addActionListener(events);
    }

    private void putButtons(ActionEvent e) {
        if (e.getSource()==b1) {
            appendNumbers += "1";
        }
        if (e.getSource()==b2) {
            appendNumbers += "2";
        }
        if (e.getSource()==b3) {
            appendNumbers += "3";
        }
        if (e.getSource()==b4) {
            appendNumbers += "4";
        }
        if (e.getSource()==b5) {
            appendNumbers += "5";
        }
        if (e.getSource()==b6) {
            appendNumbers += "6";
        }
        if (e.getSource()==b7) {
            appendNumbers += "7";
        }
        if (e.getSource()==b8) {
            appendNumbers += "8";
        }
        if (e.getSource()==b9) {
            appendNumbers += "9";
        }
        if (e.getSource() == b0) {
            if (Integer.parseInt(result.getText()) > 0) {
                appendNumbers += "0";
            }
        }
        if (appendNumbers.length() > 0 && !appendNumbers.equalsIgnoreCase("0")) {
            activate = true;
            result.setText(appendNumbers);
        }
    }

    private void sumarButton(ActionEvent e) {
        if (e.getSource() == sumar) {
            if (activate) {
                actualNumber = Double.parseDouble(appendNumbers);
                appendNumbers = "";
                operacion = "sumar";
                activate = false;
            }
        }
    }

    private void restarButton(ActionEvent e) {
        if (e.getSource() == restar) {
            if (activate) {
                actualNumber = Double.parseDouble(appendNumbers);
                appendNumbers = "";
                operacion = "restar";
                activate = false;
            }
        }
    }

    private void multiplicarButton(ActionEvent e) {
        if (e.getSource() == multi) {
            if (activate) {
                actualNumber = Double.parseDouble(appendNumbers);
                appendNumbers = "";
                operacion = "multiplicar";
                activate = false;
            }
        }
    }

    private void dividirButton(ActionEvent e) {
        if (e.getSource() == div) {
            if (activate) {
                actualNumber = Double.parseDouble(appendNumbers);
                appendNumbers = "";
                operacion = "dividir";
                activate = false;
            }
        }
    }

    private void igualButton(ActionEvent e) {
        if (e.getSource() == igual) {
            if (activate) {
                double secondNumber;
                if (operacion.equalsIgnoreCase("sumar")) {
                    secondNumber = Double.parseDouble(appendNumbers);
                    resultNumber = actualNumber + secondNumber;
                    result.setText(resultNumber + "");
                    appendNumbers = String.valueOf(resultNumber);
                    operacion = null;
                }
                else if (operacion.equalsIgnoreCase("restar")) {
                    secondNumber = Double.parseDouble(appendNumbers);
                    resultNumber = actualNumber - secondNumber;
                    result.setText(resultNumber + "");
                    appendNumbers = String.valueOf(resultNumber);
                    operacion = null;
                }
                else if (operacion.equalsIgnoreCase("multiplicar")) {
                    secondNumber = Double.parseDouble(appendNumbers);
                    resultNumber = actualNumber * secondNumber;
                    result.setText(resultNumber + "");
                    appendNumbers = String.valueOf(resultNumber);
                    operacion = null;
                }
                else if (operacion.equalsIgnoreCase("dividir")) {
                    secondNumber = Double.parseDouble(appendNumbers);
                    resultNumber = actualNumber / secondNumber;
                    result.setText(resultNumber + "");
                    appendNumbers = String.valueOf(resultNumber);
                    operacion = null;
                }
                activate = true;
            }
        }
    }

    private void cButton(ActionEvent e) {
        if (e.getSource() == c) {
            actualNumber = 0;
            appendNumbers = "";
            result.setText("0");
            activate = false;
        }
    }

    private void info(ActionEvent e) {
        if (e.getSource() == info) {
            showMessageDialog(null, "Author: Bl4ckV - 2022\nDeveloped in: Java");
        }
    }

    private void exit(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
    }

    private class Events implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                putButtons(e);
                sumarButton(e);
                restarButton(e);
                multiplicarButton(e);
                dividirButton(e);
                igualButton(e);
                cButton(e);
                info(e);
                exit(e);
            }
            catch (Exception ex) {
                result.setText("Error");
            }
        }
    }

    public static void main(String[] args) {
        source calculator = new source();
    }
}
