public class Pistol {
    int bulletCount;
    public Pistol(int BulletCount){
        this.bulletCount = BulletCount;
    }
    public Pistol(){
        this(5);
    }
    public String shootString(){
        if(bulletCount > 0){
            bulletCount--;
            return "boom";
        }
        return "click";
    }

    @Override
    public String toString() {
        return "Pistol{" +
                "bulletCount=" + bulletCount +
                '}';
    }
}
