package view;

import view.Stats.SaveRes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class Analysis extends JFrame {
    private JButton save_res;
    private JButton exit;
    private JButton registration;
    private JButton disabilities;
    private JButton employments;
    private JButton type_employments;
    private JButton work_experience;
    private JButton age;
    private JPanel material;
    private JPanel manage;
    private JLabel label;
    public Analysis(Map<String, Integer> res, int all, int score,String type) {
        super("Результат");
        setMinimumSize(new Dimension(800, 500));
        setLocationRelativeTo(null);
        init(res,all,score,type);
    }
    private void init(Map<String, Integer> res, int all, int score,String type) {
        label=new JLabel("Всего клиентов: "+all);
        save_res=new JButton("Сохранить результат и выйти");
        exit=new JButton("Выйти без сохранения");
        registration=new JButton("Регистрация");
        disabilities=new JButton("Инвалидность");
        employments=new JButton("Тип трудоустройства");
        type_employments=new JButton("Работодатель");
        work_experience=new JButton("Опыт работы");
        age=new JButton("Возраст");
        label.setBackground(new Color(33, 64, 154));
        label.setFont(new Font("Arial", Font.BOLD, 20));
        save_res.setFont(new Font("Arial", Font.BOLD, 20));
        exit.setFont(new Font("Arial", Font.BOLD, 20));
        registration.setFont(new Font("Arial", Font.BOLD, 20));
        disabilities.setFont(new Font("Arial", Font.BOLD, 20));
        employments.setFont(new Font("Arial", Font.BOLD, 20));
        type_employments.setFont(new Font("Arial", Font.BOLD, 20));
        work_experience.setFont(new Font("Arial", Font.BOLD, 20));
        age.setFont(new Font("Arial", Font.BOLD, 20));
        save_res.setBackground(new Color(240, 78, 83));
        exit.setBackground(new Color(240, 78, 83));
        registration.setBackground(new Color(240, 78, 83));
        disabilities.setBackground(new Color(240, 78, 83));
        employments.setBackground(new Color(240, 78, 83));
        type_employments.setBackground(new Color(240, 78, 83));
        work_experience.setBackground(new Color(240, 78, 83));
        age.setBackground(new Color(240, 78, 83));
        label.setForeground(Color.WHITE);
        save_res.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
        registration.setForeground(Color.WHITE);
        disabilities.setForeground(Color.WHITE);
        employments.setForeground(Color.WHITE);
        type_employments.setForeground(Color.WHITE);
        work_experience.setForeground(Color.WHITE);
        age.setForeground(Color.WHITE);
        material=new JPanel(new GridLayout(2,3));
        manage=new JPanel();
        material.setBackground(new Color(33, 64, 154));
        manage.setBackground(new Color(33, 64, 154));
        manage.add(label);
        manage.add(save_res,BorderLayout.WEST);
        manage.add(exit,BorderLayout.EAST);
        this.getContentPane().setBackground(new Color(33, 64, 154));
        if(!res.isEmpty()){
            for (Map.Entry<String, Integer> entry : res.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();
                if(value>0){
                    switch (key) {
                        case "registration":
                            material.add(registration);
                            break;
                        case "disabilities":
                           material.add(disabilities);
                            break;
                        case "employments":
                            material.add(employments);
                            break;
                        case "type_employments":
                            material.add(type_employments);
                            break;
                        case "work_experience":
                            material.add(work_experience);
                            break;
                        case "age":
                            material.add(age);
                            break;
                    }
                }
            }
        }
        registration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label1=new JLabel("<html><p style=\"white-space: normal;\">Для халвы, виртуального кредитного доктора, денежного кредита дистанционно и в офисе необходимо иметь постоянную регистрацию. Для халвы 0,1 необходимо иметь либо постоянную, либо временную прописку. Для дебетовой халвы можно иметь постоянную, временную регистрацию или же в целом не иметь её</p></html>");
                new Material(label1);
            }
        });
        disabilities.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label1=new JLabel("<html><p style=\"white-space: normal;\">Для инвалидов 1 группы доступны только офисные продукты: халва, халва 0,1, дебетовая халва и денежный кредит в офисе. Для остальных групп инвалидности доступны все продукты.</p></html>");
                new Material(label1);
            }
        });
        employments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label1=new JLabel("<html><p style=\"white-space: normal;\">Для официально трудоустроенных доступны все продукты банка. Для трудоустроенных неофициально нет доступных продуктов в офисе: денежный кредит, халва. Также не доступен виртуальный кредитный доктор. Доступны халва 0,1, дебетовая халва и денежный кредит дистанционно.</p></html>");
                new Material(label1);
            }
        });
        type_employments.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label1=new JLabel("<html><p style=\"white-space: normal;\">Если трудоустройство официальное, то доступны все продукты не зависимо от типа. Если неофициальное, то денежный кредит дистанционно доступен для работающих на организацию и ип. Если же клиент работает на себя, то доступно рассмотрение денежного кредит под залог недвижимости. Если работает на самозанятого, то доступна только дебетовая халва и халва 0,1. Также при остальных случаях работодателей эти карты доступны.</p></html>");
                new Material(label1);
            }
        });
        work_experience.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label1=new JLabel("<html><p style=\"white-space: normal;\">При официальном трудоустройстве для обращения в офис или для оформления виртуального кредитного доктора необходимо иметь срок работы более 4 месяцев. Для дистанционного обращения при официальном трудоустройстве срок работы не важен. Если трудоустройство неофициальное, то дистанционное рассмотрение доступно при сроке работы более 4 месяцев. Также при любом сроке доступны халва 0,1 и дебетовая в обоих случаях.</p></html>");
                new Material(label1);
            }
        });
        age.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JLabel label1=new JLabel("<html><p style=\"white-space: normal;\">Если клиенту есть 20 лет ему доступны все продукты. Если клиенту 18 или 19 лет доступны все продукты, кроме денежного кредита под залог недвижимости. Если клиент старше 14 и младше 18, то доступна дебетовая халва.</p></html>");
                new Material(label1);
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Window window : Window.getWindows()){
                    window.dispose();
                }
                new MainWindow();
            }
        });
        save_res.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float result=(float)score/(float)all*100;
                SaveRes.add(type,result);
                for(Window window : Window.getWindows()){
                    window.dispose();
                }
                new MainWindow();
            }
        });
        this.add(new BarChartExample(res,all));
        this.add(material,BorderLayout.SOUTH);
        this.add(manage,BorderLayout.NORTH);
        this.pack();
        this.setVisible(true);
    }
}
