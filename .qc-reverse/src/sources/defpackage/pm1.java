package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pm1 extends kj1 {
    public a c;
    public final int d;

    public pm1(a aVar, int i) {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
        this.c = aVar;
        this.d = i;
    }

    @Override // defpackage.kj1
    public final boolean d(int i, Parcel parcel, Parcel parcel2) {
        if (i == 1) {
            int i2 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) pl1.a(parcel, Bundle.CREATOR);
            pl1.b(parcel);
            xy0.e("onPostInitComplete can be called only once per call to getRemoteService", this.c);
            a aVar = this.c;
            int i3 = this.d;
            aVar.getClass();
            do1 do1Var = new do1(aVar, i2, strongBinder, bundle);
            al1 al1Var = aVar.e;
            al1Var.sendMessage(al1Var.obtainMessage(1, i3, -1, do1Var));
            this.c = null;
        } else if (i == 2) {
            parcel.readInt();
            pl1.b(parcel);
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        } else {
            if (i != 3) {
                return false;
            }
            int i4 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            tq1 tq1Var = (tq1) pl1.a(parcel, tq1.CREATOR);
            pl1.b(parcel);
            a aVar2 = this.c;
            xy0.e("onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService", aVar2);
            xy0.d(tq1Var);
            aVar2.u = tq1Var;
            Bundle bundle2 = tq1Var.b;
            xy0.e("onPostInitComplete can be called only once per call to getRemoteService", this.c);
            a aVar3 = this.c;
            int i5 = this.d;
            aVar3.getClass();
            do1 do1Var2 = new do1(aVar3, i4, strongBinder2, bundle2);
            al1 al1Var2 = aVar3.e;
            al1Var2.sendMessage(al1Var2.obtainMessage(1, i5, -1, do1Var2));
            this.c = null;
        }
        parcel2.writeNoException();
        return true;
    }
}
