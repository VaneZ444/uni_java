public class Fraction {
    int num;
    int den;
    public Fraction(int num,int den){
        int a = num;
        int b = den;
        int limit = Math.min(a,b);
        for (int i=2; i<= limit; i++) {
            if (a%i==0 && b%i==0){
                a/=i;
                b/=i;
            }
        }
        this.num = a;
        this.den = b;
    }
    public Fraction sum(Fraction second){
        return new Fraction(this.num * second.den + second.num * this.den, this.den * second.den);
    }
    public Fraction sub(Fraction second) {
        return new Fraction(this.num * second.den - second.num * this.den, this.den * second.den);
    }
    public Fraction mul(Fraction second){
        return new Fraction(this.num * second.num, this.den * second.den);
    }
    public Fraction div(Fraction second){
        return new Fraction(this.num * second.den, this.num * second.den);
    }
    public Fraction sum(int num){
        return new Fraction(this.num + num*this.den, this.den);
    }
    public Fraction sub(int num) {
        return new Fraction(this.num - num*this.den, this.den);
    }
    public Fraction mul(int num){
        return new Fraction(this.num * num, this.den);
    }
    public Fraction div(int num){
        return new Fraction(this.num, this.num * num);
    }
    @Override
    public String toString() {
        return num + "/" + den;
    }
}
