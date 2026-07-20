package defpackage;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hs1 implements ja0, IInterface {
    public final IBinder b;

    public hs1(IBinder iBinder) {
        this.b = iBinder;
    }

    public final Account a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IAccountAccessor");
        parcelObtain = Parcel.obtain();
        try {
            this.b.transact(2, parcelObtain, parcelObtain, 0);
            parcelObtain.readException();
            parcelObtain.recycle();
            return (Account) pl1.a(parcelObtain, Account.CREATOR);
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcelObtain.recycle();
        }
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.b;
    }
}
