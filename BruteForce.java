package caesarCipher;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BruteForce {
    private static final char COMMA = ',';
    private static final char DOT = '.';
    private static final char SPACE = ' ';

    /****
     Так как вариантов расшифровки множество, будем считать что последний символ в нашем файле ТОЧКА
     ****/
    public void decoding(String firsFile, String secondFile) {
        try (FileReader fileReader = new FileReader(firsFile);
             FileWriter fileWriter = new FileWriter(secondFile)) {
            StringBuilder stringBuilder = new StringBuilder();
            int key = 0;
            char[] symbols = new char[1024];
            int length = fileReader.read(symbols);    // заполняем массив символами из файла
            for (int i = 1; i <= 100; i++) {   // будем пробовать ключи от 1 до 100
                for (int j = 0; j < length; j++) {    //  проходимся по нашему массиву символов
                    if (COMMA + i == symbols[j] || DOT + i == symbols[j] || SPACE + i == symbols[j]) {//если есть возможное совпадение
                        key = i;
                        if (symbols[length - 1] - key == DOT) { // если последний символ ТОЧКА по нашему подобранному ключу
                            for (int k = 0; k < length; k++) {   // то заполняем наш стрингбилдер с подобранным ключом
                                stringBuilder.append((char) (symbols[k] - key));
                            }
                            fileWriter.write(stringBuilder.toString());
                            break;
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
