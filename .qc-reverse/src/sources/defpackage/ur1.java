package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ur1 extends BroadcastReceiver {
    public boolean a;
    public final boolean b;
    public final /* synthetic */ o90 c;

    public ur1(o90 o90Var, boolean z) {
        this.c = o90Var;
        this.b = z;
    }

    public final synchronized void a(Context context, IntentFilter intentFilter) {
        try {
            if (this.a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this, intentFilter, true != this.b ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Context context) {
        if (!this.a) {
            pn1.g("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.a = false;
        }
    }

    public final void c(Bundle bundle, df dfVar, int i) {
        try {
            byte[] byteArray = bundle.getByteArray("FAILURE_LOGGING_PAYLOAD");
            xl1 xl1Var = (xl1) this.c.e;
            if (byteArray == null) {
                ((pn0) xl1Var).b0(vl1.b(23, i, dfVar));
                return;
            }
            byte[] byteArray2 = bundle.getByteArray("FAILURE_LOGGING_PAYLOAD");
            int i2 = bp1.a;
            synchronized (bp1.class) {
                int i3 = bp1.a;
                aq1 aq1Var = aq1.c;
                fp1.K();
                int i4 = bp1.a;
            }
            ((pn0) xl1Var).b0(sq1.o(byteArray2, null));
        } catch (Throwable unused) {
            pn1.g("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0109  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onReceive(android.content.Context r11, android.content.Intent r12) {
        /*
            Method dump skipped, instruction units count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ur1.onReceive(android.content.Context, android.content.Intent):void");
    }
}
