package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rb implements dt {
    public final char a;

    public rb(char c) {
        this.a = c;
    }

    @Override // defpackage.dt
    public final char a() {
        return this.a;
    }

    @Override // defpackage.dt
    public final int b() {
        return 1;
    }

    @Override // defpackage.dt
    public final int c(ct ctVar, ct ctVar2) {
        if (ctVar.d || ctVar2.c) {
            int i = ctVar2.h;
            if (i % 3 != 0 && (ctVar.h + i) % 3 == 0) {
                return 0;
            }
        }
        return (ctVar.g < 2 || ctVar2.g < 2) ? 1 : 2;
    }

    @Override // defpackage.dt
    public final void d(u41 u41Var, u41 u41Var2, int i) {
        String.valueOf(this.a);
        vm0 iyVar = i == 1 ? new iy() : new f31();
        vm0 vm0Var = u41Var.e;
        while (vm0Var != null && vm0Var != u41Var2) {
            vm0 vm0Var2 = vm0Var.e;
            iyVar.b(vm0Var);
            vm0Var = vm0Var2;
        }
        iyVar.f();
        vm0 vm0Var3 = u41Var.e;
        iyVar.e = vm0Var3;
        if (vm0Var3 != null) {
            vm0Var3.d = iyVar;
        }
        iyVar.d = u41Var;
        u41Var.e = iyVar;
        vm0 vm0Var4 = u41Var.a;
        iyVar.a = vm0Var4;
        if (iyVar.e == null) {
            vm0Var4.c = iyVar;
        }
    }

    @Override // defpackage.dt
    public final char e() {
        return this.a;
    }
}
