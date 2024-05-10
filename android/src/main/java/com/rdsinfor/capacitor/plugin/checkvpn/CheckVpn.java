package com.rdsinfor.capacitor.plugin.checkvpn;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

import com.getcapacitor.Bridge;
import com.getcapacitor.JSObject;
import com.getcapacitor.PluginCall;

public class CheckVpn {
    private ConnectivityManager connectivityManager;
    public void load(Bridge bridge) {
        this.connectivityManager = (ConnectivityManager) bridge.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public void getVpnStatus(PluginCall call) {
        Network activeNetwork = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            activeNetwork = connectivityManager.getActiveNetwork();
        }
        NetworkCapabilities caps = connectivityManager.getNetworkCapabilities(activeNetwork);
        boolean isVpnActive = caps != null && caps.hasTransport(NetworkCapabilities.TRANSPORT_VPN);

        JSObject result = new JSObject();
        result.put("vpnStatus", isVpnActive ? "active" : "inactive");
        call.resolve(result);
    }

}
