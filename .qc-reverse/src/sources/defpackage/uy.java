package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uy {
    public final String a;

    public uy(String str) {
        if (str != null) {
            this.a = str;
        } else {
            zy.r("name is null");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uy)) {
            return false;
        }
        return this.a.equals(((uy) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return l11.k(new StringBuilder("Encoding{name=\""), this.a, "\"}");
    }
}
