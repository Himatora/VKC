package view;

import java.awt.*;
import java.util.Map;
import javax.swing.JPanel;

public class BarChartExample extends JPanel {

    private Map<String, Integer> res;
    private int all;
    public BarChartExample(Map<String, Integer> res,int all) {
        this.res = res;
        this.all=all;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("Arial", Font.BOLD, 12));
        this.setBackground(new Color(33, 64, 154));
        // Настройка диаграммы
        int barWidth = 50;
        int barGap = 70;
        int maxValue = all+1;
        int height = getHeight() - 100;
        int width = getWidth();
        int totalBarWidth = barWidth * 6 + barGap * (6 - 1);
        int startX = (width - totalBarWidth) / 2;
        int i = 0;
        String[] color=new String[]{"#98FB98","#00FF7F","#9ACD32","#20B2AA","#87CEFA","#7B68EE"};
        // Отрисовка столбцов
        if (!res.isEmpty()) {
            for (Map.Entry<String, Integer> entry : res.entrySet()) {
                String key = entry.getKey();
                switch (key) {
                    case "registration":
                        key = "Регистрация";
                        break;
                    case "disabilities":
                        key = "Инвалидность";
                        break;
                    case "employments":
                        key = "Тип трудоустройства";
                        break;
                    case "type_employments":
                        key = "Работодатель";
                        break;
                    case "work_experience":
                        key = "Опыт работы";
                        break;
                    case "age":
                        key = "Возраст";
                        break;
                }
                int value = entry.getValue();
                int x = startX + (barWidth + barGap) * i;
                int heightm = (int) (((double) value / maxValue) * height);

                // Устанавливаем высоту столбца в зависимости от его значения
                g2.setColor(Color.decode(color[i]));
                g2.fillRect(x, height - heightm, barWidth, heightm);


                int labelHeight = 20;
                int labelX = x + (barWidth / 2) - (g2.getFontMetrics().stringWidth(key + ": " + value) / 2);
                int labelY = height - heightm - labelHeight;
                g2.setColor(Color.WHITE);
                g2.drawString(key + ": " + value, labelX, labelY);
                i++;
            }
        }
    }


    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 200);
    }
}
