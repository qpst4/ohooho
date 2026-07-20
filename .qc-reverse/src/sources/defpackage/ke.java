package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.view.View;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ke {
    public final Context a;
    public final ExtendedFloatingActionButton b;
    public final ArrayList c = new ArrayList();
    public final sp1 d;
    public bm0 e;
    public bm0 f;

    public ke(ExtendedFloatingActionButton extendedFloatingActionButton, sp1 sp1Var) {
        this.b = extendedFloatingActionButton;
        this.a = extendedFloatingActionButton.getContext();
        this.d = sp1Var;
    }

    public AnimatorSet a() {
        bm0 bm0Var = this.f;
        if (bm0Var == null) {
            if (this.e == null) {
                this.e = bm0.b(this.a, c());
            }
            bm0Var = this.e;
            bm0Var.getClass();
        }
        return b(bm0Var);
    }

    public final AnimatorSet b(bm0 bm0Var) {
        ArrayList arrayList = new ArrayList();
        boolean zG = bm0Var.g("opacity");
        ExtendedFloatingActionButton extendedFloatingActionButton = this.b;
        if (zG) {
            arrayList.add(bm0Var.d("opacity", extendedFloatingActionButton, View.ALPHA));
        }
        if (bm0Var.g("scale")) {
            arrayList.add(bm0Var.d("scale", extendedFloatingActionButton, View.SCALE_Y));
            arrayList.add(bm0Var.d("scale", extendedFloatingActionButton, View.SCALE_X));
        }
        if (bm0Var.g("width")) {
            arrayList.add(bm0Var.d("width", extendedFloatingActionButton, ExtendedFloatingActionButton.J));
        }
        if (bm0Var.g("height")) {
            arrayList.add(bm0Var.d("height", extendedFloatingActionButton, ExtendedFloatingActionButton.K));
        }
        if (bm0Var.g("paddingStart")) {
            arrayList.add(bm0Var.d("paddingStart", extendedFloatingActionButton, ExtendedFloatingActionButton.L));
        }
        if (bm0Var.g("paddingEnd")) {
            arrayList.add(bm0Var.d("paddingEnd", extendedFloatingActionButton, ExtendedFloatingActionButton.M));
        }
        if (bm0Var.g("labelOpacity")) {
            arrayList.add(bm0Var.d("labelOpacity", extendedFloatingActionButton, new je(this)));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        xr.E(animatorSet, arrayList);
        return animatorSet;
    }

    public abstract int c();

    public void d() {
        this.d.c = null;
    }

    public abstract void e();

    public abstract void f(Animator animator);

    public abstract void g();

    public abstract boolean h();
}
