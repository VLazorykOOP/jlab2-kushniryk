package Lab2;

public class Baloon {
    // Поля класу для координат центру і радіусу
    private int centerX;
    private int centerY;
    private int centerZ;
    private int radius;

    // Статичне поле для підрахунку кількості об'єктів Baloon
    private static int count = 0;

    // Конструктор за замовчуванням
    public Baloon() {
        this.centerX = 0;
        this.centerY = 0;
        this.centerZ = 0;
        this.radius = 1;
        count++;
    }

    // Конструктор з параметрами
    public Baloon(int centerX, int centerY, int centerZ, int radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.centerZ = centerZ;
        this.radius = radius;
        count++;
    }

    // Статичний метод для отримання кількості об'єктів
    public static int getCount() {
        return count;
    }

    // Метод для обчислення об'єму кулі
    public double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    // Метод для знаходження відстані між двома центрами куль
    private double distanceTo(Baloon other) {
        return Math.sqrt(Math.pow(this.centerX - other.centerX, 2) +
                         Math.pow(this.centerY - other.centerY, 2) +
                         Math.pow(this.centerZ - other.centerZ, 2));
    }

    // Метод для обчислення об'єму перетину двох куль
    public double intersectionVolume(Baloon other) {
        double distance = distanceTo(other);
        if (distance >= this.radius + other.radius) {
            return 0; // Кулі не перетинаються
        }
        if (distance <= Math.abs(this.radius - other.radius)) {
            return (4.0 / 3.0) * Math.PI * Math.pow(Math.min(this.radius, other.radius), 3);
        }
        
        double r1 = this.radius;
        double r2 = other.radius;
        double d = distance;
        
        double volume = (Math.PI * (r1 + r2 - d) * (r1 + r2 - d) * (d * d + 2 * d * r1 + 2 * d * r2 - 3 * r1 * r1 - 3 * r2 * r2)) / (12 * d);
        return volume;
    }

    // Метод для обчислення об'єму об'єднання двох куль
    public double unionVolume(Baloon other) {
        return this.getVolume() + other.getVolume() - this.intersectionVolume(other);
    }

    // Перевантаження методу toString
    @Override
    public String toString() {
        return "Baloon{" +
                "centerX=" + centerX +
                ", centerY=" + centerY +
                ", centerZ=" + centerZ +
                ", radius=" + radius +
                '}';
    }

    // Перевантаження методу equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Baloon baloon = (Baloon) obj;
        return centerX == baloon.centerX &&
                centerY == baloon.centerY &&
                centerZ == baloon.centerZ &&
                radius == baloon.radius;
    }
}
