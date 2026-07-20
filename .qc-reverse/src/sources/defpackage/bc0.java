package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bc0 extends zb0 {
    public static final bc0 e = new bc0(1, 0, 1);

    @Override // defpackage.zb0
    public final boolean equals(Object obj) {
        if (!(obj instanceof bc0)) {
            return false;
        }
        if (isEmpty() && ((bc0) obj).isEmpty()) {
            return true;
        }
        bc0 bc0Var = (bc0) obj;
        return this.b == bc0Var.b && this.c == bc0Var.c;
    }

    @Override // defpackage.zb0
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.b * 31) + this.c;
    }

    @Override // defpackage.zb0
    public final boolean isEmpty() {
        return this.b > this.c;
    }

    @Override // defpackage.zb0
    public final String toString() {
        return this.b + ".." + this.c;
    }
}
