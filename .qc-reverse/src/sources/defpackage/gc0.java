package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gc0 implements kg1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ hc0 c;

    public /* synthetic */ gc0(hc0 hc0Var, int i) {
        this.b = i;
        this.c = hc0Var;
    }

    @Override // defpackage.kg1
    public final void d(int i) {
        int i2 = this.b;
        hc0 hc0Var = this.c;
        switch (i2) {
            case 0:
                hc0Var.J = i;
                hc0Var.P();
                hc0Var.K();
                break;
            default:
                es0 es0Var = (es0) hc0Var;
                es0Var.c0 = i;
                es0Var.e0();
                es0Var.K();
                break;
        }
    }

    @Override // defpackage.kg1
    public final void l(float f, int i, int i2) {
        int i3 = this.b;
        hc0 hc0Var = this.c;
        switch (i3) {
            case 0:
                float f2 = i + f;
                int iFloor = (int) Math.floor(f2);
                hc0Var.J = iFloor;
                float f3 = ((f2 % 1.0f) + 1.0f) % 1.0f;
                hc0Var.K = f3;
                if (f3 == 0.0f && iFloor == hc0Var.H.g.size()) {
                    hc0Var.setResult(-1);
                    hc0Var.finish();
                    hc0Var.overridePendingTransition(0, 0);
                } else {
                    if (Math.abs(f) < 0.1f) {
                        hc0Var.K();
                    }
                    hc0Var.M();
                    hc0Var.O();
                }
                break;
            default:
                es0 es0Var = (es0) hc0Var;
                float f4 = i + f;
                es0Var.c0 = (int) Math.floor(f4);
                es0Var.d0 = ((f4 % 1.0f) + 1.0f) % 1.0f;
                if (!es0Var.U()) {
                    if (Math.abs(f) < 0.1f) {
                        es0Var.K();
                    }
                    es0Var.b0();
                    es0Var.d0();
                    break;
                }
                break;
        }
    }

    @Override // defpackage.kg1
    public final void a(int i) {
    }
}
