package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import com.quickcursor.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m8 implements un0, bo, ol0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ y8 c;

    public /* synthetic */ m8(y8 y8Var, int i) {
        this.b = i;
        this.c = y8Var;
    }

    @Override // defpackage.ol0
    public void a(zk0 zk0Var, boolean z) {
        x8 x8Var;
        int i = this.b;
        y8 y8Var = this.c;
        switch (i) {
            case 2:
                y8Var.r(zk0Var);
                break;
            default:
                zk0 zk0VarK = zk0Var.k();
                int i2 = 0;
                boolean z2 = zk0VarK != zk0Var;
                if (z2) {
                    zk0Var = zk0VarK;
                }
                x8[] x8VarArr = y8Var.L;
                int length = x8VarArr != null ? x8VarArr.length : 0;
                while (true) {
                    if (i2 >= length) {
                        x8Var = null;
                    } else {
                        x8Var = x8VarArr[i2];
                        if (x8Var == null || x8Var.h != zk0Var) {
                            i2++;
                        }
                    }
                }
                if (x8Var != null) {
                    if (!z2) {
                        y8Var.s(x8Var, z);
                    } else {
                        y8Var.q(x8Var.a, x8Var, zk0VarK);
                        y8Var.s(x8Var, true);
                    }
                }
                break;
        }
    }

    @Override // defpackage.un0
    public wi1 k(View view, wi1 wi1Var) {
        boolean z;
        boolean z2;
        int iD = wi1Var.d();
        y8 y8Var = this.c;
        Context context = y8Var.l;
        int iD2 = wi1Var.d();
        ActionBarContextView actionBarContextView = y8Var.v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) y8Var.v.getLayoutParams();
            if (y8Var.v.isShown()) {
                if (y8Var.c0 == null) {
                    y8Var.c0 = new Rect();
                    y8Var.d0 = new Rect();
                }
                Rect rect = y8Var.c0;
                Rect rect2 = y8Var.d0;
                rect.set(wi1Var.b(), wi1Var.d(), wi1Var.c(), wi1Var.a());
                ViewGroup viewGroup = y8Var.A;
                if (Build.VERSION.SDK_INT >= 29) {
                    boolean z3 = vg1.a;
                    tg1.a(viewGroup, rect, rect2);
                } else {
                    if (!vg1.a) {
                        vg1.a = true;
                        try {
                            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                            vg1.b = declaredMethod;
                            if (!declaredMethod.isAccessible()) {
                                vg1.b.setAccessible(true);
                            }
                        } catch (NoSuchMethodException unused) {
                            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                        }
                    }
                    Method method = vg1.b;
                    if (method != null) {
                        try {
                            method.invoke(viewGroup, rect, rect2);
                        } catch (Exception e) {
                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
                        }
                    }
                }
                int i = rect.top;
                int i2 = rect.left;
                int i3 = rect.right;
                ViewGroup viewGroup2 = y8Var.A;
                WeakHashMap weakHashMap = uf1.a;
                wi1 wi1VarA = mf1.a(viewGroup2);
                int iB = wi1VarA == null ? 0 : wi1VarA.b();
                int iC = wi1VarA == null ? 0 : wi1VarA.c();
                if (marginLayoutParams.topMargin == i && marginLayoutParams.leftMargin == i2 && marginLayoutParams.rightMargin == i3) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i;
                    marginLayoutParams.leftMargin = i2;
                    marginLayoutParams.rightMargin = i3;
                    z2 = true;
                }
                if (i <= 0 || y8Var.C != null) {
                    View view2 = y8Var.C;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i4 = marginLayoutParams2.height;
                        int i5 = marginLayoutParams.topMargin;
                        if (i4 != i5 || marginLayoutParams2.leftMargin != iB || marginLayoutParams2.rightMargin != iC) {
                            marginLayoutParams2.height = i5;
                            marginLayoutParams2.leftMargin = iB;
                            marginLayoutParams2.rightMargin = iC;
                            y8Var.C.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    y8Var.C = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iB;
                    layoutParams.rightMargin = iC;
                    y8Var.A.addView(y8Var.C, -1, layoutParams);
                }
                View view4 = y8Var.C;
                z = view4 != null;
                if (z && view4.getVisibility() != 0) {
                    View view5 = y8Var.C;
                    view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & 8192) != 0 ? context.getColor(R.color.abc_decor_view_status_guard_light) : context.getColor(R.color.abc_decor_view_status_guard));
                }
                if (!y8Var.H && z) {
                    iD2 = 0;
                }
                z = z;
                z = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z = false;
            }
            if (z) {
                y8Var.v.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = y8Var.C;
        if (view6 != null) {
            view6.setVisibility(z ? 0 : 8);
        }
        return uf1.i(view, iD != iD2 ? wi1Var.f(wi1Var.b(), iD2, wi1Var.c(), wi1Var.a()) : wi1Var);
    }

    @Override // defpackage.ol0
    public boolean s(zk0 zk0Var) {
        Window.Callback callback;
        int i = this.b;
        y8 y8Var = this.c;
        switch (i) {
            case 2:
                Window.Callback callback2 = y8Var.m.getCallback();
                if (callback2 != null) {
                    callback2.onMenuOpened(108, zk0Var);
                }
                break;
            default:
                if (zk0Var == zk0Var.k() && y8Var.F && (callback = y8Var.m.getCallback()) != null && !y8Var.Q) {
                    callback.onMenuOpened(108, zk0Var);
                }
                break;
        }
        return true;
    }
}
