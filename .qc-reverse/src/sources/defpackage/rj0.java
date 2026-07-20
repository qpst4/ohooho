package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.button.MaterialButton;
import com.quickcursor.R;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class rj0 {
    public final MaterialButton a;
    public mz0 b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;
    public int h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public ColorStateList k;
    public ColorStateList l;
    public ik0 m;
    public boolean q;
    public RippleDrawable s;
    public int t;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;
    public boolean r = true;

    public rj0(MaterialButton materialButton, mz0 mz0Var) {
        this.a = materialButton;
        this.b = mz0Var;
    }

    public final xz0 a() {
        RippleDrawable rippleDrawable = this.s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        int numberOfLayers = this.s.getNumberOfLayers();
        RippleDrawable rippleDrawable2 = this.s;
        return numberOfLayers > 2 ? (xz0) rippleDrawable2.getDrawable(2) : (xz0) rippleDrawable2.getDrawable(1);
    }

    public final ik0 b(boolean z) {
        RippleDrawable rippleDrawable = this.s;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (ik0) ((LayerDrawable) ((InsetDrawable) this.s.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final void c(mz0 mz0Var) {
        this.b = mz0Var;
        if (b(false) != null) {
            b(false).setShapeAppearanceModel(mz0Var);
        }
        if (b(true) != null) {
            b(true).setShapeAppearanceModel(mz0Var);
        }
        if (a() != null) {
            a().setShapeAppearanceModel(mz0Var);
        }
    }

    public final void d(int i, int i2) {
        WeakHashMap weakHashMap = uf1.a;
        MaterialButton materialButton = this.a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i3 = this.e;
        int i4 = this.f;
        this.f = i2;
        this.e = i;
        if (!this.o) {
            e();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    public final void e() {
        ik0 ik0Var = new ik0(this.b);
        MaterialButton materialButton = this.a;
        ik0Var.i(materialButton.getContext());
        ik0Var.setTintList(this.j);
        PorterDuff.Mode mode = this.i;
        if (mode != null) {
            ik0Var.setTintMode(mode);
        }
        float f = this.h;
        ColorStateList colorStateList = this.k;
        ik0Var.b.j = f;
        ik0Var.invalidateSelf();
        hk0 hk0Var = ik0Var.b;
        if (hk0Var.d != colorStateList) {
            hk0Var.d = colorStateList;
            ik0Var.onStateChange(ik0Var.getState());
        }
        ik0 ik0Var2 = new ik0(this.b);
        ik0Var2.setTint(0);
        float f2 = this.h;
        int iL = this.n ? xr.l(materialButton, R.attr.colorSurface) : 0;
        ik0Var2.b.j = f2;
        ik0Var2.invalidateSelf();
        ColorStateList colorStateListValueOf = ColorStateList.valueOf(iL);
        hk0 hk0Var2 = ik0Var2.b;
        if (hk0Var2.d != colorStateListValueOf) {
            hk0Var2.d = colorStateListValueOf;
            ik0Var2.onStateChange(ik0Var2.getState());
        }
        ik0 ik0Var3 = new ik0(this.b);
        this.m = ik0Var3;
        ik0Var3.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(nw0.c(this.l), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{ik0Var2, ik0Var}), this.c, this.e, this.d, this.f), this.m);
        this.s = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        ik0 ik0VarB = b(false);
        if (ik0VarB != null) {
            ik0VarB.j(this.t);
            ik0VarB.setState(materialButton.getDrawableState());
        }
    }

    public final void f() {
        ik0 ik0VarB = b(false);
        ik0 ik0VarB2 = b(true);
        if (ik0VarB != null) {
            float f = this.h;
            ColorStateList colorStateList = this.k;
            ik0VarB.b.j = f;
            ik0VarB.invalidateSelf();
            hk0 hk0Var = ik0VarB.b;
            if (hk0Var.d != colorStateList) {
                hk0Var.d = colorStateList;
                ik0VarB.onStateChange(ik0VarB.getState());
            }
            if (ik0VarB2 != null) {
                float f2 = this.h;
                int iL = this.n ? xr.l(this.a, R.attr.colorSurface) : 0;
                ik0VarB2.b.j = f2;
                ik0VarB2.invalidateSelf();
                ColorStateList colorStateListValueOf = ColorStateList.valueOf(iL);
                hk0 hk0Var2 = ik0VarB2.b;
                if (hk0Var2.d != colorStateListValueOf) {
                    hk0Var2.d = colorStateListValueOf;
                    ik0VarB2.onStateChange(ik0VarB2.getState());
                }
            }
        }
    }
}
