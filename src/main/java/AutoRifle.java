public class AutoRifle extends Gun{
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
     public String shoot(){
          return super.shoot(RoundsPerSecond);
     }
     public String shootContiniously(int seconds){
          return super.shoot(RoundsPerSecond*seconds);
     }
}
