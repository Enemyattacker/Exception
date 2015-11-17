package ru.stetsenko;

import java.lang.Math;
import java.lang.String;
import java.util.InputMismatchException;
import java.util.Scanner;



/**
 * Класс для представления окружности(круга)
 *
 * @author Алексей Стеценко
 */
public class Circle {
    Scanner reader = new Scanner(System.in);
    private double x;
    private double y;
    private double r;
    private String n;


    /**
     * Метод позволяет ввести первоначальные данные(координаты и имя центра окружности, радиус окружности) с помощью клавиатуры
     *
     */
    public void input(){
        System.out.println("Введите координату X");
        x=reader.nextDouble();
        System.out.println("Введите координату Y");
        y=reader.nextDouble();
        System.out.println("Введите радиус окружности");
        exceptionR(reader.nextDouble());
        System.out.println("Введите имя центра окружности");
        n = reader.next();
    }

    public Circle(double x, double y, double r, String n){
        this.x=x;
        this.y=y;
        this.r=r;
        this.n=n;
    }

    public Circle(){
        this.x=0.0;
        this.y=0.0;
        this.r=1.0;
        this.n="";
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String getName(){
        return n;
    }

    public void setName(){
        this.n=n;
    }

    /**
     * Метод выводит данные об окружности
     */
    public void printCircle() {
        System.out.println("Окружность "+n+" с центром ("+x+";"+y+") и радиусом "+r);
    }

    /**
     * Метод рассчитывает площадь круга
     *
     * @return (area) площадь круга
     */
    public double area (){
        double area = Math.PI*Math.pow(r,2);
        return area;
    }

    /**
     * Метод рассчитывает длину окружности
     *
     * @return (length) длина окружности
     */
    public double length(){
        double length = 2 * Math.PI * r;
        return length;
    }

    /**
     * Метод сравнивает площадь двух кругов
     *
     * @param obj Объект, содержащий имя и координаты центра окружности, и радиус окружности
     */
    public boolean equalsArea(Circle obj){
        if(this.area() == obj.area()){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Метод выводит информацию о равенстве площадей кругов
     *
     * @param obj Объект, содержащий имя и координаты центра окружности, и радиус окружности
     */
    public void equalsOutput(Circle obj){
        if(this.equalsArea(obj)){
            System.out.println("Плошадь кругов равна");
        }
        if(!this.equalsArea(obj)){
            System.out.println("Плошадь кругов не равна");
        }

    }

    public void exception(){
        try{
            this.input();
        }
        catch(InputMismatchException e){
            System.out.println("Ошибка типа " + e + "\n");
        }
    }

    public void exceptionR(double r){
        try{
            if(r<0) {
                throw new NumberFormatException("Радиус не может быть отрицательным");
            }
            this.r=r;
        }
        catch(NumberFormatException e){
            System.out.println("Ошибка типа " + e);
            System.out.println("Радиус был возвращён по модулю");
            this.r=Math.abs(r);

        }
    }

    /**
     * Метод перемещает центр окружности в случайную точку из диапазона ([-99;99],[-99;99])
     */
    public void move(){
        this.x=-99 + (int)(Math.random() * ((198)+1));
        this.y=-99 + (int)(Math.random() * ((198)+1));
    }

    /**
     * Метод находится расстояние между центрами окружностей и определяет касаются ли они
     *
     * @param obj Объект, содержащий имя и координаты центра окружности, и радиус окружности
     * @return (d) - Расстояние между центрами окружностей
     */
    public double howLong(Circle obj) {
        double dX = (this.x - obj.getX()) * (this.x - obj.getX());
        double dY = (this.y - obj.getY()) * (this.y - obj.getY());
        double d = Math.sqrt(dX + dY);
        return d;
    }

    /**
     * Метод, определяющий, касаются ли окружности.
     *
     * @param obj Объект, содержащий имя и координаты центра окружности, и радиус окружности
     */
    public boolean touch(Circle obj){
        double d = howLong(obj);
        if ((d==this.r+obj.r)||(d==Math.abs(this.r-obj.r))){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Метод, выводящий информацию о касательности окружностей
     *
     * @param obj
     */
    public void touchOutput(Circle obj){
        if(this.touch(obj)) {
            System.out.println("Окружности касаются");
        }
        if(!this.touch(obj)){
            System.out.println("Окружности не касаются");
        }
    }
}
