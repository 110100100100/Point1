import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        //Ket noi den server
        int serverPort = 1234;
        String IPAddress = "localhost";
        Socket socket = new Socket(IPAddress, serverPort);
        //Scanner de nhap du lieu. O day la nhap ban kinh
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ban kinh: " );
        Double radius = scanner.nextDouble();
        //Gui du lieu sang cho Server
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(Double.toString(radius).getBytes());
        System.out.println("Da gui so ve cho server thanh cong");

        //Nhan ket qua tu Server
        InputStream inputStream = socket.getInputStream();
        byte[] buffer = new byte[1024];
        int byteRead = inputStream.read(buffer);
       // Vi de nhan duoc ket qua thi du lieu do phai o dang Byte
       // nen de hien thi duoc ket qua phai chuyen sang dang String

        String inputNumberFromServer = new String(buffer, 0 , byteRead);

        System.out.println("Dien tich hinh tron la: " + inputNumberFromServer );

        socket.close();

    }
}
