package by.astapchik;

import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bank";
        String user = "root";
        String password = "root";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("База данных успешно подключена!");
//            conn.setAutoCommit(false);
//
//              Statement statement=conn.createStatement();
//             statement.execute("insert into `bank_client` values (6,'Kirill','Bach', date ('2020-01-02'))");
//            ResultSet rs = statement.executeQuery("select * from bank_client ");
//            while (rs.next()){
//                System.out.printf("id: %d,first_name:%s,last_name:%s,birth_date:%s\n",
//                        rs.getLong(1),rs.getString(2),
//                       rs.getString(3),rs.getDate(4));
//            }
//            rs.close();


//             statement.executeUpdate("");

            String sql = "select * from bank_client where id= ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, 3);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.printf("id: %d,first_name:%s,last_name:%s,birth_date:%s",
                        rs.getLong(1), rs.getString(2),
                        rs.getString(3), rs.getDate(4));
            }
//            CallableStatement callableStatement= conn.prepareCall("");

//            statement.close();
            preparedStatement.close();
//            callableStatement.close();

        } catch (SQLException e) {
            System.out.println("База данных подключена не успешно!");
            e.printStackTrace();
        }
    }
}
