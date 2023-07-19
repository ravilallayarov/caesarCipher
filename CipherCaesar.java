package caesarCipher;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CipherCaesar {

    public void encryption(String firstFile, String secondFile, int key) {
        try (FileReader fileReader = new FileReader(firstFile);
             FileWriter fileWriter = new FileWriter(secondFile)) {
            char[] symbols = new char[64];
            int length;
            while ((length = fileReader.read(symbols)) != -1) {
                for (int i = 0; i < length; i++) {
                    fileWriter.write(symbols[i] + key);
                }
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void decoding(String firstFile, String secondFile, int key) {
        try (FileReader fileReader = new FileReader(firstFile);
             FileWriter fileWriter = new FileWriter(secondFile)) {
            char[] symbols = new char[64];
            int length;
            while ((length = fileReader.read(symbols)) != -1) {
                for (int i = 0; i < length; i++) {
                    fileWriter.write(symbols[i] - key);
                }
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
