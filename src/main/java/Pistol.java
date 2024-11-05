import lombok.Getter;

public class Pistol extends Weapon{
    @Getter
    protected final int maxCap;

    public Pistol(int maxCap, int ammo){
        super(ammo);
        this.maxCap = maxCap;
    }

    public Pistol(int maxCap){
        this(maxCap,maxCap);
    }

    public int unload(){
        int CurrCap = 0;
        while (ammo() > 0){
            CurrCap++;
            getAmmo();
        }
        return CurrCap;
    }

    @Override
    public int load(int ammo) {
        int ammoNeeded= getMaxCap() - ammo();
        if(ammo <= ammoNeeded){
            super.load(ammo);
            return 0;
        }
        super.load(ammoNeeded);
        return ammo - ammoNeeded;
    }

    public void shoot(){
        getAmmo();
    }
    public String shootStr(int amountOfShots){
        String str = "";
        for (int i = 0; i < amountOfShots; i++) {
            if (ammo() > 0) {
                str += "pew ";
                getAmmo();
            } else {
                str += "click ";
            }
        }
        return str;
    }
    @Override
    public String toString() {
        return "Pistol{" +
                "maxCap=" + maxCap + ", ammo=" + super.ammo() + '}';
    }
}
