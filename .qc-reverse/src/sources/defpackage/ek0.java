package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ek0 implements un0 {
    public final View b;
    public int c;
    public int d;

    public ek0(View view, int i, int i2) {
        this.c = i;
        this.b = view;
        this.d = i2;
    }

    @Override // defpackage.un0
    public wi1 k(View view, wi1 wi1Var) {
        int i = wi1Var.a.f(519).b;
        int i2 = this.c;
        View view2 = this.b;
        if (i2 >= 0) {
            view2.getLayoutParams().height = i2 + i;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(view2.getPaddingLeft(), this.d + i, view2.getPaddingRight(), view2.getPaddingBottom());
        return wi1Var;
    }

    public ek0(View view) {
        this.b = view;
    }
}
