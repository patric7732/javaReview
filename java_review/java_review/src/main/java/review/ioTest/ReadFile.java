package review.ioTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ReadFile {
    public static void main(String[] args) throws Exception{
//        FileInputStream fis = new FileInputStream("src/com/example/day12/ReadFile.java");
        FileInputStream fis = new FileInputStream("a.txt");
        FileOutputStream fos = new FileOutputStream("b.txt");
//        System.out.println(System.getProperty("user.dir"));
        int n;
        int cnt = 0;
//        byte[] bytes = new byte[1024];
//        while((n = fis.read(bytes)) != -1){
//            String str = new String(bytes);
////            System.out.println(str);
//            fos.write(bytes);
//        }

        // 1 단어씩
        while((n = fis.read()) != -1){
            System.out.println((char)n);
            cnt++;
        }

        System.out.println(cnt);
        fos.close();
        fis.close();
    }
}
