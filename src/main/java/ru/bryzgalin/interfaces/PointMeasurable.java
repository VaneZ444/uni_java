package ru.bryzgalin.interfaces;

import ru.bryzgalin.mathematical.Point;

public interface PointMeasurable<T extends Point>{
    public float distanceTo(T point);
}
