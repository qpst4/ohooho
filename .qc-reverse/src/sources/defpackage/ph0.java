package defpackage;

import android.widget.AbsListView;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ph0 implements AbsListView.OnScrollListener {
    public final /* synthetic */ rh0 a;

    public ph0(rh0 rh0Var) {
        this.a = rh0Var;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        rh0 rh0Var = this.a;
        oh0 oh0Var = rh0Var.s;
        h9 h9Var = rh0Var.A;
        if (i != 1 || h9Var.getInputMethodMode() == 2 || h9Var.getContentView() == null) {
            return;
        }
        rh0Var.w.removeCallbacks(oh0Var);
        oh0Var.run();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
