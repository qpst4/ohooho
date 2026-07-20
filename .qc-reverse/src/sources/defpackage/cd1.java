package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cd1 {
    public static final cd1 d = new cd1(0, new int[0], new Object[0]);
    public final int a;
    public final int[] b;
    public final Object[] c;

    public cd1(int i, int[] iArr, Object[] objArr) {
        this.a = i;
        this.b = iArr;
        this.c = objArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof cd1)) {
            return false;
        }
        cd1 cd1Var = (cd1) obj;
        return this.a == cd1Var.a && Arrays.equals(this.b, cd1Var.b) && Arrays.deepEquals(this.c, cd1Var.c);
    }

    public final int hashCode() {
        return Arrays.deepHashCode(this.c) + ((Arrays.hashCode(this.b) + ((527 + this.a) * 31)) * 31);
    }
}
