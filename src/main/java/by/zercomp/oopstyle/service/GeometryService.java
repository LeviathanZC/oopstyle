package by.zercomp.oopstyle.service;

import by.zercomp.oopstyle.exception.InvalidDataException;
import by.zercomp.oopstyle.validator.ArithmeticValidator;

public class GeometryService {


    //Площадь круга вписанного в квадрат меньше площади квадрата в 4/π раза.
    private static final double RATIO_INNER = 4 / Math.PI;
    //Площадь круга описанного вокруг квадрата большая площадь того же квадрата в π/2 раз
    private static final double RATIO_OUTER = Math.PI / 2;

    private double calcInnerCircleArea(double squareArea) throws InvalidDataException {
        validate(squareArea);
        return  squareArea / RATIO_INNER;
    }

    private double calcInnerSquareArea(double circleArea) throws InvalidDataException {
        validate(circleArea);
        return circleArea / RATIO_OUTER;
    }

    private double calcRatioOfInscribedSquare(double outer, double inscribed) throws InvalidDataException {
        validate(outer);
        validate(inscribed);
        return outer / inscribed;
    }

    private void validate(double data) throws InvalidDataException {
        if(ArithmeticValidator.isNegative(data)) {
            throw new InvalidDataException("Invalid data:" + data);
        }
    }


}
