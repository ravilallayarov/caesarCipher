package caesarCipher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class UI {
    private BruteForce bruteForce = new BruteForce();
    private CipherCaesar cipherCaesar = new CipherCaesar();

    public void start() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите режим");
        System.out.println("1.Зашифровать текст");
        System.out.println("2.Расшифровать текст");
        System.out.println("3.Расшифровать методом brute force");
        int number = 0;
        boolean enterNumber = false;
        while (!enterNumber) {
            try {
                number = Integer.parseInt(bufferedReader.readLine());
                if (number != 1 && number != 2 && number != 3) {
                    System.out.println("Введено неверное число,повторите попытку");
                    continue;
                }
                enterNumber = true;
            } catch (Exception e) {
                System.out.println("Вы ввели не число,повторите попытку");
            }
        }
        String firstFile = null;
        String secondFile = null;
        int key = 0;
        switch (number) {
            case 1 -> {
                System.out.println("Введите путь к файлу который нужно зашифровать");
                try {
                    firstFile = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Введите путь к файлу с зашифрованным текстом");
                try {
                    secondFile = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Введите количество сдвига от 1 до 100");
                boolean enterCorrectKey = false;
                while (!enterCorrectKey) {
                    try {
                        key = Integer.parseInt(bufferedReader.readLine());
                        if (key < 1 || key > 100) {
                            throw new KeyException("Введен некорректный сдвиг");
                        }
                        enterCorrectKey = true;
                    } catch (KeyException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Повторите попытку");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                cipherCaesar.encryption(firstFile, secondFile, key);
                System.out.println("Текст зашифрован");
            }
            case 2 -> {
                System.out.println("Введите путь к файлу который нужно расшифровать");
                try {
                    firstFile = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Введите путь к файлу с расшифрованным текстом");
                try {
                    secondFile = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Введите количество сдвига от 1 до 100");
                boolean enterCorrectKey = false;
                while (!enterCorrectKey) {
                    try {
                        key = Integer.parseInt(bufferedReader.readLine());
                        if (key <= 0 || key > 100) {
                            throw new KeyException("Введен некорректный сдвиг");
                        }
                        enterCorrectKey = true;
                    } catch (KeyException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Повторите попытку");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                cipherCaesar.decoding(firstFile, secondFile, key);
                System.out.println("Текст расшифрован");

            }
            case 3 -> {
                System.out.println("Введите путь к файлу который нужно расшифровать");
                try {
                    firstFile = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Введите путь к файлу с расшифрованным текстом");
                try {
                    secondFile = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bruteForce.decoding(firstFile, secondFile);
                System.out.println("Текст расшифрован методом brute force");
            }
        }
    }
}
