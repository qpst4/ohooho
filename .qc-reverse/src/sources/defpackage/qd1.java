package defpackage;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class qd1 implements Runnable {
    public final /* synthetic */ vd1 b;
    public final /* synthetic */ hd c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Runnable e;

    public /* synthetic */ qd1(vd1 vd1Var, hd hdVar, int i, Runnable runnable) {
        this.b = vd1Var;
        this.c = hdVar;
        this.d = i;
        this.e = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final hd hdVar = this.c;
        final int i = this.d;
        Runnable runnable = this.e;
        final vd1 vd1Var = this.b;
        dx0 dx0Var = vd1Var.f;
        try {
            try {
                dx0 dx0Var2 = vd1Var.c;
                Objects.requireNonNull(dx0Var2);
                dx0Var.q(new rd1(dx0Var2, 1));
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) vd1Var.a.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                    dx0Var.q(new t31() { // from class: sd1
                        @Override // defpackage.t31
                        public final Object f() {
                            vd1Var.d.P(hdVar, i + 1, false);
                            return null;
                        }
                    });
                } else {
                    vd1Var.a(hdVar, i);
                }
                runnable.run();
            } catch (s31 unused) {
                vd1Var.d.P(hdVar, i + 1, false);
                runnable.run();
            }
        } catch (Throwable th) {
            runnable.run();
            throw th;
        }
    }
}
