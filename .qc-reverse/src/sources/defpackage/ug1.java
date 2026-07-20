package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ug1 {
    public static final ah1 a;
    public static final ej b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            a = new bh1();
        } else {
            a = new ah1();
        }
        b = new ej(Float.class, "translationAlpha", 10);
        new ej(Rect.class, "clipBounds", 11);
    }

    public static void a(View view, int i, int i2, int i3, int i4) {
        a.F(view, i, i2, i3, i4);
    }

    public static void b(View view, int i) {
        a.G(view, i);
    }
}
