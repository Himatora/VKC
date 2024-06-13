package view;

import java.sql.*;
import java.util.Random;

public class GeneratePerson {
    public static final String PATH_TO_DB_FILE="VCC.db";
    public static final String URL = "jdbc:sqlite:" + PATH_TO_DB_FILE;
            // Установить соединение с базой данных
            Connection connection = DriverManager.getConnection(URL);
    public GeneratePerson() throws SQLException {
    }

    int genderIdG=0;
    int typeIdG=0;
    public int getGender() throws SQLException {
            Statement statement = connection.createStatement();
            ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM genders");
            int max=idResultSet.getInt(1);
            int genderId = randomId(max);
            genderIdG=genderId;
            idResultSet.close();
            statement.close();
            return genderId;
    }
    public String getName() throws SQLException {
        Statement statement = connection.createStatement();
//        ResultSet idResultSet = statement.executeQuery("SELECT name FROM genders where id=" + genderIdG);
//        String gender=idResultSet.getString(1);
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM first_name where gender_id="+genderIdG);
        int max=idResultSet.getInt(1);
        int nameId = randomId(max);
        int id[]=new int[max];
        ResultSet resultSet = statement.executeQuery("SELECT id FROM first_name where gender_id="+genderIdG);
        {
            int i=0;
            while (resultSet.next()) {
                id[i]= Integer.parseInt(resultSet.getString("id"));
                i++;
            }
        }

        idResultSet = statement.executeQuery("SELECT name FROM first_name where id="+id[nameId-1]);
        String name=idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return name;
    }
    public String getMiddlename() throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM middle_names");
        int max=idResultSet.getInt(1);
        int middleNameId = randomId(max);
        idResultSet = statement.executeQuery("SELECT name FROM middle_names where id="+middleNameId);
        String middlename=idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return middlename;
    }
    public String getLastname() throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM last_names");
        int max=idResultSet.getInt(1);
        int lastNameId = randomId(max);
        idResultSet = statement.executeQuery("SELECT name FROM last_names where id="+lastNameId);
        String lastname=idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return lastname;
    }
    public String getRegistration() throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM registrations");
        int max=idResultSet.getInt(1);

        int registrationId = randomIdProb(max, new int[]{80, 10, 10});
        idResultSet = statement.executeQuery("SELECT registration FROM registrations where id="+registrationId);
        String registration=idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return registration;
    }
    public String getRegion() throws SQLException{
        Statement statement = connection.createStatement();
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM regions");
        int max=idResultSet.getInt(1);
        int regionId = randomId(max);
        idResultSet = statement.executeQuery("SELECT region FROM regions where id="+regionId);
        String region=idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return region;
    }
    public String getTerm() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM terms");
        int max = idResultSet.getInt(1);
        int termId = randomId(max);
        idResultSet = statement.executeQuery("SELECT term FROM terms where id=" + termId);
        String term = idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return term;
    }
    public String getAge() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM ages");
        int max=idResultSet.getInt(1);
        int ageId = randomId(max);
        idResultSet = statement.executeQuery("SELECT age FROM ages where id="+ageId);
        String age=idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return age;
    }
    public String getDisability() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM disabilities");
        int max=idResultSet.getInt(1);
        int disabilityId = randomId(max);
        idResultSet = statement.executeQuery("SELECT disability FROM disabilities where id="+disabilityId);
        String disability=idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return disability;
    }


    public String getEmployments() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM employments");
        int max=idResultSet.getInt(1);
        int employmentId = randomIdProb(max, new int[]{40, 40, 20});
        typeIdG=employmentId;
        idResultSet = statement.executeQuery("SELECT employment FROM employments where id=" + employmentId);
        String employment=idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return employment;
    }
    public String getTypeEmployments() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM type_employments where employment_id=" + typeIdG);
        int max=idResultSet.getInt(1);
        int employmentTypeId = randomId(max);
        int[] id_type =new int[max];
        ResultSet resulSet = statement.executeQuery("SELECT id FROM type_employments where employment_id="+typeIdG);
        {
            int i=0;
            while (resulSet.next()) {
                id_type[i]= Integer.parseInt(resulSet.getString("id"));
                i++;
            }
        }
        idResultSet = statement.executeQuery("SELECT type_employment FROM type_employments where id="+id_type[employmentTypeId-1]);
        String typeEmployment=idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return typeEmployment;
    }
    public String getWorkExperience() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM work_experiences");
        int max=idResultSet.getInt(1);
        int workExperienceId = randomId(max);
        idResultSet = statement.executeQuery("SELECT work_experience FROM work_experiences where id="+workExperienceId);
        String workExperience=idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return workExperience;
    }
    public String getCity() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet idResultSet = statement.executeQuery("SELECT COUNT(*) FROM cities");
        int max=idResultSet.getInt(1);
        int cityId = randomId(max);
        idResultSet = statement.executeQuery("SELECT city FROM cities where id="+cityId);
        String city=idResultSet.getString(1);
        idResultSet.close();
        statement.close();
        return city;
    }
    private static int randomIdProb(int max,int[] probabilities) throws SQLException {
        // Настройте вероятности выпадения чисел здесь


        // Создайте генератор псевдослучайных чисел с настроенными вероятностями
        Random random = new Random();
        int randomIndex = random.nextInt(100); // Диапазон значений от 0 до 99

        int probabilitySum = 0;
        for (int i = 0; i < probabilities.length; i++) {
            probabilitySum += probabilities[i];
            if (randomIndex < probabilitySum) {
                return i + 1;
            }
        }

        // Если ни одно из условий вероятности не выполнено, верните max
        return max;
    }

    private static int randomId(int max) throws SQLException {
        int min = 1;
        return min + (int)(Math.random() * (max - min + 1));
    }
}