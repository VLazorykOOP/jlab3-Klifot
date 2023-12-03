import java.util.Scanner;

public class NumberDemo {

    public interface Number {
        Number add(Number other);
        Number subtract(Number other);
        Number multiply(Number other);
        Number divide(Number other);
    }

    public static class Integer implements Number {
        private int value;

        public Integer(int value) {
            this.value = value;
        }

        @Override
        public Number add(Number other) {
            if (other instanceof Integer) {
                return new Integer(this.value + ((Integer) other).getValue());
            } else {
                throw new IllegalArgumentException("Cannot perform addition with non-integer type");
            }
        }

        @Override
        public Number subtract(Number other) {
            if (other instanceof Integer) {
                return new Integer(this.value - ((Integer) other).getValue());
            } else {
                throw new IllegalArgumentException("Cannot perform subtraction with non-integer type");
            }
        }

        @Override
        public Number multiply(Number other) {
            if (other instanceof Integer) {
                return new Integer(this.value * ((Integer) other).getValue());
            } else {
                throw new IllegalArgumentException("Cannot perform multiplication with non-integer type");
            }
        }

        @Override
        public Number divide(Number other) {
            if (other instanceof Integer) {
                int otherValue = ((Integer) other).getValue();
                if (otherValue == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return new Integer(this.value / otherValue);
            } else {
                throw new IllegalArgumentException("Cannot perform division with non-integer type");
            }
        }

        public int getValue() {
            return value;
        }
    }

    public static class Real implements Number {
        private double value;

        public Real(double value) {
            this.value = value;
        }

        @Override
        public Number add(Number other) {
            if (other instanceof Real) {
                return new Real(this.value + ((Real) other).getValue());
            } else {
                throw new IllegalArgumentException("Cannot perform addition with non-real type");
            }
        }

        @Override
        public Number subtract(Number other) {
            if (other instanceof Real) {
                return new Real(this.value - ((Real) other).getValue());
            } else {
                throw new IllegalArgumentException("Cannot perform subtraction with non-real type");
            }
        }

        @Override
        public Number multiply(Number other) {
            if (other instanceof Real) {
                return new Real(this.value * ((Real) other).getValue());
            } else {
                throw new IllegalArgumentException("Cannot perform multiplication with non-real type");
            }
        }

        @Override
        public Number divide(Number other) {
            if (other instanceof Real) {
                double otherValue = ((Real) other).getValue();
                if (otherValue == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return new Real(this.value / otherValue);
            } else {
                throw new IllegalArgumentException("Cannot perform division with non-real type");
            }
        }

        public double getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer value: ");
        int intValue1 = scanner.nextInt();
        Number integer1 = new Integer(intValue1);

        System.out.print("Enter another integer value: ");
        int intValue2 = scanner.nextInt();
        Number integer2 = new Integer(intValue2);

        System.out.print("Enter a real value: ");
        double realValue1 = scanner.nextDouble();
        Number real1 = new Real(realValue1);

        System.out.print("Enter another real value: ");
        double realValue2 = scanner.nextDouble();
        Number real2 = new Real(realValue2);

        Number resultInt = integer1.add(integer2);
        Number resultReal = real1.divide(real2);

        System.out.println("Integer Result: " + ((Integer) resultInt).getValue());
        System.out.println("Real Result: " + ((Real) resultReal).getValue());

        // Закриваємо Scanner
        scanner.close();
    }
}
