public class Complex {
    public double im, re;
    public Complex(double real, double image){
        this.im = image;
        this.re = real;
    }
    public Complex add(Complex value){
        return new Complex(this.re + value.re, this.im + value.im);
    }
    public Complex subtraction(Complex value){
        return new Complex(this.re - value.re, this.im - value.im);
    }
    public Complex multiplication(Complex value){
        return new Complex(this.re * value.re - this.im * value.im, this.im * value.re + this.re * value.im);
    }
    public void out_complex(){
        if (this.im < 0){
            System.out.printf("%f%fi ", this.re, this.im);
        }
        else{
            System.out.printf("%f+%fi ", this.re, this.im);
        }
    }
    public double absolute(){
        return Math.sqrt(this.im * this.im + this.re * this.re);
    }
    public double arg_z(){
        if (this.re > 0 && this.im >= 0){
            return Math.toDegrees(Math.atan(this.im/this.re));
        }
        else if (this.re < 0 && this.im >= 0){
            return Math.toDegrees(Math.PI) - Math.toDegrees(Math.atan(this.im/Math.abs(this.re)));
        }
        else if (this.re < 0 && this.im < 0){
            return Math.toDegrees(-Math.PI) + Math.toDegrees(Math.atan(Math.abs(this.im/this.re)));
        }
        else if (this.re > 0 && this.im < 0){
            return Math.toDegrees(-Math.atan(Math.abs(this.im)/this.re));
        }
        else if (this.re == 0 && this.im > 0){
            return Math.toDegrees(Math.PI);
        }
        else if (this.re == 0 && this.im < 0){
            return Math.toDegrees(-Math.PI/2);
        }
        else{
            return 0;
        }
    }
    public void out_in_trigonometric_form(){
        System.out.printf("%f*(cos(%f°)+i*sin(%f°)))\n", this.absolute(), this.arg_z(), this.arg_z());
    }
}

