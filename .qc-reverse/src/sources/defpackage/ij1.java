package defpackage;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ij1 implements IInterface {
    public final /* synthetic */ int b;
    public final IBinder c;
    public final String d;

    public /* synthetic */ ij1(IBinder iBinder, String str, int i) {
        this.b = i;
        this.c = iBinder;
        this.d = str;
    }

    public Parcel a() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.d);
        return parcelObtain;
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i = this.b;
        return this.c;
    }

    public Parcel b(Parcel parcel, int i) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.c.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }
}
