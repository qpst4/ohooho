package defpackage;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g40 {
    public static final f40 a = f40.a;

    public static f40 a(j30 j30Var) {
        while (j30Var != null) {
            if (j30Var.D()) {
                j30Var.x();
            }
            j30Var = j30Var.w;
        }
        return a;
    }

    public static void b(dh1 dh1Var) {
        if (y30.I(3)) {
            Log.d("FragmentManager", "StrictMode violation in ".concat(dh1Var.b.getClass().getName()), dh1Var);
        }
    }

    public static final void c(j30 j30Var, String str) {
        j30Var.getClass();
        str.getClass();
        b(new c40(j30Var, "Attempting to reuse fragment " + j30Var + " with previous ID " + str));
        a(j30Var).getClass();
    }
}
