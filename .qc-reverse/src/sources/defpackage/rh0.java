package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class rh0 implements n01 {
    public static final Method B;
    public static final Method C;
    public final h9 A;
    public final Context b;
    public ListAdapter c;
    public bv d;
    public int g;
    public int h;
    public boolean j;
    public boolean k;
    public boolean l;
    public d10 o;
    public View p;
    public AdapterView.OnItemClickListener q;
    public AdapterView.OnItemSelectedListener r;
    public final Handler w;
    public Rect y;
    public boolean z;
    public final int e = -2;
    public int f = -2;
    public final int i = 1002;
    public int m = 0;
    public final int n = Integer.MAX_VALUE;
    public final oh0 s = new oh0(this, 1);
    public final qh0 t = new qh0(0, this);
    public final ph0 u = new ph0(this);
    public final oh0 v = new oh0(this, 0);
    public final Rect x = new Rect();

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                B = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                C = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public rh0(Context context, AttributeSet attributeSet, int i, int i2) {
        int resourceId;
        this.b = context;
        this.w = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, zs0.o, i, 0);
        this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(0, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(1, 0);
        this.h = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.j = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        h9 h9Var = new h9(context, attributeSet, i, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, zs0.s, i, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(2)) {
            h9Var.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(2, false));
        }
        h9Var.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(0) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(0, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(0) : tk0.j(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.A = h9Var;
        h9Var.setInputMethodMode(1);
    }

    public final Drawable a() {
        return this.A.getBackground();
    }

    @Override // defpackage.n01
    public final boolean b() {
        return this.A.isShowing();
    }

    public final int c() {
        return this.g;
    }

    @Override // defpackage.n01
    public final void d() {
        int i;
        int paddingBottom;
        bv bvVar;
        bv bvVar2 = this.d;
        Context context = this.b;
        int i2 = 1;
        h9 h9Var = this.A;
        if (bvVar2 == null) {
            bv bvVarQ = q(context, !this.z);
            this.d = bvVarQ;
            bvVarQ.setAdapter(this.c);
            this.d.setOnItemClickListener(this.q);
            this.d.setFocusable(true);
            this.d.setFocusableInTouchMode(true);
            this.d.setOnItemSelectedListener(new cv(i2, this));
            this.d.setOnScrollListener(this.u);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.r;
            if (onItemSelectedListener != null) {
                this.d.setOnItemSelectedListener(onItemSelectedListener);
            }
            h9Var.setContentView(this.d);
        }
        Drawable background = h9Var.getBackground();
        Rect rect = this.x;
        if (background != null) {
            background.getPadding(rect);
            int i3 = rect.top;
            i = rect.bottom + i3;
            if (!this.j) {
                this.h = -i3;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        int iA = mh0.a(h9Var, this.p, this.h, h9Var.getInputMethodMode() == 2);
        int i4 = this.e;
        if (i4 == -1) {
            paddingBottom = iA + i;
        } else {
            int i5 = this.f;
            int iA2 = this.d.a(i5 != -2 ? i5 != -1 ? View.MeasureSpec.makeMeasureSpec(i5, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
            paddingBottom = iA2 + (iA2 > 0 ? this.d.getPaddingBottom() + this.d.getPaddingTop() + i : 0);
        }
        boolean z = h9Var.getInputMethodMode() == 2;
        h9Var.setWindowLayoutType(this.i);
        if (h9Var.isShowing()) {
            if (this.p.isAttachedToWindow()) {
                int width = this.f;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.p.getWidth();
                }
                if (i4 == -1) {
                    i4 = z ? paddingBottom : -1;
                    int i6 = this.f;
                    if (z) {
                        h9Var.setWidth(i6 == -1 ? -1 : 0);
                        h9Var.setHeight(0);
                    } else {
                        h9Var.setWidth(i6 == -1 ? -1 : 0);
                        h9Var.setHeight(-1);
                    }
                } else if (i4 == -2) {
                    i4 = paddingBottom;
                }
                h9Var.setOutsideTouchable(true);
                int i7 = width;
                View view = this.p;
                int i8 = this.g;
                int i9 = this.h;
                int i10 = i7 < 0 ? -1 : i7;
                if (i4 < 0) {
                    i4 = -1;
                }
                h9Var.update(view, i8, i9, i10, i4);
                return;
            }
            return;
        }
        int width2 = this.f;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.p.getWidth();
        }
        if (i4 == -1) {
            i4 = -1;
        } else if (i4 == -2) {
            i4 = paddingBottom;
        }
        h9Var.setWidth(width2);
        h9Var.setHeight(i4);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = B;
            if (method != null) {
                try {
                    method.invoke(h9Var, Boolean.TRUE);
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            nh0.b(h9Var, true);
        }
        h9Var.setOutsideTouchable(true);
        h9Var.setTouchInterceptor(this.t);
        if (this.l) {
            h9Var.setOverlapAnchor(this.k);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = C;
            if (method2 != null) {
                try {
                    method2.invoke(h9Var, this.y);
                } catch (Exception e) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                }
            }
        } else {
            nh0.a(h9Var, this.y);
        }
        h9Var.showAsDropDown(this.p, this.g, this.h, this.m);
        this.d.setSelection(-1);
        if ((!this.z || this.d.isInTouchMode()) && (bvVar = this.d) != null) {
            bvVar.setListSelectionHidden(true);
            bvVar.requestLayout();
        }
        if (this.z) {
            return;
        }
        this.w.post(this.v);
    }

    @Override // defpackage.n01
    public final void dismiss() {
        h9 h9Var = this.A;
        h9Var.dismiss();
        h9Var.setContentView(null);
        this.d = null;
        this.w.removeCallbacks(this.s);
    }

    public final void g(Drawable drawable) {
        this.A.setBackgroundDrawable(drawable);
    }

    @Override // defpackage.n01
    public final bv h() {
        return this.d;
    }

    public final void j(int i) {
        this.h = i;
        this.j = true;
    }

    public final void l(int i) {
        this.g = i;
    }

    public final int n() {
        if (this.j) {
            return this.h;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        d10 d10Var = this.o;
        if (d10Var == null) {
            this.o = new d10(2, this);
        } else {
            ListAdapter listAdapter2 = this.c;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(d10Var);
            }
        }
        this.c = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.o);
        }
        bv bvVar = this.d;
        if (bvVar != null) {
            bvVar.setAdapter(this.c);
        }
    }

    public bv q(Context context, boolean z) {
        return new bv(context, z);
    }

    public final void r(int i) {
        Drawable background = this.A.getBackground();
        if (background == null) {
            this.f = i;
            return;
        }
        Rect rect = this.x;
        background.getPadding(rect);
        this.f = rect.left + rect.right + i;
    }
}
