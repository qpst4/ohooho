package defpackage;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class th1 extends qg1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ vh1 b;

    public /* synthetic */ th1(vh1 vh1Var, int i) {
        this.a = i;
        this.b = vh1Var;
    }

    @Override // defpackage.pg1
    public final void a() {
        View view;
        int i = this.a;
        vh1 vh1Var = this.b;
        switch (i) {
            case 0:
                if (vh1Var.o && (view = vh1Var.g) != null) {
                    view.setTranslationY(0.0f);
                    vh1Var.d.setTranslationY(0.0f);
                }
                vh1Var.d.setVisibility(8);
                vh1Var.d.setTransitioning(false);
                vh1Var.s = null;
                i9 i9Var = vh1Var.k;
                if (i9Var != null) {
                    i9Var.C(vh1Var.j);
                    vh1Var.j = null;
                    vh1Var.k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = vh1Var.c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = uf1.a;
                    jf1.c(actionBarOverlayLayout);
                }
                break;
            default:
                vh1Var.s = null;
                vh1Var.d.requestLayout();
                break;
        }
    }
}
