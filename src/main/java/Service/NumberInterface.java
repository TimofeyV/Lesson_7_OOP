package Service;

import Numbers.ComplexNumber;
import Numbers.RationalNumber;

import java.util.List;

public interface NumberInterface {
    public List<ComplexNumber> getAllComplexNumbers();
    public List<RationalNumber> getallRationalNumbers();

    public void createCoupleComplexNumbers();
    public void createCoupleRationalNumbers();
    public ComplexNumber addition(ComplexNumber x,ComplexNumber y);
    public ComplexNumber subtraction(ComplexNumber x, ComplexNumber y);
    public ComplexNumber multiplication(ComplexNumber x,ComplexNumber y);
    public ComplexNumber division(ComplexNumber x,ComplexNumber y);
    public RationalNumber addition(RationalNumber x, RationalNumber y);
    public RationalNumber subtraction(RationalNumber x, RationalNumber y);
    public RationalNumber multiplication(RationalNumber x,RationalNumber y);
    public RationalNumber division(RationalNumber x,RationalNumber y);


}