package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kf1 implements View.OnApplyWindowInsetsListener {
    public wi1 a = null;
    public final /* synthetic */ View b;
    public final /* synthetic */ un0 c;

    public kf1(View view, un0 un0Var) {
        this.b = view;
        this.c = un0Var;
    }

    @Override // android.view.View.OnApplyWindowInsetsListener
    public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        wi1 wi1VarH = wi1.h(view, windowInsets);
        int i = Build.VERSION.SDK_INT;
        un0 un0Var = this.c;
        if (i < 30) {
            lf1.a(windowInsets, this.b);
            if (wi1VarH.equals(this.a)) {
                return un0Var.k(view, wi1VarH).g();
            }
        }
        this.a = wi1VarH;
        wi1 wi1VarK = un0Var.k(view, wi1VarH);
        if (i >= 30) {
            return wi1VarK.g();
        }
        WeakHashMap weakHashMap = uf1.a;
        jf1.c(view);
        return wi1VarK.g();
    }
}
