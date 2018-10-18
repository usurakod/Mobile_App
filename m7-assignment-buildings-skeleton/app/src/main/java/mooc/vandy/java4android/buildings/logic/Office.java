package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office 
       extends Building {


    private String mBusinessName;
    private int mPartkingSpaces;
    private static int sTotalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String mBusinnessName) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = mBusinnessName;
        setLength(length);
        setWidth(width);
        setLotLength(lotLength);
        setLotWidth(width);

        int buildingSize = calcBuildingArea();
        int lotSize = calcLotArea();
        mBusinnessName =null;
        mPartkingSpaces = 0;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String mBusinnessName, int mPartkingSpaces) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = mBusinnessName;
        this.mPartkingSpaces = mPartkingSpaces;
        sTotalOffices++;
    }

    public String getBusinessName() {
        return mBusinessName;
    }

    public int getParkingSpaces() {
        return mPartkingSpaces;
    }

    public void setBusinessName(String mBusinnessName) {
        this.mBusinessName = mBusinnessName;
    }

    public void setParkingSpaces(int mPartkingSpaces) {
        this.mPartkingSpaces = mPartkingSpaces;
    }

    @Override
    public String toString() {
        if (mBusinessName == null) {
            return (super.toString() + "unoccupied"+" (total offices: "+sTotalOffices+")");
        }
        return (super.toString() + " ;" + mBusinessName);
    }

    public boolean equals(Office O){
        if(this.calcBuildingArea() == O.calcBuildingArea() && this.getParkingSpaces() == O.getParkingSpaces()){
            return true;
        }
        return false;
    }
}
