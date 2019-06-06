package biosensews.utils;

public interface IMySQL {

    final String USER = "root";

    final String PASSWORD = "";

    final String URL = "jdbc:mysql://localhost:3306/"
            + "biosense"
            + "?useTimezone=true&serverTimezone=UTC&useSSL=false";

    final String DRIVER = "com.mysql.cj.jdbc.Driver";
}
