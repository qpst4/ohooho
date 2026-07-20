package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.quickcursor.R;
import defpackage.ah;
import defpackage.ba;
import defpackage.eo;
import defpackage.h0;
import defpackage.hk0;
import defpackage.i1;
import defpackage.ik0;
import defpackage.j81;
import defpackage.jf1;
import defpackage.jl1;
import defpackage.l11;
import defpackage.lf1;
import defpackage.mz0;
import defpackage.no;
import defpackage.pn0;
import defpackage.qo;
import defpackage.qq0;
import defpackage.s1;
import defpackage.sg1;
import defpackage.uf1;
import defpackage.wf1;
import defpackage.wg;
import defpackage.x;
import defpackage.xg;
import defpackage.xh1;
import defpackage.y;
import defpackage.yb0;
import defpackage.yg;
import defpackage.yh1;
import defpackage.ys0;
import defpackage.zg;
import defpackage.zh1;
import defpackage.zy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends no {
    public final ah A;
    public final ValueAnimator B;
    public final int C;
    public int D;
    public int E;
    public final float F;
    public int G;
    public final float H;
    public boolean I;
    public boolean J;
    public final boolean K;
    public int L;
    public wf1 M;
    public boolean N;
    public int O;
    public boolean P;
    public final float Q;
    public int R;
    public int S;
    public int T;
    public WeakReference U;
    public WeakReference V;
    public final ArrayList W;
    public VelocityTracker X;
    public int Y;
    public int Z;
    public final int a;
    public boolean a0;
    public boolean b;
    public HashMap b0;
    public final float c;
    public final SparseIntArray c0;
    public final int d;
    public final yg d0;
    public int e;
    public boolean f;
    public int g;
    public final int h;
    public final ik0 i;
    public final ColorStateList j;
    public final int k;
    public final int l;
    public int m;
    public final boolean n;
    public final boolean o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final boolean t;
    public final boolean u;
    public int v;
    public int w;
    public final boolean x;
    public final mz0 y;
    public boolean z;

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        int i;
        int i2 = 0;
        this.a = 0;
        this.b = true;
        this.k = -1;
        this.l = -1;
        this.A = new ah(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Q = 0.1f;
        this.W = new ArrayList();
        this.Z = -1;
        this.c0 = new SparseIntArray();
        this.d0 = new yg(this, i2);
        this.h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ys0.b);
        if (typedArrayObtainStyledAttributes.hasValue(3)) {
            this.j = yb0.i(context, typedArrayObtainStyledAttributes, 3);
        }
        if (typedArrayObtainStyledAttributes.hasValue(21)) {
            this.y = mz0.b(context, attributeSet, R.attr.bottomSheetStyle, R.style.Widget_Design_BottomSheet_Modal).a();
        }
        mz0 mz0Var = this.y;
        if (mz0Var != null) {
            ik0 ik0Var = new ik0(mz0Var);
            this.i = ik0Var;
            ik0Var.i(context);
            ColorStateList colorStateList = this.j;
            if (colorStateList != null) {
                this.i.k(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.i.setTint(typedValue.data);
            }
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(s(), 1.0f);
        this.B = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(500L);
        this.B.addUpdateListener(new wg(i2, this));
        this.H = typedArrayObtainStyledAttributes.getDimension(2, -1.0f);
        if (typedArrayObtainStyledAttributes.hasValue(0)) {
            this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, -1);
        }
        if (typedArrayObtainStyledAttributes.hasValue(1)) {
            this.l = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, -1);
        }
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(9);
        if (typedValuePeekValue == null || (i = typedValuePeekValue.data) != -1) {
            A(typedArrayObtainStyledAttributes.getDimensionPixelSize(9, -1));
        } else {
            A(i);
        }
        boolean z = typedArrayObtainStyledAttributes.getBoolean(8, false);
        if (this.I != z) {
            this.I = z;
            if (!z && this.L == 5) {
                B(4);
            }
            F();
        }
        this.n = typedArrayObtainStyledAttributes.getBoolean(13, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(6, true);
        if (this.b != z2) {
            this.b = z2;
            if (this.U != null) {
                r();
            }
            C((this.b && this.L == 6) ? 3 : this.L);
            G(this.L, true);
            F();
        }
        this.J = typedArrayObtainStyledAttributes.getBoolean(12, false);
        this.K = typedArrayObtainStyledAttributes.getBoolean(4, true);
        this.a = typedArrayObtainStyledAttributes.getInt(10, 0);
        float f = typedArrayObtainStyledAttributes.getFloat(7, 0.5f);
        if (f <= 0.0f || f >= 1.0f) {
            zy.n("ratio must be a float value between 0 and 1");
            throw null;
        }
        this.F = f;
        if (this.U != null) {
            this.E = (int) ((1.0f - f) * this.T);
        }
        TypedValue typedValuePeekValue2 = typedArrayObtainStyledAttributes.peekValue(5);
        if (typedValuePeekValue2 == null || typedValuePeekValue2.type != 16) {
            int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(5, 0);
            if (dimensionPixelOffset < 0) {
                zy.n("offset must be greater than or equal to 0");
                throw null;
            }
            this.C = dimensionPixelOffset;
            G(this.L, true);
        } else {
            int i3 = typedValuePeekValue2.data;
            if (i3 < 0) {
                zy.n("offset must be greater than or equal to 0");
                throw null;
            }
            this.C = i3;
            G(this.L, true);
        }
        this.d = typedArrayObtainStyledAttributes.getInt(11, 500);
        this.o = typedArrayObtainStyledAttributes.getBoolean(17, false);
        this.p = typedArrayObtainStyledAttributes.getBoolean(18, false);
        this.q = typedArrayObtainStyledAttributes.getBoolean(19, false);
        this.r = typedArrayObtainStyledAttributes.getBoolean(20, true);
        this.s = typedArrayObtainStyledAttributes.getBoolean(14, false);
        this.t = typedArrayObtainStyledAttributes.getBoolean(15, false);
        this.u = typedArrayObtainStyledAttributes.getBoolean(16, false);
        this.x = typedArrayObtainStyledAttributes.getBoolean(23, true);
        typedArrayObtainStyledAttributes.recycle();
        this.c = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    public static View v(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        WeakHashMap weakHashMap = uf1.a;
        if (lf1.h(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewV = v(viewGroup.getChildAt(i));
            if (viewV != null) {
                return viewV;
            }
        }
        return null;
    }

    public static int w(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        if (mode == 1073741824) {
            return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), 1073741824);
        }
        if (size != 0) {
            i3 = Math.min(size, i3);
        }
        return View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
    }

    public final void A(int i) {
        boolean z = this.f;
        if (i == -1) {
            if (z) {
                return;
            } else {
                this.f = true;
            }
        } else {
            if (!z && this.e == i) {
                return;
            }
            this.f = false;
            this.e = Math.max(0, i);
        }
        I();
    }

    public final void B(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException(l11.k(new StringBuilder("STATE_"), i == 1 ? "DRAGGING" : "SETTLING", " should not be set externally."));
        }
        if (!this.I && i == 5) {
            Log.w("BottomSheetBehavior", "Cannot set state: " + i);
            return;
        }
        int i2 = (i == 6 && this.b && y(i) <= this.D) ? 3 : i;
        WeakReference weakReference = this.U;
        if (weakReference == null || weakReference.get() == null) {
            C(i);
            return;
        }
        View view = (View) this.U.get();
        ba baVar = new ba(this, view, i2);
        ViewParent parent = view.getParent();
        if (parent != null && parent.isLayoutRequested()) {
            WeakHashMap weakHashMap = uf1.a;
            if (view.isAttachedToWindow()) {
                view.post(baVar);
                return;
            }
        }
        baVar.run();
    }

    public final void C(int i) {
        if (this.L == i) {
            return;
        }
        this.L = i;
        if (i != 4 && i != 3 && i != 6) {
            boolean z = this.I;
        }
        WeakReference weakReference = this.U;
        if (weakReference == null || ((View) weakReference.get()) == null) {
            return;
        }
        if (i == 3) {
            H(true);
        } else if (i == 6 || i == 5 || i == 4) {
            H(false);
        }
        G(i, true);
        ArrayList arrayList = this.W;
        if (arrayList.size() <= 0) {
            F();
        } else {
            arrayList.get(0).getClass();
            s1.d();
        }
    }

    public final boolean D(View view, float f) {
        if (this.J) {
            return true;
        }
        if (view.getTop() < this.G) {
            return false;
        }
        return Math.abs(((f * this.Q) + ((float) view.getTop())) - ((float) this.G)) / ((float) t()) > 0.5f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
    
        if (r3 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0032, code lost:
    
        C(2);
        G(r4, true);
        r2.A.a(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x003f, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r1.o(r3.getLeft(), r0) != false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E(android.view.View r3, int r4, boolean r5) {
        /*
            r2 = this;
            int r0 = r2.y(r4)
            wf1 r1 = r2.M
            if (r1 == 0) goto L40
            if (r5 == 0) goto L15
            int r3 = r3.getLeft()
            boolean r3 = r1.o(r3, r0)
            if (r3 == 0) goto L40
            goto L32
        L15:
            int r5 = r3.getLeft()
            r1.r = r3
            r3 = -1
            r1.c = r3
            r3 = 0
            boolean r3 = r1.h(r5, r0, r3, r3)
            if (r3 != 0) goto L30
            int r5 = r1.a
            if (r5 != 0) goto L30
            android.view.View r5 = r1.r
            if (r5 == 0) goto L30
            r5 = 0
            r1.r = r5
        L30:
            if (r3 == 0) goto L40
        L32:
            r3 = 2
            r2.C(r3)
            r3 = 1
            r2.G(r4, r3)
            ah r2 = r2.A
            r2.a(r4)
            return
        L40:
            r2.C(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.E(android.view.View, int, boolean):void");
    }

    public final void F() {
        View view;
        int iA;
        WeakReference weakReference = this.U;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        uf1.k(view, 524288);
        uf1.h(view, 0);
        uf1.k(view, 262144);
        uf1.h(view, 0);
        uf1.k(view, 1048576);
        uf1.h(view, 0);
        SparseIntArray sparseIntArray = this.c0;
        int i = sparseIntArray.get(0, -1);
        if (i != -1) {
            uf1.k(view, i);
            uf1.h(view, 0);
            sparseIntArray.delete(0);
        }
        if (!this.b && this.L != 6) {
            String string = view.getResources().getString(R.string.bottomsheet_action_expand_halfway);
            jl1 jl1Var = new jl1(6, this);
            ArrayList arrayListF = uf1.f(view);
            int i2 = 0;
            while (true) {
                if (i2 >= arrayListF.size()) {
                    int i3 = 0;
                    int i4 = -1;
                    while (true) {
                        int[] iArr = uf1.d;
                        if (i3 >= 32 || i4 != -1) {
                            break;
                        }
                        int i5 = iArr[i3];
                        boolean z = true;
                        for (int i6 = 0; i6 < arrayListF.size(); i6++) {
                            z &= ((h0) arrayListF.get(i6)).a() != i5;
                        }
                        if (z) {
                            i4 = i5;
                        }
                        i3++;
                    }
                    iA = i4;
                } else {
                    if (TextUtils.equals(string, ((AccessibilityNodeInfo.AccessibilityAction) ((h0) arrayListF.get(i2)).a).getLabel())) {
                        iA = ((h0) arrayListF.get(i2)).a();
                        break;
                    }
                    i2++;
                }
            }
            if (iA != -1) {
                h0 h0Var = new h0(null, iA, string, jl1Var, null);
                View.AccessibilityDelegate accessibilityDelegateD = uf1.d(view);
                y yVar = accessibilityDelegateD == null ? null : accessibilityDelegateD instanceof x ? ((x) accessibilityDelegateD).a : new y(accessibilityDelegateD);
                if (yVar == null) {
                    yVar = new y();
                }
                uf1.n(view, yVar);
                uf1.k(view, h0Var.a());
                uf1.f(view).add(h0Var);
                uf1.h(view, 0);
            }
            sparseIntArray.put(0, iA);
        }
        if (this.I && this.L != 5) {
            uf1.l(view, h0.j, new jl1(5, this));
        }
        int i7 = this.L;
        if (i7 == 3) {
            uf1.l(view, h0.i, new jl1(this.b ? 4 : 6, this));
            return;
        }
        if (i7 == 4) {
            uf1.l(view, h0.h, new jl1(this.b ? 3 : 6, this));
        } else {
            if (i7 != 6) {
                return;
            }
            uf1.l(view, h0.i, new jl1(4, this));
            uf1.l(view, h0.h, new jl1(3, this));
        }
    }

    public final void G(int i, boolean z) {
        ik0 ik0Var;
        if (i == 2) {
            return;
        }
        boolean z2 = this.L == 3 && (this.x || z());
        if (this.z == z2 || (ik0Var = this.i) == null) {
            return;
        }
        this.z = z2;
        ValueAnimator valueAnimator = this.B;
        if (z && valueAnimator != null) {
            if (valueAnimator.isRunning()) {
                valueAnimator.reverse();
                return;
            } else {
                valueAnimator.setFloatValues(ik0Var.b.i, z2 ? s() : 1.0f);
                valueAnimator.start();
                return;
            }
        }
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
        }
        float fS = this.z ? s() : 1.0f;
        hk0 hk0Var = ik0Var.b;
        if (hk0Var.i != fS) {
            hk0Var.i = fS;
            ik0Var.f = true;
            ik0Var.invalidateSelf();
        }
    }

    public final void H(boolean z) {
        WeakReference weakReference = this.U;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = ((View) weakReference.get()).getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.b0 != null) {
                    return;
                } else {
                    this.b0 = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.U.get() && z) {
                    this.b0.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                }
            }
            if (z) {
                return;
            }
            this.b0 = null;
        }
    }

    public final void I() {
        View view;
        if (this.U != null) {
            r();
            if (this.L != 4 || (view = (View) this.U.get()) == null) {
                return;
            }
            view.requestLayout();
        }
    }

    @Override // defpackage.no
    public final void c(qo qoVar) {
        this.U = null;
        this.M = null;
    }

    @Override // defpackage.no
    public final void e() {
        this.U = null;
        this.M = null;
    }

    @Override // defpackage.no
    public final boolean f(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        int i;
        wf1 wf1Var;
        if (!view.isShown() || !this.K) {
            this.N = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.Y = -1;
            this.Z = -1;
            VelocityTracker velocityTracker = this.X;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.X = null;
            }
        }
        if (this.X == null) {
            this.X = VelocityTracker.obtain();
        }
        this.X.addMovement(motionEvent);
        if (actionMasked == 0) {
            int x = (int) motionEvent.getX();
            this.Z = (int) motionEvent.getY();
            if (this.L != 2) {
                WeakReference weakReference = this.V;
                View view2 = weakReference != null ? (View) weakReference.get() : null;
                if (view2 != null && coordinatorLayout.o(view2, x, this.Z)) {
                    this.Y = motionEvent.getPointerId(motionEvent.getActionIndex());
                    this.a0 = true;
                }
            }
            this.N = this.Y == -1 && !coordinatorLayout.o(view, x, this.Z);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.a0 = false;
            this.Y = -1;
            if (this.N) {
                this.N = false;
                return false;
            }
        }
        if (this.N || (wf1Var = this.M) == null || !wf1Var.p(motionEvent)) {
            WeakReference weakReference2 = this.V;
            View view3 = weakReference2 != null ? (View) weakReference2.get() : null;
            if (actionMasked != 2 || view3 == null || this.N || this.L == 1 || coordinatorLayout.o(view3, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.M == null || (i = this.Z) == -1 || Math.abs(i - motionEvent.getY()) <= this.M.b) {
                return false;
            }
        }
        return true;
    }

    @Override // defpackage.no
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
        WeakHashMap weakHashMap = uf1.a;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        boolean z = false;
        if (this.U == null) {
            this.g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            int i2 = Build.VERSION.SDK_INT;
            boolean z2 = (i2 < 29 || this.n || this.f) ? false : true;
            if (this.o || this.p || this.q || this.s || this.t || this.u || z2) {
                xg xgVar = new xg(this, z2);
                int paddingStart = view.getPaddingStart();
                view.getPaddingTop();
                int paddingEnd = view.getPaddingEnd();
                int paddingBottom = view.getPaddingBottom();
                j81 j81Var = new j81();
                j81Var.b = paddingStart;
                j81Var.c = paddingEnd;
                j81Var.d = paddingBottom;
                lf1.l(view, new pn0(xgVar, j81Var, 15, z));
                if (view.isAttachedToWindow()) {
                    jf1.c(view);
                } else {
                    view.addOnAttachStateChangeListener(new sg1());
                }
            }
            eo eoVar = new eo(view);
            if (i2 >= 30) {
                view.setWindowInsetsAnimationCallback(new zh1(eoVar));
            } else {
                PathInterpolator pathInterpolator = yh1.e;
                View.OnApplyWindowInsetsListener xh1Var = new xh1(view, eoVar);
                view.setTag(R.id.tag_window_insets_animation_callback, xh1Var);
                if (view.getTag(R.id.tag_compat_insets_dispatch) == null && view.getTag(R.id.tag_on_apply_window_listener) == null) {
                    view.setOnApplyWindowInsetsListener(xh1Var);
                }
            }
            this.U = new WeakReference(view);
            Context context = view.getContext();
            i1.U(context, R.attr.motionEasingStandardDecelerateInterpolator, new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f));
            i1.T(context, R.attr.motionDurationMedium2, 300);
            i1.T(context, R.attr.motionDurationShort3, 150);
            i1.T(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_x_distance);
            resources.getDimension(R.dimen.m3_back_progress_bottom_container_max_scale_y_distance);
            ik0 ik0Var = this.i;
            if (ik0Var != null) {
                view.setBackground(ik0Var);
                float fE = this.H;
                if (fE == -1.0f) {
                    fE = lf1.e(view);
                }
                ik0Var.j(fE);
            } else {
                ColorStateList colorStateList = this.j;
                if (colorStateList != null) {
                    lf1.i(view, colorStateList);
                }
            }
            F();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
        }
        if (this.M == null) {
            this.M = new wf1(coordinatorLayout.getContext(), coordinatorLayout, this.d0);
        }
        int top = view.getTop();
        coordinatorLayout.q(view, i);
        this.S = coordinatorLayout.getWidth();
        this.T = coordinatorLayout.getHeight();
        int height = view.getHeight();
        this.R = height;
        int iMin = this.T;
        int i3 = iMin - height;
        int i4 = this.w;
        if (i3 < i4) {
            boolean z3 = this.r;
            int i5 = this.l;
            if (z3) {
                if (i5 != -1) {
                    iMin = Math.min(iMin, i5);
                }
                this.R = iMin;
            } else {
                int iMin2 = iMin - i4;
                if (i5 != -1) {
                    iMin2 = Math.min(iMin2, i5);
                }
                this.R = iMin2;
            }
        }
        this.D = Math.max(0, this.T - this.R);
        this.E = (int) ((1.0f - this.F) * this.T);
        r();
        int i6 = this.L;
        if (i6 == 3) {
            view.offsetTopAndBottom(x());
        } else if (i6 == 6) {
            view.offsetTopAndBottom(this.E);
        } else if (this.I && i6 == 5) {
            view.offsetTopAndBottom(this.T);
        } else if (i6 == 4) {
            view.offsetTopAndBottom(this.G);
        } else if (i6 == 1 || i6 == 2) {
            view.offsetTopAndBottom(top - view.getTop());
        }
        G(this.L, false);
        this.V = new WeakReference(v(view));
        ArrayList arrayList = this.W;
        if (arrayList.size() <= 0) {
            return true;
        }
        arrayList.get(0).getClass();
        s1.d();
        return false;
    }

    @Override // defpackage.no
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(w(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, this.k, marginLayoutParams.width), w(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, this.l, marginLayoutParams.height));
        return true;
    }

    @Override // defpackage.no
    public final boolean i(View view) {
        WeakReference weakReference = this.V;
        return (weakReference == null || view != weakReference.get() || this.L == 3) ? false : true;
    }

    @Override // defpackage.no
    public final void j(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        WeakReference weakReference = this.V;
        if (view2 != (weakReference != null ? (View) weakReference.get() : null)) {
            return;
        }
        int top = view.getTop();
        int i4 = top - i2;
        boolean z = this.K;
        if (i2 > 0) {
            if (i4 < x()) {
                int iX = top - x();
                iArr[1] = iX;
                int i5 = -iX;
                WeakHashMap weakHashMap = uf1.a;
                view.offsetTopAndBottom(i5);
                C(3);
            } else {
                if (!z) {
                    return;
                }
                iArr[1] = i2;
                WeakHashMap weakHashMap2 = uf1.a;
                view.offsetTopAndBottom(-i2);
                C(1);
            }
        } else if (i2 < 0 && !view2.canScrollVertically(-1)) {
            int i6 = this.G;
            if (i4 > i6 && !this.I) {
                int i7 = top - i6;
                iArr[1] = i7;
                int i8 = -i7;
                WeakHashMap weakHashMap3 = uf1.a;
                view.offsetTopAndBottom(i8);
                C(4);
            } else {
                if (!z) {
                    return;
                }
                iArr[1] = i2;
                WeakHashMap weakHashMap4 = uf1.a;
                view.offsetTopAndBottom(-i2);
                C(1);
            }
        }
        u(view.getTop());
        this.O = i2;
        this.P = true;
    }

    @Override // defpackage.no
    public final void m(View view, Parcelable parcelable) {
        zg zgVar = (zg) parcelable;
        int i = this.a;
        if (i != 0) {
            if (i == -1 || (i & 1) == 1) {
                this.e = zgVar.e;
            }
            if (i == -1 || (i & 2) == 2) {
                this.b = zgVar.f;
            }
            if (i == -1 || (i & 4) == 4) {
                this.I = zgVar.g;
            }
            if (i == -1 || (i & 8) == 8) {
                this.J = zgVar.h;
            }
        }
        int i2 = zgVar.d;
        if (i2 == 1 || i2 == 2) {
            this.L = 4;
        } else {
            this.L = i2;
        }
    }

    @Override // defpackage.no
    public final Parcelable n(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new zg(this);
    }

    @Override // defpackage.no
    public final boolean o(View view, int i, int i2) {
        this.O = 0;
        this.P = false;
        return (i & 2) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    @Override // defpackage.no
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(android.view.View r4, android.view.View r5, int r6) {
        /*
            r3 = this;
            int r6 = r4.getTop()
            int r0 = r3.x()
            r1 = 3
            if (r6 != r0) goto Lf
            r3.C(r1)
            return
        Lf:
            java.lang.ref.WeakReference r6 = r3.V
            if (r6 == 0) goto Lb5
            java.lang.Object r6 = r6.get()
            if (r5 != r6) goto Lb5
            boolean r5 = r3.P
            if (r5 != 0) goto L1f
            goto Lb5
        L1f:
            int r5 = r3.O
            r6 = 6
            if (r5 <= 0) goto L34
            boolean r5 = r3.b
            if (r5 == 0) goto L2a
            goto Laf
        L2a:
            int r5 = r4.getTop()
            int r0 = r3.E
            if (r5 <= r0) goto Laf
            goto Lae
        L34:
            boolean r5 = r3.I
            if (r5 == 0) goto L55
            android.view.VelocityTracker r5 = r3.X
            if (r5 != 0) goto L3e
            r5 = 0
            goto L4d
        L3e:
            r0 = 1000(0x3e8, float:1.401E-42)
            float r2 = r3.c
            r5.computeCurrentVelocity(r0, r2)
            android.view.VelocityTracker r5 = r3.X
            int r0 = r3.Y
            float r5 = r5.getYVelocity(r0)
        L4d:
            boolean r5 = r3.D(r4, r5)
            if (r5 == 0) goto L55
            r1 = 5
            goto Laf
        L55:
            int r5 = r3.O
            r0 = 4
            if (r5 != 0) goto L93
            int r5 = r4.getTop()
            boolean r2 = r3.b
            if (r2 == 0) goto L74
            int r6 = r3.D
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r2 = r3.G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r6 >= r5) goto L97
            goto Laf
        L74:
            int r2 = r3.E
            if (r5 >= r2) goto L83
            int r0 = r3.G
            int r0 = r5 - r0
            int r0 = java.lang.Math.abs(r0)
            if (r5 >= r0) goto Lae
            goto Laf
        L83:
            int r1 = r5 - r2
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r1 >= r5) goto L97
            goto Lae
        L93:
            boolean r5 = r3.b
            if (r5 == 0) goto L99
        L97:
            r1 = r0
            goto Laf
        L99:
            int r5 = r4.getTop()
            int r1 = r3.E
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.G
            int r5 = r5 - r2
            int r5 = java.lang.Math.abs(r5)
            if (r1 >= r5) goto L97
        Lae:
            r1 = r6
        Laf:
            r5 = 0
            r3.E(r4, r1, r5)
            r3.P = r5
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.p(android.view.View, android.view.View, int):void");
    }

    @Override // defpackage.no
    public final boolean q(View view, MotionEvent motionEvent) {
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        int i = this.L;
        if (i == 1 && actionMasked == 0) {
            return true;
        }
        wf1 wf1Var = this.M;
        boolean z = this.K;
        if (wf1Var != null && (z || i == 1)) {
            wf1Var.j(motionEvent);
        }
        if (actionMasked == 0) {
            this.Y = -1;
            this.Z = -1;
            VelocityTracker velocityTracker = this.X;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.X = null;
            }
        }
        if (this.X == null) {
            this.X = VelocityTracker.obtain();
        }
        this.X.addMovement(motionEvent);
        if (this.M != null && ((z || this.L == 1) && actionMasked == 2 && !this.N)) {
            float fAbs = Math.abs(this.Z - motionEvent.getY());
            wf1 wf1Var2 = this.M;
            if (fAbs > wf1Var2.b) {
                wf1Var2.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.N;
    }

    public final void r() {
        int iT = t();
        boolean z = this.b;
        int i = this.T;
        if (z) {
            this.G = Math.max(i - iT, this.D);
        } else {
            this.G = i - iT;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final float s() {
        /*
            r5 = this;
            r0 = 0
            ik0 r1 = r5.i
            if (r1 == 0) goto L75
            java.lang.ref.WeakReference r2 = r5.U
            if (r2 == 0) goto L75
            java.lang.Object r2 = r2.get()
            if (r2 == 0) goto L75
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 31
            if (r2 < r3) goto L75
            java.lang.ref.WeakReference r2 = r5.U
            java.lang.Object r2 = r2.get()
            android.view.View r2 = (android.view.View) r2
            boolean r5 = r5.z()
            if (r5 == 0) goto L75
            android.view.WindowInsets r5 = r2.getRootWindowInsets()
            if (r5 == 0) goto L75
            hk0 r2 = r1.b
            mz0 r2 = r2.a
            bp r2 = r2.e
            android.graphics.RectF r3 = r1.g()
            float r2 = r2.a(r3)
            android.view.RoundedCorner r3 = defpackage.dg.n(r5)
            if (r3 == 0) goto L4c
            int r3 = defpackage.dg.d(r3)
            float r3 = (float) r3
            int r4 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r4 <= 0) goto L4c
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L4c
            float r3 = r3 / r2
            goto L4d
        L4c:
            r3 = r0
        L4d:
            hk0 r2 = r1.b
            mz0 r2 = r2.a
            bp r2 = r2.f
            android.graphics.RectF r1 = r1.g()
            float r1 = r2.a(r1)
            android.view.RoundedCorner r5 = defpackage.dg.s(r5)
            if (r5 == 0) goto L70
            int r5 = defpackage.dg.d(r5)
            float r5 = (float) r5
            int r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r2 <= 0) goto L70
            int r2 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r2 <= 0) goto L70
            float r0 = r5 / r1
        L70:
            float r5 = java.lang.Math.max(r3, r0)
            return r5
        L75:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomsheet.BottomSheetBehavior.s():float");
    }

    public final int t() {
        int iMin;
        int i;
        int i2;
        if (this.f) {
            iMin = Math.min(Math.max(this.g, this.T - ((this.S * 9) / 16)), this.R);
            i = this.v;
        } else {
            if (!this.n && !this.o && (i2 = this.m) > 0) {
                return Math.max(this.e, i2 + this.h);
            }
            iMin = this.e;
            i = this.v;
        }
        return iMin + i;
    }

    public final void u(int i) {
        if (((View) this.U.get()) != null) {
            ArrayList arrayList = this.W;
            if (arrayList.isEmpty()) {
                return;
            }
            int i2 = this.G;
            if (i <= i2 && i2 != x()) {
                x();
            }
            if (arrayList.size() <= 0) {
                return;
            }
            arrayList.get(0).getClass();
            s1.d();
        }
    }

    public final int x() {
        if (this.b) {
            return this.D;
        }
        return Math.max(this.C, this.r ? 0 : this.w);
    }

    public final int y(int i) {
        if (i == 3) {
            return x();
        }
        if (i == 4) {
            return this.G;
        }
        if (i == 5) {
            return this.T;
        }
        if (i == 6) {
            return this.E;
        }
        zy.n(qq0.i("Invalid state to get top offset: ", i));
        return 0;
    }

    public final boolean z() {
        WeakReference weakReference = this.U;
        if (weakReference != null && weakReference.get() != null) {
            int[] iArr = new int[2];
            ((View) this.U.get()).getLocationOnScreen(iArr);
            if (iArr[1] == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.no
    public final void k(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.k = -1;
        this.l = -1;
        this.A = new ah(this);
        this.F = 0.5f;
        this.H = -1.0f;
        this.K = true;
        this.L = 4;
        this.Q = 0.1f;
        this.W = new ArrayList();
        this.Z = -1;
        this.c0 = new SparseIntArray();
        this.d0 = new yg(this, 0);
    }
}
