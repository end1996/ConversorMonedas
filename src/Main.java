import api.FetchExchangeRate;
import java.util.*;

public class Main {
    private static List<Conversion> historial = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        // Crear un mapa para asociar cada opción del menú con las monedas correspondientes
        HashMap<Integer, String[]> currencyOptions = new HashMap<>();
        currencyOptions.put(1, new String[]{"USD", "ARS"});
        currencyOptions.put(2, new String[]{"ARS", "USD"});
        currencyOptions.put(3, new String[]{"USD", "BRL"});
        currencyOptions.put(4, new String[]{"BRL", "USD"});
        currencyOptions.put(5, new String[]{"USD", "COP"});
        currencyOptions.put(6, new String[]{"COP", "USD"});
        currencyOptions.put(7, new String[]{"USD", "PEN"});
        currencyOptions.put(8, new String[]{"PEN", "USD"});

        while (option != 9) {
            Menu.showMenu();
            try {
                option = scanner.nextInt();

                if (currencyOptions.containsKey(option)) {
                    System.out.println("Ingrese el valor que desea convertir: ");
                    double ammount = scanner.nextDouble();

                    // Obtener las monedas de origen y destino del mapa
                    String[] monedas = currencyOptions.get(option);
                    String baseCurrency = monedas[0];
                    String targetCurrency = monedas[1];

                    // Realizar la conversión
                    double result = exchangeCurrency(baseCurrency, targetCurrency, ammount);

                    // Mostrar el resultado
                    System.out.println("El valor " + ammount + " " + baseCurrency + " corresponde al valor final de " + result+ " " + targetCurrency);
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido");
                scanner.next(); // Limpiar buffer
            }

        }
        System.out.println("¡Gracias por utilizar el conversor de monedas, vuelva pronto! \n");
        System.out.println("Historial de conversiones \n");
        for (Conversion conversion : historial) {
            System.out.println(conversion); // Imprimir cada conversión individualmente
        }
        SaveMovements.write(historial); // Guardar historial en un archivo independiente
    }

    public static double exchangeCurrency(String baseCurrency, String targetCurrency, double ammount) {
        try {
            double result = FetchExchangeRate.getRate(baseCurrency, targetCurrency, ammount);

            // Crear un objeto Conversion
            Conversion conversion = new Conversion(baseCurrency, targetCurrency, ammount, result);

            // Agregar la conversión al historial
            historial.add(conversion);

            return result;
        } catch (Exception e) {
            System.out.println("Error al obtener la tasa de cambio: " + e.getMessage());
            return 0;
        }
    }
}
