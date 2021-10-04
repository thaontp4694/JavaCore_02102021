import java.io.*;

public class App {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("originalFile.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write("Nội dung trong file gốc !!!".getBytes());
            bos.flush();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fis = new FileInputStream("originalFile.txt");
            BufferedInputStream bis = new BufferedInputStream(fis);
            FileOutputStream fosCopy = new FileOutputStream("copiedFile.txt");
            BufferedOutputStream bosCopy = new BufferedOutputStream(fosCopy);
            int ch;
            ch = bis.read();
            while (ch != -1) {
                bosCopy.write(ch);
                ch = bis.read();
            }
            bis.close();
            bosCopy.flush();
            bosCopy.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}