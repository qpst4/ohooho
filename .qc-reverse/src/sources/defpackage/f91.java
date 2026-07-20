package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f91 {
    private m91 actions;
    private db cursorArea;
    private da1 design;
    private db moveArea;
    private String name;
    private db triggerArea;

    public f91(String str, db dbVar, db dbVar2, db dbVar3, da1 da1Var, m91 m91Var) {
        this.name = str;
        this.triggerArea = dbVar;
        this.moveArea = dbVar2;
        this.cursorArea = dbVar3;
        this.design = da1Var;
        this.actions = m91Var;
    }

    public static f91 a(f91 f91Var, float f, float f2) {
        e91 e91VarE = f91Var.e();
        float f3 = (e91VarE == e91.left || e91VarE == e91.right) ? f : f2;
        return new f91(f91Var.name, db.a(f91Var.triggerArea, f, f2), db.a(f91Var.moveArea, f, f2), db.a(f91Var.cursorArea, f, f2), da1.a(f91Var.design, f3), m91.a(f91Var.actions, f3));
    }

    public final m91 b() {
        return this.actions;
    }

    public final db c() {
        return this.cursorArea;
    }

    public final da1 d() {
        return this.design;
    }

    public final e91 e() {
        int iF = this.triggerArea.f();
        int iC = this.triggerArea.c();
        db dbVar = this.triggerArea;
        if (iF > iC) {
            return (this.triggerArea.c() / 2) + dbVar.e() > ey0.b() / 2 ? e91.bottom : e91.top;
        }
        return (this.triggerArea.f() / 2) + dbVar.d() > ey0.c() / 2 ? e91.right : e91.left;
    }

    public final db f() {
        return this.moveArea;
    }

    public final String g() {
        return this.name;
    }

    public final db h() {
        return this.triggerArea;
    }

    public final void i(m91 m91Var) {
        this.actions = m91Var;
    }

    public final void j(db dbVar) {
        this.cursorArea = dbVar;
    }

    public final void k(da1 da1Var) {
        this.design = da1Var;
    }

    public final void l(db dbVar) {
        this.moveArea = dbVar;
    }

    public final void m(String str) {
        this.name = str;
    }

    public final void n(db dbVar) {
        this.triggerArea = dbVar;
    }
}
