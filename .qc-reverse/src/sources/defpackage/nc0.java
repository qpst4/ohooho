package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nc0 implements la0, ka0 {
    public final mc0 a;
    public final sj b;
    public final String c;
    public final boolean d;

    public nc0(mc0 mc0Var, sj sjVar, String str, boolean z) {
        this.a = mc0Var;
        this.b = sjVar;
        this.c = str != null ? str.replaceAll("\\[", "<").replaceAll("\\]", ">") : str;
        this.d = z;
    }

    @Override // defpackage.ka0
    public final int a() {
        return this.a.b;
    }

    @Override // defpackage.la0
    public final int b() {
        return 1;
    }
}
