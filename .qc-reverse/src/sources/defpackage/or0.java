package defpackage;

import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class or0 {
    public final String a;

    public or0(String str) {
        this.a = str;
    }

    public final Object a(kj0 kj0Var) {
        Object obj = kj0Var.a.get(this);
        if (obj != null) {
            return obj;
        }
        zy.r(this.a);
        return null;
    }

    public final void b(kj0 kj0Var, Object obj) {
        HashMap map = kj0Var.a;
        if (obj == null) {
            map.remove(this);
        } else {
            map.put(this, obj);
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || or0.class != obj.getClass()) {
            return false;
        }
        return this.a.equals(((or0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return l11.k(new StringBuilder("Prop{name='"), this.a, "'}");
    }
}
