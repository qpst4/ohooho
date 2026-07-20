package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class oh0 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ rh0 c;

    public /* synthetic */ oh0(rh0 rh0Var, int i) {
        this.b = i;
        this.c = rh0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        rh0 rh0Var = this.c;
        switch (i) {
            case 0:
                bv bvVar = rh0Var.d;
                if (bvVar != null) {
                    bvVar.setListSelectionHidden(true);
                    bvVar.requestLayout();
                }
                break;
            default:
                bv bvVar2 = rh0Var.d;
                if (bvVar2 != null && bvVar2.isAttachedToWindow() && rh0Var.d.getCount() > rh0Var.d.getChildCount() && rh0Var.d.getChildCount() <= rh0Var.n) {
                    rh0Var.A.setInputMethodMode(2);
                    rh0Var.d();
                    break;
                }
                break;
        }
    }
}
