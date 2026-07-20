package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class v9 extends rh0 implements x9 {
    public CharSequence D;
    public s9 E;
    public final Rect F;
    public int G;
    public final /* synthetic */ y9 H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v9(y9 y9Var, Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.spinnerStyle, 0);
        this.H = y9Var;
        this.F = new Rect();
        this.p = y9Var;
        this.z = true;
        this.A.setFocusable(true);
        this.q = new t9(0, this);
    }

    @Override // defpackage.x9
    public final void e(CharSequence charSequence) {
        this.D = charSequence;
    }

    @Override // defpackage.x9
    public final void k(int i) {
        this.G = i;
    }

    @Override // defpackage.x9
    public final void m(int i, int i2) {
        ViewTreeObserver viewTreeObserver;
        h9 h9Var = this.A;
        boolean zIsShowing = h9Var.isShowing();
        s();
        h9Var.setInputMethodMode(2);
        d();
        bv bvVar = this.d;
        bvVar.setChoiceMode(1);
        bvVar.setTextDirection(i);
        bvVar.setTextAlignment(i2);
        y9 y9Var = this.H;
        int selectedItemPosition = y9Var.getSelectedItemPosition();
        bv bvVar2 = this.d;
        if (h9Var.isShowing() && bvVar2 != null) {
            bvVar2.setListSelectionHidden(false);
            bvVar2.setSelection(selectedItemPosition);
            if (bvVar2.getChoiceMode() != 0) {
                bvVar2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (zIsShowing || (viewTreeObserver = y9Var.getViewTreeObserver()) == null) {
            return;
        }
        p9 p9Var = new p9(1, this);
        viewTreeObserver.addOnGlobalLayoutListener(p9Var);
        h9Var.setOnDismissListener(new u9(this, p9Var));
    }

    @Override // defpackage.x9
    public final CharSequence o() {
        return this.D;
    }

    @Override // defpackage.rh0, defpackage.x9
    public final void p(ListAdapter listAdapter) {
        super.p(listAdapter);
        this.E = (s9) listAdapter;
    }

    public final void s() {
        int i;
        h9 h9Var = this.A;
        Drawable background = h9Var.getBackground();
        y9 y9Var = this.H;
        Rect rect = y9Var.i;
        if (background != null) {
            background.getPadding(rect);
            boolean z = vg1.a;
            i = y9Var.getLayoutDirection() == 1 ? rect.right : -rect.left;
        } else {
            i = 0;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = y9Var.getPaddingLeft();
        int paddingRight = y9Var.getPaddingRight();
        int width = y9Var.getWidth();
        int i2 = y9Var.h;
        if (i2 == -2) {
            int iA = y9Var.a(this.E, h9Var.getBackground());
            int i3 = (y9Var.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
            if (iA > i3) {
                iA = i3;
            }
            r(Math.max(iA, (width - paddingLeft) - paddingRight));
        } else if (i2 == -1) {
            r((width - paddingLeft) - paddingRight);
        } else {
            r(i2);
        }
        boolean z2 = vg1.a;
        this.g = y9Var.getLayoutDirection() == 1 ? (((width - paddingRight) - this.f) - this.G) + i : paddingLeft + this.G + i;
    }
}
