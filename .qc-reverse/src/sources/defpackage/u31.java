package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class u31 implements Serializable {
    public k40 b;
    public volatile Object c = c70.i;
    public final Object d = this;

    public u31(k40 k40Var) {
        this.b = k40Var;
    }

    public final Object a() {
        Object objA;
        Object obj = this.c;
        c70 c70Var = c70.i;
        if (obj != c70Var) {
            return obj;
        }
        synchronized (this.d) {
            objA = this.c;
            if (objA == c70Var) {
                k40 k40Var = this.b;
                k40Var.getClass();
                objA = k40Var.a();
                this.c = objA;
                this.b = null;
            }
        }
        return objA;
    }

    public final String toString() {
        return this.c != c70.i ? String.valueOf(a()) : "Lazy value not initialized yet.";
    }
}
