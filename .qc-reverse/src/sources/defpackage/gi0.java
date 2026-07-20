package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gi0 extends gi implements k40, de0 {
    public final boolean h;

    public gi0(Object obj, Class cls, int i) {
        super(obj, cls, "classSimpleName", "getClassSimpleName(Ljava/lang/Object;)Ljava/lang/String;", (i & 1) == 1);
        this.h = (i & 2) == 2;
    }

    @Override // defpackage.k40
    public final Object a() {
        return this.c.getClass().getSimpleName();
    }

    @Override // defpackage.gi
    public final be0 c() {
        tu0.a.getClass();
        return this;
    }

    public final be0 e() {
        if (this.h) {
            return this;
        }
        be0 be0Var = this.b;
        if (be0Var != null) {
            return be0Var;
        }
        c();
        this.b = this;
        return this;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof gi0) {
            gi0 gi0Var = (gi0) obj;
            return d().equals(gi0Var.d()) && this.e.equals(gi0Var.e) && this.f.equals(gi0Var.f) && fc0.b(this.c, gi0Var.c);
        }
        if (obj instanceof de0) {
            return obj.equals(e());
        }
        return false;
    }

    public final int hashCode() {
        return this.f.hashCode() + ((this.e.hashCode() + (d().hashCode() * 31)) * 31);
    }

    public final String toString() {
        be0 be0VarE = e();
        return be0VarE != this ? be0VarE.toString() : l11.k(new StringBuilder("property "), this.e, " (Kotlin reflection is not available)");
    }
}
