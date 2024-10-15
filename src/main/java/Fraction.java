public record Fraction(int num, int den) {
    public Fraction(int num, int den){
        if(den <= 0){
            throw new IllegalArgumentException("Denuminator cannot be negative or zero");
        }
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
        return this.sum(new Fraction(num,1));
    }
    public Fraction sub(int num) {
        return this.sub(new Fraction(num,1));
    }
    public Fraction mul(int num){
        return this.mul(new Fraction(num,1));
    }
    public Fraction div(int num){
        return this.div(new Fraction(num,1));
    }
    @Override
    public String toString() {
        return num + "/" + den;
    }
}