package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kg extends vm0 {
    @Override // defpackage.vm0
    public final vm0 c() {
        return (kg) this.a;
    }

    @Override // defpackage.vm0
    public final void d(vm0 vm0Var) {
        if (vm0Var instanceof kg) {
            this.a = vm0Var;
        } else {
            zy.n("Parent of block must also be block (can not be inline)");
        }
    }
}
