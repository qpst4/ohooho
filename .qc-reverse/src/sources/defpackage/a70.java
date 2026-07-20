package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.Status;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a70 implements Handler.Callback {
    public static final Status o = new Status(4, "Sign-out occurred while this API call was in progress.", null, null);
    public static final Status p = new Status(4, "The user must be signed in to make this API call.", null, null);
    public static final Object q = new Object();
    public static a70 r;
    public long a;
    public boolean b;
    public q41 c;
    public gk1 d;
    public final Context e;
    public final w60 f;
    public final pn0 g;
    public final AtomicInteger h;
    public final AtomicInteger i;
    public final ConcurrentHashMap j;
    public final mb k;
    public final mb l;
    public final kk1 m;
    public volatile boolean n;

    public a70(Context context, Looper looper) {
        w60 w60Var = w60.c;
        this.a = 10000L;
        this.b = false;
        this.h = new AtomicInteger(1);
        this.i = new AtomicInteger(0);
        this.j = new ConcurrentHashMap(5, 0.75f, 1);
        this.k = new mb(0);
        this.l = new mb(0);
        this.n = true;
        this.e = context;
        kk1 kk1Var = new kk1(looper, this);
        Looper.getMainLooper();
        this.m = kk1Var;
        this.f = w60Var;
        this.g = new pn0(19);
        PackageManager packageManager = context.getPackageManager();
        if (xy0.k == null) {
            xy0.k = Boolean.valueOf(Build.VERSION.SDK_INT >= 26 && packageManager.hasSystemFeature("android.hardware.type.automotive"));
        }
        if (xy0.k.booleanValue()) {
            this.n = false;
        }
        kk1Var.sendMessage(kk1Var.obtainMessage(6));
    }

    public static Status b(w7 w7Var, xm xmVar) {
        return new Status(17, "API: " + ((String) w7Var.b.d) + " is not available on this device. Connection failed with: " + String.valueOf(xmVar), xmVar.d, xmVar);
    }

    public static a70 d(Context context) {
        a70 a70Var;
        HandlerThread handlerThread;
        synchronized (q) {
            if (r == null) {
                synchronized (cs1.g) {
                    try {
                        handlerThread = cs1.i;
                        if (handlerThread == null) {
                            HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                            cs1.i = handlerThread2;
                            handlerThread2.start();
                            handlerThread = cs1.i;
                        }
                    } finally {
                    }
                }
                Looper looper = handlerThread.getLooper();
                Context applicationContext = context.getApplicationContext();
                Object obj = w60.b;
                r = new a70(applicationContext, looper);
            }
            a70Var = r;
        }
        return a70Var;
    }

    public final boolean a(xm xmVar, int i) {
        boolean zBooleanValue;
        PendingIntent activity;
        Boolean bool;
        w60 w60Var = this.f;
        Context context = this.e;
        w60Var.getClass();
        synchronized (yb0.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = yb0.a;
            if (context2 == null || (bool = yb0.b) == null || context2 != applicationContext) {
                yb0.b = null;
                if (Build.VERSION.SDK_INT >= 26) {
                    yb0.b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
                } else {
                    try {
                        context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                        yb0.b = Boolean.TRUE;
                    } catch (ClassNotFoundException unused) {
                        yb0.b = Boolean.FALSE;
                    }
                }
                yb0.a = applicationContext;
                zBooleanValue = yb0.b.booleanValue();
            } else {
                zBooleanValue = bool.booleanValue();
            }
        }
        if (!zBooleanValue) {
            int i2 = xmVar.c;
            if (i2 == 0 || (activity = xmVar.d) == null) {
                Intent intentA = w60Var.a(i2, context, null);
                activity = intentA != null ? PendingIntent.getActivity(context, 0, intentA, 201326592) : null;
            }
            if (activity != null) {
                int i3 = xmVar.c;
                int i4 = GoogleApiActivity.c;
                Intent intent = new Intent(context, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", activity);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", true);
                w60Var.f(context, i3, PendingIntent.getActivity(context, 0, intent, hk1.a | 134217728));
                return true;
            }
        }
        return false;
    }

    public final mj1 c(gk1 gk1Var) {
        w7 w7Var = gk1Var.e;
        ConcurrentHashMap concurrentHashMap = this.j;
        mj1 mj1Var = (mj1) concurrentHashMap.get(w7Var);
        if (mj1Var == null) {
            mj1Var = new mj1(this, gk1Var);
            concurrentHashMap.put(w7Var, mj1Var);
        }
        if (mj1Var.c.j()) {
            this.l.add(w7Var);
        }
        mj1Var.m();
        return mj1Var;
    }

    public final void e(xm xmVar, int i) {
        if (a(xmVar, i)) {
            return;
        }
        kk1 kk1Var = this.m;
        kk1Var.sendMessage(kk1Var.obtainMessage(5, i, 0, xmVar));
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x011b  */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean handleMessage(android.os.Message r11) {
        /*
            Method dump skipped, instruction units count: 1180
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a70.handleMessage(android.os.Message):boolean");
    }
}
