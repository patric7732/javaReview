//package review.networkTest.day2.chatTest;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ChatServerTest {
//    public static void main(String[] args) {
//        try {
//            ServerSocket serverSocket = new ServerSocket(9999);
//            System.out.println("서버가 성공적으로 실행되었습니다.");
//            Map<String, PrintWriter> chatClients = new HashMap<>();
//            while(true){
//                Socket socket = serverSocket.accept();
//                new ChatThread(socket, chatClients).start();
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
//
//class ChatThread extends Thread{
//    private Socket socket;
//    private String id;
//    private Map<String, PrintWriter> chatClients;
//
//    BufferedReader in = null;
//    PrintWriter out = null;
//
//    public ChatThread(Socket socket, Map<String, PrintWriter> chatClients){
//        this.socket = socket;
//        this.chatClients = chatClients;
//
//        try{
//            out = new PrintWriter(socket.getOutputStream(), true);
//            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            id = in.readLine();
//
//            broadcast(id + "님이 입장하셨습니다.");
//            System.out.println("새로운 사용자의 아이디는 " + id + "입니다.");
//
//        }catch (Exception e){
//            System.out.println(e);
//        }
//    }
//}