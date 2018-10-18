package mooc.vandy.java4android.buildings.logic;

/**
 * This is the cottage class file.  It is a subclass of House.
 */
public class Cottage extends House {
    private boolean mSecondFloor;

    public Cottage(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
    }

    public Cottage(int dimension, int lotLength, int lotWidth, String Owner, boolean mSecondFloor) {
        super(dimension/2, dimension/2, lotLength, lotWidth, Owner);
        this.mSecondFloor = mSecondFloor;
    }
    public boolean hasSecondFloor(){
        if(mSecondFloor){
            return true;
        }
        return false;
    }
    @Override
    public String toString() {
        int length = this.getLength();
        int width = this.getWidth();
        if(length == width && mSecondFloor == true) {
            return (super.toString()+";has a Cottage");
        }
        return super.toString();
    }
}

