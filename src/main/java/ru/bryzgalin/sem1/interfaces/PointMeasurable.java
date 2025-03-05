package ru.bryzgalin.sem1.interfaces;

import ru.bryzgalin.sem1.mathematical.Point;

public interface PointMeasurable<T extends Point>{
    public float distanceTo(T point);
}
