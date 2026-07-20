package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ur0 implements ge1 {
    public boolean a = false;
    public boolean b = false;
    public o10 c;
    public final tr0 d;

    public ur0(tr0 tr0Var) {
        this.d = tr0Var;
    }

    @Override // defpackage.ge1
    public final ge1 b(String str) {
        if (this.a) {
            throw new vy("Cannot encode a second value in the ValueEncoderContext");
        }
        this.a = true;
        this.d.e(this.c, str, this.b);
        return this;
    }

    @Override // defpackage.ge1
    public final ge1 c(boolean z) {
        if (this.a) {
            throw new vy("Cannot encode a second value in the ValueEncoderContext");
        }
        this.a = true;
        this.d.b(this.c, z ? 1 : 0, this.b);
        return this;
    }
}
