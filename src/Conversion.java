import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversion {
    private String baseCurrency;
    private String targetCurrency;
    private double baseAmmount;
    private double targetAmmount;
    private LocalDate date;

    public Conversion(String baseCurrency, String targetCurrency, double baseAmmount, double targetAmmount) {
        this.baseCurrency = baseCurrency;
        this.targetCurrency = targetCurrency;
        this.baseAmmount = baseAmmount;
        this.targetAmmount = targetAmmount;
        this.date = LocalDate.now();
    }

    // Getters y setters

    @Override
    public String toString() {
        // Formatear los números con dos decimales
        DecimalFormat df = new DecimalFormat("#.##");

        // Formatear la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);

        // Crear la cadena formateada
        return String.format("%-30s%-30s%-30s%-30s%-15s",
                "Moneda Base: " + baseCurrency,
                "Moneda Destino: " + targetCurrency,
                "Monto Base: " + df.format(baseAmmount),
                "Monto Destino: " + df.format(targetAmmount),
                "Fecha: " + formattedDate);
    }
}
