package defpackage;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ni1 extends mi1 {
    public xb0 o;
    public xb0 p;
    public xb0 q;

    public ni1(wi1 wi1Var, WindowInsets windowInsets) {
        super(wi1Var, windowInsets);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    @Override // defpackage.ri1
    public xb0 g() {
        if (this.p == null) {
            this.p = xb0.c(this.c.getMandatorySystemGestureInsets());
        }
        return this.p;
    }

    @Override // defpackage.ri1
    public xb0 i() {
        if (this.o == null) {
            this.o = xb0.c(this.c.getSystemGestureInsets());
        }
        return this.o;
    }

    @Override // defpackage.ri1
    public xb0 k() {
        if (this.q == null) {
            this.q = xb0.c(this.c.getTappableElementInsets());
        }
        return this.q;
    }

    @Override // defpackage.ki1, defpackage.ri1
    public wi1 l(int i, int i2, int i3, int i4) {
        return wi1.h(null, this.c.inset(i, i2, i3, i4));
    }

    @Override // defpackage.li1, defpackage.ri1
    public void q(xb0 xb0Var) {
    }
}
