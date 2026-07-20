package defpackage;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cs1 {
    public static final Object g = new Object();
    public static cs1 h;
    public static HandlerThread i;
    public final HashMap a = new HashMap();
    public final Context b;
    public volatile kk1 c;
    public final c70 d;
    public final long e;
    public final long f;

    public cs1(Context context, Looper looper) {
        h11 h11Var = new h11(1, this);
        this.b = context.getApplicationContext();
        kk1 kk1Var = new kk1(looper, h11Var);
        Looper.getMainLooper();
        this.c = kk1Var;
        if (c70.e == null) {
            synchronized (c70.d) {
                try {
                    if (c70.e == null) {
                        c70.e = new c70();
                    }
                } finally {
                }
            }
        }
        c70 c70Var = c70.e;
        xy0.d(c70Var);
        this.d = c70Var;
        this.e = 5000L;
        this.f = 300000L;
    }

    public final void a(String str, ServiceConnection serviceConnection, boolean z) {
        yr1 yr1Var = new yr1(str, z);
        xy0.e("ServiceConnection must not be null", serviceConnection);
        synchronized (this.a) {
            try {
                zr1 zr1Var = (zr1) this.a.get(yr1Var);
                if (zr1Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: ".concat(yr1Var.toString()));
                }
                if (!zr1Var.a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=".concat(yr1Var.toString()));
                }
                zr1Var.a.remove(serviceConnection);
                if (zr1Var.a.isEmpty()) {
                    this.c.sendMessageDelayed(this.c.obtainMessage(0, yr1Var), this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean b(yr1 yr1Var, qn1 qn1Var, String str) {
        boolean z;
        synchronized (this.a) {
            try {
                zr1 zr1Var = (zr1) this.a.get(yr1Var);
                if (zr1Var == null) {
                    zr1Var = new zr1(this, yr1Var);
                    zr1Var.a.put(qn1Var, qn1Var);
                    zr1Var.a(str, null);
                    this.a.put(yr1Var, zr1Var);
                } else {
                    this.c.removeMessages(0, yr1Var);
                    if (zr1Var.a.containsKey(qn1Var)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=".concat(yr1Var.toString()));
                    }
                    zr1Var.a.put(qn1Var, qn1Var);
                    int i2 = zr1Var.b;
                    if (i2 == 1) {
                        qn1Var.onServiceConnected(zr1Var.f, zr1Var.d);
                    } else if (i2 == 2) {
                        zr1Var.a(str, null);
                    }
                }
                z = zr1Var.c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }
}
