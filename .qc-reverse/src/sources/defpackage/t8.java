package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationManager;
import android.os.PowerManager;
import android.util.Log;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class t8 extends v8 {
    public final /* synthetic */ int c = 0;
    public final /* synthetic */ y8 d;
    public final Object e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t8(y8 y8Var, Context context) {
        super(y8Var);
        this.d = y8Var;
        this.e = (PowerManager) context.getApplicationContext().getSystemService("power");
    }

    @Override // defpackage.v8
    public final IntentFilter e() {
        switch (this.c) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
                return intentFilter;
            default:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.TIME_SET");
                intentFilter2.addAction("android.intent.action.TIMEZONE_CHANGED");
                intentFilter2.addAction("android.intent.action.TIME_TICK");
                return intentFilter2;
        }
    }

    @Override // defpackage.v8
    public final int f() {
        Location location;
        boolean z;
        long j;
        int i = this.c;
        Object obj = this.e;
        switch (i) {
            case 0:
                if (!o8.a((PowerManager) obj)) {
                    break;
                }
                break;
            default:
                ra raVar = (ra) obj;
                cb1 cb1Var = (cb1) raVar.d;
                LocationManager locationManager = (LocationManager) raVar.c;
                if (cb1Var.b > System.currentTimeMillis()) {
                    z = cb1Var.a;
                } else {
                    Context context = (Context) raVar.e;
                    Location lastKnownLocation = null;
                    if (yb0.d(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        try {
                        } catch (Exception e) {
                            Log.d("TwilightManager", "Failed to get last known location", e);
                        }
                        Location lastKnownLocation2 = locationManager.isProviderEnabled("network") ? locationManager.getLastKnownLocation("network") : null;
                        location = lastKnownLocation2;
                    } else {
                        location = null;
                    }
                    if (yb0.d(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                        try {
                            if (locationManager.isProviderEnabled("gps")) {
                                lastKnownLocation = locationManager.getLastKnownLocation("gps");
                            }
                        } catch (Exception e2) {
                            Log.d("TwilightManager", "Failed to get last known location", e2);
                        }
                    }
                    if (lastKnownLocation == null || location == null ? lastKnownLocation != null : lastKnownLocation.getTime() > location.getTime()) {
                        location = lastKnownLocation;
                    }
                    if (location != null) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (bb1.d == null) {
                            bb1.d = new bb1();
                        }
                        bb1 bb1Var = bb1.d;
                        bb1Var.a(jCurrentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
                        bb1Var.a(jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
                        z = bb1Var.c == 1;
                        long j2 = bb1Var.b;
                        long j3 = bb1Var.a;
                        bb1Var.a(86400000 + jCurrentTimeMillis, location.getLatitude(), location.getLongitude());
                        long j4 = bb1Var.b;
                        if (j2 == -1 || j3 == -1) {
                            j = jCurrentTimeMillis + 43200000;
                        } else {
                            if (jCurrentTimeMillis > j3) {
                                j2 = j4;
                            } else if (jCurrentTimeMillis > j2) {
                                j2 = j3;
                            }
                            j = j2 + 60000;
                        }
                        cb1Var.a = z;
                        cb1Var.b = j;
                    } else {
                        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
                        int i2 = Calendar.getInstance().get(11);
                        if (i2 < 6 || i2 >= 22) {
                            z = true;
                        }
                    }
                }
                if (!z) {
                    break;
                }
                break;
        }
        return 1;
    }

    @Override // defpackage.v8
    public final void h() {
        int i = this.c;
        y8 y8Var = this.d;
        switch (i) {
            case 0:
                y8Var.m(true, true);
                break;
            default:
                y8Var.m(true, true);
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t8(y8 y8Var, ra raVar) {
        super(y8Var);
        this.d = y8Var;
        this.e = raVar;
    }
}
