import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
 
//https://www.cnblogs.com/winkey4986/p/5622758.html
//http://blog.onlycatch.com/post/%E5%B9%BF%E6%92%AD%EF%BC%88broadcast-%EF%BC%8C%E7%BB%84%E6%92%AD-multicast-%EF%BC%8C%E5%8D%95%E6%92%AD-unicast-%E7%9A%84Java%E5%AE%9E%E7%8E%B0
//服务端
public class BroadcastReceive
{
    public static void main(String[] args) throws IOException
    {
 
        DatagramPacket receive = new DatagramPacket(new byte[1024], 1024);
        DatagramSocket server = new DatagramSocket(8888);
 
        System.out.println("---------------------------------");
        System.out.println("Server current start......");
        System.out.println("---------------------------------");
 
        while (true)
        {
            server.receive(receive);
 
            byte[] recvByte = Arrays.copyOfRange(receive.getData(), 0,
                    receive.getLength());
 
            System.out.println("Server receive msg:" + new String(recvByte));
        }
 
    }
}