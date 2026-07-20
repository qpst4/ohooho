package defpackage;

import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class r61 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Toolbar c;

    public /* synthetic */ r61(Toolbar toolbar, int i) {
        this.b = i;
        this.c = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Toolbar toolbar = this.c;
        switch (i) {
            case 0:
                u61 u61Var = toolbar.N;
                cl0 cl0Var = u61Var == null ? null : u61Var.c;
                if (cl0Var != null) {
                    cl0Var.collapseActionView();
                }
                break;
            default:
                toolbar.n();
                break;
        }
    }
}
