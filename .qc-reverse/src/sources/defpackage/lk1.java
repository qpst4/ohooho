package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lk1 extends v {
    public static final Parcelable.Creator<lk1> CREATOR = new ip0(18);
    public final int b;
    public final IBinder c;
    public final xm d;
    public final boolean e;
    public final boolean f;

    public lk1(int i, IBinder iBinder, xm xmVar, boolean z, boolean z2) {
        this.b = i;
        this.c = iBinder;
        this.d = xmVar;
        this.e = z;
        this.f = z2;
    }

    public final boolean equals(Object obj) {
        Object hs1Var;
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lk1)) {
            return false;
        }
        lk1 lk1Var = (lk1) obj;
        if (!this.d.equals(lk1Var.d)) {
            return false;
        }
        Object hs1Var2 = null;
        IBinder iBinder = this.c;
        if (iBinder == null) {
            hs1Var = null;
        } else {
            int i = b1.c;
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            hs1Var = iInterfaceQueryLocalInterface instanceof ja0 ? (ja0) iInterfaceQueryLocalInterface : new hs1(iBinder);
        }
        IBinder iBinder2 = lk1Var.c;
        if (iBinder2 != null) {
            int i2 = b1.c;
            IInterface iInterfaceQueryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            hs1Var2 = iInterfaceQueryLocalInterface2 instanceof ja0 ? (ja0) iInterfaceQueryLocalInterface2 : new hs1(iBinder2);
        }
        return xy0.o(hs1Var, hs1Var2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iR = tk0.R(parcel, 20293);
        tk0.V(parcel, 1, 4);
        parcel.writeInt(this.b);
        IBinder iBinder = this.c;
        if (iBinder != null) {
            int iR2 = tk0.R(parcel, 2);
            parcel.writeStrongBinder(iBinder);
            tk0.U(parcel, iR2);
        }
        tk0.M(parcel, 3, this.d, i);
        tk0.V(parcel, 4, 4);
        parcel.writeInt(this.e ? 1 : 0);
        tk0.V(parcel, 5, 4);
        parcel.writeInt(this.f ? 1 : 0);
        tk0.U(parcel, iR);
    }
}
