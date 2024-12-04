package Lab2;

import java.util.Arrays;

public class Money {
    // Поля класу для гривень та копійок
    private int[] bills; // Массив для гривень
    private double kopecks; // Копійки
    
    // Статичне поле, що рахує кількість об'єктів Money
    private static int count = 0;

    // Конструктор за замовчуванням
    public Money() {
        this.bills = new int[9]; // Масив для номіналів гривень
        this.kopecks = 0.0;
        count++; // Збільшуємо лічильник
    }

    // Конструктор з параметрами
    public Money(int bill1, int bill2, int bill5, int bill10, int bill20, int bill50, int bill100, int bill200, int bill500, double kopecks) {
        this.bills = new int[]{bill1, bill2, bill5, bill10, bill20, bill50, bill100, bill200, bill500};
        this.kopecks = kopecks;
        count++;
    }

    // Статичний метод для отримання кількості об'єктів
    public static int getCount() {
        return count;
    }

    // Метод додавання
    public Money add(Money other) {
        Money result = new Money();
        for (int i = 0; i < this.bills.length; i++) {
            result.bills[i] = this.bills[i] + other.bills[i];
        }
        result.kopecks = this.kopecks + other.kopecks;
        if (result.kopecks >= 1.0) {
            result.bills[0] += (int) result.kopecks; // Додаємо цілу частину копійок до гривень
            result.kopecks = result.kopecks % 1.0;
        }
        return result;
    }

    // Метод віднімання
    public Money subtract(Money other) {
        Money result = new Money();
        for (int i = 0; i < this.bills.length; i++) {
            result.bills[i] = this.bills[i] - other.bills[i];
        }
        result.kopecks = this.kopecks - other.kopecks;
        if (result.kopecks < 0.0) {
            result.bills[0]--; // Забираємо одну гривню, якщо копійки негативні
            result.kopecks += 1.0;
        }
        return result;
    }

    // Метод ділення
    public Money divide(double divisor) {
        Money result = new Money();
        double total = this.getTotalAmount() / divisor;
        result.bills[0] = (int) total;
        result.kopecks = total - result.bills[0];
        return result;
    }

    // Метод для отримання загальної суми
    public double getTotalAmount() {
        double total = 0;
        int[] nominalValues = {1, 2, 5, 10, 20, 50, 100, 200, 500};
        for (int i = 0; i < bills.length; i++) {
            total += bills[i] * nominalValues[i];
        }
        return total + kopecks;
    }

    // Перевантаження методу toString
    @Override
    public String toString() {
        return Arrays.toString(bills) + ", копійки: " + kopecks;
    }

    // Перевантаження методу equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Money money = (Money) obj;
        return Arrays.equals(bills, money.bills) && Double.compare(money.kopecks, kopecks) == 0;
    }

    // Метод для порівняння
    public int compareTo(Money other) {
        double thisTotal = this.getTotalAmount();
        double otherTotal = other.getTotalAmount();
        return Double.compare(thisTotal, otherTotal);
    }
}
