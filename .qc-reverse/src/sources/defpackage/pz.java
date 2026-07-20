package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pz extends hp {
    public long d;
    public boolean e;
    public eb f;

    public final void s() {
        long j = this.d - 4294967296L;
        this.d = j;
        if (j <= 0 && this.e) {
            shutdown();
        }
    }

    public abstract void shutdown();

    public final boolean t() {
        eb ebVar = this.f;
        if (ebVar == null) {
            return false;
        }
        hu huVar = (hu) (ebVar.isEmpty() ? null : ebVar.removeFirst());
        if (huVar == null) {
            return false;
        }
        huVar.run();
        return true;
    }
}
