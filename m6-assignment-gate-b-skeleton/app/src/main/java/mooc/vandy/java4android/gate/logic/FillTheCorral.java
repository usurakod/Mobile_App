package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to fill the corral with snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class FillTheCorral {
    /**
     * Reference to the OutputInterface.
     */
    private OutputInterface mOut;

    /**
     * Constructor initializes the field.
     */
    FillTheCorral(OutputInterface out) {
        mOut = out;
    }

    // TODO -- Fill your code in here
    public void setCorralGates(Gate[] gates,Random rand){
        boolean InOut;
        for(int i=0;i<gates.length;i++){
            int randomGate = rand.nextInt(2)-1;
            gates[i].setSwing(randomGate);
        }
    }
    public boolean anyCorralAvailable(Gate[] coral) {
            for (int i = 0; i < coral.length; i++) {
                if (coral[i].getSwingDirection() == coral[i].IN){
                    return true;
                }
            }
        return false;
    }
    public void corralSnails(Gate[] coral, Random Rand){
        int count = 5;
        int snail = Rand.nextInt(5);
        int attempt = 1;
        do {
            int gateNum = Rand.nextInt(3) ;
            mOut.println(snail +" are trying to move through corral "+coral[gateNum]);
            count += coral[gateNum].thru(snail);
            snail = Rand.nextInt(count);
            attempt++;
            mOut.println(snail +" are trying to move through corral "+coral[gateNum]);
        }while(count == 0);
        mOut.println("It took "+ attempt +" attempts to corral all of the snails.");
        //return attempt;
    }
}
