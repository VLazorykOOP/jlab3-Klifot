import java.util.Scanner;

abstract class MyNumber {
    abstract MyNumber add(MyNumber other);
    abstract MyNumber subtract(MyNumber other);
    abstract MyNumber multiply(MyNumber other);
    abstract MyNumber divide(MyNumber other);
}

class MyInteger extends MyNumber {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }

    @Override
    MyNumber add(MyNumber other) {
        if (other instanceof MyInteger) {
            return new MyInteger(this.value + ((MyInteger) other).value);
        }
        throw new IllegalArgumentException("Cannot add MyInteger with a different type.");
    }

    @Override
    MyNumber subtract(MyNumber other) {
        if (other instanceof MyInteger) {
            return new MyInteger(this.value - ((MyInteger) other).value);
        }
        throw new IllegalArgumentException("Cannot subtract MyInteger with a different type.");
    }

    @Override
    MyNumber multiply(MyNumber other) {
        if (other instanceof MyInteger) {
            return new MyInteger(this.value * ((MyInteger) other).value);
        }
        throw new IllegalArgumentException("Cannot multiply MyInteger with a different type.");
    }

    @Override
    MyNumber divide(MyNumber other) {
        if (other instanceof MyInteger) {
            int divisor = ((MyInteger) other).value;
            if (divisor != 0) {
                return new MyInteger(this.value / divisor);
            } else {
                throw new ArithmeticException("Cannot divide by zero.");
            }
        }
        throw new IllegalArgumentException("Cannot divide MyInteger with a different type.");
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}

class MyReal extends MyNumber {
    private double value;

    public MyReal(double value) {
        this.value = value;
    }

    @Override
    MyNumber add(MyNumber other) {
        if (other instanceof MyReal) {
            return new MyReal(this.value + ((MyReal) other).value);
        }
        throw new IllegalArgumentException("Cannot add MyReal with a different type.");
    }

    @Override
    MyNumber subtract(MyNumber other) {
        if (other instanceof MyReal) {
            return new MyReal(this.value - ((MyReal) other).value);
        }
        throw new IllegalArgumentException("Cannot subtract MyReal with a different type.");
    }

    @Override
    MyNumber multiply(MyNumber other) {
        if (other instanceof MyReal) {
            return new MyReal(this.value * ((MyReal) other).value);
        }
        throw new IllegalArgumentException("Cannot multiply MyReal with a different type.");
    }

    @Override
    MyNumber divide(MyNumber other) {
        if (other instanceof MyReal) {
            double divisor = ((MyReal) other).value;
            if (divisor != 0) {
                return new MyReal(this.value / divisor);
            } else {
                throw new ArithmeticException("Cannot divide by zero.");
            }
        }
        throw new IllegalArgumentException("Cannot divide MyReal with a different type.");
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення двох цілих чисел
        System.out.print("Введіть перше ціле число: ");
        int num1 = scanner.nextInt();

        System.out.print("Введіть друге ціле число: ");
        int num2 = scanner.nextInt();

        // Приклад використання класу MyInteger
        MyInteger myInt1 = new MyInteger(num1);
        MyInteger myInt2 = new MyInteger(num2);

        try {
            MyNumber resultAdd = myInt1.add(myInt2);
            MyNumber resultSubtract = myInt1.subtract(myInt2);
            MyNumber resultMultiply = myInt1.multiply(myInt2);
            MyNumber resultDivide = myInt1.divide(myInt2);

            System.out.println("Результат додавання MyInteger: " + resultAdd);
            System.out.println("Результат віднімання MyInteger: " + resultSubtract);
            System.out.println("Результат множення MyInteger: " + resultMultiply);
            System.out.println("Результат ділення MyInteger: " + resultDivide);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        // Введення двох дійсних чисел
        System.out.print("Введіть перше дійсне число: ");
        double real1 = scanner.nextDouble();

        System.out.print("Введіть друге дійсне число: ");
        double real2 = scanner.nextDouble();

        // Приклад використання класу MyReal
        MyReal myReal1 = new MyReal(real1);
        MyReal myReal2 = new MyReal(real2);

        try {
            MyNumber resultAdd = myReal1.add(myReal2);
            MyNumber resultSubtract = myReal1.subtract(myReal2);
            MyNumber resultMultiply = myReal1.multiply(myReal2);
            MyNumber resultDivide = myReal1.divide(myReal2);

            System.out.println("Результат додавання MyReal: " + resultAdd);
            System.out.println("Результат віднімання MyReal: " + resultSubtract);
            System.out.println("Результат множення MyReal: " + resultMultiply);
            System.out.println("Результат ділення MyReal: " + resultDivide);
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }

        scanner.close(); // Закрити Scanner, щоб уникнути витоку ресурсів
    }
}
