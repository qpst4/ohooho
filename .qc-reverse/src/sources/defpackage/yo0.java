package defpackage;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yo0 extends qg0 {
    public final /* synthetic */ zo0 q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public yo0(zo0 zo0Var, Context context) {
        super(context);
        this.q = zo0Var;
    }

    @Override // defpackage.qg0
    public final float d(DisplayMetrics displayMetrics) {
        return 100.0f / displayMetrics.densityDpi;
    }

    @Override // defpackage.qg0
    public final int e(int i) {
        return Math.min(100, super.e(i));
    }

    @Override // defpackage.qg0
    public final void i(View view, ku0 ku0Var) {
        zo0 zo0Var = this.q;
        int[] iArrA = zo0Var.a(zo0Var.a.getLayoutManager(), view);
        int i = iArrA[0];
        int i2 = iArrA[1];
        int iCeil = (int) Math.ceil(((double) e(Math.max(Math.abs(i), Math.abs(i2)))) / 0.3356d);
        if (iCeil > 0) {
            ku0Var.a = i;
            ku0Var.b = i2;
            ku0Var.c = iCeil;
            ku0Var.e = this.j;
            ku0Var.f = true;
        }
    }
}
