package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j50 extends gi implements i50, be0, h50 {
    public final int h;
    public final int i;

    public j50(int i, Object obj, Class cls, String str, String str2) {
        super(obj, cls, str, str2, false);
        this.h = i;
        this.i = 0;
    }

    @Override // defpackage.i50
    public final int b() {
        return this.h;
    }

    @Override // defpackage.gi
    public final be0 c() {
        tu0.a.getClass();
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    public final boolean equals(Object obj) {
        ?? r2;
        if (obj == this) {
            return true;
        }
        if (obj instanceof j50) {
            j50 j50Var = (j50) obj;
            return this.e.equals(j50Var.e) && this.f.equals(j50Var.f) && this.i == j50Var.i && this.h == j50Var.h && fc0.b(this.c, j50Var.c) && fc0.b(d(), j50Var.d());
        }
        if (!(obj instanceof j50)) {
            return false;
        }
        be0 be0Var = this.b;
        if (be0Var == null) {
            c();
            this.b = this;
            this = this;
        } else {
            r2 = be0Var;
        }
        return obj.equals(r2);
    }

    public final int hashCode() {
        return this.f.hashCode() + ((this.e.hashCode() + (d() == null ? 0 : d().hashCode() * 31)) * 31);
    }

    public final String toString() {
        be0 be0Var = this.b;
        if (be0Var == null) {
            c();
            this.b = this;
            be0Var = this;
        }
        if (be0Var != this) {
            return be0Var.toString();
        }
        String str = this.e;
        return "<init>".equals(str) ? "constructor (Kotlin reflection is not available)" : l11.j("function ", str, " (Kotlin reflection is not available)");
    }
}
