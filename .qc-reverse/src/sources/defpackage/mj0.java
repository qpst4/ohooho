package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import com.quickcursor.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mj0 extends jl1 {
    public Drawable d;
    public final Rect e;

    /* JADX WARN: Illegal instructions before constructor call */
    public mj0(z7 z7Var) {
        TypedValue typedValueQ = i1.Q(z7Var, R.attr.materialAlertDialogTheme);
        int i = typedValueQ == null ? 0 : typedValueQ.data;
        Context contextL = xy0.L(z7Var, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        contextL = i != 0 ? new io(contextL, i) : contextL;
        TypedValue typedValueQ2 = i1.Q(z7Var, R.attr.materialAlertDialogTheme);
        super(contextL, typedValueQ2 == null ? 0 : typedValueQ2.data);
        ContextThemeWrapper contextThemeWrapper = ((x6) this.c).a;
        Resources.Theme theme = contextThemeWrapper.getTheme();
        f01.i(contextThemeWrapper, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        int[] iArr = ys0.l;
        f01.l(contextThemeWrapper, null, iArr, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = contextThemeWrapper.obtainStyledAttributes(null, iArr, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_start));
        int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(3, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_top));
        int dimensionPixelSize3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_end));
        int dimensionPixelSize4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_alert_dialog_background_inset_bottom));
        typedArrayObtainStyledAttributes.recycle();
        if (contextThemeWrapper.getResources().getConfiguration().getLayoutDirection() == 1) {
            dimensionPixelSize3 = dimensionPixelSize;
            dimensionPixelSize = dimensionPixelSize3;
        }
        this.e = new Rect(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize3, dimensionPixelSize4);
        TypedValue typedValueV = i1.V(R.attr.colorSurface, contextThemeWrapper, mj0.class.getCanonicalName());
        int i2 = typedValueV.resourceId;
        int color = i2 != 0 ? contextThemeWrapper.getColor(i2) : typedValueV.data;
        TypedArray typedArrayObtainStyledAttributes2 = contextThemeWrapper.obtainStyledAttributes(null, iArr, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        int color2 = typedArrayObtainStyledAttributes2.getColor(4, color);
        typedArrayObtainStyledAttributes2.recycle();
        ik0 ik0Var = new ik0(contextThemeWrapper, null, R.attr.alertDialogStyle, R.style.MaterialAlertDialog_MaterialComponents);
        ik0Var.i(contextThemeWrapper);
        ik0Var.k(ColorStateList.valueOf(color2));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(android.R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(((x6) this.c).a.getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                lz0 lz0VarF = ik0Var.b.a.f();
                lz0VarF.e = new h(dimension);
                lz0VarF.f = new h(dimension);
                lz0VarF.g = new h(dimension);
                lz0VarF.h = new h(dimension);
                ik0Var.setShapeAppearanceModel(lz0VarF.a());
            }
        }
        this.d = ik0Var;
    }

    @Override // defpackage.jl1
    public final b7 c() {
        b7 b7VarC = super.c();
        Window window = b7VarC.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.d;
        if (drawable instanceof ik0) {
            WeakHashMap weakHashMap = uf1.a;
            ((ik0) drawable).j(lf1.e(decorView));
        }
        Drawable drawable2 = this.d;
        Rect rect = this.e;
        window.setBackgroundDrawable(new InsetDrawable(drawable2, rect.left, rect.top, rect.right, rect.bottom));
        decorView.setOnTouchListener(new wb0(b7VarC, rect));
        return b7VarC;
    }

    @Override // defpackage.jl1
    public final jl1 g(int i) {
        throw null;
    }

    @Override // defpackage.jl1
    public final void h(int i, DialogInterface.OnClickListener onClickListener) {
        super.h(R.string.dialog_button_cancel, onClickListener);
    }

    @Override // defpackage.jl1
    public final void i(int i, DialogInterface.OnClickListener onClickListener) {
        super.i(R.string.dialog_button_default, onClickListener);
    }

    @Override // defpackage.jl1
    public final void k(int i, DialogInterface.OnClickListener onClickListener) {
        super.k(R.string.dialog_button_done, onClickListener);
    }

    @Override // defpackage.jl1
    public final jl1 m(int i) {
        throw null;
    }

    public final void p(String str, z2 z2Var) {
        super.j(str, z2Var);
    }

    public final void q(String str, g2 g2Var) {
        super.l(str, g2Var);
    }
}
