package Lab2;
import Lab2.Money;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter task");
        int task = scanner.nextInt();
        if(task == 1){

            // Створення об'єктів Money за допомогою конструктора з параметрами
            Money money1 = new Money(2, 3, 1, 1, 0, 0, 1, 0, 1, 0.75);
            Money money2 = new Money(1, 1, 1, 0, 0, 0, 0, 1, 0, 0.50);
            
            // Вивід значень об'єктів
            System.out.println("Money 1: " + money1);
            System.out.println("Money 2: " + money2);
            
            // Додавання двох об'єктів Money
            Money sum = money1.add(money2);
            System.out.println("Sum: " + sum);
            
            // Віднімання двох об'єктів Money
            Money difference = money1.subtract(money2);
            System.out.println("Difference: " + difference);
            
            // Ділення об'єкта Money на число
            Money divided = money1.divide(2);
            System.out.println("Divided by 2: " + divided);
            
            // Порівняння двох об'єктів Money
            int comparisonResult = money1.compareTo(money2);
            System.out.println("Comparison (money1 vs money2): " + (comparisonResult == 0 ? "Equal" : (comparisonResult > 0 ? "money1 > money2" : "money1 < money2")));
            
            // Загальна сума для money1
            double totalAmount = money1.getTotalAmount();
            System.out.println("Total amount in Money 1: " + totalAmount + " грн.");
            
            // Демонстрація перевантаження методу equals
            Money money3 = new Money(2, 3, 1, 1, 0, 0, 1, 0, 1, 0.75);
            System.out.println("money1 equals money3: " + money1.equals(money3));
            
            // Виведення кількості створених об'єктів Money
            System.out.println("Total Money objects created: " + Money.getCount());
            scanner.close(); 
        }
        if(task == 2){

          // Створення векторів за допомогою конструктора з параметрами
          Vector vector1 = new Vector(1, 2, 3);
          Vector vector2 = new Vector(4, 5, 6);
  
          // Вивід значень векторів
          System.out.println("Vector 1: " + vector1);
          System.out.println("Vector 2: " + vector2);
  
          // Знаходження модуля вектора
          System.out.println("Modulus of Vector 1: " + vector1.modulus());
  
          // Множення вектора на число
          Vector multipliedVector = vector1.multiplyByScalar(2);
          System.out.println("Vector 1 multiplied by 2: " + multipliedVector);
  
          // Додавання векторів
          Vector sumVector = vector1.add(vector2);
          System.out.println("Sum of Vector 1 and Vector 2: " + sumVector);
  
          // Скалярне множення
          double dotProductResult = vector1.dotProduct(vector2);
          System.out.println("Dot product of Vector 1 and Vector 2: " + dotProductResult);
  
          // Векторне множення
          Vector crossProductResult = vector1.crossProduct(vector2);
          System.out.println("Cross product of Vector 1 and Vector 2: " + crossProductResult);
  
          // Демонстрація перевантаження методу equals
          Vector vector3 = new Vector(1, 2, 3);
          System.out.println("Vector 1 equals Vector 3: " + vector1.equals(vector3));
  
          // Виведення кількості створених об'єктів Vector
          System.out.println("Total Vector objects created: " + Vector.getCount());
          scanner.close(); 
      }
      if(task ==3){

          // Зчитування координат і радіусів з консолі
          System.out.println("Введіть координати центру і радіус першої кулі (x1 y1 z1 radius1):");
          int x1 = scanner.nextInt();
          int y1 = scanner.nextInt();
          int z1 = scanner.nextInt();
          int radius1 = scanner.nextInt();
  
          System.out.println("Введіть координати центру і радіус другої кулі (x2 y2 z2 radius2):");
          int x2 = scanner.nextInt();
          int y2 = scanner.nextInt();
          int z2 = scanner.nextInt();
          int radius2 = scanner.nextInt();
  
          // Створення об'єктів класу Baloon
          Baloon baloon1 = new Baloon(x1, y1, z1, radius1);
          Baloon baloon2 = new Baloon(x2, y2, z2, radius2);
  
          // Вивід інформації про кулі
          System.out.println("Baloon 1: " + baloon1);
          System.out.println("Baloon 2: " + baloon2);
  
          // Обчислення об'ємів
          System.out.println("Об'єм кулі 1: " + baloon1.getVolume());
          System.out.println("Об'єм кулі 2: " + baloon2.getVolume());
  
          // Обчислення об'єму перетину
          double intersectionVolume = baloon1.intersectionVolume(baloon2);
          System.out.println("Об'єм перетину: " + intersectionVolume);
  
          // Обчислення об'єму об'єднання
          double unionVolume = baloon1.unionVolume(baloon2);
          System.out.println("Об'єм об'єднання: " + unionVolume);
  
          // Виведення кількості створених об'єктів Baloon
          System.out.println("Загальна кількість об'єктів Baloon: " + Baloon.getCount());
          scanner.close(); 
      }
    }
}
