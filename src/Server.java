import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        //Tao con ket noi
        int serverPort = 1234;
        //Ket noi den Client
        ServerSocket serverSocket = new ServerSocket(1234);
        System.out.println( "sever da ket noi o cong: " + serverPort);
        Socket socket = serverSocket.accept();
        System.out.println( "Da ket noi thanh cong");
        //InputStream de nhan du lieu tu client
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int byteRead = inputStream.read(buffer);
        String inputNumberFromClient = new String(buffer, 0 , byteRead);
        //Hien thi so nhap vao tu Clien
        System.out.println("So duoc nhap tu clien:" + inputNumberFromClient);

        //Tao tham so number
        double number = Double.parseDouble(inputNumberFromClient);
        //Tao OutputStream de gui ket qua sang Client
        OutputStream outputStream = socket.getOutputStream();
        //Ep kieu de chuyen Double sang String
        String answer = Double.toString(calculator(calculator(number)));
        outputStream.write(answer.getBytes());
        System.out.println("Du lieu da duoc gui");

        socket.close();

    }
    //Phuong thuc de tinh toan
    private static  double calculator(double number){

        return  Math.PI * Math.pow(number,2);
    }

}
