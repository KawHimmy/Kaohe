import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //服务端
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(8080)){    //将服务端创建在端口8080上
            System.out.println("正在等待客户端连接...");
            Socket socket = server.accept();  //当没有客户端连接时，线程会阻塞，直到有客户端连接为止
            System.out.println("客户端已连接，IP地址为："+socket.getInetAddress().getHostAddress());
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));  //通过
            System.out.print("接收到客户端数据：");
            System.out.println(reader.readLine());

            OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            writer.write("已收到！");
            writer.flush();

            socket.close();   //和服务端TCP连接完成之后，记得关闭socket
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}