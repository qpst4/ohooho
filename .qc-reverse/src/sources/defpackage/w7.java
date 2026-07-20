package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class w7 {
    public final int a;
    public final i9 b;
    public final String c;

    public w7(i9 i9Var, String str) {
        this.b = i9Var;
        this.c = str;
        this.a = Arrays.hashCode(new Object[]{i9Var, r41.a, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w7)) {
            return false;
        }
        w7 w7Var = (w7) obj;
        if (!xy0.o(this.b, w7Var.b)) {
            return false;
        }
        r41 r41Var = r41.a;
        return xy0.o(r41Var, r41Var) && xy0.o(this.c, w7Var.c);
    }

    public final int hashCode() {
        return this.a;
    }
}
