package by.astapchik;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Less19 {

    public static void main(String[] args) {

        Thread thread = new MyClient("BankThread");
        thread.start();
    }

    static class MyClient extends Thread {
        public MyClient(String name) {
            super(name);
        }

        @Override
        public void run() {
            String url = "jdbc:mysql://localhost:3306/bank";
            String user = "root";
            String password = "root";
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                System.out.println("База данных успешно подключена!");
                File file = new File("ВankСlient.txt");
                FileWriter fileWriter = new FileWriter(file);
                Statement statement = conn.createStatement();
                ResultSet rs = statement.executeQuery("select * from bank_client ");
                while (rs.next()) {
                    String str = String.format("id: %d,first_name:%s,last_name:%s,birth_date:%s\n",
                            rs.getLong(1), rs.getString(2),
                            rs.getString(3), rs.getDate(4));
                    fileWriter.write(str);
                }
                rs.close();
                fileWriter.close();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}