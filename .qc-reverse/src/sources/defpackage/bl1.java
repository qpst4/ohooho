package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bl1 implements ServiceConnection {
    public final sp1 a;
    public final /* synthetic */ af b;

    public /* synthetic */ bl1(af afVar, sp1 sp1Var) {
        this.b = afVar;
        this.a = sp1Var;
    }

    public final void a() {
        synchronized (this.b.a) {
            try {
                if (this.b.b == 3) {
                    return;
                }
                ((xg) this.a.c).d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        boolean z;
        pn1.g("BillingClient", "Billing service died.");
        try {
            af afVar = this.b;
            synchronized (afVar.a) {
                z = true;
                if (afVar.b != 1) {
                    z = false;
                }
            }
            pn0 pn0Var = this.b.g;
            if (z) {
                rq1 rq1VarR = sq1.r();
                rq1VarR.c();
                sq1.q((sq1) rq1VarR.c, 6);
                xq1 xq1VarS = yq1.s();
                xq1VarS.d(122);
                rq1VarR.d(xq1VarS);
                pn0Var.b0((sq1) rq1VarR.b());
            } else {
                pn0Var.d0(ar1.o());
            }
        } catch (Throwable th) {
            pn1.h("BillingClient", "Unable to log.", th);
        }
        synchronized (this.b.a) {
            if (this.b.b != 3 && this.b.b != 0) {
                this.b.o(0);
                this.b.p();
                ((xg) this.a.c).d();
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        sk1 pk1Var;
        pn1.f("BillingClient", "Billing service connected.");
        synchronized (this.b.a) {
            try {
                if (this.b.b == 3) {
                    return;
                }
                af afVar = this.b;
                int i = qk1.c;
                if (iBinder == null) {
                    pk1Var = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.android.vending.billing.IInAppBillingService");
                    pk1Var = iInterfaceQueryLocalInterface instanceof sk1 ? (sk1) iInterfaceQueryLocalInterface : new pk1(iBinder, "com.android.vending.billing.IInAppBillingService", 1);
                }
                afVar.h = pk1Var;
                af afVar2 = this.b;
                if (af.h(new Callable() { // from class: zk1
                    /* JADX WARN: Removed duplicated region for block: B:135:0x01d9  */
                    /* JADX WARN: Removed duplicated region for block: B:136:0x01de  */
                    @Override // java.util.concurrent.Callable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object call() {
                        /*
                            Method dump skipped, instruction units count: 672
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: defpackage.zk1.call():java.lang.Object");
                    }
                }, 30000L, new nc(26, this), afVar2.u(), afVar2.l()) == null) {
                    af afVar3 = this.b;
                    afVar3.w(25, 6, afVar3.i());
                    a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        boolean z;
        pn1.g("BillingClient", "Billing service disconnected.");
        try {
            af afVar = this.b;
            synchronized (afVar.a) {
                z = true;
                if (afVar.b != 1) {
                    z = false;
                }
            }
            pn0 pn0Var = this.b.g;
            if (z) {
                rq1 rq1VarR = sq1.r();
                rq1VarR.c();
                sq1.q((sq1) rq1VarR.c, 6);
                xq1 xq1VarS = yq1.s();
                xq1VarS.d(121);
                rq1VarR.d(xq1VarS);
                pn0Var.b0((sq1) rq1VarR.b());
            } else {
                pn0Var.f0(pr1.o());
            }
        } catch (Throwable th) {
            pn1.h("BillingClient", "Unable to log.", th);
        }
        synchronized (this.b.a) {
            try {
                if (this.b.b == 3) {
                    return;
                }
                this.b.o(0);
                ((xg) this.a.c).d();
            } finally {
            }
        }
    }
}
