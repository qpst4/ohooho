package defpackage;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mf1 {
    public static wi1 a(View view) {
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        wi1 wi1VarH = wi1.h(null, rootWindowInsets);
        ri1 ri1Var = wi1VarH.a;
        ri1Var.p(wi1VarH);
        ri1Var.d(view.getRootView());
        return wi1VarH;
    }

    public static void b(View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }
}
