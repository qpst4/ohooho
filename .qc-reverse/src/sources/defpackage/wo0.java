package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wo0 implements kk {
    public final Class a;

    public wo0(Class cls) {
        cls.getClass();
        this.a = cls;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof wo0) {
            return fc0.b(this.a, ((wo0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString() + " (Kotlin reflection is not available)";
    }
}
