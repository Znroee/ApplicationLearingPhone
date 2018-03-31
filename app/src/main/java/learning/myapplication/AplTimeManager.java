package learning.myapplication;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by roeez on 12/28/2017.
 */


public class AplTimeManager
{

//region Timer manager verbs:

    private boolean timerExpandFlag = false;
    private Timer timer;
    private TimerTask mTimerTask;
//endregion

//region Timer connection:

    public boolean StartTimer(int iTimePeriod)
    {
        timerExpandFlag = false;
        timer = new Timer();
        timer.schedule(new timerTask(), iTimePeriod*AplCommon.SecPeriod, 1000);
        while(!timerExpandFlag);
        StopTimerThread();
        return true;
    }

    public void StopTimerThread()
    {
        timer.cancel();
        timerExpandFlag = false;
    }

    class timerTask extends TimerTask
    {
        @Override
        public void run()
        {
            timerExpandFlag = true;
        }
    };
//endregion

}