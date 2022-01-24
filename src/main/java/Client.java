import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws Exception {
        String host = "netology.homework";
        int port = 8089;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

            try (Scanner scanner = new Scanner(System.in)) {
                String input = null;

                System.out.println("Для запроса сервера введите курсор ниже строки, введите любой символ и нажмите Еnter");
                input = scanner.nextLine();
                out.println(input);
                String resp = in.readLine();
                System.out.println(resp); //Введите Ваше имя:
                input = scanner.nextLine();
                out.println(input);
                String resp1 = in.readLine();
                System.out.println(resp1); //Печатаем имя имя:

                System.out.println("Для продолжения введите любой символ и нажмите Еnter");
                input = scanner.nextLine();
                out.println(input);
                String resp2 = in.readLine();
                System.out.println(resp2); //Введите Вашу фамилию:
                input = scanner.nextLine();
                out.println(input);
                String resp3 = in.readLine();
                System.out.println(resp3); //Печатаем Фамилию:

                System.out.println("Для продолжения введите любой символ и нажмите Еnter");
                input = scanner.nextLine();
                out.println(input);
                String resp4 = in.readLine();
                System.out.println(resp4); //Введите Ваш возраст:
                input = scanner.nextLine();
                out.println(input);
                String resp5 = in.readLine();
                System.out.println(resp5); //Печатаем Ваш возраст

            } catch (RuntimeException exception) {
                System.out.println("Не верно ведена информация ");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
