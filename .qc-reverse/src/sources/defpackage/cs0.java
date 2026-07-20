package defpackage;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class cs0 implements View.OnClickListener {
    public final /* synthetic */ int b;
    public final /* synthetic */ es0 c;

    public /* synthetic */ cs0(es0 es0Var, int i) {
        this.b = i;
        this.c = es0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.b;
        es0 es0Var = this.c;
        switch (i) {
            case 0:
                int i2 = es0Var.h0;
                if (i2 == 2) {
                    es0Var.J(es0Var.H());
                } else if (i2 == 1) {
                    es0Var.J(es0Var.U.getCurrentItem() - 1);
                }
                break;
            default:
                es0Var.W();
                break;
        }
    }
}
