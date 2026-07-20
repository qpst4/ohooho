package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ki1 extends ri1 {
    public static boolean i = false;
    public static Method j;
    public static Class k;
    public static Field l;
    public static Field m;
    public final WindowInsets c;
    public xb0[] d;
    public xb0 e;
    public wi1 f;
    public xb0 g;
    public int h;

    public ki1(wi1 wi1Var, WindowInsets windowInsets) {
        super(wi1Var);
        this.e = null;
        this.c = windowInsets;
    }

    private xb0 s(int i2, boolean z) {
        xb0 xb0VarA = xb0.e;
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i2 & i3) != 0) {
                xb0VarA = xb0.a(xb0VarA, t(i3, z));
            }
        }
        return xb0VarA;
    }

    private xb0 u() {
        wi1 wi1Var = this.f;
        return wi1Var != null ? wi1Var.a.h() : xb0.e;
    }

    private xb0 v(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            zy.f("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            return null;
        }
        if (!i) {
            w();
        }
        Method method = j;
        if (method != null && k != null && l != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke == null) {
                    Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                    return null;
                }
                Rect rect = (Rect) l.get(m.get(objInvoke));
                if (rect != null) {
                    return xb0.b(rect.left, rect.top, rect.right, rect.bottom);
                }
                return null;
            } catch (ReflectiveOperationException e) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
            }
        }
        return null;
    }

    private static void w() {
        try {
            j = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            k = cls;
            l = cls.getDeclaredField("mVisibleInsets");
            m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            l.setAccessible(true);
            m.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e.getMessage(), e);
        }
        i = true;
    }

    public static boolean y(int i2, int i3) {
        return (i2 & 6) == (i3 & 6);
    }

    @Override // defpackage.ri1
    public void d(View view) {
        xb0 xb0VarV = v(view);
        if (xb0VarV == null) {
            xb0VarV = xb0.e;
        }
        x(xb0VarV);
    }

    @Override // defpackage.ri1
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        ki1 ki1Var = (ki1) obj;
        return Objects.equals(this.g, ki1Var.g) && y(this.h, ki1Var.h);
    }

    @Override // defpackage.ri1
    public xb0 f(int i2) {
        return s(i2, false);
    }

    @Override // defpackage.ri1
    public final xb0 j() {
        if (this.e == null) {
            WindowInsets windowInsets = this.c;
            this.e = xb0.b(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.e;
    }

    @Override // defpackage.ri1
    public wi1 l(int i2, int i3, int i4, int i5) {
        wi1 wi1VarH = wi1.h(null, this.c);
        int i6 = Build.VERSION.SDK_INT;
        ji1 ii1Var = i6 >= 34 ? new ii1(wi1VarH) : i6 >= 31 ? new hi1(wi1VarH) : i6 >= 30 ? new gi1(wi1VarH) : i6 >= 29 ? new fi1(wi1VarH) : new di1(wi1VarH);
        ii1Var.g(wi1.e(j(), i2, i3, i4, i5));
        ii1Var.e(wi1.e(h(), i2, i3, i4, i5));
        return ii1Var.b();
    }

    @Override // defpackage.ri1
    public boolean n() {
        return this.c.isRound();
    }

    @Override // defpackage.ri1
    public void o(xb0[] xb0VarArr) {
        this.d = xb0VarArr;
    }

    @Override // defpackage.ri1
    public void p(wi1 wi1Var) {
        this.f = wi1Var;
    }

    @Override // defpackage.ri1
    public void r(int i2) {
        this.h = i2;
    }

    public xb0 t(int i2, boolean z) {
        xb0 xb0VarH;
        int i3;
        xb0 xb0Var = xb0.e;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 8) {
                    xb0[] xb0VarArr = this.d;
                    xb0VarH = xb0VarArr != null ? xb0VarArr[tk0.o(8)] : null;
                    if (xb0VarH != null) {
                        return xb0VarH;
                    }
                    xb0 xb0VarJ = j();
                    xb0 xb0VarU = u();
                    int i4 = xb0VarJ.d;
                    if (i4 > xb0VarU.d) {
                        return xb0.b(0, 0, 0, i4);
                    }
                    xb0 xb0Var2 = this.g;
                    if (xb0Var2 != null && !xb0Var2.equals(xb0Var) && (i3 = this.g.d) > xb0VarU.d) {
                        return xb0.b(0, 0, 0, i3);
                    }
                } else {
                    if (i2 == 16) {
                        return i();
                    }
                    if (i2 == 32) {
                        return g();
                    }
                    if (i2 == 64) {
                        return k();
                    }
                    if (i2 == 128) {
                        wi1 wi1Var = this.f;
                        ku kuVarE = wi1Var != null ? wi1Var.a.e() : e();
                        if (kuVarE != null) {
                            int i5 = Build.VERSION.SDK_INT;
                            return xb0.b(i5 >= 28 ? ju.f(kuVarE.a) : 0, i5 >= 28 ? ju.h(kuVarE.a) : 0, i5 >= 28 ? ju.g(kuVarE.a) : 0, i5 >= 28 ? ju.e(kuVarE.a) : 0);
                        }
                    }
                }
            } else {
                if (z) {
                    xb0 xb0VarU2 = u();
                    xb0 xb0VarH2 = h();
                    return xb0.b(Math.max(xb0VarU2.a, xb0VarH2.a), 0, Math.max(xb0VarU2.c, xb0VarH2.c), Math.max(xb0VarU2.d, xb0VarH2.d));
                }
                if ((this.h & 2) == 0) {
                    xb0 xb0VarJ2 = j();
                    wi1 wi1Var2 = this.f;
                    xb0VarH = wi1Var2 != null ? wi1Var2.a.h() : null;
                    int iMin = xb0VarJ2.d;
                    if (xb0VarH != null) {
                        iMin = Math.min(iMin, xb0VarH.d);
                    }
                    return xb0.b(xb0VarJ2.a, 0, xb0VarJ2.c, iMin);
                }
            }
        } else {
            if (z) {
                return xb0.b(0, Math.max(u().b, j().b), 0, 0);
            }
            if ((this.h & 4) == 0) {
                return xb0.b(0, j().b, 0, 0);
            }
        }
        return xb0Var;
    }

    public void x(xb0 xb0Var) {
        this.g = xb0Var;
    }
}
