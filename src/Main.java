import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Main {

    private static final String API_KEY = "YOUR_API_KEY"; // Replace with your API key
    private static final String API_BASE_URL =
        "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBem-vindo ao conversor de moedas");
            System.out.println("1- BRL -> USD");
            System.out.println("2- BRL -> EUR");
            System.out.println("3- BRL -> ARS");
            System.out.println("4- USD -> BRL");
            System.out.println("5- EUR -> BRL");
            System.out.println("6- ARS -> BRL");
            System.out.println("0- Sair");
            System.out.println(
                "Digite o número correspondente à opção desejada:"
            );

            int choice = scanner.nextInt();
            if (choice == 0) break;

            if (choice < 1 || choice > 6) {
                System.out.println("Opção inválida!");
                continue;
            }

            String fromCurrency = (choice <= 3)
                ? "BRL"
                : (choice == 4 ? "USD" : (choice == 5 ? "EUR" : "ARS"));
            String toCurrency = (choice <= 3)
                ? (choice == 1 ? "USD" : (choice == 2 ? "EUR" : "ARS"))
                : "BRL";

            try {
                double exchangeRate = getExchangeRate(fromCurrency, toCurrency);
                System.out.println("Digite o valor em " + fromCurrency + ":");
                double value = scanner.nextDouble();
                double convertedValue = value * exchangeRate;
                System.out.printf(
                    "O valor em %s é: %.2f%n",
                    toCurrency,
                    convertedValue
                );
            } catch (Exception e) {
                System.out.println(
                    "Erro ao obter a taxa de câmbio: " + e.getMessage()
                );
            }
        }

        scanner.close();
        System.out.println("Obrigado por usar o conversor de moedas!");
    }

    private static double getExchangeRate(
        String fromCurrency,
        String toCurrency
    ) throws Exception {
        String apiUrl = API_BASE_URL + fromCurrency;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
            );
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(
                response.toString(),
                JsonObject.class
            );
            return jsonObject
                .getAsJsonObject("conversion_rates")
                .get(toCurrency)
                .getAsDouble();
        } else {
            throw new Exception(
                "HTTP request failed. Response Code: " + responseCode
            );
        }
    }
}
