package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.quickcursor.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class r00 extends ke {
    public final u00 g;
    public final boolean h;
    public final /* synthetic */ ExtendedFloatingActionButton i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r00(ExtendedFloatingActionButton extendedFloatingActionButton, sp1 sp1Var, u00 u00Var, boolean z) {
        super(extendedFloatingActionButton, sp1Var);
        this.i = extendedFloatingActionButton;
        this.g = u00Var;
        this.h = z;
    }

    @Override // defpackage.ke
    public final AnimatorSet a() {
        bm0 bm0Var = this.f;
        if (bm0Var == null) {
            if (this.e == null) {
                this.e = bm0.b(this.a, c());
            }
            bm0Var = this.e;
            bm0Var.getClass();
        }
        boolean zG = bm0Var.g("width");
        u00 u00Var = this.g;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.i;
        if (zG) {
            PropertyValuesHolder[] propertyValuesHolderArrE = bm0Var.e("width");
            propertyValuesHolderArrE[0].setFloatValues(extendedFloatingActionButton.getWidth(), u00Var.i());
            bm0Var.h("width", propertyValuesHolderArrE);
        }
        if (bm0Var.g("height")) {
            PropertyValuesHolder[] propertyValuesHolderArrE2 = bm0Var.e("height");
            propertyValuesHolderArrE2[0].setFloatValues(extendedFloatingActionButton.getHeight(), u00Var.b());
            bm0Var.h("height", propertyValuesHolderArrE2);
        }
        if (bm0Var.g("paddingStart")) {
            PropertyValuesHolder[] propertyValuesHolderArrE3 = bm0Var.e("paddingStart");
            PropertyValuesHolder propertyValuesHolder = propertyValuesHolderArrE3[0];
            WeakHashMap weakHashMap = uf1.a;
            propertyValuesHolder.setFloatValues(extendedFloatingActionButton.getPaddingStart(), u00Var.d());
            bm0Var.h("paddingStart", propertyValuesHolderArrE3);
        }
        if (bm0Var.g("paddingEnd")) {
            PropertyValuesHolder[] propertyValuesHolderArrE4 = bm0Var.e("paddingEnd");
            PropertyValuesHolder propertyValuesHolder2 = propertyValuesHolderArrE4[0];
            WeakHashMap weakHashMap2 = uf1.a;
            propertyValuesHolder2.setFloatValues(extendedFloatingActionButton.getPaddingEnd(), u00Var.c());
            bm0Var.h("paddingEnd", propertyValuesHolderArrE4);
        }
        if (bm0Var.g("labelOpacity")) {
            PropertyValuesHolder[] propertyValuesHolderArrE5 = bm0Var.e("labelOpacity");
            boolean z = this.h;
            propertyValuesHolderArrE5[0].setFloatValues(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
            bm0Var.h("labelOpacity", propertyValuesHolderArrE5);
        }
        return b(bm0Var);
    }

    @Override // defpackage.ke
    public final int c() {
        return this.h ? R.animator.mtrl_extended_fab_change_size_expand_motion_spec : R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
    }

    @Override // defpackage.ke
    public final void e() {
        this.d.c = null;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.i;
        extendedFloatingActionButton.E = false;
        extendedFloatingActionButton.setHorizontallyScrolling(false);
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        u00 u00Var = this.g;
        layoutParams.width = u00Var.j().width;
        layoutParams.height = u00Var.j().height;
    }

    @Override // defpackage.ke
    public final void f(Animator animator) {
        sp1 sp1Var = this.d;
        Animator animator2 = (Animator) sp1Var.c;
        if (animator2 != null) {
            animator2.cancel();
        }
        sp1Var.c = animator;
        boolean z = this.h;
        ExtendedFloatingActionButton extendedFloatingActionButton = this.i;
        extendedFloatingActionButton.D = z;
        extendedFloatingActionButton.E = true;
        extendedFloatingActionButton.setHorizontallyScrolling(true);
    }

    @Override // defpackage.ke
    public final void g() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.i;
        boolean z = this.h;
        extendedFloatingActionButton.D = z;
        ViewGroup.LayoutParams layoutParams = extendedFloatingActionButton.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (!z) {
            extendedFloatingActionButton.H = layoutParams.width;
            extendedFloatingActionButton.I = layoutParams.height;
        }
        u00 u00Var = this.g;
        layoutParams.width = u00Var.j().width;
        layoutParams.height = u00Var.j().height;
        int iD = u00Var.d();
        int paddingTop = extendedFloatingActionButton.getPaddingTop();
        int iC = u00Var.c();
        int paddingBottom = extendedFloatingActionButton.getPaddingBottom();
        WeakHashMap weakHashMap = uf1.a;
        extendedFloatingActionButton.setPaddingRelative(iD, paddingTop, iC, paddingBottom);
        extendedFloatingActionButton.requestLayout();
    }

    @Override // defpackage.ke
    public final boolean h() {
        ExtendedFloatingActionButton extendedFloatingActionButton = this.i;
        return this.h == extendedFloatingActionButton.D || extendedFloatingActionButton.getIcon() == null || TextUtils.isEmpty(extendedFloatingActionButton.getText());
    }
}
