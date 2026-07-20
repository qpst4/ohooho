package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.quickcursor.R;
import defpackage.bm0;
import defpackage.ej;
import defpackage.f01;
import defpackage.i9;
import defpackage.mo;
import defpackage.mz0;
import defpackage.no;
import defpackage.q00;
import defpackage.qo;
import defpackage.r00;
import defpackage.ra;
import defpackage.s00;
import defpackage.sp1;
import defpackage.t00;
import defpackage.u00;
import defpackage.uf1;
import defpackage.xy0;
import defpackage.ys0;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements mo {
    public static final ej J = new ej(Float.class, "width", 5);
    public static final ej K = new ej(Float.class, "height", 6);
    public static final ej L = new ej(Float.class, "paddingStart", 7);
    public static final ej M = new ej(Float.class, "paddingEnd", 8);
    public int A;
    public int B;
    public final ExtendedFloatingActionButtonBehavior C;
    public boolean D;
    public boolean E;
    public boolean F;
    public ColorStateList G;
    public int H;
    public int I;
    public int u;
    public final r00 v;
    public final r00 w;
    public final t00 x;
    public final s00 y;
    public final int z;

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        super(xy0.L(context, attributeSet, R.attr.extendedFloatingActionButtonStyle, R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon), attributeSet, R.attr.extendedFloatingActionButtonStyle);
        this.u = 0;
        sp1 sp1Var = new sp1(5);
        t00 t00Var = new t00(this, sp1Var);
        this.x = t00Var;
        s00 s00Var = new s00(this, sp1Var);
        this.y = s00Var;
        this.D = true;
        this.E = false;
        this.F = false;
        Context context2 = getContext();
        this.C = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray typedArrayE = f01.E(context2, attributeSet, ys0.g, R.attr.extendedFloatingActionButtonStyle, R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon, new int[0]);
        bm0 bm0VarA = bm0.a(context2, typedArrayE, 5);
        bm0 bm0VarA2 = bm0.a(context2, typedArrayE, 4);
        bm0 bm0VarA3 = bm0.a(context2, typedArrayE, 2);
        bm0 bm0VarA4 = bm0.a(context2, typedArrayE, 6);
        this.z = typedArrayE.getDimensionPixelSize(0, -1);
        int i = typedArrayE.getInt(3, 1);
        this.A = getPaddingStart();
        this.B = getPaddingEnd();
        sp1 sp1Var2 = new sp1(5);
        u00 q00Var = new q00(this, 1);
        i9 i9Var = new i9(this, 16, q00Var);
        r00 r00Var = new r00(this, sp1Var2, i != 1 ? i != 2 ? new ra(this, i9Var, q00Var, 10, false) : i9Var : q00Var, true);
        this.w = r00Var;
        r00 r00Var2 = new r00(this, sp1Var2, new q00(this, 0), false);
        this.v = r00Var2;
        t00Var.f = bm0VarA;
        s00Var.f = bm0VarA2;
        r00Var.f = bm0VarA3;
        r00Var2.f = bm0VarA4;
        typedArrayE.recycle();
        setShapeAppearanceModel(mz0.c(context2, attributeSet, R.attr.extendedFloatingActionButtonStyle, R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon, mz0.m).a());
        this.G = getTextColors();
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton r5, int r6) {
        /*
            r0 = 2
            r1 = 1
            if (r6 == 0) goto L1e
            if (r6 == r1) goto L1b
            if (r6 == r0) goto L18
            r2 = 3
            if (r6 != r2) goto Le
            r00 r2 = r5.w
            goto L20
        Le:
            java.lang.String r5 = "Unknown strategy type: "
            java.lang.String r5 = defpackage.qq0.i(r5, r6)
            defpackage.s1.f(r5)
            return
        L18:
            r00 r2 = r5.v
            goto L20
        L1b:
            s00 r2 = r5.y
            goto L20
        L1e:
            t00 r2 = r5.x
        L20:
            boolean r3 = r2.h()
            if (r3 == 0) goto L27
            return
        L27:
            java.util.WeakHashMap r3 = defpackage.uf1.a
            boolean r3 = r5.isLaidOut()
            if (r3 != 0) goto L41
            int r3 = r5.getVisibility()
            int r4 = r5.u
            if (r3 == 0) goto L3a
            if (r4 != r0) goto L3d
            goto L8d
        L3a:
            if (r4 == r1) goto L3d
            goto L8d
        L3d:
            boolean r1 = r5.F
            if (r1 == 0) goto L8d
        L41:
            boolean r1 = r5.isInEditMode()
            if (r1 != 0) goto L8d
            if (r6 != r0) goto L64
            android.view.ViewGroup$LayoutParams r6 = r5.getLayoutParams()
            if (r6 == 0) goto L58
            int r0 = r6.width
            r5.H = r0
            int r6 = r6.height
            r5.I = r6
            goto L64
        L58:
            int r6 = r5.getWidth()
            r5.H = r6
            int r6 = r5.getHeight()
            r5.I = r6
        L64:
            r6 = 0
            r5.measure(r6, r6)
            android.animation.AnimatorSet r5 = r2.a()
            m1 r0 = new m1
            r1 = 5
            r0.<init>(r1, r2)
            r5.addListener(r0)
            java.util.ArrayList r0 = r2.c
            int r1 = r0.size()
        L7b:
            if (r6 >= r1) goto L89
            java.lang.Object r2 = r0.get(r6)
            int r6 = r6 + 1
            android.animation.Animator$AnimatorListener r2 = (android.animation.Animator.AnimatorListener) r2
            r5.addListener(r2)
            goto L7b
        L89:
            r5.start()
            return
        L8d:
            r2.g()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.e(com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton, int):void");
    }

    public final void f(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }

    @Override // defpackage.mo
    public no getBehavior() {
        return this.C;
    }

    public int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        int i = this.z;
        if (i >= 0) {
            return i;
        }
        WeakHashMap weakHashMap = uf1.a;
        return getIconSize() + (Math.min(getPaddingStart(), getPaddingEnd()) * 2);
    }

    public bm0 getExtendMotionSpec() {
        return this.w.f;
    }

    public bm0 getHideMotionSpec() {
        return this.y.f;
    }

    public bm0 getShowMotionSpec() {
        return this.x.f;
    }

    public bm0 getShrinkMotionSpec() {
        return this.v.f;
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.D && TextUtils.isEmpty(getText()) && getIcon() != null) {
            this.D = false;
            this.v.g();
        }
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.F = z;
    }

    public void setExtendMotionSpec(bm0 bm0Var) {
        this.w.f = bm0Var;
    }

    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(bm0.b(getContext(), i));
    }

    public void setExtended(boolean z) {
        if (this.D == z) {
            return;
        }
        r00 r00Var = z ? this.w : this.v;
        if (r00Var.h()) {
            return;
        }
        r00Var.g();
    }

    public void setHideMotionSpec(bm0 bm0Var) {
        this.y.f = bm0Var;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(bm0.b(getContext(), i));
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (!this.D || this.E) {
            return;
        }
        WeakHashMap weakHashMap = uf1.a;
        this.A = getPaddingStart();
        this.B = getPaddingEnd();
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        if (!this.D || this.E) {
            return;
        }
        this.A = i;
        this.B = i3;
    }

    public void setShowMotionSpec(bm0 bm0Var) {
        this.x.f = bm0Var;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(bm0.b(getContext(), i));
    }

    public void setShrinkMotionSpec(bm0 bm0Var) {
        this.v.f = bm0Var;
    }

    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(bm0.b(getContext(), i));
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        this.G = getTextColors();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        this.G = getTextColors();
    }

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends no {
        public final boolean a;
        public final boolean b;

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.h);
            this.a = typedArrayObtainStyledAttributes.getBoolean(0, false);
            this.b = typedArrayObtainStyledAttributes.getBoolean(1, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // defpackage.no
        public final /* bridge */ /* synthetic */ boolean a(Rect rect, View view) {
            return false;
        }

        @Override // defpackage.no
        public final void c(qo qoVar) {
            if (qoVar.h == 0) {
                qoVar.h = 80;
            }
        }

        @Override // defpackage.no
        public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof qo ? ((qo) layoutParams).a instanceof BottomSheetBehavior : false) {
                r(view2, extendedFloatingActionButton);
            }
            return false;
        }

        @Override // defpackage.no
        public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
            ExtendedFloatingActionButton extendedFloatingActionButton = (ExtendedFloatingActionButton) view;
            ArrayList arrayListJ = coordinatorLayout.j(extendedFloatingActionButton);
            int size = arrayListJ.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = (View) arrayListJ.get(i2);
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if ((layoutParams instanceof qo ? ((qo) layoutParams).a instanceof BottomSheetBehavior : false) && r(view2, extendedFloatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.q(extendedFloatingActionButton, i);
            return true;
        }

        public final boolean r(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            qo qoVar = (qo) extendedFloatingActionButton.getLayoutParams();
            boolean z = this.a;
            boolean z2 = this.b;
            if ((!z && !z2) || qoVar.f != view.getId()) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((qo) extendedFloatingActionButton.getLayoutParams())).topMargin) {
                ExtendedFloatingActionButton.e(extendedFloatingActionButton, z2 ? 2 : 1);
            } else {
                ExtendedFloatingActionButton.e(extendedFloatingActionButton, z2 ? 3 : 0);
            }
            return true;
        }

        public ExtendedFloatingActionButtonBehavior() {
            this.a = false;
            this.b = true;
        }
    }
}
