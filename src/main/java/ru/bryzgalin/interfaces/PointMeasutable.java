package ru.bryzgalin.interfaces;

import ru.bryzgalin.mathematical.Point;

public interface PointMeasutable<T extends Point>{
    public float distanceTo(T point);
}
