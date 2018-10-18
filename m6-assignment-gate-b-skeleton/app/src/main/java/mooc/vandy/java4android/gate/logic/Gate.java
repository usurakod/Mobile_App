package mooc.vandy.java4android.gate.logic;

/**
 * This file defines the Gate class.
 */
public class Gate {
    // TODO -- Fill in your code here
    public static final int OUT = -1;
    public static final int IN = 1;
    public static final int CLOSED = 0;
    private int mSwing;

    public Gate(){
        mSwing = CLOSED;
    }
    public int getSwingDirection(){
        return this.mSwing;
    }
    public boolean setSwing(int validDirection){
        this.mSwing = validDirection;
        /*this code is to set the direction */
        if(mSwing == this.IN || mSwing == this.OUT){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean open(int direction){
        //  this snippet is to check the valid condition to open the pen
        if(direction == this.IN || direction == this.OUT) {
            setSwing(direction);
            return true;
        }
        return false;
    }
    public void close(){
        //to close the pen
        this.mSwing = this.CLOSED;
    }
    public int thru(int count){
        //to count the snails in or out
        if(mSwing == this.IN){
            return count;
        }
        else if(mSwing == this.OUT){
            return -count;
        }
        else if(mSwing == this.CLOSED){
            return 0;
        }
        return count;
    }
    public String toString(){
        // to print the instance of the gate class
        String status=null;
        String action=null;
        if(mSwing == this.IN || mSwing == this.OUT) {
            //to print according to the snail is in or out
            if (mSwing == this.IN) {
                status = "open";
                action = "enter";
            } else if (mSwing == this.OUT) {
                status = "open";
                action = "exit";
            }
            return ("This gate is " + status + " and swings to " + action + " the pen only");
        }
        else if(mSwing == this.CLOSED){
            status = "closed";
            return("This gate is "+status);

        }
        //return invalid when wrong swing direction
        return ("This gate has an invalid swing direction");
    }


}
