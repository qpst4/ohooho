package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.quickcursor.R;
import defpackage.ah;
import defpackage.h;
import defpackage.h0;
import defpackage.i1;
import defpackage.ik0;
import defpackage.l11;
import defpackage.lc1;
import defpackage.lf1;
import defpackage.lz0;
import defpackage.mz0;
import defpackage.no;
import defpackage.o01;
import defpackage.p01;
import defpackage.qo;
import defpackage.s1;
import defpackage.tf0;
import defpackage.uf1;
import defpackage.wf1;
import defpackage.yb0;
import defpackage.yg;
import defpackage.ys0;
import defpackage.zy;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends no {
    public lc1 a;
    public final ik0 b;
    public final ColorStateList c;
    public final mz0 d;
    public final ah e;
    public final float f;
    public final boolean g;
    public int h;
    public wf1 i;
    public boolean j;
    public final float k;
    public int l;
    public int m;
    public int n;
    public int o;
    public WeakReference p;
    public WeakReference q;
    public final int r;
    public VelocityTracker s;
    public int t;
    public final LinkedHashSet u;
    public final yg v;

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.e = new ah(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.r = -1;
        this.u = new LinkedHashSet();
        this.v = new yg(this, 1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.A);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.c = yb0.i(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(6)) {
            this.d = mz0.b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).a();
        }
        if (typedArrayObtainStyledAttributes.hasValue(5)) {
            int resourceId = typedArrayObtainStyledAttributes.getResourceId(5, -1);
            this.r = resourceId;
            WeakReference weakReference = this.q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.q = null;
            WeakReference weakReference2 = this.p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1) {
                    WeakHashMap weakHashMap = uf1.a;
                    if (view.isLaidOut()) {
                        view.requestLayout();
                    }
                }
            }
        }
        mz0 mz0Var = this.d;
        if (mz0Var != null) {
            ik0 ik0Var = new ik0(mz0Var);
            this.b = ik0Var;
            ik0Var.i(context);
            ColorStateList colorStateList = this.c;
            if (colorStateList != null) {
                this.b.k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.b.setTint(typedValue.data);
            }
        }
        this.f = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        this.g = typedArrayObtainStyledAttributes.getBoolean(4, true);
        typedArrayObtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // defpackage.no
    public final void c(qo qoVar) {
        this.p = null;
        this.i = null;
    }

    @Override // defpackage.no
    public final void e() {
        this.p = null;
        this.i = null;
    }

    @Override // defpackage.no
    public final boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        wf1 wf1Var;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && uf1.e(view) == null) || !this.g) {
            this.j = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.s) != null) {
            velocityTracker.recycle();
            this.s = null;
        }
        if (this.s == null) {
            this.s = VelocityTracker.obtain();
        }
        this.s.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.t = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.j) {
            this.j = false;
            return false;
        }
        return (this.j || (wf1Var = this.i) == null || !wf1Var.p(motionEvent)) ? false : true;
    }

    @Override // defpackage.no
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        View view2;
        View view3;
        int iH;
        int i2;
        View viewFindViewById;
        WeakHashMap weakHashMap = uf1.a;
        int i3 = 1;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        WeakReference weakReference = this.p;
        ik0 ik0Var = this.b;
        int i4 = 0;
        if (weakReference == null) {
            this.p = new WeakReference(view);
            Context context = view.getContext();
            i1.U(context, R.attr.motionEasingStandardDecelerateInterpolator, new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f));
            i1.T(context, R.attr.motionDurationMedium2, 300);
            i1.T(context, R.attr.motionDurationShort3, 150);
            i1.T(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
            if (ik0Var != null) {
                view.setBackground(ik0Var);
                float fE = this.f;
                if (fE == -1.0f) {
                    fE = lf1.e(view);
                }
                ik0Var.j(fE);
            } else {
                ColorStateList colorStateList = this.c;
                if (colorStateList != null) {
                    lf1.i(view, colorStateList);
                }
            }
            int i5 = this.h == 5 ? 4 : 0;
            if (view.getVisibility() != i5) {
                view.setVisibility(i5);
            }
            u();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (uf1.e(view) == null) {
                uf1.o(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        int i6 = Gravity.getAbsoluteGravity(((qo) view.getLayoutParams()).c, i) == 3 ? 1 : 0;
        lc1 lc1Var = this.a;
        if (lc1Var == null || lc1Var.J() != i6) {
            qo qoVar = null;
            mz0 mz0Var = this.d;
            if (i6 == 0) {
                this.a = new tf0(this, i3);
                if (mz0Var != null) {
                    WeakReference weakReference2 = this.p;
                    if (weakReference2 != null && (view3 = (View) weakReference2.get()) != null && (view3.getLayoutParams() instanceof qo)) {
                        qoVar = (qo) view3.getLayoutParams();
                    }
                    if (qoVar == null || ((ViewGroup.MarginLayoutParams) qoVar).rightMargin <= 0) {
                        lz0 lz0VarF = mz0Var.f();
                        lz0VarF.f = new h(0.0f);
                        lz0VarF.g = new h(0.0f);
                        mz0 mz0VarA = lz0VarF.a();
                        if (ik0Var != null) {
                            ik0Var.setShapeAppearanceModel(mz0VarA);
                        }
                    }
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalArgumentException("Invalid sheet edge position value: " + i6 + ". Must be 0 or 1.");
                }
                this.a = new tf0(this, i4);
                if (mz0Var != null) {
                    WeakReference weakReference3 = this.p;
                    if (weakReference3 != null && (view2 = (View) weakReference3.get()) != null && (view2.getLayoutParams() instanceof qo)) {
                        qoVar = (qo) view2.getLayoutParams();
                    }
                    if (qoVar == null || ((ViewGroup.MarginLayoutParams) qoVar).leftMargin <= 0) {
                        lz0 lz0VarF2 = mz0Var.f();
                        lz0VarF2.e = new h(0.0f);
                        lz0VarF2.h = new h(0.0f);
                        mz0 mz0VarA2 = lz0VarF2.a();
                        if (ik0Var != null) {
                            ik0Var.setShapeAppearanceModel(mz0VarA2);
                        }
                    }
                }
            }
        }
        if (this.i == null) {
            this.i = new wf1(coordinatorLayout.getContext(), coordinatorLayout, this.v);
        }
        int iH2 = this.a.H(view);
        coordinatorLayout.q(view, i);
        this.m = coordinatorLayout.getWidth();
        this.n = this.a.I(coordinatorLayout);
        this.l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.o = marginLayoutParams != null ? this.a.b(marginLayoutParams) : 0;
        int i7 = this.h;
        if (i7 == 1 || i7 == 2) {
            iH = iH2 - this.a.H(view);
        } else if (i7 == 3) {
            iH = 0;
        } else {
            if (i7 != 5) {
                zy.g("Unexpected value: ", this.h);
                return false;
            }
            iH = this.a.C();
        }
        view.offsetLeftAndRight(iH);
        if (this.q == null && (i2 = this.r) != -1 && (viewFindViewById = coordinatorLayout.findViewById(i2)) != null) {
            this.q = new WeakReference(viewFindViewById);
        }
        Iterator it = this.u.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                s1.d();
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.no
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // defpackage.no
    public final void m(View view, Parcelable parcelable) {
        int i = ((p01) parcelable).d;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.h = i;
    }

    @Override // defpackage.no
    public final Parcelable n(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new p01(this);
    }

    @Override // defpackage.no
    public final boolean q(View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.h == 1 && actionMasked == 0) {
            return true;
        }
        if (s()) {
            this.i.j(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.s) != null) {
            velocityTracker.recycle();
            this.s = null;
        }
        if (this.s == null) {
            this.s = VelocityTracker.obtain();
        }
        this.s.addMovement(motionEvent);
        if (s() && actionMasked == 2 && !this.j && s()) {
            float fAbs = Math.abs(this.t - motionEvent.getX());
            wf1 wf1Var = this.i;
            if (fAbs > wf1Var.b) {
                wf1Var.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.j;
    }

    public final void r(int i) {
        View view;
        if (this.h == i) {
            return;
        }
        this.h = i;
        WeakReference weakReference = this.p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i2 = this.h == 5 ? 4 : 0;
        if (view.getVisibility() != i2) {
            view.setVisibility(i2);
        }
        Iterator it = this.u.iterator();
        if (it.hasNext()) {
            throw l11.h(it);
        }
        u();
    }

    public final boolean s() {
        if (this.i != null) {
            return this.g || this.h == 1;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        if (r1.o(r0, r3.getTop()) != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if (r3 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        r(2);
        r2.e.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            r0 = 3
            if (r4 == r0) goto L17
            r0 = 5
            if (r4 != r0) goto Ld
            lc1 r0 = r2.a
            int r0 = r0.C()
            goto L1d
        Ld:
            java.lang.String r2 = "Invalid state to get outer edge offset: "
            java.lang.String r2 = defpackage.qq0.i(r2, r4)
            defpackage.zy.n(r2)
            return
        L17:
            lc1 r0 = r2.a
            int r0 = r0.B()
        L1d:
            wf1 r1 = r2.i
            if (r1 == 0) goto L55
            if (r5 == 0) goto L2e
            int r3 = r3.getTop()
            boolean r3 = r1.o(r0, r3)
            if (r3 == 0) goto L55
            goto L4b
        L2e:
            int r5 = r3.getTop()
            r1.r = r3
            r3 = -1
            r1.c = r3
            r3 = 0
            boolean r3 = r1.h(r0, r5, r3, r3)
            if (r3 != 0) goto L49
            int r5 = r1.a
            if (r5 != 0) goto L49
            android.view.View r5 = r1.r
            if (r5 == 0) goto L49
            r5 = 0
            r1.r = r5
        L49:
            if (r3 == 0) goto L55
        L4b:
            r3 = 2
            r2.r(r3)
            ah r2 = r2.e
            r2.a(r4)
            return
        L55:
            r2.r(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.sidesheet.SideSheetBehavior.t(android.view.View, int, boolean):void");
    }

    public final void u() {
        View view;
        WeakReference weakReference = this.p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        uf1.k(view, 262144);
        int i = 0;
        uf1.h(view, 0);
        uf1.k(view, 1048576);
        uf1.h(view, 0);
        int i2 = 5;
        if (this.h != 5) {
            uf1.l(view, h0.j, new o01(i2, i, this));
        }
        int i3 = 3;
        if (this.h != 3) {
            uf1.l(view, h0.h, new o01(i3, i, this));
        }
    }

    public SideSheetBehavior() {
        this.e = new ah(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.r = -1;
        this.u = new LinkedHashSet();
        this.v = new yg(this, 1);
    }
}
