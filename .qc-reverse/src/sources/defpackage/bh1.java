package defpackage;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bh1 extends ah1 {
    @Override // defpackage.ah1
    public final void F(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    @Override // defpackage.ah1
    public final void G(View view, int i) {
        view.setTransitionVisibility(i);
    }

    @Override // defpackage.ah1
    public final void H(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // defpackage.ah1
    public final void I(ViewGroup viewGroup, Matrix matrix) {
        viewGroup.transformMatrixToLocal(matrix);
    }

    @Override // defpackage.yb0
    public final float n(View view) {
        return view.getTransitionAlpha();
    }

    @Override // defpackage.yb0
    public final void x(View view, float f) {
        view.setTransitionAlpha(f);
    }
}
