package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zq implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ ar c;

    public /* synthetic */ zq(ar arVar, int i) {
        this.b = i;
        this.c = arVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        ar arVar = this.c;
        switch (i) {
            case 0:
                arVar.p(null);
                break;
            default:
                arVar.l();
                break;
        }
    }
}
