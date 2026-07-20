package defpackage;

import android.os.BadParcelableException;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kj1 extends Binder implements IInterface {
    public final /* synthetic */ int b;

    public kj1(String str) {
        this.b = 2;
        attachInterface(this, str);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        int i = this.b;
        return this;
    }

    public boolean d(int i, Parcel parcel, Parcel parcel2) {
        return false;
    }

    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        boolean z = false;
        switch (this.b) {
            case 0:
                if (i > 16777215) {
                    if (!super.onTransact(i, parcel, parcel2, i2)) {
                    }
                    return true;
                }
                parcel.enforceInterface(getInterfaceDescriptor());
                uj1 uj1Var = (uj1) this;
                switch (i) {
                    case 3:
                        qj1.b(parcel);
                        break;
                    case 4:
                        qj1.b(parcel);
                        break;
                    case 5:
                    default:
                        return false;
                    case 6:
                        qj1.b(parcel);
                        break;
                    case 7:
                        qj1.b(parcel);
                        break;
                    case 8:
                        fk1 fk1Var = (fk1) qj1.a(parcel, fk1.CREATOR);
                        qj1.b(parcel);
                        uj1Var.d.post(new vn1(uj1Var, fk1Var, 13, z));
                        break;
                    case 9:
                        qj1.b(parcel);
                        break;
                }
                parcel2.writeNoException();
                return true;
            case 1:
                if (i > 16777215) {
                    if (!super.onTransact(i, parcel, parcel2, i2)) {
                    }
                    return true;
                }
                parcel.enforceInterface(getInterfaceDescriptor());
                ol1 ol1Var = (ol1) this;
                if (i != 1) {
                    return false;
                }
                int i3 = parcel.readInt();
                int i4 = uk1.a;
                int iDataAvail = parcel.dataAvail();
                if (iDataAvail > 0) {
                    throw new BadParcelableException(qq0.i("Parcel data not fully consumed, unread size: ", iDataAvail));
                }
                Integer numValueOf = Integer.valueOf(i3);
                bs1 bs1Var = ol1Var.c;
                bs1Var.d = true;
                fs1 fs1Var = bs1Var.b;
                if (fs1Var != null) {
                    ds1 ds1Var = fs1Var.c;
                    ds1Var.getClass();
                    if (as1.g.a0(ds1Var, null, numValueOf)) {
                        as1.c(ds1Var);
                        bs1Var.a = null;
                        bs1Var.b = null;
                        bs1Var.c = null;
                    }
                }
                return true;
            default:
                if (i <= 16777215) {
                    parcel.enforceInterface(getInterfaceDescriptor());
                } else if (super.onTransact(i, parcel, parcel2, i2)) {
                    return true;
                }
                return d(i, parcel, parcel2);
        }
    }
}
