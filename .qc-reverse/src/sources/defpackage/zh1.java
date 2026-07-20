package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zh1 extends WindowInsetsAnimation$Callback {
    public final eo a;
    public List b;
    public ArrayList c;
    public final HashMap d;

    public zh1(eo eoVar) {
        super(0);
        this.d = new HashMap();
        this.a = eoVar;
    }

    public final ci1 a(WindowInsetsAnimation windowInsetsAnimation) {
        HashMap map = this.d;
        ci1 ci1Var = (ci1) map.get(windowInsetsAnimation);
        if (ci1Var == null) {
            ci1Var = new ci1(0, null, 0L);
            if (Build.VERSION.SDK_INT >= 30) {
                ci1Var.a = new ai1(windowInsetsAnimation);
            }
            map.put(windowInsetsAnimation, ci1Var);
        }
        return ci1Var;
    }

    public final void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        ((View) this.a.f).setTranslationY(0.0f);
        this.d.remove(windowInsetsAnimation);
    }

    public final void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
        a(windowInsetsAnimation);
        eo eoVar = this.a;
        View view = (View) eoVar.f;
        int[] iArr = (int[]) eoVar.g;
        view.getLocationOnScreen(iArr);
        eoVar.d = iArr[1];
    }

    public final WindowInsets onProgress(WindowInsets windowInsets, List list) {
        ArrayList arrayList = this.c;
        if (arrayList == null) {
            ArrayList arrayList2 = new ArrayList(list.size());
            this.c = arrayList2;
            this.b = Collections.unmodifiableList(arrayList2);
        } else {
            arrayList.clear();
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            WindowInsetsAnimation windowInsetsAnimationM = e0.m(list.get(size));
            ci1 ci1VarA = a(windowInsetsAnimationM);
            ci1VarA.a.d(windowInsetsAnimationM.getFraction());
            this.c.add(ci1VarA);
        }
        wi1 wi1VarH = wi1.h(null, windowInsets);
        this.a.a(wi1VarH, this.b);
        return wi1VarH.g();
    }

    public final WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
        a(windowInsetsAnimation);
        xb0 xb0VarC = xb0.c(bounds.getLowerBound());
        xb0 xb0VarC2 = xb0.c(bounds.getUpperBound());
        eo eoVar = this.a;
        View view = (View) eoVar.f;
        int[] iArr = (int[]) eoVar.g;
        view.getLocationOnScreen(iArr);
        int i = eoVar.d - iArr[1];
        eoVar.e = i;
        view.setTranslationY(i);
        e0.q();
        return e0.k(xb0VarC.d(), xb0VarC2.d());
    }
}
