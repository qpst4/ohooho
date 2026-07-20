package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import com.quickcursor.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e71 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static e71 l;
    public static e71 m;
    public final View b;
    public final CharSequence c;
    public final int d;
    public final d71 e;
    public final d71 f;
    public int g;
    public int h;
    public f71 i;
    public boolean j;
    public boolean k;

    /* JADX WARN: Type inference failed for: r0v0, types: [d71] */
    /* JADX WARN: Type inference failed for: r0v1, types: [d71] */
    public e71(View view, CharSequence charSequence) {
        final int i = 0;
        this.e = new Runnable(this) { // from class: d71
            public final /* synthetic */ e71 c;

            {
                this.c = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i2 = i;
                e71 e71Var = this.c;
                switch (i2) {
                    case 0:
                        e71Var.c(false);
                        break;
                    default:
                        e71Var.a();
                        break;
                }
            }
        };
        final int i2 = 1;
        this.f = new Runnable(this) { // from class: d71
            public final /* synthetic */ e71 c;

            {
                this.c = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i22 = i2;
                e71 e71Var = this.c;
                switch (i22) {
                    case 0:
                        e71Var.c(false);
                        break;
                    default:
                        e71Var.a();
                        break;
                }
            }
        };
        this.b = view;
        this.c = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = vf1.a;
        this.d = Build.VERSION.SDK_INT >= 28 ? ju.i(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.k = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(e71 e71Var) {
        e71 e71Var2 = l;
        if (e71Var2 != null) {
            e71Var2.b.removeCallbacks(e71Var2.e);
        }
        l = e71Var;
        if (e71Var != null) {
            e71Var.b.postDelayed(e71Var.e, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        e71 e71Var = m;
        View view = this.b;
        if (e71Var == this) {
            m = null;
            f71 f71Var = this.i;
            if (f71Var != null) {
                View view2 = (View) f71Var.c;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) f71Var.b).getSystemService("window")).removeView(view2);
                }
                this.i = null;
                this.k = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (l == this) {
            b(null);
        }
        view.removeCallbacks(this.f);
    }

    public final void c(boolean z) {
        int height;
        int i;
        int i2;
        boolean z2;
        int i3;
        int i4;
        long longPressTimeout;
        long j;
        long j2;
        View view = this.b;
        if (view.isAttachedToWindow()) {
            b(null);
            e71 e71Var = m;
            if (e71Var != null) {
                e71Var.a();
            }
            m = this;
            this.j = z;
            Context context = view.getContext();
            f71 f71Var = new f71();
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            f71Var.e = layoutParams;
            f71Var.f = new Rect();
            f71Var.g = new int[2];
            f71Var.h = new int[2];
            f71Var.b = context;
            View viewInflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
            f71Var.c = viewInflate;
            f71Var.d = (TextView) viewInflate.findViewById(R.id.message);
            layoutParams.setTitle(f71.class.getSimpleName());
            layoutParams.packageName = context.getPackageName();
            layoutParams.type = 1002;
            layoutParams.width = -2;
            layoutParams.height = -2;
            layoutParams.format = -3;
            layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
            layoutParams.flags = 24;
            View view2 = (View) f71Var.c;
            Context context2 = (Context) f71Var.b;
            this.i = f71Var;
            int width = this.g;
            int i5 = this.h;
            boolean z3 = this.j;
            WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) f71Var.e;
            if (view2.getParent() != null && view2.getParent() != null) {
                ((WindowManager) context2.getSystemService("window")).removeView(view2);
            }
            ((TextView) f71Var.d).setText(this.c);
            int[] iArr = (int[]) f71Var.h;
            int[] iArr2 = (int[]) f71Var.g;
            Rect rect = (Rect) f71Var.f;
            layoutParams2.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context2.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                height = i5 + dimensionPixelOffset2;
                i = i5 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams2.gravity = 49;
            int dimensionPixelOffset3 = context2.getResources().getDimensionPixelOffset(z3 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams3 = rootView.getLayoutParams();
            int i6 = width;
            if (!(layoutParams3 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams3).type != 2) {
                Context context3 = view.getContext();
                while (true) {
                    if (!(context3 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context3 instanceof Activity) {
                        rootView = ((Activity) context3).getWindow().getDecorView();
                        break;
                    }
                    context3 = ((ContextWrapper) context3).getBaseContext();
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
                i4 = 1;
            } else {
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i2 = i;
                    z2 = z3;
                    i3 = 0;
                    i4 = 1;
                } else {
                    Resources resources = context2.getResources();
                    i4 = 1;
                    i2 = i;
                    z2 = z3;
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i3 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(iArr);
                view.getLocationOnScreen(iArr2);
                int i7 = iArr2[i3] - iArr[i3];
                iArr2[i3] = i7;
                iArr2[i4] = iArr2[i4] - iArr[i4];
                layoutParams2.x = (i7 + i6) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, i3);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i8 = iArr2[i4];
                int i9 = ((i8 + i2) - dimensionPixelOffset3) - measuredHeight;
                int i10 = i8 + height + dimensionPixelOffset3;
                if (z2) {
                    if (i9 >= 0) {
                        layoutParams2.y = i9;
                    } else {
                        layoutParams2.y = i10;
                    }
                } else if (measuredHeight + i10 <= rect.height()) {
                    layoutParams2.y = i10;
                } else {
                    layoutParams2.y = i9;
                }
            }
            ((WindowManager) context2.getSystemService("window")).addView(view2, layoutParams2);
            view.addOnAttachStateChangeListener(this);
            if (this.j) {
                j2 = 2500;
            } else {
                WeakHashMap weakHashMap = uf1.a;
                if ((view.getWindowSystemUiVisibility() & 1) == i4) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 15000;
                }
                j2 = j - longPressTimeout;
            }
            d71 d71Var = this.f;
            view.removeCallbacks(d71Var);
            view.postDelayed(d71Var, j2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            f71 r4 = r3.i
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.j
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.b
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.k = r4
            r3.a()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            f71 r4 = r3.i
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.k
            if (r1 != 0) goto L66
            int r1 = r3.g
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.d
            if (r1 > r2) goto L66
            int r1 = r3.h
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.g = r4
            r3.h = r5
            r3.k = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e71.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.g = view.getWidth() / 2;
        this.h = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
