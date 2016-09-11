package com.example.zhang.app2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by zhang on 2016/9/11.
 */
public class BootCompleteReciver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"boot in kernel start",Toast.LENGTH_SHORT).show();
    }
}
