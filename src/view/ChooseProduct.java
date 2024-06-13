package view;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ChooseProduct {
    public static final String PATH_TO_DB_FILE="VCC.db";
    public static final String URL = "jdbc:sqlite:" + PATH_TO_DB_FILE;
    // Установить соединение с базой данных
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ChooseProduct() throws SQLException {
    }
    private int checkingStr(ResultSet resultSet, String name, JCheckBox checkbox, String currCond) throws SQLException {
        int Green=0;
        while (resultSet.next()) {
            String productName = resultSet.getString("product");  // Имя продукта
            String condition = resultSet.getString(name);

            if (Objects.equals(checkbox.getText(), productName) && Objects.equals(condition, currCond)) {
                if (checkbox.isSelected()) {
                    Green = 1;
                    break;
                }else{
                    Green=2;
                }
            }
            else{
                if(checkbox.isSelected()){
                    Green=2;

                }
            }
        }
        return Green;
    }
    private int checkingTerm(ResultSet resultSet, String name, JCheckBox checkbox, String currCond, String secondCond) throws SQLException {
        int Green=0;
        while (resultSet.next()) {
            String productName = resultSet.getString("product");  // Имя продукта
            String condition = resultSet.getString(name);
            String employment = resultSet.getString("employ_id");
            String res;
            String res2 = "";
            if(Integer.parseInt(currCond)>=4){
                res="больше";
            }
            else {
                res="меньше";
            }
            switch (Integer.parseInt(employment)){
                case 1:
                    res2="официально";
                    break;
                case 2:
                    res2="неофициально";
                    break;
                case 3:
                    res2="не работаю";
                    break;
            }
            if (Objects.equals(checkbox.getText(), productName) && Objects.equals(condition, res) && Objects.equals(res2,secondCond)) {
                if (checkbox.isSelected()) {
                    Green = 1;
                    break;
                }else{
                    Green=2;
                }
            }
            else{
                if(checkbox.isSelected()){
                    Green=2;

                }
            }
        }
        return Green;
    }
    private int checkingAge(ResultSet resultSet, String name, JCheckBox checkbox, String currCond) throws SQLException {
        int Green=0;
        while (resultSet.next()) {
            String productName = resultSet.getString("product");  // Имя продукта
            String condition = resultSet.getString(name);
            String res = "";
            if(Integer.parseInt(currCond)>=20){
                res="20";
            }
            else if(Integer.parseInt(currCond)>=18) {
                res="18";
            }
            else if(Integer.parseInt(currCond)>=14){
                res="14";
            }
            if (Objects.equals(checkbox.getText(), productName) && Objects.equals(condition, res)) {
                if (checkbox.isSelected()) {
                    Green = 1;
                    break;
                }else{
                    Green=2;
                }
            }
            else{
                if(checkbox.isSelected()){
                    Green=2;

                }
            }
        }
        return Green;
    }
    public Map<String, Integer> checkRegistrationAndDisabilities(JCheckBox checkbox, Person person) throws SQLException {
        Statement registrationStatement = connection.createStatement();
        ResultSet registrationRs = registrationStatement.executeQuery("SELECT * FROM registration_cond");

        Statement disabilitiesStatement = connection.createStatement();
        ResultSet disabilitiesRs = disabilitiesStatement.executeQuery("SELECT * FROM disabilities_cond");

        Statement employmentsStatement = connection.createStatement();
        ResultSet employmentsRs = employmentsStatement.executeQuery("SELECT * FROM employments_cond");

        Statement typeEmployStatement = connection.createStatement();
        ResultSet typeEmploymentsRs = typeEmployStatement.executeQuery("SELECT * FROM type_cond");

        Statement termStatement = connection.createStatement();
        ResultSet termEmploymentsRs = termStatement.executeQuery("SELECT * FROM terms_cond");

        Statement ageStatement = connection.createStatement();
        ResultSet ageEmploymentsRs = ageStatement.executeQuery("SELECT * FROM ages_cond");

        int registrationGreen= checkingStr(registrationRs,"registration",checkbox,person.getRegistration());
        int disabilitiesGreen= checkingStr(disabilitiesRs,"disability",checkbox, person.getDisability());
        int employmentsGreen= checkingStr(employmentsRs,"employment",checkbox,person.getEmployment());
        int typeEmployGreen= checkingStr(typeEmploymentsRs,"type_employments",checkbox,person.getTypeEmployment());
        int workExperience=checkingTerm(termEmploymentsRs,"value",checkbox,person.getWorkExperience(),person.getEmployment());
        int age=checkingAge(ageEmploymentsRs,"age",checkbox, person.getAge());
        Map<String, Integer> errors = new HashMap<>();
        if (registrationGreen==1 && disabilitiesGreen==1 && employmentsGreen==1 && typeEmployGreen==1 && workExperience==1 && age==1) {
            checkbox.setBackground(Color.GREEN);
        }
        else if(!(disabilitiesGreen==0 || registrationGreen==0||employmentsGreen==0 || typeEmployGreen==0 || workExperience==0 || age==0)){
            checkbox.setBackground(Color.RED);
                errors.put("registration", registrationGreen);
                errors.put("disabilities", disabilitiesGreen);
                errors.put("employments", employmentsGreen);
                errors.put("type_employments", typeEmployGreen);
                errors.put("work_experience", workExperience);
                errors.put("age", age);
        }
        registrationStatement.close();
        disabilitiesStatement.close();
        employmentsStatement.close();
        termStatement.close();
        typeEmployStatement.close();
        ageStatement.close();
        return errors;

    }

}