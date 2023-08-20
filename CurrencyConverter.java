import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.0); // Default exchange rate
        exchangeRates.put("EUR", 0.85);
        exchangeRates.put("JPY", 110.45);
        exchangeRates.put("GBP", 0.73);

        System.out.println("Welcome to Currency Converter!");
        System.out.println("Supported currencies: USD, EUR, JPY, GBP");

        System.out.print("Enter the source currency code: ");
        String sourceCurrency = scanner.next().toUpperCase();
        if (!exchangeRates.containsKey(sourceCurrency)) {
            System.out.println("Currency not supported.");
            scanner.close();
            return;
        }

        System.out.print("Enter the amount in " + sourceCurrency + ": ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the target currency code: ");
        String targetCurrency = scanner.next().toUpperCase();
        if (!exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Currency not supported.");
            scanner.close();
            return;
        }

        double sourceRate = exchangeRates.get(sourceCurrency);
        double targetRate = exchangeRates.get(targetCurrency);

        double convertedAmount = amount * (targetRate / sourceRate);
        System.out.println(amount + " " + sourceCurrency + " is equivalent to " + convertedAmount + " " + targetCurrency);

        scanner.close();
    }
}
