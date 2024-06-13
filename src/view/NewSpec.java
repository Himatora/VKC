package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Map;

public class NewSpec extends JFrame {
    Boolean flag=true;
    Boolean chose=true;
    private JPanel product;
    private JPanel task;
    private JCheckBox vcd;
    private JCheckBox dc;
    private JCheckBox pza;
    private JCheckBox pzn;
    private JCheckBox dcO;
    private JCheckBox pzaO;
    private JCheckBox pznO;
    private JCheckBox halva;
    private JCheckBox halva0;
    private JCheckBox debetH;
    private JLabel inf;
    private JLabel scoreL;
    private JButton check;
    private JButton next;
    private JPanel manage;
    private JButton exit;
    private Timer timer;


    public NewSpec(String type,int number,int score, Map<String, Integer> res) throws SQLException {
        super("Тренажёр для "+type+" сотрудников ВКЦ");
        setMinimumSize(new Dimension(800, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        init(type,number,score,res);
    }
    private void init(String type,int number, int score ,Map<String, Integer> res) throws SQLException {
        task=new JPanel();
        GeneratePerson generatePerson=new GeneratePerson();
        Person person=new Person(generatePerson.getGender(),generatePerson.getName(),generatePerson.getMiddlename(),generatePerson.getLastname(),generatePerson.getRegistration(),generatePerson.getRegion(),generatePerson.getTerm(),generatePerson.getAge(),generatePerson.getDisability(),generatePerson.getEmployments(),generatePerson.getTypeEmployments(),generatePerson.getWorkExperience(),generatePerson.getCity());
        String html="<html><p style=\"white-space: normal;\">"+String.valueOf(number)+"  Клиент "+person.getLastName()+" "+person.getName()+" "+person.getFatherName()+" из г. "+person.getCity()+".Возраст: "+person.getAge()+". Работает "+ person.getEmployment()+" "+person.getTypeEmployment()+" " + person.getWorkExperience()+" месяца. Регистрация "+person.getRegistration()+" в "+ person.getRegion()+". Срок регистрации "+ person.getTerm()+" месяца. Инвалидность: "+ person.getDisability()+"."+"</p></html>";
        exit=new JButton("Выйти");
        inf=new JLabel(html);
        inf.setPreferredSize(new Dimension(800,100));
        manage=new JPanel();
        scoreL=new JLabel("Счёт:  "+String.valueOf(score));
        scoreL.setHorizontalAlignment(SwingConstants.CENTER);
        scoreL.setVerticalAlignment(SwingConstants.CENTER);
        task.add(inf,BorderLayout.CENTER);
        manage.add(scoreL,BorderLayout.CENTER);
        manage.add(exit,BorderLayout.EAST);
        task.add(manage,BorderLayout.WEST);

        product =new JPanel();
        vcd=new JCheckBox("Виртуальный кредитный доктор");
        dc=new JCheckBox("Беззалоговый денежный кредит");
        pzn=new JCheckBox("Под залог недвижимости");
        pza=new JCheckBox("Под залог авто");
        dcO=new JCheckBox("Беззалоговый денежный кредит офис");
        pznO=new JCheckBox("Под залог недвижимости офис");
        pzaO=new JCheckBox("Под залог авто офис");
        debetH=new JCheckBox("Дебетовая карта халва");
        halva=new JCheckBox("Карта рассрочки халва без лимита");
        halva0=new JCheckBox("Халва");
        product.setLayout(new GridLayout(6,2));
        product.add(vcd);
        product.add(dc);
        product.add(pzn);
        product.add(pza);
        product.add(dcO);
        product.add(pznO);
        product.add(pzaO);
        product.add(debetH);
        product.add(halva);
        product.add(halva0);
        vcd.setBackground(new Color(33, 64, 154));
        dc.setBackground(new Color(33, 64, 154));
        pzn.setBackground(new Color(33, 64, 154));
        pza.setBackground(new Color(33, 64, 154));
        dcO.setBackground(new Color(33, 64, 154));
        pznO.setBackground(new Color(33, 64, 154));
        pzaO.setBackground(new Color(33, 64, 154));
        debetH.setBackground(new Color(33, 64, 154));
        halva.setBackground(new Color(33, 64, 154));
        halva0.setBackground(new Color(33, 64, 154));
        vcd.setFont(new Font("Arial", Font.BOLD, 16));
        dc.setFont(new Font("Arial", Font.BOLD, 16));
        pzn.setFont(new Font("Arial", Font.BOLD, 16));
        pza.setFont(new Font("Arial", Font.BOLD, 16));
        dcO.setFont(new Font("Arial", Font.BOLD, 16));
        pznO.setFont(new Font("Arial", Font.BOLD, 16));
        pzaO.setFont(new Font("Arial", Font.BOLD, 16));
        debetH.setFont(new Font("Arial", Font.BOLD, 16));
        halva.setFont(new Font("Arial", Font.BOLD, 16));
        halva0.setFont(new Font("Arial", Font.BOLD, 16));
        vcd.setForeground(Color.WHITE);
        dc.setForeground(Color.WHITE);
        pzn.setForeground(Color.WHITE);
        pza.setForeground(Color.WHITE);
        dcO.setForeground(Color.WHITE);
        pznO.setForeground(Color.WHITE);
        pzaO.setForeground(Color.WHITE);
        debetH.setForeground(Color.WHITE);
        halva.setForeground(Color.WHITE);
        halva0.setForeground(Color.WHITE);

        next=new JButton("Дальше");
        check=new JButton("Проверить");
        product.add(check);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(flag){
                    new Analysis(res,number-1,score,type);
                }
                else {
                    new Analysis(res,number,score,type);
                }
                // Создание и отображение диаграммы

            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=false;
                product.remove(check);
                product.add(next);
                product.revalidate();
                product.repaint();
            }
        });

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if(chose){
                        new NewSpec(type,number+1,score+1,res);
                    }
                    else {
                        new NewSpec(type,number+1,score,res);
                    }
                    setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    ChooseProduct chooseProduct = new ChooseProduct();
                    Map<String, Integer> map=chooseProduct.checkRegistrationAndDisabilities(vcd,person);
                    map.putAll(chooseProduct.checkRegistrationAndDisabilities(dc,person));
                    map.putAll(chooseProduct.checkRegistrationAndDisabilities(pzn,person));
                    map.putAll(chooseProduct.checkRegistrationAndDisabilities(pza,person));
                    map.putAll(chooseProduct.checkRegistrationAndDisabilities(dcO,person));
                    map.putAll(chooseProduct.checkRegistrationAndDisabilities(pznO,person));
                    map.putAll(chooseProduct.checkRegistrationAndDisabilities(pzaO,person));
                    map.putAll(chooseProduct.checkRegistrationAndDisabilities(halva,person));
                    map.putAll(chooseProduct.checkRegistrationAndDisabilities(halva0,person));
                    map.putAll(chooseProduct.checkRegistrationAndDisabilities(debetH,person));
                    if(!map.isEmpty()){
                        for (Map.Entry<String, Integer> entry : map.entrySet()) {
                            String key = entry.getKey();
                            int value = entry.getValue();
                            if(value==2){
                                res.put(key,res.get(key)+1);
                            }
                        }
                    }
                    if(!res.isEmpty()){
                        for (Map.Entry<String, Integer> entry : res.entrySet()) {
                            String key = entry.getKey();
                            int value = entry.getValue();
                            System.out.println(key+" "+value);
                        }
                    }
                    if(vcd.getBackground()==Color.red||dc.getBackground()==Color.red||pzn.getBackground()==Color.red||pza.getBackground()==Color.red||dcO.getBackground()==Color.red||pznO.getBackground()==Color.red||pzaO.getBackground()==Color.red || halva.getBackground()==Color.red||halva0.getBackground()==Color.red||debetH.getBackground()==Color.red)
                    {
                        chose=false;
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        if(type=="опытных"){
            JLabel timerLabel = new JLabel("20 sec");
            timerLabel.setForeground(Color.WHITE);
            timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
            timerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            timerLabel.setVerticalAlignment(SwingConstants.CENTER);
            product.add(timerLabel);
            timer = new Timer(20000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    check.doClick();
                    timer.stop(); // остановить таймер
                    product.remove(timerLabel);
                    product.revalidate();
                    product.repaint();
                }
            });
            timer.start();
            Timer updateTimer = new Timer(1000, new ActionListener() {
                int remainingSeconds = 20;

                @Override
                public void actionPerformed(ActionEvent e) {
                    remainingSeconds--;
                    timerLabel.setText(remainingSeconds + " sec");

                    if (remainingSeconds == 0) {
                        ((Timer) e.getSource()).stop(); // остановить таймер обновления
                    }
                }
            });
            updateTimer.start();
            check.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    product.remove(timerLabel);
                }
            });
        }
        this.getContentPane().setBackground(new Color(33, 64, 154));
        task.setBackground(new Color(33, 64, 154));
        product.setBackground(new Color(33, 64, 154));
        manage.setBackground(new Color(33, 64, 154));
        // Устанавливаем цвет кнопок
        exit.setBackground(new Color(240, 78, 83));
        next.setBackground(new Color(240, 78, 83));
        check.setBackground(new Color(240, 78, 83));

        // Устанавливаем белый цвет шрифта для кнопок
        exit.setForeground(Color.WHITE);
        next.setForeground(Color.WHITE);

        check.setForeground(Color.WHITE);
        inf.setForeground(Color.WHITE);
        manage.setForeground(Color.WHITE);
        scoreL.setForeground(Color.WHITE);
        inf.setFont(new Font("Arial", Font.BOLD, 16));
        manage.setFont(new Font("Arial", Font.BOLD, 16));
        scoreL.setFont(new Font("Arial", Font.BOLD, 16));
        // Устанавливаем шрифт для кнопок

        exit.setFont(new Font("Arial", Font.BOLD, 20));
        next.setFont(new Font("Arial", Font.BOLD, 20));
        check.setFont(new Font("Arial", Font.BOLD, 20));

        this.add(task,BorderLayout.NORTH);
        this.add(product);


        this.pack();
        this.setVisible(true);
    }
}
