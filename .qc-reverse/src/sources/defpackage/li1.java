package defpackage;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class li1 extends ki1 {
    public xb0 n;

    public li1(wi1 wi1Var, WindowInsets windowInsets) {
        super(wi1Var, windowInsets);
        this.n = null;
    }

    @Override // defpackage.ri1
    public wi1 b() {
        return wi1.h(null, this.c.consumeStableInsets());
    }

    @Override // defpackage.ri1
    public wi1 c() {
        return wi1.h(null, this.c.consumeSystemWindowInsets());
    }

    @Override // defpackage.ri1
    public final xb0 h() {
        if (this.n == null) {
            WindowInsets windowInsets = this.c;
            this.n = xb0.b(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.n;
    }

    @Override // defpackage.ri1
    public boolean m() {
        return this.c.isConsumed();
    }

    @Override // defpackage.ri1
    public void q(xb0 xb0Var) {
        this.n = xb0Var;
    }
}
