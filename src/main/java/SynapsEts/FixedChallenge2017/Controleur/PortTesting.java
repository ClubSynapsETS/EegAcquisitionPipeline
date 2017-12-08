package SynapsEts.FixedChallenge2017.Controleur;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.DataInputStream;

public class PortTesting {

    public static void main(String[] args) throws IOException {

        // writing string to a file encoded as modified UTF-8
        // DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("D:\\file.txt"));
        //dataOut.writeUTF("hello");

        // Reading data from the same file
        DataInputStream dataIn = new DataInputStream(new FileInputStream("D:\\file.txt"));

        while(dataIn.available()>0) {
            String k = dataIn.readUTF();
            System.out.print(k+" ");
        }
    }
}
