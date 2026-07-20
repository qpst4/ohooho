package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class vm0 {
    public vm0 a = null;
    public vm0 b = null;
    public vm0 c = null;
    public vm0 d = null;
    public vm0 e = null;

    public abstract void a(g7 g7Var);

    public final void b(vm0 vm0Var) {
        vm0Var.f();
        vm0Var.d(this);
        vm0 vm0Var2 = this.c;
        if (vm0Var2 == null) {
            this.b = vm0Var;
            this.c = vm0Var;
        } else {
            vm0Var2.e = vm0Var;
            vm0Var.d = vm0Var2;
            this.c = vm0Var;
        }
    }

    public vm0 c() {
        return this.a;
    }

    public void d(vm0 vm0Var) {
        this.a = vm0Var;
    }

    public String e() {
        return "";
    }

    public final void f() {
        vm0 vm0Var = this.d;
        if (vm0Var != null) {
            vm0Var.e = this.e;
        } else {
            vm0 vm0Var2 = this.a;
            if (vm0Var2 != null) {
                vm0Var2.b = this.e;
            }
        }
        vm0 vm0Var3 = this.e;
        if (vm0Var3 != null) {
            vm0Var3.d = vm0Var;
        } else {
            vm0 vm0Var4 = this.a;
            if (vm0Var4 != null) {
                vm0Var4.c = vm0Var;
            }
        }
        this.a = null;
        this.e = null;
        this.d = null;
    }

    public final String toString() {
        return getClass().getSimpleName() + "{" + e() + "}";
    }
}
