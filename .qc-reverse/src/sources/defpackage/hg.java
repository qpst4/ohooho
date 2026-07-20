package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hg implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ig c;

    public /* synthetic */ hg(ig igVar, int i) {
        this.b = i;
        this.c = igVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        ig igVar = this.c;
        switch (i) {
            case 0:
                b61 b61Var = igVar.l;
                if (b61Var != null) {
                    b61Var.d();
                    igVar.l = null;
                }
                igVar.b();
                break;
            default:
                igVar.b();
                break;
        }
    }
}
