package Service;

import Numbers.ComplexNumber;
import Numbers.RationalNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Содержит список комплексых и рациональных чисел
 * Включает в себя методы сложения, вычитания, умножения, деления и сокращения чисел
 */
public class NumberService implements NumberInterface {
    private List<ComplexNumber> complexNumbers;
    private List<RationalNumber> rationalNumbers;

    public NumberService() {
        this.complexNumbers = new ArrayList<>();
        this.rationalNumbers = new ArrayList<>();
    }


    @Override
    public List<ComplexNumber> getAllComplexNumbers() {
        return complexNumbers;
    }

    @Override
    public List<RationalNumber> getallRationalNumbers() {
        return rationalNumbers;
    }

    /**
     * Создание комплексных чисел
     */
    @Override
    public void createCoupleComplexNumbers() {
        Scanner scanner = new Scanner(System.in);
        double x;
        double y;
        System.out.println("Введите действительную часть первого числа");
        x = scanner.nextDouble();
        System.out.println("Введите мнимую часть первого числа");
        y = scanner.nextDouble();
        ComplexNumber complexNumber1 = new ComplexNumber(x, y);
        complexNumbers.add(complexNumber1);
        System.out.println("Введите действительную часть второго числа");
        x = scanner.nextDouble();
        System.out.println("Введите мнимую часть второго числа");
        y = scanner.nextDouble();
        ComplexNumber complexNumber2 = new ComplexNumber(x, y);
        complexNumbers.add(complexNumber2);
    }

    /**
     * Создание рациональных чисел
     */
    @Override
    public void createCoupleRationalNumbers() {
        Scanner scanner = new Scanner(System.in);
        int x;
        int y;
        List<RationalNumber> list = new ArrayList<>();
        System.out.println("Введите числитель первого числа");
        x = scanner.nextInt();
        System.out.println("Введите знаменатель первого числа");
        y = scanner.nextInt();
        RationalNumber rationalNumber1 = new RationalNumber(x, y);
        rationalNumbers.add(rationalNumber1);
        System.out.println("Введите числитель второго числа");
        x = scanner.nextInt();
        System.out.println("Введите знаменатель второго числа");
        y = scanner.nextInt();
        RationalNumber rationalNumber2 = new RationalNumber(x, y);
        rationalNumbers.add(rationalNumber2);
    }

