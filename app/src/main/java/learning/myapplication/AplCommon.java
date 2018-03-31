package learning.myapplication;

/**
 * Created by roeez on 12/28/2017.
 */

public final class AplCommon
{

//region Final (static) verbs:

    // Logs prefix:
    public static final String APL_LOG_RUN = "APL_LOG_RUN";

    // Timer arguments:
    public static final int SecPeriod = 1000;

    // Broadcast Activity to Apl service verbs:
    public static final String ToServiceBroadcastAction = "ToServiceBroadcastAction";
    final static String ACTION_MSG_TO_SERVICE = "MSG_TO_SERVICE";

    // Broadcast Apl service to Activity:

//endregion

//region Enums:

    public enum APL_STATE
    {
        APL_START,
        APL_GET_GAME_CONFIGURATION,
        APL_LOAD_GAME_ACTIVITY,
        APL_START_TIMER,
        APL_GET_STATISTIC,
        APL_NONE,
    }
//endregion

}
