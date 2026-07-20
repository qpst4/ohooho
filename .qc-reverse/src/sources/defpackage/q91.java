package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q91 {
    private boolean animation;
    private int animationDuration;
    private int iconColor;
    private int iconSize;
    private int pieColor;
    private int selectedColor;
    private int strokeColor;
    private int strokeSize;

    public q91() {
        j();
    }

    public static q91 a(q91 q91Var, float f) {
        q91 q91Var2 = new q91();
        q91Var2.pieColor = q91Var.pieColor;
        q91Var2.selectedColor = q91Var.selectedColor;
        q91Var2.strokeColor = q91Var.strokeColor;
        q91Var2.iconColor = q91Var.iconColor;
        q91Var2.strokeSize = (int) (q91Var.strokeSize * f);
        q91Var2.iconSize = (int) (q91Var.iconSize * f);
        q91Var2.animation = q91Var.animation;
        q91Var2.animationDuration = q91Var.animationDuration;
        return q91Var2;
    }

    public final int b() {
        return this.animationDuration;
    }

    public final int c() {
        return this.iconColor;
    }

    public final int d() {
        return this.iconSize;
    }

    public final int e() {
        return this.pieColor;
    }

    public final int f() {
        return this.selectedColor;
    }

    public final int g() {
        return this.strokeColor;
    }

    public final int h() {
        return this.strokeSize;
    }

    public final boolean i() {
        return this.animation;
    }

    public final void j() {
        this.pieColor = dn.N0;
        this.selectedColor = dn.O0;
        this.iconColor = dn.Q0;
        this.strokeColor = dn.P0;
        this.strokeSize = (int) dn.H0;
        this.iconSize = (int) dn.I0;
        this.animation = dn.H2;
        this.animationDuration = dn.I2;
    }

    public final void k(boolean z) {
        this.animation = z;
    }

    public final void l(int i) {
        this.animationDuration = i;
    }

    public final void m(int i) {
        this.iconColor = i;
    }

    public final void n(int i) {
        this.iconSize = i;
    }

    public final void o(int i) {
        this.pieColor = i;
    }

    public final void p(int i) {
        this.selectedColor = i;
    }

    public final void q(int i) {
        this.strokeColor = i;
    }

    public final void r(int i) {
        this.strokeSize = i;
    }
}
