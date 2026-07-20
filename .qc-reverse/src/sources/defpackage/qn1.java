package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qn1 implements ServiceConnection {
    public final int a;
    public final /* synthetic */ a b;

    public qn1(a aVar, int i) {
        this.b = aVar;
        this.a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        int i;
        int i2;
        a aVar = this.b;
        if (iBinder == null) {
            synchronized (aVar.f) {
                i = aVar.m;
            }
            if (i == 3) {
                aVar.t = true;
                i2 = 5;
            } else {
                i2 = 4;
            }
            al1 al1Var = aVar.e;
            al1Var.sendMessage(al1Var.obtainMessage(i2, aVar.v.get(), 16));
            return;
        }
        synchronized (aVar.g) {
            try {
                a aVar2 = this.b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                aVar2.h = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof ok1)) ? new ok1(iBinder) : (ok1) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        a aVar3 = this.b;
        int i3 = this.a;
        vo1 vo1Var = new vo1(aVar3, 0);
        al1 al1Var2 = aVar3.e;
        al1Var2.sendMessage(al1Var2.obtainMessage(7, i3, -1, vo1Var));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        a aVar;
        synchronized (this.b.g) {
            aVar = this.b;
            aVar.h = null;
        }
        int i = this.a;
        al1 al1Var = aVar.e;
        al1Var.sendMessage(al1Var.obtainMessage(6, i, 1));
    }
}
