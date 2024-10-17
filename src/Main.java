import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

  private static final String API_KEY = "0aa11028e9fcc1e89d5462e9";  // Replace with your API key
  private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/BRL";

  public static void main(String[] args) {
    public static void main(String[] args) {
        boolean state = true;
        Scanner scanner = new Scanner(System.in);

        while (state) {
            System.out.println(
                "Bem vindo ao conversor de moedas\n1- Real Brasileiro -> Dolar Americano\nDigite o numero correspondente a opcao!\n"
            );
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Digite o valor em Real Brasileiro!");
                    double value = scanner.nextDouble();
                    double dollar = value * 0.02;
                    System.out.println(
                        "O valor em Dolar Americano é: " + dollar
                    );
                    break;
                default:
                    System.out.println("Opcao inválida!");
                    break;
            }
        }
    }
}
