package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House extends Building {
       
    // TODO - Put your code here.
    private String mOwner;
    private boolean mPool;


    public House(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
    }
    public House(int length, int width, int lotLength, int lotWidth, String Owner) {
        super(length, width, lotLength, lotWidth);
        this.mOwner = Owner;
    }
    public House(int length, int width, int lotLength, int lotWidth, Boolean pool) {
        super(length, width, lotLength, lotWidth);
        this.mPool = pool;
    }
    public House(int length, int width, int lotLength, int lotWidth, String Owner, Boolean pool){
        super(length,width,lotLength,lotWidth);
        this.mPool = pool;
        this.mOwner = Owner;
    }

    public String getOwner() {
        return mOwner;
    }

    public void setOwner(String mOwner) {
        this.mOwner = mOwner;
    }

    public boolean hasPool(){
        if(!mPool){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        int LotArea = calcLotArea();
        int BuildArea = calcBuildingArea();
        if(LotArea > BuildArea){
            return ("Owner: "+mOwner+"; has a big open space");
        }
        return super.toString();
    }

    public void setPool(boolean mPool) {
        this.mPool = mPool;
    }

    public boolean equals(House h){
       if( this.calcBuildingArea() == h.calcBuildingArea() && this.mPool == h.mPool){
           return true;
       }
       return false;
    }

}

