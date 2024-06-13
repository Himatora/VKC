package view;

import view.Stats.Stats;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class MainWindow extends JFrame {
    private JPanel menu;
    private JButton newSpec;
    private JButton experSpec;
    private JButton stats;
    private JButton article;
    private Label menuName;
    private Map<String, Integer> res;
    public MainWindow(){
        super("Тренажёр для сотрудников ВКЦ");
        setMinimumSize(new Dimension(800, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
    }
    private void init(){

        newSpec=new JButton("Я новичок");
        experSpec=new JButton("Я опытный");
        stats=new JButton("Статистика");
        article=new JButton("Материалы");
        menuName=new Label("Главное меню");
        menuName.setAlignment(Label.CENTER);
        menuName.setFont(new Font("Arial", Font.BOLD, 24));
        newSpec.setFont(new Font("Arial", Font.BOLD, 20));
        experSpec.setFont(new Font("Arial", Font.BOLD, 20));
        stats.setFont(new Font("Arial", Font.BOLD, 20));
        article.setFont(new Font("Arial", Font.BOLD, 20));
        res= HashMap.newHashMap(6);
        res.put("registration", 0);
        res.put("disabilities", 0);
        res.put("employments", 0);
        res.put("type_employments", 0);
        res.put("work_experience",0);
        res.put("age", 0);
        // Устанавливаем цвет фона
        this.getContentPane().setBackground(new Color(33, 64, 154));
        // Устанавливаем цвет кнопок
        newSpec.setBackground(new Color(240, 78, 83));
        experSpec.setBackground(new Color(240, 78, 83));
        stats.setBackground(new Color(240, 78, 83));
        article.setBackground(new Color(240, 78, 83));
        // Устанавливаем белый цвет шрифта для кнопок
        newSpec.setForeground(Color.WHITE);
        experSpec.setForeground(Color.WHITE);
        stats.setForeground(Color.WHITE);
        article.setForeground(Color.WHITE);
        menuName.setForeground(Color.WHITE);
        menu=new JPanel();
        menu.setBackground(new Color(33, 64, 154));
        menu.setLayout(new GridLayout(4,1));
        menu.add(newSpec);
        menu.add(experSpec);
        menu.add(stats);
        menu.add(article);
        menu.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        newSpec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new NewSpec("новых",1,0,res);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
            }
        });
        experSpec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new NewSpec("опытных",1,0,res);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
            }
        });
        stats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    new Stats();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                setVisible(false);
            }
        });
        article.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Article();
            }
        });
        this.add(menuName, BorderLayout.NORTH);
        this.add(menu);


        this.pack();
        this.setVisible(true);
    }

}
