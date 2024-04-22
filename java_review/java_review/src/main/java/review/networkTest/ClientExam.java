package review.networkTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientExam {
    public static void main(String[] args) {
        try {
            Socket sock = new Socket("127.0.0.1", 9999);
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()), true);
            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));

            String line = null;
            while ((line = keyboard.readLine()) != null) {
                if ("exit".equalsIgnoreCase(line.trim())) {
                    break;
                }
                //서버에게 보냄.
                pw.println(line);

                //서버에서 받음
                String echo = br.readLine();
                System.out.println("서버로부터 받은 응답 메시지 : " + echo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
