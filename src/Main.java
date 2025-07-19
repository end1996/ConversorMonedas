import api.FetchExchangeRate;
import models.ExchangeRate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la moneda a la que desea convertir: ");
        var base = scanner.nextLine();
        System.out.println("Ingrese la moneda objetivo: ");
        var target = scanner.nextLine();

        FetchExchangeRate search = new FetchExchangeRate();
        ExchangeRate exchangeRate = search.getRate(base, target);

        System.out.println(exchangeRate);
    }
}
