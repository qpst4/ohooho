package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class u11 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ v11 c;
    public final /* synthetic */ xs d;

    public /* synthetic */ u11(xs xsVar, v11 v11Var, int i) {
        this.b = i;
        this.d = xsVar;
        this.c = v11Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        v11 v11Var = this.c;
        xs xsVar = this.d;
        switch (i) {
            case 0:
                if (xsVar.b.contains(v11Var)) {
                    qq0.a(v11Var.c.H, v11Var.a);
                }
                break;
            default:
                xsVar.b.remove(v11Var);
                xsVar.c.remove(v11Var);
                break;
        }
    }
}
