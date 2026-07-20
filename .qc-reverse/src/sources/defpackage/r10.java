package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r10 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ s10 c;

    public /* synthetic */ r10(s10 s10Var, int i) {
        this.b = i;
        this.c = s10Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        s10 s10Var = this.c;
        switch (i) {
            case 0:
                s10Var.k();
                break;
            default:
                s10Var.l();
                break;
        }
    }
}
