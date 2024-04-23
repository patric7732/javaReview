//package review.networkTest;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.HashSet;
//import java.util.Set;
//
//public class ChatServer {
//    private static final int PORT = 9999;
//    private static Set<PrintWriter> allClients = new HashSet<>();
//
//    public static void main(String[] args) throws Exception {
//        System.out.println(" 채팅 서버 시작 ");
//        ServerSocket serverSocket = new ServerSocket(PORT);
//
//        try {
//            while(true){
//                new Handler(serverSocket.accept()).start();
//            }
//        } finally {
//        }
//    }
//}
//
//
