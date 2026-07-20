package defpackage;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class h11 implements Handler.Callback {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ h11(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        ComponentName componentName = null;
        switch (this.a) {
            case 0:
                if (message.what == 0) {
                    m0 m0Var = (m0) this.b;
                    if (message.obj == null) {
                        synchronized (m0Var.b) {
                            throw null;
                        }
                    }
                    s1.d();
                }
                return false;
            default:
                int i = message.what;
                if (i != 0) {
                    if (i != 1) {
                        return false;
                    }
                    synchronized (((cs1) this.b).a) {
                        try {
                            yr1 yr1Var = (yr1) message.obj;
                            zr1 zr1Var = (zr1) ((cs1) this.b).a.get(yr1Var);
                            if (zr1Var != null && zr1Var.b == 3) {
                                Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback ".concat(String.valueOf(yr1Var)), new Exception());
                                ComponentName componentName2 = zr1Var.f;
                                if (componentName2 == null) {
                                    yr1Var.getClass();
                                } else {
                                    componentName = componentName2;
                                }
                                if (componentName == null) {
                                    String str = yr1Var.b;
                                    xy0.d(str);
                                    componentName = new ComponentName(str, "unknown");
                                }
                                zr1Var.onServiceDisconnected(componentName);
                            }
                        } finally {
                        }
                        break;
                    }
                } else {
                    synchronized (((cs1) this.b).a) {
                        try {
                            yr1 yr1Var2 = (yr1) message.obj;
                            zr1 zr1Var2 = (zr1) ((cs1) this.b).a.get(yr1Var2);
                            if (zr1Var2 != null && zr1Var2.a.isEmpty()) {
                                if (zr1Var2.c) {
                                    zr1Var2.g.c.removeMessages(1, zr1Var2.e);
                                    cs1 cs1Var = zr1Var2.g;
                                    cs1Var.d.k(cs1Var.b, zr1Var2);
                                    zr1Var2.c = false;
                                    zr1Var2.b = 2;
                                }
                                ((cs1) this.b).a.remove(yr1Var2);
                            }
                        } finally {
                        }
                        break;
                    }
                }
                return true;
        }
    }
}
