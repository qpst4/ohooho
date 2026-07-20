package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class db {
    private float height;
    private float marginLeft;
    private float marginTop;
    private float width;

    public db(float f, float f2, float f3, float f4) {
        this.width = f;
        this.height = f2;
        this.marginLeft = f3;
        this.marginTop = f4;
    }

    public static db a(db dbVar, float f, float f2) {
        return new db(dbVar.width * f, dbVar.height * f2, dbVar.marginLeft * f, ((int) dbVar.marginTop) * f2);
    }

    public final float b() {
        return this.height;
    }

    public final int c() {
        return (int) this.height;
    }

    public final int d() {
        return (int) this.marginLeft;
    }

    public final int e() {
        return (int) this.marginTop;
    }

    public final int f() {
        return (int) this.width;
    }

    public final float g() {
        return this.marginLeft;
    }

    public final float h() {
        return this.marginTop;
    }

    public final int i() {
        return Math.min((int) this.marginLeft, (ey0.c() - ((int) this.marginLeft)) - ((int) this.width));
    }

    public final float j() {
        return this.width;
    }

    public final void k(int i) {
        this.height = i;
    }

    public final void l(float f) {
        this.marginLeft = f;
    }

    public final void m(int i) {
        this.marginLeft = i;
    }

    public final void n(int i) {
        this.marginTop = i;
    }

    public final void o(int i) {
        this.width = i;
    }
}
