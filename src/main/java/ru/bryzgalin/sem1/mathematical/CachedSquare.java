package ru.bryzgalin.sem1.mathematical;

public class CachedSquare extends Square {
    double cachedArea = -1;
    Square sq;
    public CachedSquare(Square sq) {
        super(sq.getA(), sq.getSide());
        this.sq = sq;
    }

    @Override
    public void setSide(int side) {
        this.cachedArea = -1;
        sq.setSide(side);
    }

    @Override
    public double square() {
        if (this.cachedArea > 0) return this.cachedArea;
        this.cachedArea = sq.square();
        return this.cachedArea;
    }
}
