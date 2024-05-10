package com.rdsinfor.capacitor.plugin.checkvpn;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.util.Log;

import com.getcapacitor.JSObject;
import com.getcapacitor.PermissionState;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.Permission;
import com.getcapacitor.annotation.PermissionCallback;

@CapacitorPlugin(name = "CheckVpn", 
permissions = {
    @Permission(
            strings = { Manifest.permission.ACCESS_NETWORK_STATE },
            alias  = "networkState"
    )
})

public class CheckVpnPlugin extends Plugin {
    private CheckVpn implementation = new CheckVpn();
    private static final int API_VERSION = Build.VERSION.SDK_INT;
    private CheckVpn vpnStatusChecker;

    @Override
    public void load() {
        super.load();
        this.vpnStatusChecker = new CheckVpn();
        this.vpnStatusChecker.load(this.bridge);
    }

    @PluginMethod
    public void getVpnStatus(PluginCall call) {
        if (API_VERSION >= 23 && getPermissionState("networkState") != PermissionState.GRANTED) {
            requestPermissionForAlias("networkState", call, "accessNetworkState");
        } else {
            this.vpnStatusChecker.getVpnStatus(call);
        }
    }

    @PermissionCallback
    private void accessNetworkState(PluginCall call) {
        if (getPermissionState("network") == PermissionState.GRANTED) {
            if (call.getMethodName().equals("getVpnStatus")) {
                this.vpnStatusChecker.getVpnStatus(call);
            }
        } else {
            call.reject("User denied permission for ACCESS_NETWORK_STATE");
        }
    }

}
