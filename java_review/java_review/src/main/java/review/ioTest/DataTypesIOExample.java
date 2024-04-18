package review.ioTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataTypesIOExample {
    public static void main(String[] args) {
        try (
                DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.bin"));
                DataInputStream dis = new DataInputStream(new FileInputStream("data.bin"))
        ) {
            // 데이터 쓰기
            dos.writeInt(123);
            dos.writeDouble(123.45);
            dos.writeBoolean(true);
            dos.writeUTF("Hello Java!");

            // 데이터 읽기
            int intData = dis.readInt();
            double doubleData = dis.readDouble();
            boolean booleanData = dis.readBoolean();
            String stringData = dis.readUTF();

            // 출력
            System.out.println("Int data: " + intData);
            System.out.println("Double data: " + doubleData);
            System.out.println("Boolean data: " + booleanData);
            System.out.println("String data: " + stringData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
