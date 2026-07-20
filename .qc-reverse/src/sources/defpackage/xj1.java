package defpackage;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xj1 extends kk1 {
    public final Context a;
    public final /* synthetic */ w60 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xj1(w60 w60Var, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.b = w60Var;
        this.a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i);
            return;
        }
        int i2 = x60.a;
        w60 w60Var = this.b;
        Context context = this.a;
        int iB = w60Var.b(context, i2);
        int i3 = b70.c;
        if (iB == 1 || iB == 2 || iB == 3 || iB == 9) {
            Intent intentA = w60Var.a(iB, context, "n");
            w60Var.f(context, iB, intentA == null ? null : PendingIntent.getActivity(context, 0, intentA, 201326592));
        }
    }
}
