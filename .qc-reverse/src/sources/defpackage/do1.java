package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class do1 extends mk1 {
    public final IBinder g;
    public final /* synthetic */ a h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public do1(a aVar, int i, IBinder iBinder, Bundle bundle) {
        super(aVar, i, bundle);
        this.h = aVar;
        this.g = iBinder;
    }

    @Override // defpackage.mk1
    public final void a(xm xmVar) {
        tb0 tb0Var = this.h.o;
        if (tb0Var != null) {
            ((z60) tb0Var.c).b(xmVar);
        }
        System.currentTimeMillis();
    }

    @Override // defpackage.mk1
    public final boolean b() {
        IBinder iBinder = this.g;
        try {
            xy0.d(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            a aVar = this.h;
            if (!aVar.q().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + aVar.q() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceL = aVar.l(iBinder);
            if (iInterfaceL == null || !(a.t(aVar, 2, 4, iInterfaceL) || a.t(aVar, 3, 4, iInterfaceL))) {
                return false;
            }
            aVar.s = null;
            tb0 tb0Var = aVar.n;
            if (tb0Var == null) {
                return true;
            }
            ((y60) tb0Var.c).c();
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
