package defpackage;

import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l8 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ y8 c;

    public /* synthetic */ l8(y8 y8Var, int i) {
        this.b = i;
        this.c = y8Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewGroup viewGroup;
        int i = this.b;
        y8 y8Var = this.c;
        switch (i) {
            case 0:
                if ((y8Var.Z & 1) != 0) {
                    y8Var.v(0);
                }
                if ((y8Var.Z & 4096) != 0) {
                    y8Var.v(108);
                }
                y8Var.Y = false;
                y8Var.Z = 0;
                break;
            default:
                y8Var.w.showAtLocation(y8Var.v, 55, 0, 0);
                ng1 ng1Var = y8Var.y;
                if (ng1Var != null) {
                    ng1Var.b();
                }
                if (y8Var.z && (viewGroup = y8Var.A) != null && viewGroup.isLaidOut()) {
                    y8Var.v.setAlpha(0.0f);
                    ng1 ng1VarA = uf1.a(y8Var.v);
                    ng1VarA.a(1.0f);
                    y8Var.y = ng1VarA;
                    ng1VarA.d(new n8(0, this));
                } else {
                    y8Var.v.setAlpha(1.0f);
                    y8Var.v.setVisibility(0);
                }
                break;
        }
    }
}