    /**
     * Сложение комплексных чисел
     * @param x - первое число
     * @param y - второе число
     * @return результат сложения
     */
    @Override
    public ComplexNumber addition(ComplexNumber x, ComplexNumber y) {
        ComplexNumber z = new ComplexNumber(0.0, 0.0);
        z.setNumerator(x.getNumerator() + y.getNumerator());
        z.setImaginaryPart(x.getImaginaryPart() + y.getImaginaryPart());
        return z;
    }
    /**
     * Вычитание комплексных чисел
     * @param x - первое число
     * @param y - второе число
     * @return результат вычитания
     */
    @Override
    public ComplexNumber subtraction(ComplexNumber x, ComplexNumber y) {
        ComplexNumber z = new ComplexNumber(0.0, 0.0);
        z.setNumerator(x.getNumerator() - y.getNumerator());
        z.setImaginaryPart(x.getImaginaryPart() - y.getImaginaryPart());
        return z;
    }
    /**
     * Умножение комплексных чисел
     * @param x - первое число
     * @param y - второе число
     * @return результат умножения
     */
    @Override
    public ComplexNumber multiplication(ComplexNumber x, ComplexNumber y) {
        ComplexNumber z = new ComplexNumber(0.0, 0.0);
        z.setNumerator((x.getNumerator() * y.getNumerator()) -
                (x.getImaginaryPart() * y.getImaginaryPart()));
        z.setImaginaryPart((x.getImaginaryPart() * y.getNumerator()) +
                (x.getNumerator() * y.getImaginaryPart()));
        return z;
    }
    /**
     * Деление комплексных чисел
     * @param x - первое число
     * @param y - второе число
     * @return результат деления
     */
    @Override
    public ComplexNumber division(ComplexNumber x, ComplexNumber y) {
        ComplexNumber z = new ComplexNumber(0.0, 0.0);
        z.setNumerator(((x.getNumerator() * y.getNumerator()) +
                (x.getImaginaryPart() * y.getImaginaryPart())) /
                ((y.getNumerator() * y.getNumerator()) + (y.getImaginaryPart() * y.getImaginaryPart())));
        z.setImaginaryPart((((x.getImaginaryPart() * y.getNumerator()) -
                (x.getNumerator() * y.getImaginaryPart())) /
                ((y.getNumerator() * y.getNumerator()) + (y.getImaginaryPart() * y.getImaginaryPart()))));
        return z;
    }
    /**
     * Сложение рациональных чисел
     * @param x - первое число
     * @param y - второе число
     * @return результат сложения
     */
    @Override
    public RationalNumber addition(RationalNumber x, RationalNumber y) {
        RationalNumber z = new RationalNumber(0, 1);
        z.setDenominator(x.getDenominator() * y.getDenominator());
        z.setNumerator((y.getDenominator() * x.getNumerator()) + (x.getDenominator() * y.getNumerator()));
        reduction(z);
        return z;
    }
    /**
     * Вычитание рациональных чисел
     * @param x - первое число
     * @param y - второе число
     * @return результат вычитания
     */
    @Override
    public RationalNumber subtraction(RationalNumber x, RationalNumber y) {
        RationalNumber z = new RationalNumber(0, 1);
        z.setDenominator(x.getDenominator() * y.getDenominator());
        z.setNumerator((y.getDenominator() * x.getNumerator()) - (x.getDenominator() * y.getNumerator()));
        if (z.getNumerator() != 0) reduction(z);
        return z;
    }
    /**
     * Умножение рациональных чисел
     * @param x - первое число
     * @param y - второе число
     * @return результат умножения
     */
    @Override
    public RationalNumber multiplication(RationalNumber x, RationalNumber y) {
        RationalNumber z = new RationalNumber(0, 1);
        z.setDenominator(x.getDenominator() * y.getDenominator());
        z.setNumerator(x.getNumerator()* y.getNumerator());
        if (z.getNumerator() != 0) reduction(z);
        return z;
    }
    /**
     * Деление рациональных чисел
     * @param x - первое число
     * @param y - второе число
     * @return результат деления
     */
    @Override
    public RationalNumber division(RationalNumber x, RationalNumber y) {
        RationalNumber z = new RationalNumber(0, 1);
        z.setDenominator(x.getDenominator() * y.getNumerator());
        z.setNumerator(x.getNumerator()* y.getDenominator());
        if (z.getNumerator() != 0) reduction(z);
        return z;
    }

    /**
     * Сокращения рационального числа
     * @param z - число, которое необходимо сократить
     * @return сокращенное число
     */
    public RationalNumber reduction(RationalNumber z){
        if (z.getNumerator() % 2 != 0 && z.getNumerator() % 3 != 0 && z.getNumerator() % 5 != 0 && z.getNumerator() % 7 != 0){
            return z;
        } else if (z.getDenominator() % z.getNumerator() == 0) {
            z.setDenominator(z.getDenominator() / z.getNumerator());
            z.setNumerator(1);
            return z;
        } else if(z.getNumerator() % 2 == 0 && z.getDenominator() % 2 == 0){
            z.setNumerator(z.getNumerator() / 2);
            z.setDenominator(z.getDenominator() / 2);
            reduction(z);
        } else if(z.getNumerator() % 3 == 0 && z.getDenominator() % 3 == 0){
            z.setNumerator(z.getNumerator() / 3);
            z.setDenominator(z.getDenominator() / 3);
            reduction(z);
        } else if(z.getNumerator() % 5 == 0 && z.getDenominator() % 5 == 0){
            z.setNumerator(z.getNumerator() / 5);
            z.setDenominator(z.getDenominator() / 5);
            reduction(z);
        } else if(z.getNumerator() % 7 == 0 && z.getDenominator() % 7 == 0){
            z.setNumerator(z.getNumerator() / 7);
            z.setDenominator(z.getDenominator() / 7);
            reduction(z);
        }
        return z;
    }
}