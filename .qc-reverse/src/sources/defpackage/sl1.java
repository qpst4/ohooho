package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sl1 implements ServiceConnection {
    public final /* synthetic */ ul1 a;

    public /* synthetic */ sl1(ul1 ul1Var) {
        this.a = ul1Var;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        yk1 wk1Var;
        pn1.f("BillingClientTesting", "Billing Override Service connected.");
        ul1 ul1Var = this.a;
        int i = xk1.c;
        if (iBinder == null) {
            wk1Var = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService");
            wk1Var = iInterfaceQueryLocalInterface instanceof yk1 ? (yk1) iInterfaceQueryLocalInterface : new wk1(iBinder, "com.google.android.apps.play.billingtestcompanion.aidl.IBillingOverrideService", 1);
        }
        ul1Var.B = wk1Var;
        this.a.A = 2;
        ul1 ul1Var2 = this.a;
        wq1 wq1VarD = vl1.d(26);
        Objects.requireNonNull(wq1VarD, "ApiSuccess should not be null");
        ul1Var2.g.c0(wq1VarD);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        pn1.g("BillingClientTesting", "Billing Override Service disconnected.");
        this.a.B = null;
        this.a.A = 0;
    }
}
