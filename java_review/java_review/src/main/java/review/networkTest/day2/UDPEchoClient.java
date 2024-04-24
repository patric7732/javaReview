package review.networkTest.day2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPEchoClient {
        public static void main(String[] args) throws Exception {
                // 클라이언트에서 사용할 DatagramSocket 생성
                DatagramSocket clientSocket = new DatagramSocket();

                // 서버의 IP 주소 및 포트 설정
                InetAddress IPAddress = InetAddress.getByName("localhost");
                byte[] sendData;
                byte[] receiveData = new byte[1024];

                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter a message: ");
                String message = scanner.nextLine();
                scanner.close();

                // 서버로 데이터 보내기
                sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
                clientSocket.send(sendPacket);

                // 서버로부터 응답 받기
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String modifiedMessage = new String(receivePacket.getData()).trim();
                System.out.println("FROM SERVER: " + modifiedMessage);

                // 소켓 종료
                clientSocket.close();
        }
}
