package Lab2;

import java.util.Arrays;

public class Vector {
    // Поля класу для координат вектора
    private double x;
    private double y;
    private double z;

    // Статичне поле, що рахує кількість об'єктів Vector
    private static int count = 0;

    // Конструктор за замовчуванням
    public Vector() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
        count++;
    }

    // Конструктор з параметрами
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        count++;
    }

    // Статичний метод для отримання кількості об'єктів
    public static int getCount() {
        return count;
    }

    // Метод для знаходження модуля вектора
    public double modulus() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Метод для множення вектора на число
    public Vector multiplyByScalar(double scalar) {
        return new Vector(x * scalar, y * scalar, z * scalar);
    }

    // Метод для додавання векторів
    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    // Метод для скалярного множення
    public double dotProduct(Vector other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    // Метод для векторного множення
    public Vector crossProduct(Vector other) {
        return new Vector(
            this.y * other.z - this.z * other.y,
            this.z * other.x - this.x * other.z,
            this.x * other.y - this.y * other.x
        );
    }

    // Перевантаження методу toString
    @Override
    public String toString() {
        return "Vector{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    // Перевантаження методу equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vector vector = (Vector) obj;
        return Double.compare(vector.x, x) == 0 &&
               Double.compare(vector.y, y) == 0 &&
               Double.compare(vector.z, z) == 0;
    }
}
