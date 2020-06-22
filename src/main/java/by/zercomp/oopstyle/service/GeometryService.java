package by.zercomp.oopstyle.service;

import by.zercomp.oopstyle.entity.PlanePoint;
import by.zercomp.oopstyle.exception.InvalidDataException;
import by.zercomp.oopstyle.validator.ArithmeticValidator;

public class GeometryService {


    //Площадь круга вписанного в квадрат меньше площади квадрата в 4/π раза.
    private static final double RATIO_INNER = 4 / Math.PI;
    //Площадь круга описанного вокруг квадрата большая площадь того же квадрата в π/2 раз
    private static final double RATIO_OUTER = Math.PI / 2;

    private double calcInnerCircleArea(double squareArea) throws InvalidDataException {
        validate(squareArea);
        return squareArea / RATIO_INNER;
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
        if (ArithmeticValidator.isNegative(data)) {
            throw new InvalidDataException("Invalid data:" + data);
        }
    }

    /**
     * Task 7
     * @param point1 - first point
     * @param point2 - second point
     * @return point that closer to zero Point of coord plane (0,0)
     * @throws InvalidDataException - throws when some of points is null or both of them.
     */
    private PlanePoint whichIsCloserToZero(PlanePoint point1, PlanePoint point2) throws InvalidDataException {
        if (point1 == null || point2 == null) {
            throw new InvalidDataException(new StringBuilder("point1 and point2 must be not null: ").append(point1)
                    .append(", ").append(point2).toString());
        }
        return point1.distFromCenter() > point2.distFromCenter() ? point2 : point1;
    }

}
