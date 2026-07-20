package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fx0 implements Map.Entry {
    public final Object b;
    public final Object c;
    public fx0 d;
    public fx0 e;

    public fx0(Object obj, Object obj2) {
        this.b = obj;
        this.c = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fx0)) {
            return false;
        }
        fx0 fx0Var = (fx0) obj;
        return this.b.equals(fx0Var.b) && this.c.equals(fx0Var.c);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.b;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.c.hashCode() ^ this.b.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.b + "=" + this.c;
    }
}
