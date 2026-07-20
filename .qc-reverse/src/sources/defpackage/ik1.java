package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ik1 extends a {
    public final r41 y;

    public ik1(Context context, Looper looper, a9 a9Var, r41 r41Var, mj1 mj1Var, mj1 mj1Var2) {
        super(context, looper, 270, a9Var, mj1Var, mj1Var2);
        this.y = r41Var;
    }

    @Override // defpackage.t7
    public final int c() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface l(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof ek1 ? (ek1) iInterfaceQueryLocalInterface : new ek1(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 0);
    }

    @Override // com.google.android.gms.common.internal.a
    public final l10[] n() {
        return i1.n;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle o() {
        this.y.getClass();
        return new Bundle();
    }

    @Override // com.google.android.gms.common.internal.a
    public final String q() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String r() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.a
    public final boolean s() {
        return true;
    }
}
