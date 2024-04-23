//package review.networkTest;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//import java.net.Socket;
//
//private static class Handler extends Thread {
//    private Socket socket;
//    private PrintWriter out;
//    private BufferedReader in;
//
//    public Handler(Socket socket) {
//        this.socket = socket;
//    }
//
//    public void run() {
//        try {
//            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//            out = new PrintWriter(socket.getOutputStream(), true);
//
//            synchronized (allClients) {
//                allClients.add(out);
//            }
//
//            String input;
//            while ((input = in.readLine()) != null) {
//                synchronized (allClients) {
//                    for (PrintWriter writer : allClients) {
//                        writer.println(input);
//                    }
//                }
//            }
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            if (out != null) {
//                synchronized (allClients) {
//                    allClients.remove(out);
//                }
//            }
//            try {
//                socket.close();
//            } catch (IOException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//}
