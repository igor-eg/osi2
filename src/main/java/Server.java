import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        int port = 8089;
        while (true) {
            try (ServerSocket serverSocket = new ServerSocket(port);
                 Socket clientSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                // Запрос имени
                String name = in.readLine();
                out.println("Введите Ваше имя:");
                name = in.readLine();
                out.println(String.format("Привет, %s, Ваш порт: %d", name, clientSocket.getPort()));

                // Запрос фамилии
                name = in.readLine();
                out.println("Введите Вашу Фамилию:");
                name = in.readLine();
                out.println(String.format(" Ваша фамилия: %s", name));

                //Запрос возраста
                name = in.readLine();
                out.println("Введите Ваш возраст:");
                name = in.readLine();

                try {
                    Integer i = Integer.valueOf(name);
                    String wordToInsert = (i >= 18) ? "разрешен доступ на сервер" : "запрещен доступ на сервер";
                    out.println(" Ваш возраст: " + name + " и Вам " + wordToInsert);

                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат строки!");
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
