package ru.bryzgalin.sem1.weaponry;

public class AutoRifle extends Pistol {
     private int RoundsPerSecond;

     public AutoRifle(int maxCap, int RoundsPerSecond) {
          super(maxCap,maxCap);
          this.RoundsPerSecond = RoundsPerSecond;
     }
     public AutoRifle(int maxCap) {
          this(maxCap, maxCap/2);
     }
     public AutoRifle(){
          this(30,30);
     }
     public String shootStr(){
          return super.shootStr(RoundsPerSecond);
     }
     public String shootStrContiniously(int seconds){
          return super.shootStr(RoundsPerSecond*seconds);
     }
}