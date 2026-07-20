package defpackage;

import com.quickcursor.android.services.CursorAccessibilityService;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w51 implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ x51 c;
    public final /* synthetic */ int d;

    public /* synthetic */ w51(x51 x51Var, int i, int i2) {
        this.b = i2;
        this.c = x51Var;
        this.d = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        int i2 = this.d;
        x51 x51Var = this.c;
        switch (i) {
            case 0:
                wi0 wi0Var = x51.k;
                CursorAccessibilityService.b();
                b61.b(new w51(x51Var, i2, 1), 300L);
                break;
            default:
                wi0 wi0Var2 = x51.k;
                CursorAccessibilityService cursorAccessibilityService = x51Var.f;
                cursorAccessibilityService.getClass();
                pn0.t().U(i2);
                cursorAccessibilityService.n(4);
                cursorAccessibilityService.l();
                break;
        }
    }
}
