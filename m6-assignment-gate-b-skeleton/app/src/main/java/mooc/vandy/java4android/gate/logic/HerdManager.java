package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Constructor initializes the fields.
     */
    public static final int HERD = 24;
    public int snailsInPen = HERD;
    public int snailsInPasture = 0;
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }
    // TODO -- Fill your code in here
    public void simulateHerd(Random Rand){
        for(int i=0;i<MAX_ITERATIONS;i++){
            int randomGate = Rand.nextInt(2)-1;
            int noOfSnails = Rand.nextInt(24)+1;

           /* if(mEastGate.open(Gate.OUT) && snailsInPasture == 0){
                snailsInPasture = randomSnails;
                snailsInPen = HERD - snailsInPasture;
                mOut.println(" There are currently "+ snailsInPen +" snails in the pen and "+ snailsInPasture +" snails in the pasture");
            }
            else if(mWestGate.open(Gate.IN) && (randomSnails>snailsInPasture)){
                snailsInPen = randomSnails;
                snailsInPasture = HERD - snailsInPen;
            }
            else {
                if (randomGate == -1 && !(randomSnails > snailsInPen)) {
                    snailsInPasture = randomSnails;
                    snailsInPen = HERD - snailsInPasture;
                } else if (randomGate == 1 && !(randomSnails > snailsInPasture)) {
                    snailsInPen = randomSnails;
                    snailsInPasture = HERD - snailsInPen;
                }
            }*/
            mOut.println("There are currently "+ snailsInPen +" snails in the pen and "+ snailsInPasture +" snails in the pasture");
           if(snailsInPen == HERD){
               noOfSnails = Rand.nextInt(HERD)+1;
               mEastGate.thru(noOfSnails);
               snailsInPen -= noOfSnails;
               snailsInPasture += noOfSnails;
           }
           else if(snailsInPasture == HERD){
               noOfSnails = Rand.nextInt(HERD)+1;
               mWestGate.thru(noOfSnails);
               snailsInPen += noOfSnails;
               snailsInPasture -= noOfSnails;
           }
           else {
               if (Rand.nextBoolean()) {
                   noOfSnails = Rand.nextInt(snailsInPen) + 1;
                   mEastGate.thru(noOfSnails);
                   snailsInPen -= noOfSnails;
                   snailsInPasture += noOfSnails;
               } else {
                   noOfSnails = Rand.nextInt(snailsInPasture) + 1;
                   mWestGate.thru(noOfSnails);
                   snailsInPen += noOfSnails;
                   snailsInPasture -= noOfSnails;
               }
           }
        }
        mOut.println("There are currently "+ snailsInPen +" snails in the pen and "+ snailsInPasture +" snails in the pasture");
    }
}
