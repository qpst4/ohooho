package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q01 extends a {
    public final Bundle A;
    public final Integer B;
    public final boolean y;
    public final a9 z;

    public q01(Context context, Looper looper, a9 a9Var, Bundle bundle, y60 y60Var, z60 z60Var) {
        super(context, looper, 44, a9Var, y60Var, z60Var);
        this.y = true;
        this.z = a9Var;
        this.A = bundle;
        this.B = (Integer) a9Var.f;
    }

    @Override // defpackage.t7
    public final int c() {
        return 12451000;
    }

    @Override // com.google.android.gms.common.internal.a, defpackage.t7
    public final boolean j() {
        return this.y;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof yj1 ? (yj1) iInterfaceQueryLocalInterface : new yj1(iBinder, "com.google.android.gms.signin.internal.ISignInService", 0);
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle o() {
        a9 a9Var = this.z;
        boolean zEquals = this.c.getPackageName().equals((String) a9Var.c);
        Bundle bundle = this.A;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) a9Var.c);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String q() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String r() {
        return "com.google.android.gms.signin.service.START";
    }
}
