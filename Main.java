import java.util.InputMismatchException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("What do you want to do? Enter the number.");
            System.out.println("1 - Add 2 complex numbers");
            System.out.println("2 - Multiply 2 complex numbers");
            System.out.println("3 - Output a complex number in trigonometric form");
            System.out.println("4 - Add 2 matrices with complex numbers");
            System.out.println("5 - Multiply 2 matrices with complex numbers");
            System.out.println("6 - Multiply matrix with complex numbers by a constant");
            System.out.println("7 - Transpose matrix with complex numbers");
            System.out.println("8 - Find determinant of matrix with complex numbers");
            System.out.println("9 - Exit");
            Scanner scanner = new Scanner(System.in);
            try {
                int request = scanner.nextInt();
                if (!(0 < request && request < 10)){
                    throw new Exception("Invalid request");
                }
                if (request == 1) {
                    try {
                        System.out.println("Enter the real and imaginary parts of first number by a space");
                        Complex number_1 = new Complex(scanner.nextDouble(), scanner.nextDouble());
                        System.out.println("Enter the real and imaginary parts of second number by a space");
                        Complex number_2 = new Complex(scanner.nextDouble(), scanner.nextDouble());
                        Complex result = number_1.add(number_2);
                        System.out.println("The result is: ");
                        result.out_complex();
                        System.out.println();
                    } catch (InputMismatchException ex) {
                        System.out.println("Invalid number entry. Remember that the fractional part is entered after the decimal point!");
                        continue;
                    }
                }
                if (request == 2) {
                    try {
                        System.out.println("Enter the real and imaginary parts of first number by a space");
                        Complex number_1 = new Complex(scanner.nextDouble(), scanner.nextDouble());
                        System.out.println("Enter the real and imaginary parts of second number by a space");
                        Complex number_2 = new Complex(scanner.nextDouble(), scanner.nextDouble());
                        Complex result = number_1.multiplication(number_2);
                        System.out.println("The result is: ");
                        result.out_complex();
                        System.out.println();
                    } catch (InputMismatchException ex) {
                        System.out.println("Invalid number entry. Remember that the fractional part is entered after the decimal point!");
                        continue;
                    }
                }
                if (request == 3) {
                    try {
                        System.out.println("Enter the real and imaginary parts of number by a space");
                        Complex number = new Complex(scanner.nextDouble(), scanner.nextDouble());
                        if (number.im == 0 && number.re == 0){
                            throw new Exception("Cannot be represented in trigonometric form");
                        }
                        System.out.println("The result is: ");
                        number.out_in_trigonometric_form();
                    } catch (InputMismatchException ex) {
                        System.out.println("Invalid number entry. Remember that the fractional part is entered after the decimal point!");
                        continue;
                    }
                    catch (Exception ex){
                        System.out.println("Cannot be represented in trigonometric form!");
                        continue;
                    }
                }
                if (request == 4) {
                    try {
                        System.out.println("Enter information about the first matrix");
                        Matrix matrix_1 = new Matrix(0, 0);
                        matrix_1 = matrix_1.matrix_filling(matrix_1);
                        if (matrix_1.rows < 1 || matrix_1.columns < 1) {
                            continue;
                        }
                        System.out.println("Enter information about the second matrix");
                        Matrix matrix_2 = new Matrix(0, 0);
                        matrix_2 = matrix_2.matrix_filling(matrix_2);
                        if (matrix_2.rows < 1 || matrix_2.columns < 1) {
                            continue;
                        }
                        if (matrix_2.columns != matrix_1.columns || matrix_2.rows != matrix_1.rows) {
                            throw new Exception("It is impossible to add matrices");
                        }
                        Matrix result = matrix_1.addition(matrix_2);
                        System.out.println("The result is: ");
                        result.print_matrix();
                    }
                    catch (Exception ex){
                        System.out.println(ex.getMessage());
                        continue;
                    }
                }
                if (request == 5) {
                    try {
                        System.out.println("Enter information about the first matrix");
                        Matrix matrix_1 = new Matrix(0, 0);
                        matrix_1 = matrix_1.matrix_filling(matrix_1);
                        if (matrix_1.rows < 1 || matrix_1.columns < 1) {
                            continue;
                        }
                        System.out.println("Enter information about the second matrix");
                        Matrix matrix_2 = new Matrix(0, 0);
                        matrix_2 = matrix_2.matrix_filling(matrix_2);
                        if (matrix_2.rows < 1 || matrix_2.columns < 1) {
                            continue;
                        }
                        if (matrix_1.rows == 1 && matrix_1.columns == 1){
                            Matrix result = matrix_2.multi_by_a_const(matrix_1.matrix[0][0]);
                            System.out.println("The result is: ");
                            result.print_matrix();
                            continue;
                        }
                        else if (matrix_2.rows == 1 && matrix_2.columns == 1){
                            Matrix result = matrix_1.multi_by_a_const(matrix_2.matrix[0][0]);
                            System.out.println("The result is: ");
                            result.print_matrix();
                            continue;
                        }
                        else if (matrix_1.columns != matrix_2.rows) {
                            throw new Exception("It is impossible to multiply matrices");
                        }
                        Matrix result = matrix_1.multi(matrix_2);
                        System.out.println("The result is: ");
                        result.print_matrix();
                    }
                    catch (Exception ex){
                        System.out.println(ex.getMessage());
                        continue;
                    }
                }
                if (request == 6) {
                    try {
                        System.out.println("Enter the real and imaginary parts of constant by a space");
                        Complex constant = new Complex(scanner.nextDouble(), scanner.nextDouble());
                        System.out.println("Enter information about the matrix");
                        Matrix matrix = new Matrix(0, 0);
                        matrix = matrix.matrix_filling(matrix);
                        if (matrix.rows < 1 || matrix.columns < 1) {
                            continue;
                        }
                        Matrix result = matrix.multi_by_a_const(constant);
                        System.out.println("The result is: ");
                        result.print_matrix();
                    }
                    catch (InputMismatchException ex) {
                        System.out.println("Invalid number entry. Remember that the fractional part is entered after the decimal point!");
                        continue;
                    }
                }
                if (request == 7) {
                    System.out.println("Enter information about the matrix");
                    Matrix matrix = new Matrix(0, 0);
                    matrix = matrix.matrix_filling(matrix);
                    if (matrix.rows < 1 || matrix.columns < 1) {
                        continue;
                    }
                    Matrix result = matrix.transpose();
                    System.out.println("The result is: ");
                    result.print_matrix();
                }
                if (request == 8) {
                    try {
                        System.out.println("Enter information about the matrix");
                        Matrix matrix = new Matrix(0, 0);
                        matrix = matrix.matrix_filling(matrix);
                        if (matrix.rows < 1 || matrix.columns < 1) {
                            continue;
                        }
                        if (matrix.columns != matrix.rows) {
                            throw new Exception("It is impossible to calculate the determinant");
                        }
                        Complex result = matrix.calculate_the_determinate(matrix);
                        System.out.println("The result is: ");
                        result.out_complex();
                        System.out.println();
                    }
                    catch (Exception ex){
                        System.out.println(ex.getMessage());
                        continue;
                    }
                }
                if (request == 9) {
                    System.exit(0);
                }
            }
            catch (Exception ex){
                    System.out.println("Invalid request!");
            }
        }
    }
}