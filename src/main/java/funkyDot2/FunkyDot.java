package funkyDot2;

import misc.Time;

public class FunkyDot{
    private Integer x = null;
    private Integer y = null;
    private Integer z = null;
    private Time timestamp = null;
    private String color = null;

    public static class Builder{
        private Integer x = null;
        private Integer y = null;
        private Integer z = null;
        private Time timestamp = null;
        private String color = null;

        public Builder addX(int x) {
            this.x = x;
            return this;
        }

        public Builder addY(int y) {
            this.y = y;
            return this;
        }

        public Builder addZ(int z) {
            this.z = z;
            return this;
        }

        public Builder addTimestamp(Time timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder addColor(String color) {
            this.color = color;
            return this;
        }

        public FunkyDot build() {
            return new FunkyDot(this);
        }
    }

    public FunkyDot(Builder builder) {
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
        this.timestamp = builder.timestamp;
        this.color = builder.color;
    }

    public Integer getX() {
        if(x!=null)return (int)x;
        return 0;
    }

    public Integer getY() {
        if(y!=null)return (int)y;
        return 0;
    }

    public Integer getZ() {
        if(z!=null)return (int)z;
        return 0;
    }

    public Time getTimestamp() {
        if (timestamp!=null) return new Time(timestamp.getInt());
        return null;
    }

    public String getColor() {
        if (color != null) {
            return new String(color);
        }
        return null;
    }

    @Override
    public String toString() {
        String str = "FunkyDot{";
        if(x != null) str+="x=" + x + ", ";
        if(y != null) str+="y=" + y + ", ";
        if(z != null) str+="z=" + z + ", ";
        if(timestamp != null) str+="[" + timestamp +"], ";
        if(color != null) str+=" color=" + color;
        str+="}";
        return str;
    }
}
