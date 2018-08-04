package com.app.imei;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Serializable {
	
	

    TextView mTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTxt = findViewById(R.id.imei);
        mTxt.setText(getDeviceIMEI());

    }

    @SuppressLint("MissingPermission")
    public String getDeviceIMEI() {

        System.out.println("innnnnnnn Gettttttt");
        String deviceUniqueIdentifier = null;
        TelephonyManager tm = (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        if (null != tm) {
            deviceUniqueIdentifier = tm.getDeviceId();
        }
        if (null == deviceUniqueIdentifier || 0 == deviceUniqueIdentifier.length()) {
            deviceUniqueIdentifier = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        System.out.println("innnnnnnn Complete   ");
        return deviceUniqueIdentifier;
    }
}
