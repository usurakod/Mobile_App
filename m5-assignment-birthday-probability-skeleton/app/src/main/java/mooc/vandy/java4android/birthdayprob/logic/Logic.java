package mooc.vandy.java4android.birthdayprob.logic;

import java.util.Random;

import mooc.vandy.java4android.birthdayprob.ui.OutputInterface;

/**
 * This is where the logic of this App is centralized for this assignment.
 * <p>
 * The assignments are designed this way to simplify your early Android interactions.
 * Designing the assignments this way allows you to first learn key 'Java' features without
 * having to beforehand learn the complexities of Android.
 *
 */
public class Logic 
       implements LogicInterface {
    /**
     * This is a String to be used in Logging (if/when you decide you
     * need it for debugging).
     */
    public static final String TAG =
        Logic.class.getName();

    /**
     * This is the variable that stores our OutputInterface instance.
     * <p>
     * This is how we will interact with the User Interface
     * [MainActivity.java].
     * <p>
     * It is called 'mOut' because it is where we 'out-put' our
     * results. (It is also the 'in-put' from where we get values
     * from, but it only needs 1 name, and 'mOut' is good enough).
    */
    OutputInterface mOut;

    /**
     * This is the constructor of this class.
     * <p>
     * It assigns the passed in [MainActivity] instance
     * (which implements [OutputInterface]) to 'out'
     */
    public Logic(OutputInterface out){
        mOut = out;
    }

    /**
     * This is the method that will (eventually) get called when the
     * on-screen button labelled 'Process...' is pressed.
     */
    public void process() {
        int groupSize = mOut.getSize();
        int simulationCount = mOut.getCount();

        if (groupSize < 2 || groupSize > 365) {
            mOut.makeAlertToast("Group Size must be in the range 2-365.");
            return;
        }
        if (simulationCount <= 0) {
            mOut.makeAlertToast("Simulation Count must be positive.");
            return;
        }

        double percent = calculate(groupSize, simulationCount);

        // report results
        mOut.println("For a group of " + groupSize + " people, the percentage");
        mOut.println("of times that two people share the same birthday is");
        mOut.println(String.format("%.2f%% of the time.", percent));

    }

    /**
     * This is the method that actually does the calculations.
     * <p>
     * We provide you this method that way we can test it with unit testing.
     */
    public double calculate(int size, int count) {
        // TODO -- add your code here
        int numOfSameBday = 0;
        int seedVal = 1;
        for(int i=1;i<=count;i++){
            numOfSameBday += countingSameBirthday(size,seedVal);
            seedVal ++;
        }
        //this returns the percentage of simulations which have same birthday
        return (numOfSameBday*100.00)/count;
    }
    //generating the random numbers within 365 days
    public int countingSameBirthday(int size,int seedVal){
        Random rndNumbers = new Random();
        rndNumbers.setSeed(seedVal);
        int [] BirthdayList = new int[size];
        for(int j=0;j<size;j++) {
            int birthday = rndNumbers.nextInt(365);
            BirthdayList[j]= birthday;
        }
        /* comparing each generated birthday with previously generated,
         if we get the match then return 1 to increase the count of same birtday */
        for(int count=0;count<size;count++){
            for(int compare=count+1;compare<size;compare++){
                if(BirthdayList[count] == BirthdayList[compare]){
                    return 1;
                }
            }
        }
        return 0;
    }
}