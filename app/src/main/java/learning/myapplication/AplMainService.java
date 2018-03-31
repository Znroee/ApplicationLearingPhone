package learning.myapplication;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;

/**
 * Created by roeez on 12/28/2017.
 */

public class AplMainService extends Service
{

//region service variables:

    // Games configuration:

    // Apl service state machine verbs:
    private int TimePeriodInGame = 0;
    private static AplCommon.APL_STATE mBtStateCurrent = AplCommon.APL_STATE.APL_START;

    // Broadcast service-activity verbs:
    public AplMainServiceListener myServiceReceiver;
//endregion

//region Service main functions:

    @Override
    public void onCreate()
    {
        myServiceReceiver = new AplMainServiceListener();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(AplCommon.ACTION_MSG_TO_SERVICE);
    }

    @Override
    public void onDestroy()
    {
        unregisterReceiver(myServiceReceiver);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        AplFsmThread.run();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }

//endregion

//region Broadcast from activity:

    public static class AplMainServiceListener extends BroadcastReceiver
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
//            if (intent.getAction().contains(CommonLib.ToServiceBroadcastAction))
//            {
//                String mStreamWord = intent.getStringExtra(CommonLib.BroadcastStringKey);
//                if (mStreamWord.contains(CommonLib.ToServiceActivityTriggerCommand))
//                {
//                    Log.d(AplCommon.APL_LOG_RUN, "BT application start");
//
//                }
//
//                else
//                {
//
//                }
//
//            }
        }
    }
//endregion

//region Application main thread
Thread AplFsmThread = new Thread()
{
    @Override
    public void run()
    {
        if (Looper.myLooper() == null)
        {
            Looper.prepare();
        }
        try
        {
            super.run();
            while (!AplFsmThread.isInterrupted())
            {
                switch (mBtStateCurrent)
                {
                    // **************************************************************************
                    case APL_START:
                        mBtStateCurrent = AplCommon.APL_STATE.APL_GET_GAME_CONFIGURATION;
                        break;

                    case APL_GET_GAME_CONFIGURATION:
                        mBtStateCurrent = AplCommon.APL_STATE.APL_START_TIMER;
                        break;

                    case APL_LOAD_GAME_ACTIVITY:
                        break;

                    case APL_START_TIMER:
                        break;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
};
//endregion

}
