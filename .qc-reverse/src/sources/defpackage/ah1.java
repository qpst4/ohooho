package defpackage;

import android.graphics.Matrix;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class ah1 extends yb0 {
    public static boolean s = true;
    public static boolean t = true;
    public static boolean u = true;
    public static boolean v = true;

    public void F(View view, int i, int i2, int i3, int i4) {
        if (u) {
            try {
                yg1.a(view, i, i2, i3, i4);
            } catch (NoSuchMethodError unused) {
                u = false;
            }
        }
    }

    public void G(View view, int i) {
        if (Build.VERSION.SDK_INT != 28) {
            if (v) {
                try {
                    zg1.a(view, i);
                    return;
                } catch (NoSuchMethodError unused) {
                    v = false;
                    return;
                }
            }
            return;
        }
        if (!yb0.r) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                yb0.q = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused2) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            yb0.r = true;
        }
        Field field = yb0.q;
        if (field != null) {
            try {
                yb0.q.setInt(view, (field.getInt(view) & (-13)) | i);
            } catch (IllegalAccessException unused3) {
            }
        }
    }

    public void H(View view, Matrix matrix) {
        if (s) {
            try {
                xg1.b(view, matrix);
            } catch (NoSuchMethodError unused) {
                s = false;
            }
        }
    }

    public void I(ViewGroup viewGroup, Matrix matrix) {
        if (t) {
            try {
                xg1.c(viewGroup, matrix);
            } catch (NoSuchMethodError unused) {
                t = false;
            }
        }
    }
}
