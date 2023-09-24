import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        //1. 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获取链接
        String url = "jdbc:mysql://127.0.0.1:3306/emp";
        String username = "root";
        String password = "20040304";
        Connection conn = DriverManager.getConnection(url, username, password);
        //3. 定义sql
        String sql = "update employee set age = 20 where id = 3";
        //4. 获取执行sql的对象Statement
        Statement stmt = conn.createStatement();
        //5. 执行sql
        int count = stmt.executeUpdate(sql);//受影响行数
        //6. 处理结果
        System.out.println(count);
        //7.  释放资源
        stmt.close();
        conn.close();
    }
}