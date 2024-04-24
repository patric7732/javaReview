package review.networkTest.day2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
public class UDPEchoServer {
    public static void main(String[] args) throws Exception {
// 서버에서 사용할 DatagramSocket 생성 (특정 포트 지정)
        DatagramSocket socket = new DatagramSocket(9876);
        while (true) {
            byte[] receiveData = new byte[1024];
            byte[] sendData;
// 클라이언트로부터 데이터를 받기 위한 DatagramPacket 생성
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            socket.receive(receivePacket);
            String message = new String(receivePacket.getData()).trim();
// 클라이언트 정보
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
// 클라이언트에게 데이터 보내기
            sendData = message.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            socket.send(sendPacket);
        }
    }
}
