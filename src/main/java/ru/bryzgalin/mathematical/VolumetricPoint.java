package ru.bryzgalin.mathematical;

import lombok.ToString;

@ToString
public class VolumetricPoint extends Point{
    int z;
    public VolumetricPoint(VolumetricPoint cloned) {
        this(cloned.x,cloned.y,cloned.z);
    }
    public VolumetricPoint(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
}
