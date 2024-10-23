import lombok.Setter;

public class Gun {
    protected final int maxCap;
    @Setter
    protected int currCap;

    public Gun(int maxCap, int currCap){
        this.maxCap = maxCap;
        setCurrCap(currCap);
    }
    public Gun(int maxCap){
        this(maxCap,maxCap);
    }
    public int getCurrCap() {
        return currCap;
    }

    public int getMaxCap() {
        return maxCap;
    }

    public boolean isLoaded() {
        return (getCurrCap()!=0);
    }

    public int reload(int ammoCount){
        if (ammoCount<0){throw new IllegalArgumentException("ammoCount cant be less than zero");}
        int ammoToAdd = maxCap-getCurrCap();
        setCurrCap(getCurrCap()+ammoToAdd);
        return ammoCount-ammoToAdd;
    }

    public int unload(){
        int ammoToExtract = getCurrCap();
        setCurrCap(0);
        return ammoToExtract;
    }
    public String shoot(){
        if(getCurrCap()>0){
            setCurrCap(getCurrCap()-1);
            return "boom ";
        } else {
            return "click ";
        }
    }
    public String shoot(int shots){
        StringBuilder shootStr = new StringBuilder();
        for (int i = 0; i < shots; i++) {
            shootStr.append(shoot());
            if(shootStr.equals("click ")){
                return shootStr.toString();
            }
        }
        return shootStr.toString();
    }
}