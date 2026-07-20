package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class d41 implements View.OnLayoutChangeListener {
    public final /* synthetic */ View a;
    public final /* synthetic */ e41 b;

    public d41(e41 e41Var, View view) {
        this.b = e41Var;
        this.a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        View view2 = this.a;
        if (view2.getVisibility() == 0) {
            this.b.c(view2);
        }
    }
}
