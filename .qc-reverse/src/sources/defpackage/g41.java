package defpackage;

import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g41 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ h41 c;

    public /* synthetic */ g41(h41 h41Var, int i) {
        this.b = i;
        this.c = h41Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = 1;
        h41 h41Var = this.c;
        switch (i) {
            case 0:
                l3 l3Var = h41.k;
                CursorAccessibilityService.b();
                b61.b(new g41(h41Var, i2), 500L);
                break;
            case 1:
                l3 l3Var2 = h41.k;
                r60.j(true);
                b61.b(new g41(h41Var, 2), 10L);
                b61.b(new s4(17), 110L);
                break;
            default:
                l3 l3Var3 = h41.k;
                h41Var.f.performGlobalAction(9);
                break;
        }
    }
}
