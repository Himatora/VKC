package view.Stats;

import view.StatsTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SaveRes {
    public static final String PATH_TO_DB_FILE="VCC.db";

    public static final String URL = "jdbc:sqlite:" + PATH_TO_DB_FILE;
    // Установить соединение с базой данных
    static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public SaveRes() throws SQLException {
    }
    public static void add(String type, float result){
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO stats('type','result')" +"VALUES(?,?);");
            statement.setObject(1, type);
            String resultStr=result+"%";
            statement.setObject(2, resultStr);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<StatsTable> getAllStats() throws SQLException {
        Statement statement = connection.createStatement();
        List<StatsTable> list = new ArrayList<StatsTable>();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM stats");
        while (resultSet.next()) {
            list.add(new StatsTable(resultSet.getInt("id"),resultSet.getString("type"), resultSet.getString("result")));
        }
        resultSet.close();
        statement.close();
        return list;
    }
}
