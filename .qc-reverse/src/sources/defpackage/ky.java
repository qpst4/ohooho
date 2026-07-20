package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ky implements xa0 {
    public final boolean a;

    public ky(boolean z) {
        this.a = z;
    }

    @Override // defpackage.xa0
    public final boolean a() {
        return this.a;
    }

    @Override // defpackage.xa0
    public final wm0 d() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.a ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
