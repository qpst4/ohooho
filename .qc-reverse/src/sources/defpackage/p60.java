package defpackage;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class p60 extends v {
    public static final Parcelable.Creator<p60> CREATOR = new ip0(26);
    public static final Scope[] p = new Scope[0];
    public static final l10[] q = new l10[0];
    public final int b;
    public final int c;
    public final int d;
    public String e;
    public IBinder f;
    public Scope[] g;
    public Bundle h;
    public Account i;
    public l10[] j;
    public l10[] k;
    public final boolean l;
    public final int m;
    public final boolean n;
    public final String o;

    public p60(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, l10[] l10VarArr, l10[] l10VarArr2, boolean z, int i4, boolean z2, String str2) {
        scopeArr = scopeArr == null ? p : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        l10[] l10VarArr3 = q;
        l10VarArr = l10VarArr == null ? l10VarArr3 : l10VarArr;
        l10VarArr2 = l10VarArr2 == null ? l10VarArr3 : l10VarArr2;
        this.b = i;
        this.c = i2;
        this.d = i3;
        if ("com.google.android.gms".equals(str)) {
            this.e = "com.google.android.gms";
        } else {
            this.e = str;
        }
        if (i < 2) {
            Account accountA = null;
            if (iBinder != null) {
                int i5 = b1.c;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface hs1Var = iInterfaceQueryLocalInterface instanceof ja0 ? (ja0) iInterfaceQueryLocalInterface : new hs1(iBinder);
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    try {
                        accountA = ((hs1) hs1Var).a();
                    } catch (RemoteException unused) {
                        Log.w("AccountAccessor", "Remote account accessor probably died");
                    }
                } finally {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                }
            }
            this.i = accountA;
        } else {
            this.f = iBinder;
            this.i = account;
        }
        this.g = scopeArr;
        this.h = bundle;
        this.j = l10VarArr;
        this.k = l10VarArr2;
        this.l = z;
        this.m = i4;
        this.n = z2;
        this.o = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        ip0.a(this, parcel, i);
    }
}
