import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleCount = -1;

        while(peopleCount <= 1) {
            print("На скольких человек необходимо разделить счёт");
            peopleCount = scanner.nextInt();

            if (peopleCount <= 1) {
                print("Кол-во человек должно быть больше 1");
            }
        }

        Calc calc = new Calc(peopleCount);

        while(true) {
            print("Введите информацию о товаре");
            print("Название:");
            String inputName = scanner.next();

            if (inputName.trim().equalsIgnoreCase("завершить")) {
                break;
            }

            print("Цена:");
            double inputPrice;

            try {
                inputPrice = scanner.nextDouble();
            } catch (Exception e) {
                print("Цена должна быть числом, попробуйте снова.");

                continue;
            }

            if (inputPrice <= 0) {
                print("Цена не может быть меньше или равной нулю, попробуйте снова.");

                continue;
            }

            Product product = new Product(inputName, inputPrice);

            calc.add(product);

            double total = calc.getTotalPrice();
            String end = getRubEnd(total);

            print(String.format("Товар '%s' успешно добавлен! Общая стоимость: %.2f %s", product.name, total, end));
        }

        print(String.format("Добавленные товары: %s", calc.getAllProductNames()));
        print(String.format(
            "Каждый должен по: %.2f %s",
            calc.getPricePerPerson(),
            getRubEnd(calc.getPricePerPerson())
        ));
    }

    public static void print(String text) {
        System.out.println(text);
    }

    public static String getRubEnd(double d) {
        int num = (int) Math.floor(d);
        int preLastDigit = num % 100 / 10;

        if (preLastDigit == 1)
        {
            return "рублей";
        }

        switch (num % 10)
        {
            case 1:
                return "рубль";
            case 2:
            case 3:
            case 4:
                return "рубля";
            default:
                return "рублей";
        }
    }
}
