import java.util.InputMismatchException;
import java.util.Scanner;
public class Matrix {
    int rows, columns;
    Complex[][] matrix;
    public Matrix(int rows, int columns){
        this.matrix = new Complex[rows][columns];
        this.rows = rows;
        this.columns = columns;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < columns; j++){
                this.matrix[i][j] = new Complex(0, 0);
            }
        }
    }
    public Matrix matrix_filling(Matrix matrix1){
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the number of rows in matrix");
            int rows = scanner.nextInt();
            System.out.println("Enter the number of columns in matrix");
            int columns = scanner.nextInt();
            if (columns < 1 || rows < 1) {
                throw new Exception("Unable to set matrix");
            }
            Matrix matrix_1 = new Matrix(rows, columns);
            for (int i = 0; i < matrix_1.rows; i++) {
                for (int j = 0; j < matrix_1.columns; j++) {
                    System.out.printf("Enter the real and imaginary part of matrix[%d][%d] number in first matrix by a space\n", i, j);
                    Complex value = new Complex(scanner.nextDouble(), scanner.nextDouble());
                    matrix_1.matrix[i][j] = value;
                }
            }
            return matrix_1;
        }
        catch (InputMismatchException ex) {
            System.out.println("Invalid number entry");
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return matrix1;
    }
    public Matrix addition(Matrix value){
        Matrix result = new Matrix(this.rows, this.columns);
        for (int i = 0; i < result.rows; i++){
            for (int j = 0; j < result.columns; j++){
                result.matrix[i][j] = this.matrix[i][j].add(value.matrix[i][j]);
            }
        }
        return result;
    }
    public Matrix multi(Matrix value){
        Matrix result = new Matrix(this.rows, value.columns);
        for (int i = 0; i < result.rows; i++){
            for (int j = 0; j < result.columns; j++){
                for (int k = 0; k < value.rows; k++)
                        result.matrix[i][j] = result.matrix[i][j].add(this.matrix[i][k].multiplication(value.matrix[k][j]));
            }
        }
        return result;
    }
    public Matrix multi_by_a_const(Complex constant){
        Matrix result = new Matrix(this.rows, this.columns);
        for (int i = 0; i < result.rows; i++){
            for (int j = 0; j < result.columns; j++){
                result.matrix[i][j] = this.matrix[i][j].multiplication(constant);
            }
        }
        return result;
    }
    public Matrix transpose(){
        Matrix result = new Matrix(this.columns, this.rows);
        for (int i = 0; i < result.rows; i++){
            for (int j = 0; j < result.columns; j++){
                result.matrix[i][j] = this.matrix[j][i];
            }
        }
        return result;
    }
    public Matrix get_matrix_without_i_row_j_column(int row, int column){
        Matrix result = new Matrix(this.columns - 1, this.rows - 1);
        int s_i = 0;
        for (int i = 0; i < result.rows; i++){
            if (i == row){
                s_i = 1;
            }
            int s_j = 0;
            for (int j = 0; j < result.columns; j++){
                if (j == column){
                    s_j = 1;
                }
                result.matrix[i][j] = this.matrix[i + s_i][j + s_j];
            }
        }
        return result;
    }
    public Complex calculate_the_determinate(Matrix matrix){
        Complex determinate = new Complex(0, 0);
        Complex k = new Complex(1, 0);
        Complex negative_k = new Complex(-1, 0);
        if (matrix.rows == 1){
            determinate = determinate.add(matrix.matrix[0][0]);
            return determinate;
        }
        if (matrix.rows == 2){
            determinate = determinate.add((matrix.matrix[0][0].multiplication(matrix.matrix[1][1])).subtraction(matrix.matrix[1][0].multiplication(matrix.matrix[0][1])));
            return determinate;
        }
        else{
            for (int i = 0; i < matrix.rows; i++){
                Matrix addition_matrix = matrix.get_matrix_without_i_row_j_column(i, 0);
                determinate = determinate.add((k.multiplication(matrix.matrix[i][0])).multiplication(calculate_the_determinate(addition_matrix)));
                k = k.multiplication(negative_k);
            }
        }
        return determinate;
    }
    public void print_matrix(){
        for (int i = 0; i < this.rows; i++){
            for (int j = 0; j < this.columns; j++){
                this.matrix[i][j].out_complex();
            }
            System.out.println();
        }
    }
}
