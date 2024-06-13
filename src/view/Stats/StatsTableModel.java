package view.Stats;

import view.StatsTable;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class StatsTableModel extends AbstractTableModel {
    private List<StatsTable> data;
    public StatsTableModel(List<StatsTable> statsTable){
        data=statsTable;
    }

    @Override
    public int getRowCount() {
        return  data.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StatsTable gr=data.get(rowIndex);
        switch (columnIndex){
            case 0: return gr.getId();
            case 1: return gr.getType();
            case 2:return gr.getResult();
        }
        return "";
    }


    @Override
    public String getColumnName(int column){
        switch (column){
            case 0:return "Номер попытки";
            case 1:return "Тип сотрудника";
            case 2:return "Результат";
        }
        return "";
    }
}
