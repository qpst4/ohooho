package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wy0 {
    public final byte[] a;
    public int b;
    public int c;
    public boolean d;
    public final boolean e;
    public wy0 f;
    public wy0 g;

    public wy0() {
        this.a = new byte[8192];
        this.e = true;
        this.d = false;
    }

    public final wy0 a() {
        wy0 wy0Var = this.f;
        wy0 wy0Var2 = wy0Var != this ? wy0Var : null;
        wy0 wy0Var3 = this.g;
        wy0Var3.f = wy0Var;
        this.f.g = wy0Var3;
        this.f = null;
        this.g = null;
        return wy0Var2;
    }

    public final void b(wy0 wy0Var) {
        wy0Var.g = this;
        wy0Var.f = this.f;
        this.f.g = wy0Var;
        this.f = wy0Var;
    }

    public final wy0 c() {
        this.d = true;
        return new wy0(this.a, this.b, this.c);
    }

    public final void d(wy0 wy0Var, int i) {
        boolean z = wy0Var.e;
        byte[] bArr = wy0Var.a;
        if (!z) {
            throw new IllegalArgumentException();
        }
        int i2 = wy0Var.c;
        int i3 = i2 + i;
        if (i3 > 8192) {
            if (wy0Var.d) {
                throw new IllegalArgumentException();
            }
            int i4 = wy0Var.b;
            if (i3 - i4 > 8192) {
                throw new IllegalArgumentException();
            }
            System.arraycopy(bArr, i4, bArr, 0, i2 - i4);
            wy0Var.c -= wy0Var.b;
            wy0Var.b = 0;
        }
        System.arraycopy(this.a, this.b, bArr, wy0Var.c, i);
        wy0Var.c += i;
        this.b += i;
    }

    public wy0(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
        this.d = true;
        this.e = false;
    }
}
