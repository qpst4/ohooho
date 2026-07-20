package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cj1 {
    public static final cj1 b;
    public nr a;

    static {
        cj1 cj1Var = new cj1();
        cj1Var.a = null;
        b = cj1Var;
    }

    public static nr a(Context context) {
        nr nrVar;
        cj1 cj1Var = b;
        synchronized (cj1Var) {
            try {
                if (cj1Var.a == null) {
                    if (context.getApplicationContext() != null) {
                        context = context.getApplicationContext();
                    }
                    cj1Var.a = new nr(context, 2);
                }
                nrVar = cj1Var.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return nrVar;
    }
}
