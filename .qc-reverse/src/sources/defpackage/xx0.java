package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xx0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ yx0 c;

    public /* synthetic */ xx0(yx0 yx0Var, int i) {
        this.b = i;
        this.c = yx0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        yx0.a(this.c);
    }
}
