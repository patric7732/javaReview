package review.networkTest.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ChatServer {
    public static void main(String[] args) {
        // 1. 소켓 생성
        try (ServerSocket serverSocket = new ServerSocket(9999);) {
            System.out.println("서버가 준비되었습니다.");
            // 여러명의 클라이언트 정보를 기억할 공간
            Map<String, PrintWriter> chatClients = new HashMap<>();
            while (true) {
                // 2. 소켓을 클라이언트에 받아옴, 대기 상태 ( 여러명의 클라이언트와 접속 가능하게 )
                Socket socket = serverSocket.accept();
                // Thread 이용
                new ChatThread(socket, chatClients).start();
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

class ChatThread extends Thread {
    // 생성자를 통해 소켓을 얻어옴
    private Socket socket;
    private String id;
    private Map<String, PrintWriter> chatClients;

    BufferedReader in = null;
    PrintWriter out = null;


    public ChatThread(Socket socket, Map<String, PrintWriter> chatClients) {
        this.socket = socket;
        this.chatClients = chatClients;

        // 클라이언트가 생성될 때 클라이언트로 부터 아아디를 얻게 하고 있음
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            id = in.readLine();
            // 이떄 모든 사용자에게 id님이 입장되었다는 것을 알림
            broadcast(id + " 님이 입장하셨습니다.");
            System.out.println("새로운 사용자의 아이디는 " + id + " 입니다.");

            // 동시에 일어날 수 있음, sync : 동기화 시켜줌
            synchronized (chatClients) {
                chatClients.put(this.id, out);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void run() {
        // run 실행
        // 연결된 클라이언트가 메시지를 전송하면, 그 메시지를 받아서 다른 사용자들에게 보내줌
        String msg = null;

        try {
            while ((msg = in.readLine()) != null) {
                if ("/quit".equalsIgnoreCase(msg)) {
                    break;
                }
                if (msg.indexOf("/to") == 0) {
                    sendMsg(msg);
                } else {
                    broadcast(id + " : " + msg);
                }
            }
        } catch(IOException e)
    {
        System.out.println(e);
    } finally

    {
        synchronized (chatClients) {
            chatClients.remove(id);
        }
        broadcast(id + " 님이 채팅에서 나가셨습니다.");

        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

    // 전체 사용자에게 알려주는 메서드
    public void broadcast(String msg) {
//        for (PrintWriter out : chatClients.values()){
//            out.println(msg);
//        }

        synchronized (chatClients) {
            Iterator<PrintWriter> it = chatClients.values().iterator();
            while (it.hasNext()) {
                PrintWriter out = it.next();
                try {
                    out.println(msg);
                } catch (Exception e) {
                    it.remove();
                    e.printStackTrace();
                }
            }
        }
    }

    // 귓속말 하는 메소드
//    public void sendPrivateMessage(String msg) {
//        try {
//            // 귓속말 명령어 분석: 예상 형식 "/to <대상ID> <메시지>"
//            // 메시지를 분리합니다.
//            String[] parts = msg.split(" ", 3);
//            if (parts.length < 3) {
//                out.println("귓속말 형식이 잘못되었습니다. 사용법: /to <대상ID> <메시지>");
//                return;
//            }
//
//            String targetId = parts[1];
//            String message = parts[2];
//
//            // 대상ID에 해당하는 PrintWriter를 찾아 메시지를 전송
//            PrintWriter targetOut = chatClients.get(targetId);
//            if (targetOut != null) {
//                targetOut.println("(귓속말) " + this.id + ": " + message);
//                out.println("(귓속말 -> " + targetId + ") " + message);
//            } else {
//                out.println(targetId + " 사용자는 존재하지 않습니다.");
//            }
//        } catch (Exception e) {
//            out.println("귓속말 전송 중 오류가 발생했습니다.");
//        }
//    }

    public void sendMsg(String msg) {
        int firstSpaceIndex = msg.indexOf(" ");
        if (firstSpaceIndex == -1) {
            return; //공백이 없다면, 실행 안함..
        }

        int secondSpaceIndex = msg.indexOf(" ", firstSpaceIndex + 1);
        if (secondSpaceIndex == -1) {
            return; //수신자는 있는데 보낼 사람이 없을 때, 보낼 메시지가 없음
        }

        String to = msg.substring(firstSpaceIndex + 1, secondSpaceIndex);
        String message = msg.substring(secondSpaceIndex + 1);

        // to(수신자)에게 메시지 전송.
        PrintWriter pw = chatClients.get(to);
        if (pw != null) {
            pw.println(id + "님으로부터 온 귓속말 : " + message);
        } else {
            System.out.println("오류 : 수신자 " + to + "님을 찾을 수 없습니다.");
        }
    }
}

