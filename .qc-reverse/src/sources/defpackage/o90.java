package defpackage;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o90 implements ie {
    public boolean b;
    public Object c;
    public Object d;
    public Object e;
    public Object f = new ur1(this, true);
    public Object g = new ur1(this, false);

    public o90(Context context, sf sfVar, pn0 pn0Var) {
        this.c = context;
        this.d = sfVar;
        this.e = pn0Var;
    }

    public void a(xm xmVar) {
        mj1 mj1Var = (mj1) ((a70) this.g).j.get((w7) this.d);
        if (mj1Var != null) {
            mj1Var.p(xmVar);
        }
    }

    public void b(boolean z) {
        IntentFilter intentFilter = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
        IntentFilter intentFilter2 = new IntentFilter("com.android.vending.billing.LOCAL_BROADCAST_PURCHASES_UPDATED");
        intentFilter2.addAction("com.android.vending.billing.ALTERNATIVE_BILLING");
        this.b = z;
        ((ur1) this.g).a((Context) this.c, intentFilter2);
        boolean z2 = this.b;
        ur1 ur1Var = (ur1) this.f;
        Context context = (Context) this.c;
        if (!z2) {
            ur1Var.a(context, intentFilter);
            return;
        }
        synchronized (ur1Var) {
            try {
                if (ur1Var.a) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    context.registerReceiver(ur1Var, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != ur1Var.b ? 4 : 2);
                } else {
                    context.registerReceiver(ur1Var, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                ur1Var.a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ie
    public void g(xm xmVar) {
        ((a70) this.g).m.post(new vn1(this, xmVar, 12, false));
    }
}
