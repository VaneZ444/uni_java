public class Pistol{
    public final int maxCap;
    private int currCap;

    public Pistol(int maxCap, int currCap){
        this.maxCap = maxCap;
        setCurrCap(currCap);
    }
    public Pistol(int maxCap){
        this(maxCap,maxCap);
    }
    public int getCurrCap() {
        return currCap;
    }

    public void setCurrCap(int currCap) {
        this.currCap = currCap;
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
        }
        return shootStr.toString();
    }
}