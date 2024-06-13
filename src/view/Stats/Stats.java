package view.Stats;

import view.MainWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Stats extends JFrame {
    private StatsTableModel statsTableModel;
    private JButton menu;
    private JTable stats;

    public Stats() throws SQLException {
        super("Статистика");
        setMinimumSize(new Dimension(800, 500));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        init();
    }

    private void init() throws SQLException {
        stats = new JTable();
        statsTableModel = new StatsTableModel(SaveRes.getAllStats());
        menu = new JButton("Главное меню");
        stats.setModel(statsTableModel);

        Container contentPane = this.getContentPane();
        contentPane.setBackground(new Color(240, 78, 83));
        contentPane.add(new JScrollPane(stats), BorderLayout.CENTER);
        contentPane.add(menu, BorderLayout.SOUTH);

        menu.setBackground(new Color(240, 78, 83));
        menu.setFont(new Font("Arial", Font.BOLD, 20));
        menu.setForeground(Color.WHITE);

        stats.setBackground(new Color(240, 78, 83));
        stats.setFont(new Font("Arial", Font.BOLD, 20));
        stats.setForeground(Color.WHITE);
        stats.getTableHeader().setBackground(new Color(240, 78, 83));
        stats.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
        stats.getTableHeader().setForeground(Color.WHITE);
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            new MainWindow();
            setVisible(false);
            }
        });
        this.pack();
        this.setVisible(true);
    }
}