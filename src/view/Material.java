package view;

import javax.swing.*;
import java.awt.*;

public class Material extends JFrame {
    public Material(JLabel label){
        super("Материал");
        setSize(500, 500);
        setLocationRelativeTo(null);
        init(label);
    }

    private void init(JLabel label) {

        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setForeground(Color.WHITE);
        label.setPreferredSize(new Dimension(500,150));
        label.setBackground(new Color(33, 64, 154));
        this.getContentPane().setBackground(new Color(33, 64, 154));
        this.add(label);
        this.pack();
        this.setVisible(true);
    }
}
