package defpackage;

import android.util.SparseArray;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fu0 {
    public SparseArray a;
    public int b;

    public final eu0 a(int i) {
        SparseArray sparseArray = this.a;
        eu0 eu0Var = (eu0) sparseArray.get(i);
        if (eu0Var != null) {
            return eu0Var;
        }
        eu0 eu0Var2 = new eu0();
        sparseArray.put(i, eu0Var2);
        return eu0Var2;
    }
}
