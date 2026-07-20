package defpackage;

import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class u50 implements v50 {
    public static final u50 a = new u50();

    @Override // defpackage.v50
    public final zh a(boolean z, zh zhVar, boolean z2, zh zhVar2) {
        return z2 ? zhVar2 : zhVar;
    }

    @Override // defpackage.v50
    public final String b(boolean z, String str, boolean z2, String str2) {
        return z2 ? str2 : str;
    }

    @Override // defpackage.v50
    public final sr0 c(sr0 sr0Var, sr0 sr0Var2) {
        int size = sr0Var.c.size();
        int size2 = sr0Var2.c.size();
        if (size > 0 && size2 > 0) {
            if (!sr0Var.b) {
                int i = size2 + size;
                ArrayList arrayList = sr0Var.c;
                if (i < arrayList.size()) {
                    throw new IllegalArgumentException();
                }
                ArrayList arrayList2 = new ArrayList(i);
                arrayList2.addAll(arrayList);
                sr0Var = new sr0(arrayList2);
            }
            sr0Var.addAll(sr0Var2);
        }
        return size > 0 ? sr0Var : sr0Var2;
    }

    @Override // defpackage.v50
    public final boolean d(boolean z, boolean z2, boolean z3, boolean z4) {
        return z3 ? z4 : z2;
    }

    @Override // defpackage.v50
    public final w50 e(w50 w50Var, w50 w50Var2) {
        if (w50Var == null || w50Var2 == null) {
            return w50Var != null ? w50Var : w50Var2;
        }
        p50 p50VarK = w50Var.k();
        if (p50VarK.b.getClass().isInstance(w50Var2)) {
            p50VarK.d(w50Var2);
            return p50VarK.a();
        }
        zy.n("mergeFrom(MessageLite) can only merge messages of the same type.");
        return null;
    }

    @Override // defpackage.v50
    public final int f(int i, int i2, boolean z, boolean z2) {
        return z2 ? i2 : i;
    }

    @Override // defpackage.v50
    public final cd1 g(cd1 cd1Var, cd1 cd1Var2) {
        if (cd1Var2 == cd1.d) {
            return cd1Var;
        }
        int i = cd1Var.a + cd1Var2.a;
        int[] iArrCopyOf = Arrays.copyOf(cd1Var.b, i);
        int[] iArr = cd1Var2.b;
        int i2 = cd1Var.a;
        int i3 = cd1Var2.a;
        System.arraycopy(iArr, 0, iArrCopyOf, i2, i3);
        Object[] objArrCopyOf = Arrays.copyOf(cd1Var.c, i);
        System.arraycopy(cd1Var2.c, 0, objArrCopyOf, i2, i3);
        return new cd1(i, iArrCopyOf, objArrCopyOf);
    }
}
