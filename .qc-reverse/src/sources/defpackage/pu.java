package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pu implements wr0 {
    public static final Object d = new Object();
    public volatile z00 b;
    public volatile Object c;

    public static wr0 a(z00 z00Var) {
        if (z00Var instanceof pu) {
            return z00Var;
        }
        pu puVar = new pu();
        puVar.c = d;
        puVar.b = z00Var;
        return puVar;
    }

    @Override // defpackage.wr0
    public final Object get() {
        Object obj;
        Object obj2 = this.c;
        Object obj3 = d;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.c;
                if (obj == obj3) {
                    obj = this.b.get();
                    Object obj4 = this.c;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.c = obj;
                    this.b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
