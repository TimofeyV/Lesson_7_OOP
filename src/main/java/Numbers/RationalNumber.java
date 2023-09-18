package Numbers;

/**
 * Класс рациональных чисел
 */
public class RationalNumber {
    /**
     * Числитель
     */
    private int numerator;
    /**
     * Знаменатель
     */
    private int denominator;

    /**
     * Конструктор класса
     * @param numerator
     * @param denominator
     */
    public RationalNumber(int numerator, int denominator) {
        this.numerator = numerator;
        if(denominator == 0) {
            throw new IllegalArgumentException("denominator == 0?");
        }
        else this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return  "Rational number = " + numerator + "/" + denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
}
