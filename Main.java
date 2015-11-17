package ru.stetsenko;

/**
 * Демо-класс, показывающий возможности работы с объектами класса Circle
 *
 * @author Алексей Стеценко
 */
public class Main {
    public static void main (String[] argc){

        Circle A = new Circle ();
        Circle B = new Circle ();
        System.out.println("Введите данные для первой окружности");
        A.exception();
        System.out.println("Введите данные для второй окружности");
        B.exception();
        A.printCircle();
        B.printCircle();
        System.out.println("Площдь окружности " + A.getName() + " = " + A.area());
        System.out.println("Длина круга " + A.getName() + " = " + A.length());
        System.out.println("Площдь окружности " + B.getName() + " = " + B.area());
        System.out.println("Длина круга " + B.getName() + " = " + B.length());
        System.out.println("Расстояние между центрами окружностей = " + A.howLong(B));
        A.equalsOutput(B);
        A.touchOutput(B);
        A.move();
        B.move();
        System.out.println("\nОкружности были передвинуты");
        A.printCircle();
        B.printCircle();

    }
}
