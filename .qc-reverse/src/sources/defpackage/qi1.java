package defpackage;

import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qi1 extends pi1 {
    public static final wi1 s = wi1.h(null, WindowInsets.CONSUMED);

    public qi1(wi1 wi1Var, WindowInsets windowInsets) {
        super(wi1Var, windowInsets);
    }

    @Override // defpackage.oi1, defpackage.ki1, defpackage.ri1
    public xb0 f(int i) {
        return xb0.c(this.c.getInsets(vi1.a(i)));
    }
}
