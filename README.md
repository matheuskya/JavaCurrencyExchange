# JavaCurrencyExchange
 Parte do alura challenge back-end

 # JavaCurrencyExchange

 JavaCurrencyExchange is a simple currency conversion application that uses the ExchangeRate-API to fetch real-time exchange rates.

 ## Prerequisites

 Before you begin, ensure you have met the following requirements:

 * You have installed Java Development Kit (JDK) 8 or higher
 * You have a Windows/Linux/Mac machine
 * You have installed Git (optional, for cloning the repository)

 ## Installing JavaCurrencyExchange

 To install JavaCurrencyExchange, follow these steps:

 1. Clone the repository (or download the ZIP file and extract it):
    ```
    git clone https://github.com/yourusername/JavaCurrencyExchange.git
    ```
 2. Navigate to the project directory:
    ```
    cd JavaCurrencyExchange
    ```

 3. Ensure you have the required libraries. This project uses Gson for JSON parsing. You should see a `libs` folder in the project directory containing the Gson JAR file.

 ## Configuring the API Key

 Before running the application, you need to set up your API key:

 1. Sign up for a free API key at [ExchangeRate-API](https://www.exchangerate-api.com/)
 2. Open the `src/Main.java` file
 3. Replace the `API_KEY` value with your actual API key:
    ```java
    private static final String API_KEY = "YOUR_API_KEY_HERE";
    ```

 ## Running JavaCurrencyExchange

 To run JavaCurrencyExchange, follow these steps:

 1. Compile the Java file:
    ```
    javac -cp ".:libs/*" src/Main.java
    ```
    Note: On Windows, use `;` instead of `:` in the classpath:
    ```
    javac -cp ".;libs/*" src/Main.java
    ```

 2. Run the compiled program:
    ```
    java -cp ".:src:libs/*" Main
    ```
    Note: On Windows:
    ```
    java -cp ".;src;libs/*" Main
    ```

 3. Follow the on-screen prompts to convert currencies.

 ## Using JavaCurrencyExchange

 After running the program, you'll see a menu with options to convert between different currencies. Simply choose an option by entering the corresponding number, then enter the amount you wish to convert when prompted.

 ## Contact

 If you want to contact me, you can reach me at `your_email@example.com`.

 ## License

 This project uses the following license: [MIT License](https://opensource.org/licenses/MIT).
