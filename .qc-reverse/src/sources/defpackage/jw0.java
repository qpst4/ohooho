package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jw0 implements Serializable {
    public final Throwable b;

    public jw0(Throwable th) {
        this.b = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof jw0) {
            return this.b.equals(((jw0) obj).b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.b + ')';
    }
}
