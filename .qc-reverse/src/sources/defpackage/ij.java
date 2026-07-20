package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ij extends t81 {
    public static final String[] C = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final ej D = new ej(PointF.class, "topLeft", 0);
    public static final ej E = new ej(PointF.class, "bottomRight", 1);
    public static final ej F = new ej(PointF.class, "bottomRight", 2);
    public static final ej G = new ej(PointF.class, "topLeft", 3);
    public static final ej H = new ej(PointF.class, "position", 4);

    public static void I(b91 b91Var) {
        View view = b91Var.b;
        HashMap map = b91Var.a;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", view.getParent());
    }

    @Override // defpackage.t81
    public final void d(b91 b91Var) {
        I(b91Var);
    }

    @Override // defpackage.t81
    public final void g(b91 b91Var) {
        I(b91Var);
    }

    @Override // defpackage.t81
    public final Animator k(ViewGroup viewGroup, b91 b91Var, b91 b91Var2) {
        int i;
        ij ijVar;
        Animator animatorA;
        if (b91Var == null) {
            return null;
        }
        HashMap map = b91Var.a;
        if (b91Var2 == null) {
            return null;
        }
        HashMap map2 = b91Var2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = b91Var2.b;
        Rect rect = (Rect) map.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
        int i2 = rect.left;
        int i3 = rect2.left;
        int i4 = rect.top;
        int i5 = rect2.top;
        int i6 = rect.right;
        int i7 = rect2.right;
        int i8 = rect.bottom;
        int i9 = rect2.bottom;
        int i10 = i6 - i2;
        int i11 = i8 - i4;
        int i12 = i7 - i3;
        int i13 = i9 - i5;
        Rect rect3 = (Rect) map.get("android:changeBounds:clip");
        Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
        if ((i10 == 0 || i11 == 0) && (i12 == 0 || i13 == 0)) {
            i = 0;
        } else {
            i = (i2 == i3 && i4 == i5) ? 0 : 1;
            if (i6 != i7 || i8 != i9) {
                i++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i++;
        }
        int i14 = i;
        if (i14 <= 0) {
            return null;
        }
        ug1.a(view, i2, i4, i6, i8);
        if (i14 != 2) {
            ijVar = this;
            if (i2 == i3 && i4 == i5) {
                ijVar.x.getClass();
                animatorA = in0.a(view, F, ow0.g(i6, i8, i7, i9));
            } else {
                ijVar.x.getClass();
                animatorA = in0.a(view, G, ow0.g(i2, i4, i3, i5));
            }
        } else if (i10 == i12 && i11 == i13) {
            ijVar = this;
            ijVar.x.getClass();
            animatorA = in0.a(view, H, ow0.g(i2, i4, i3, i5));
        } else {
            ijVar = this;
            hj hjVar = new hj(view);
            ijVar.x.getClass();
            ObjectAnimator objectAnimatorA = in0.a(hjVar, D, ow0.g(i2, i4, i3, i5));
            ijVar.x.getClass();
            ObjectAnimator objectAnimatorA2 = in0.a(hjVar, E, ow0.g(i6, i8, i7, i9));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorA, objectAnimatorA2);
            animatorSet.addListener(new fj(hjVar));
            animatorA = animatorSet;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            fp1.B(viewGroup4, true);
            ijVar.o().a(new gj(viewGroup4));
        }
        return animatorA;
    }

    @Override // defpackage.t81
    public final String[] q() {
        return C;
    }
}
