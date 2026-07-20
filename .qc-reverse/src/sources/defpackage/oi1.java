package defpackage;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class oi1 extends ni1 {
    public static final wi1 r = wi1.h(null, WindowInsets.CONSUMED);

    public oi1(wi1 wi1Var, WindowInsets windowInsets) {
        super(wi1Var, windowInsets);
    }

    @Override // defpackage.ki1, defpackage.ri1
    public xb0 f(int i) {
        return xb0.c(this.c.getInsets(ti1.a(i)));
    }

    @Override // defpackage.ki1, defpackage.ri1
    public final void d(View view) {
    }
}
