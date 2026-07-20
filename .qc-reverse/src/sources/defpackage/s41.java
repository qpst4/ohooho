package defpackage;

import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class s41 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ t41 c;

    public /* synthetic */ s41(t41 t41Var, int i) {
        this.b = i;
        this.c = t41Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        t41 t41Var = this.c;
        switch (i) {
            case 0:
                l3 l3Var = t41.k;
                CursorAccessibilityService.b();
                b61.b(new s41(t41Var, 1), 300L);
                break;
            default:
                l3 l3Var2 = t41.k;
                t41Var.f.h();
                break;
        }
    }
}
