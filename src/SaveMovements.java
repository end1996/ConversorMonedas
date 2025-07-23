import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class SaveMovements {
    public static void write(List<Conversion> historial) {
        FileWriter fileWriter = null;
        try {
            File file = new File("historial-" + LocalDate.now() + ".txt");
            fileWriter = new FileWriter(file, true); // Append mode
            for (Conversion conversion : historial) {
                fileWriter.write(conversion.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.err.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }
}