package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ar0 implements pf, zr0 {
    public final /* synthetic */ sf b;
    public final /* synthetic */ wj c;

    public /* synthetic */ ar0(sf sfVar, wj wjVar) {
        this.b = sfVar;
        this.c = wjVar;
    }

    @Override // defpackage.zr0
    public void b(df dfVar, List list) {
        if (dfVar.a != 0) {
            si0.b("QueryHistoryAsync code: " + dfVar.a + ", " + dfVar.b);
            return;
        }
        if (list == null) {
            si0.b("QueryHistoryAsync null");
        } else {
            si0.b("QueryHistoryAsync size: " + list.size());
        }
        this.b.d(new r1(15, this.c));
    }

    @Override // defpackage.pf
    public void d(yq0 yq0Var) {
        yq0 yq0Var2 = yq0.no;
        int i = 2;
        wj wjVar = this.c;
        if (yq0Var != yq0Var2 && yq0Var != yq0.pending) {
            if (yq0Var == yq0.lifetime) {
                fp1.b(yq0Var, wjVar, new s4(2));
                return;
            }
            return;
        }
        si0.b("State: " + yq0Var);
        sf sfVar = this.b;
        ar0 ar0Var = new ar0(sfVar, wjVar);
        af afVar = sfVar.c;
        afVar.getClass();
        if (!afVar.c()) {
            df dfVar = zl1.k;
            afVar.w(2, 11, dfVar);
            ar0Var.b(dfVar, null);
        } else if (af.h(new rk1(afVar, "subs", ar0Var, i), 30000L, new vn1(afVar, 16, ar0Var), afVar.u(), afVar.l()) == null) {
            df dfVarI = afVar.i();
            afVar.w(25, 11, dfVarI);
            ar0Var.b(dfVarI, null);
        }
    }

    public /* synthetic */ ar0(wj wjVar, sf sfVar) {
        this.c = wjVar;
        this.b = sfVar;
    }
}
