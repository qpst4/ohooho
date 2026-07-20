package defpackage;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wl0 {
    public final SparseArray a;
    public uc1 b;

    public wl0(int i) {
        this.a = new SparseArray(i);
    }

    public final void a(uc1 uc1Var, int i, int i2) {
        int iA = uc1Var.a(i);
        SparseArray sparseArray = this.a;
        wl0 wl0Var = sparseArray == null ? null : (wl0) sparseArray.get(iA);
        if (wl0Var == null) {
            wl0Var = new wl0(1);
            sparseArray.put(uc1Var.a(i), wl0Var);
        }
        if (i2 > i) {
            wl0Var.a(uc1Var, i + 1, i2);
        } else {
            wl0Var.b = uc1Var;
        }
    }
}
