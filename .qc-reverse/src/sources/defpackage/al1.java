package defpackage;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class al1 extends kk1 {
    public final /* synthetic */ a a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al1(a aVar, Looper looper) {
        super(looper, 2);
        this.a = aVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Boolean bool;
        int i = this.a.v.get();
        int i2 = message.arg1;
        int i3 = message.what;
        if (i != i2) {
            if (i3 == 2 || i3 == 1 || i3 == 7) {
                mk1 mk1Var = (mk1) message.obj;
                mk1Var.getClass();
                mk1Var.c();
                return;
            }
            return;
        }
        if ((i3 == 1 || i3 == 7 || i3 == 4 || i3 == 5) && !this.a.d()) {
            mk1 mk1Var2 = (mk1) message.obj;
            mk1Var2.getClass();
            mk1Var2.c();
            return;
        }
        int i4 = message.what;
        if (i4 == 4) {
            a aVar = this.a;
            aVar.s = new xm(message.arg2);
            if (!aVar.t && !TextUtils.isEmpty(aVar.q()) && !TextUtils.isEmpty(null)) {
                try {
                    Class.forName(aVar.q());
                    a aVar2 = this.a;
                    if (!aVar2.t) {
                        aVar2.u(3, null);
                        return;
                    }
                } catch (ClassNotFoundException unused) {
                }
            }
            a aVar3 = this.a;
            xm xmVar = aVar3.s;
            if (xmVar == null) {
                xmVar = new xm(8);
            }
            aVar3.i.g(xmVar);
            System.currentTimeMillis();
            return;
        }
        if (i4 == 5) {
            a aVar4 = this.a;
            xm xmVar2 = aVar4.s;
            if (xmVar2 == null) {
                xmVar2 = new xm(8);
            }
            aVar4.i.g(xmVar2);
            System.currentTimeMillis();
            return;
        }
        if (i4 == 3) {
            Object obj = message.obj;
            this.a.i.g(new xm(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null));
            System.currentTimeMillis();
            return;
        }
        if (i4 == 6) {
            this.a.u(5, null);
            tb0 tb0Var = this.a.n;
            if (tb0Var != null) {
                ((y60) tb0Var.c).a(message.arg2);
            }
            System.currentTimeMillis();
            a.t(this.a, 5, 1, null);
            return;
        }
        if (i4 == 2 && !this.a.isConnected()) {
            mk1 mk1Var3 = (mk1) message.obj;
            mk1Var3.getClass();
            mk1Var3.c();
            return;
        }
        int i5 = message.what;
        if (i5 != 2 && i5 != 1 && i5 != 7) {
            Log.wtf("GmsClient", qq0.i("Don't know how to handle message: ", i5), new Exception());
            return;
        }
        mk1 mk1Var4 = (mk1) message.obj;
        synchronized (mk1Var4) {
            try {
                bool = mk1Var4.a;
                if (mk1Var4.b) {
                    Log.w("GmsClient", "Callback proxy " + mk1Var4.toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bool != null) {
            a aVar5 = mk1Var4.f;
            int i6 = mk1Var4.d;
            if (i6 != 0) {
                aVar5.u(1, null);
                Bundle bundle = mk1Var4.e;
                mk1Var4.a(new xm(i6, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
            } else if (!mk1Var4.b()) {
                aVar5.u(1, null);
                mk1Var4.a(new xm(8, null));
            }
        }
        synchronized (mk1Var4) {
            mk1Var4.b = true;
        }
        mk1Var4.c();
    }
}
