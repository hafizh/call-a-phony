package app.callaphony.com.callaphony;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by hhasanov on 05/11/14.
 */
public class PhoneCallReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        final String stateStr = intent.getExtras().getString(TelephonyManager.EXTRA_STATE);
        final String number = intent.getExtras().getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
        if(stateStr.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            Toast.makeText(context, number+" calling", Toast.LENGTH_LONG).show();
        }
        else if(stateStr.equals(TelephonyManager.EXTRA_STATE_IDLE)){
            Toast.makeText(context, "Idle. Wait for call.", Toast.LENGTH_LONG).show();
        }
    }
}
