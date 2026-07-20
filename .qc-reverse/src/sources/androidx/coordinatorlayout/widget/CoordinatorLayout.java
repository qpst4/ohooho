package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.quickcursor.R;
import defpackage.g7;
import defpackage.ik;
import defpackage.jf1;
import defpackage.lf1;
import defpackage.mo;
import defpackage.no;
import defpackage.oo;
import defpackage.pm0;
import defpackage.po;
import defpackage.qm0;
import defpackage.qo;
import defpackage.rm0;
import defpackage.ro;
import defpackage.s1;
import defpackage.so;
import defpackage.sp1;
import defpackage.ss0;
import defpackage.t01;
import defpackage.uf1;
import defpackage.up0;
import defpackage.wi1;
import defpackage.zf1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements pm0, qm0 {
    public static final String u;
    public static final Class[] v;
    public static final ThreadLocal w;
    public static final ik x;
    public static final up0 y;
    public final ArrayList b;
    public final g7 c;
    public final ArrayList d;
    public final ArrayList e;
    public final int[] f;
    public final int[] g;
    public boolean h;
    public boolean i;
    public final int[] j;
    public View k;
    public View l;
    public ro m;
    public boolean n;
    public wi1 o;
    public boolean p;
    public Drawable q;
    public ViewGroup.OnHierarchyChangeListener r;
    public sp1 s;
    public final rm0 t;

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        u = r0 != null ? r0.getName() : null;
        x = new ik(1);
        v = new Class[]{Context.class, AttributeSet.class};
        w = new ThreadLocal();
        y = new up0(12);
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.b = new ArrayList();
        this.c = new g7(3);
        this.d = new ArrayList();
        this.e = new ArrayList();
        this.f = new int[2];
        this.g = new int[2];
        this.t = new rm0();
        int[] iArr = ss0.a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, typedArrayObtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.j = intArray;
            float f = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i = 0; i < length; i++) {
                this.j[i] = (int) (r1[i] * f);
            }
        }
        this.q = typedArrayObtainStyledAttributes.getDrawable(1);
        typedArrayObtainStyledAttributes.recycle();
        w();
        super.setOnHierarchyChangeListener(new po(this));
        WeakHashMap weakHashMap = uf1.a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect g() {
        Rect rect = (Rect) y.a();
        return rect == null ? new Rect() : rect;
    }

    public static void l(int i, Rect rect, Rect rect2, qo qoVar, int i2, int i3) {
        int i4 = qoVar.c;
        if (i4 == 0) {
            i4 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
        int i5 = qoVar.d;
        if ((i5 & 7) == 0) {
            i5 |= 8388611;
        }
        if ((i5 & 112) == 0) {
            i5 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i5, i);
        int i6 = absoluteGravity & 7;
        int i7 = absoluteGravity & 112;
        int i8 = absoluteGravity2 & 7;
        int i9 = absoluteGravity2 & 112;
        int iWidth = i8 != 1 ? i8 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int iHeight = i9 != 16 ? i9 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i6 == 1) {
            iWidth -= i2 / 2;
        } else if (i6 != 5) {
            iWidth -= i2;
        }
        if (i7 == 16) {
            iHeight -= i3 / 2;
        } else if (i7 != 80) {
            iHeight -= i3;
        }
        rect2.set(iWidth, iHeight, i2 + iWidth, i3 + iHeight);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static qo n(View view) {
        qo qoVar = (qo) view.getLayoutParams();
        if (!qoVar.b) {
            if (view instanceof mo) {
                no behavior = ((mo) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                no noVar = qoVar.a;
                if (noVar != behavior) {
                    if (noVar != null) {
                        noVar.e();
                    }
                    qoVar.a = behavior;
                    qoVar.b = true;
                    if (behavior != null) {
                        behavior.c(qoVar);
                    }
                }
                qoVar.b = true;
                return qoVar;
            }
            oo ooVar = null;
            for (Class<?> superclass = view.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
                ooVar = (oo) superclass.getAnnotation(oo.class);
                if (ooVar != null) {
                    break;
                }
            }
            if (ooVar != null) {
                try {
                    no noVar2 = (no) ooVar.value().getDeclaredConstructor(null).newInstance(null);
                    no noVar3 = qoVar.a;
                    if (noVar3 != noVar2) {
                        if (noVar3 != null) {
                            noVar3.e();
                        }
                        qoVar.a = noVar2;
                        qoVar.b = true;
                        if (noVar2 != null) {
                            noVar2.c(qoVar);
                        }
                    }
                } catch (Exception e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + ooVar.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            qoVar.b = true;
        }
        return qoVar;
    }

    public static void u(View view, int i) {
        qo qoVar = (qo) view.getLayoutParams();
        int i2 = qoVar.i;
        if (i2 != i) {
            WeakHashMap weakHashMap = uf1.a;
            view.offsetLeftAndRight(i - i2);
            qoVar.i = i;
        }
    }

    public static void v(View view, int i) {
        qo qoVar = (qo) view.getLayoutParams();
        int i2 = qoVar.j;
        if (i2 != i) {
            WeakHashMap weakHashMap = uf1.a;
            view.offsetTopAndBottom(i - i2);
            qoVar.j = i;
        }
    }

    @Override // defpackage.pm0
    public final void a(View view, View view2, int i, int i2) {
        rm0 rm0Var = this.t;
        if (i2 == 1) {
            rm0Var.b = i;
        } else {
            rm0Var.a = i;
        }
        this.l = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((qo) getChildAt(i3).getLayoutParams()).getClass();
        }
    }

    @Override // defpackage.pm0
    public final void b(View view, int i) {
        rm0 rm0Var = this.t;
        if (i == 1) {
            rm0Var.b = 0;
        } else {
            rm0Var.a = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            qo qoVar = (qo) childAt.getLayoutParams();
            if (qoVar.a(i)) {
                no noVar = qoVar.a;
                if (noVar != null) {
                    noVar.p(childAt, view, i);
                }
                if (i == 0) {
                    qoVar.m = false;
                } else if (i == 1) {
                    qoVar.n = false;
                }
                qoVar.o = false;
            }
        }
        this.l = null;
    }

    @Override // defpackage.pm0
    public final void c(View view, int i, int i2, int[] iArr, int i3) {
        no noVar;
        int childCount = getChildCount();
        boolean z = false;
        int iMax = 0;
        int iMax2 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                qo qoVar = (qo) childAt.getLayoutParams();
                if (qoVar.a(i3) && (noVar = qoVar.a) != null) {
                    int[] iArr2 = this.f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    noVar.j(this, childAt, view, i, i2, iArr2, i3);
                    iMax = i > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i2 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iMax;
        iArr[1] = iMax2;
        if (z) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof qo) && super.checkLayoutParams(layoutParams);
    }

    @Override // defpackage.qm0
    public final void d(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        no noVar;
        int childCount = getChildCount();
        int iMax = 0;
        int iMax2 = 0;
        boolean z = false;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                qo qoVar = (qo) childAt.getLayoutParams();
                if (qoVar.a(i5) && (noVar = qoVar.a) != null) {
                    int[] iArr2 = this.f;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    noVar.k(this, childAt, i2, i3, i4, iArr2);
                    iMax = i3 > 0 ? Math.max(iMax, iArr2[0]) : Math.min(iMax, iArr2[0]);
                    iMax2 = i4 > 0 ? Math.max(iMax2, iArr2[1]) : Math.min(iMax2, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + iMax;
        iArr[1] = iArr[1] + iMax2;
        if (z) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        no noVar = ((qo) view.getLayoutParams()).a;
        if (noVar != null) {
            noVar.getClass();
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.q;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // defpackage.pm0
    public final void e(View view, int i, int i2, int i3, int i4, int i5) {
        d(view, i, i2, i3, i4, 0, this.g);
    }

    @Override // defpackage.pm0
    public final boolean f(View view, View view2, int i, int i2) {
        int childCount = getChildCount();
        boolean z = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                qo qoVar = (qo) childAt.getLayoutParams();
                no noVar = qoVar.a;
                if (noVar != null) {
                    boolean zO = noVar.o(childAt, i, i2);
                    z |= zO;
                    if (i2 == 0) {
                        qoVar.m = zO;
                    } else if (i2 == 1) {
                        qoVar.n = zO;
                    }
                } else if (i2 == 0) {
                    qoVar.m = false;
                } else if (i2 == 1) {
                    qoVar.n = false;
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new qo();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof qo ? new qo((qo) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new qo((ViewGroup.MarginLayoutParams) layoutParams) : new qo(layoutParams);
    }

    public final List<View> getDependencySortedChildren() {
        s();
        return Collections.unmodifiableList(this.b);
    }

    public final wi1 getLastWindowInsets() {
        return this.o;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        rm0 rm0Var = this.t;
        return rm0Var.b | rm0Var.a;
    }

    public Drawable getStatusBarBackground() {
        return this.q;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(qo qoVar, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) qoVar).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) qoVar).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) qoVar).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) qoVar).bottomMargin));
        rect.set(iMax, iMax2, i + iMax, i2 + iMax2);
    }

    public final void i(View view, Rect rect, boolean z) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            k(rect, view);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList j(View view) {
        t01 t01Var = (t01) this.c.d;
        int i = t01Var.d;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList arrayList2 = (ArrayList) t01Var.i(i2);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(t01Var.f(i2));
            }
        }
        ArrayList arrayList3 = this.e;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void k(Rect rect, View view) {
        ThreadLocal threadLocal = zf1.a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = zf1.a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        zf1.a(this, view, matrix);
        ThreadLocal threadLocal3 = zf1.b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int m(int i) {
        int[] iArr = this.j;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    public final boolean o(View view, int i, int i2) {
        up0 up0Var = y;
        Rect rectG = g();
        k(rectG, view);
        try {
            return rectG.contains(i, i2);
        } finally {
            rectG.setEmpty();
            up0Var.c(rectG);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        t(false);
        if (this.n) {
            if (this.m == null) {
                this.m = new ro(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.m);
        }
        if (this.o == null) {
            WeakHashMap weakHashMap = uf1.a;
            if (getFitsSystemWindows()) {
                jf1.c(this);
            }
        }
        this.i = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        t(false);
        if (this.n && this.m != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.m);
        }
        View view = this.l;
        if (view != null) {
            b(view, 0);
        }
        this.i = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.p || this.q == null) {
            return;
        }
        wi1 wi1Var = this.o;
        int iD = wi1Var != null ? wi1Var.d() : 0;
        if (iD > 0) {
            this.q.setBounds(0, 0, getWidth(), iD);
            this.q.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            t(true);
        }
        boolean zR = r(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return zR;
        }
        t(true);
        return zR;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        no noVar;
        WeakHashMap weakHashMap = uf1.a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) arrayList.get(i5);
            if (view.getVisibility() != 8 && ((noVar = ((qo) view.getLayoutParams()).a) == null || !noVar.g(this, view, layoutDirection))) {
                q(view, layoutDirection);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0189  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r27, int r28) {
        /*
            Method dump skipped, instruction units count: 499
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                qo qoVar = (qo) childAt.getLayoutParams();
                if (qoVar.a(0)) {
                    no noVar = qoVar.a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        no noVar;
        int childCount = getChildCount();
        boolean zI = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                qo qoVar = (qo) childAt.getLayoutParams();
                if (qoVar.a(0) && (noVar = qoVar.a) != null) {
                    zI |= noVar.i(view);
                }
            }
        }
        return zI;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        c(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        e(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof so)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        so soVar = (so) parcelable;
        super.onRestoreInstanceState(soVar.b);
        SparseArray sparseArray = soVar.d;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            no noVar = n(childAt).a;
            if (id != -1 && noVar != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                noVar.m(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableN;
        so soVar = new so(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            no noVar = ((qo) childAt.getLayoutParams()).a;
            if (id != -1 && noVar != null && (parcelableN = noVar.n(childAt)) != null) {
                sparseArray.append(id, parcelableN);
            }
        }
        soVar.d = sparseArray;
        return soVar;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return f(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        b(view, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0015 A[PHI: r3
  0x0015: PHI (r3v4 boolean) = (r3v2 boolean), (r3v5 boolean) binds: [B:10:0x0022, B:5:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            int r2 = r1.getActionMasked()
            android.view.View r3 = r0.k
            r4 = 1
            r5 = 0
            if (r3 != 0) goto L17
            boolean r3 = r0.r(r1, r4)
            if (r3 == 0) goto L15
            goto L18
        L15:
            r6 = r5
            goto L2a
        L17:
            r3 = r5
        L18:
            android.view.View r6 = r0.k
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            qo r6 = (defpackage.qo) r6
            no r6 = r6.a
            if (r6 == 0) goto L15
            android.view.View r7 = r0.k
            boolean r6 = r6.q(r7, r1)
        L2a:
            android.view.View r7 = r0.k
            r8 = 0
            if (r7 != 0) goto L35
            boolean r1 = super.onTouchEvent(r18)
            r6 = r6 | r1
            goto L48
        L35:
            if (r3 == 0) goto L48
            long r9 = android.os.SystemClock.uptimeMillis()
            r15 = 0
            r16 = 0
            r13 = 3
            r14 = 0
            r11 = r9
            android.view.MotionEvent r8 = android.view.MotionEvent.obtain(r9, r11, r13, r14, r15, r16)
            super.onTouchEvent(r8)
        L48:
            if (r8 == 0) goto L4d
            r8.recycle()
        L4d:
            if (r2 == r4) goto L54
            r1 = 3
            if (r2 != r1) goto L53
            goto L54
        L53:
            return r6
        L54:
            r0.t(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void p(int r23) {
        /*
            Method dump skipped, instruction units count: 752
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.p(int):void");
    }

    public final void q(View view, int i) {
        Rect rectG;
        Rect rectG2;
        qo qoVar = (qo) view.getLayoutParams();
        View view2 = qoVar.k;
        if (view2 == null && qoVar.f != -1) {
            s1.f("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
            return;
        }
        up0 up0Var = y;
        if (view2 != null) {
            rectG = g();
            rectG2 = g();
            try {
                k(rectG, view2);
                qo qoVar2 = (qo) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                l(i, rectG, rectG2, qoVar2, measuredWidth, measuredHeight);
                h(qoVar2, rectG2, measuredWidth, measuredHeight);
                view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
                return;
            } finally {
                rectG.setEmpty();
                up0Var.c(rectG);
                rectG2.setEmpty();
                up0Var.c(rectG2);
            }
        }
        int i2 = qoVar.e;
        if (i2 < 0) {
            qo qoVar3 = (qo) view.getLayoutParams();
            rectG = g();
            rectG.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) qoVar3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) qoVar3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) qoVar3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) qoVar3).bottomMargin);
            if (this.o != null) {
                WeakHashMap weakHashMap = uf1.a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    rectG.left = this.o.b() + rectG.left;
                    rectG.top = this.o.d() + rectG.top;
                    rectG.right -= this.o.c();
                    rectG.bottom -= this.o.a();
                }
            }
            rectG2 = g();
            int i3 = qoVar3.c;
            if ((i3 & 7) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            Gravity.apply(i3, view.getMeasuredWidth(), view.getMeasuredHeight(), rectG, rectG2, i);
            view.layout(rectG2.left, rectG2.top, rectG2.right, rectG2.bottom);
            return;
        }
        qo qoVar4 = (qo) view.getLayoutParams();
        int i4 = qoVar4.c;
        if (i4 == 0) {
            i4 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
        int i5 = absoluteGravity & 7;
        int i6 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i == 1) {
            i2 = width - i2;
        }
        int iM = m(i2) - measuredWidth2;
        if (i5 == 1) {
            iM += measuredWidth2 / 2;
        } else if (i5 == 5) {
            iM += measuredWidth2;
        }
        int i7 = i6 != 16 ? i6 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int iMax = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) qoVar4).leftMargin, Math.min(iM, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) qoVar4).rightMargin));
        int iMax2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) qoVar4).topMargin, Math.min(i7, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) qoVar4).bottomMargin));
        view.layout(iMax, iMax2, measuredWidth2 + iMax, measuredHeight2 + iMax2);
    }

    public final boolean r(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.d;
        arrayList.clear();
        boolean zIsChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            arrayList.add(getChildAt(zIsChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        ik ikVar = x;
        if (ikVar != null) {
            Collections.sort(arrayList, ikVar);
        }
        int size = arrayList.size();
        MotionEvent motionEventObtain = null;
        boolean zF = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) arrayList.get(i3);
            no noVar = ((qo) view.getLayoutParams()).a;
            if (zF && actionMasked != 0) {
                if (noVar != null) {
                    if (motionEventObtain == null) {
                        long jUptimeMillis = SystemClock.uptimeMillis();
                        motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i == 0) {
                        noVar.f(this, view, motionEventObtain);
                    } else if (i == 1) {
                        noVar.q(view, motionEventObtain);
                    }
                }
            } else if (!zF && noVar != null) {
                if (i == 0) {
                    zF = noVar.f(this, view, motionEvent);
                } else if (i == 1) {
                    zF = noVar.q(view, motionEvent);
                }
                if (zF) {
                    this.k = view;
                }
            }
        }
        arrayList.clear();
        return zF;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        no noVar = ((qo) view.getLayoutParams()).a;
        if (noVar != null) {
            noVar.l(this, view);
        }
        return super.requestChildRectangleOnScreen(view, rect, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.h) {
            return;
        }
        t(false);
        this.h = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instruction units count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.coordinatorlayout.widget.CoordinatorLayout.s():void");
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        w();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.r = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.q;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable drawableMutate = drawable != null ? drawable.mutate() : null;
            this.q = drawableMutate;
            if (drawableMutate != null) {
                if (drawableMutate.isStateful()) {
                    this.q.setState(getDrawableState());
                }
                Drawable drawable3 = this.q;
                WeakHashMap weakHashMap = uf1.a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.q.setVisible(getVisibility() == 0, false);
                this.q.setCallback(this);
            }
            WeakHashMap weakHashMap2 = uf1.a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? getContext().getDrawable(i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.q;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.q.setVisible(z, false);
    }

    public final void t(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            no noVar = ((qo) childAt.getLayoutParams()).a;
            if (noVar != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    noVar.f(this, childAt, motionEventObtain);
                } else {
                    noVar.q(childAt, motionEventObtain);
                }
                motionEventObtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((qo) getChildAt(i2).getLayoutParams()).getClass();
        }
        this.k = null;
        this.h = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.q;
    }

    public final void w() {
        WeakHashMap weakHashMap = uf1.a;
        if (!getFitsSystemWindows()) {
            lf1.l(this, null);
            return;
        }
        if (this.s == null) {
            this.s = new sp1(14, this);
        }
        lf1.l(this, this.s);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new qo(getContext(), attributeSet);
    }
}
