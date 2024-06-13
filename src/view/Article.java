package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Article extends JFrame {
    private JButton dc;
    private JButton dco;
    private JButton halva;
    private JButton halva0;
    private JButton halvad;
    private JButton vcd;
    private JPanel material;
    public Article() {
        super("Информация о продуктах");
        setMinimumSize(new Dimension(800, 500));
        setLocationRelativeTo(null);
        init();
    }

    private void init() {
        dc=new JButton("Денежный кредит");
        dco=new JButton("Денежный кредит в офисе");
        halva=new JButton("Халва");
        halva0=new JButton("Халва 0,1");
        halvad=new JButton("Дебетовая халва");
        vcd=new JButton("Виртуальный кредитный доктор");
        material=new JPanel(new GridLayout(3,2));
        dc.setFont(new Font("Arial", Font.BOLD, 20));
        dco.setFont(new Font("Arial", Font.BOLD, 20));
        halva.setFont(new Font("Arial", Font.BOLD, 20));
        halva0.setFont(new Font("Arial", Font.BOLD, 20));
        halvad.setFont(new Font("Arial", Font.BOLD, 20));
        vcd.setFont(new Font("Arial", Font.BOLD, 20));
        dc.setBackground(new Color(240, 78, 83));
        dco.setBackground(new Color(240, 78, 83));
        halva.setBackground(new Color(240, 78, 83));
        halva0.setBackground(new Color(240, 78, 83));
        halvad.setBackground(new Color(240, 78, 83));
        vcd.setBackground(new Color(240, 78, 83));
        dc.setForeground(Color.WHITE);
        dco.setForeground(Color.WHITE);
        halva.setForeground(Color.WHITE);
        halvad.setForeground(Color.WHITE);
        halva0.setForeground(Color.WHITE);
        vcd.setForeground(Color.WHITE);
        this.setBackground(new Color(33, 64, 154));
        material.setBackground(new Color(33, 64, 154));
        dc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label=new JLabel("<html><p style=\"white-space: normal;\">Регистрация: постоянная <br> Трудоустройство: не важно <br> Стаж работы: при официальном любой, при неофициальном >= 4 <br> Возраст: старше 18, кроме под залог недвижимости старше 20 <br> Работодатель: при официальном любой, при неофициальном на организацию, на ип, если на себя, то только под залог недвижимости, если на самозанятого ничего. Инвалидность: 2 и 3 группа</p></html>");
              new Material(label);
            }
        });
        dco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label=new JLabel("<html><p style=\"white-space: normal;\">Регистрация: постоянная <br> Трудоустройство: официальное <br> Стаж работы: >= 4 <br> Возраст: старше 18, кроме под залог недвижимости старше 20 <br> Работодатель: любой. Инвалидность: 1, 2 и 3 группа</p></html>");
                new Material(label);
            }
        });
        halva.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label=new JLabel("<html><p style=\"white-space: normal;\">Регистрация: постоянная <br> Трудоустройство: официальное <br> Стаж работы: >= 4 <br> Возраст: старше 18<br> Работодатель: любой. Инвалидность: 1, 2 и 3 группа</p></html>");
                new Material(label);
            }
        });
        halva0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label=new JLabel("<html><p style=\"white-space: normal;\">Регистрация: временная/постоянная <br> Трудоустройство: не важно <br> Стаж работы: не важно <br> Возраст: старше 18<br> Работодатель: любой. Инвалидность: 1, 2 и 3 группа</p></html>");
                new Material(label);
            }
        });
        halvad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label=new JLabel("<html><p style=\"white-space: normal;\">Регистрация: нет/временная/постоянная <br> Трудоустройство: не важно <br> Стаж работы: не важно <br> Возраст: старше 14<br> Работодатель: любой. Инвалидность: 1, 2 и 3 группа</p></html>");
                new Material(label);
            }
        });
        vcd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label=new JLabel("<html><p style=\"white-space: normal;\">Регистрация: постоянная <br> Трудоустройство: официальное <br> Стаж работы: >= 4 <br> Возраст: старше 18<br> Работодатель: любой. Инвалидность: 2 и 3 группа</p></html>");
                new Material(label);
            }
        });
        material.add(dc);
        material.add(dco);
        material.add(halva);
        material.add(halva0);
        material.add(halvad);
        material.add(vcd);
        this.add(material);
        this.setVisible(true);
    }
}
