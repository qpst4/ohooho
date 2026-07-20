package defpackage;

import android.graphics.Rect;
import android.util.Log;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class di1 extends ji1 {
    public static Field e = null;
    public static boolean f = false;
    public static Constructor g = null;
    public static boolean h = false;
    public WindowInsets c;
    public xb0 d;

    public di1() {
        this.c = i();
    }

    private static WindowInsets i() {
        if (!f) {
            try {
                e = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException e2) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e2);
            }
            f = true;
        }
        Field field = e;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException e3) {
                Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e3);
            }
        }
        if (!h) {
            try {
                g = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException e4) {
                Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e4);
            }
            h = true;
        }
        Constructor constructor = g;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException e5) {
                Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e5);
            }
        }
        return null;
    }

    @Override // defpackage.ji1
    public wi1 b() {
        a();
        wi1 wi1VarH = wi1.h(null, this.c);
        xb0[] xb0VarArr = this.b;
        ri1 ri1Var = wi1VarH.a;
        ri1Var.o(xb0VarArr);
        ri1Var.q(this.d);
        return wi1VarH;
    }

    @Override // defpackage.ji1
    public void e(xb0 xb0Var) {
        this.d = xb0Var;
    }

    @Override // defpackage.ji1
    public void g(xb0 xb0Var) {
        WindowInsets windowInsets = this.c;
        if (windowInsets != null) {
            this.c = windowInsets.replaceSystemWindowInsets(xb0Var.a, xb0Var.b, xb0Var.c, xb0Var.d);
        }
    }

    public di1(wi1 wi1Var) {
        super(wi1Var);
        this.c = wi1Var.g();
    }
}
