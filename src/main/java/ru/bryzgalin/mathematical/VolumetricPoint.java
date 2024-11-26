package ru.bryzgalin.mathematical;

import lombok.ToString;
import ru.bryzgalin.interfaces.PointMeasutable;

import java.util.Objects;

@ToString
public class VolumetricPoint extends Point implements PointMeasutable {
    int z;
    public VolumetricPoint(VolumetricPoint cloned) {
        this(cloned.x,cloned.y,cloned.z);
    }
    public VolumetricPoint(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    @Override
    public float distanceTo(Point point) {
        if (point instanceof VolumetricPoint) {
            VolumetricPoint p = (VolumetricPoint) point;
            return (float) Math.sqrt((x) * (p.x) + (y) * (p.y)) + (z) * (p.z);
        }
        return (float) Math.sqrt((x) * (point.x) + (y) * (point.y));
    }
}