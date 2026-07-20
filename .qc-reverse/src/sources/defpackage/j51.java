package defpackage;

import com.quickcursor.android.activities.ThanksProActivity;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j51 implements qf, rf {
    public final /* synthetic */ int b;
    public final /* synthetic */ ThanksProActivity c;

    public /* synthetic */ j51(ThanksProActivity thanksProActivity, int i) {
        this.b = i;
        this.c = thanksProActivity;
    }

    @Override // defpackage.rf
    public void b(int i) {
        ThanksProActivity thanksProActivity = this.c;
        sf sfVar = thanksProActivity.B;
        if (sfVar == null) {
            return;
        }
        o01 o01Var = new o01(i, 1, thanksProActivity);
        ArrayList arrayList = new ArrayList();
        c1 c1Var = new c1(2);
        c1Var.c = "inapp";
        sfVar.c.f(c1Var.b(), new lf(sfVar, arrayList, o01Var, 0));
    }

    @Override // defpackage.qf
    public void c(yq0 yq0Var) {
        int i = this.b;
        int i2 = 1;
        ThanksProActivity thanksProActivity = this.c;
        int i3 = 2;
        switch (i) {
            case 0:
                int i4 = ThanksProActivity.D;
                sf sfVar = thanksProActivity.B;
                if (sfVar != null) {
                    j51 j51Var = new j51(thanksProActivity, i2);
                    c1 c1Var = new c1(2);
                    c1Var.c = "subs";
                    sfVar.c.f(c1Var.b(), new ff(sfVar, i3, j51Var));
                }
                sf sfVar2 = thanksProActivity.B;
                if (sfVar2 != null) {
                    af afVar = sfVar2.c;
                    if (afVar != null) {
                        afVar.b();
                    }
                    thanksProActivity.B = null;
                }
                break;
            default:
                int i5 = ThanksProActivity.D;
                sf sfVar3 = thanksProActivity.B;
                if (sfVar3 != null) {
                    j51 j51Var2 = new j51(thanksProActivity, i2);
                    c1 c1Var2 = new c1(2);
                    c1Var2.c = "subs";
                    sfVar3.c.f(c1Var2.b(), new ff(sfVar3, i3, j51Var2));
                }
                sf sfVar4 = thanksProActivity.B;
                if (sfVar4 != null) {
                    af afVar2 = sfVar4.c;
                    if (afVar2 != null) {
                        afVar2.b();
                    }
                    thanksProActivity.B = null;
                }
                break;
        }
    }
}
