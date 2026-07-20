package defpackage;

import android.content.Context;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class nr implements rx {
    public Context a;

    public nr(Context context, int i) {
        switch (i) {
            case 2:
                this.a = context;
                break;
            default:
                this.a = context.getApplicationContext();
                break;
        }
    }

    @Override // defpackage.rx
    public void a(yb0 yb0Var) {
        tm tmVar = new tm("EmojiCompatInitializer");
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), tmVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new mf(this, yb0Var, threadPoolExecutor, 2));
    }

    public or b() {
        Context context = this.a;
        if (context == null) {
            throw new IllegalStateException(Context.class.getCanonicalName() + " must be set");
        }
        or orVar = new or();
        orVar.b = pu.a(f01.f);
        m0 m0Var = new m0(context);
        orVar.c = m0Var;
        boolean z = false;
        orVar.d = pu.a(new i9(m0Var, new sp1(15, m0Var), 28, z));
        m0 m0Var2 = orVar.c;
        orVar.e = new tz(m0Var2, 1);
        wr0 wr0VarA = pu.a(new pn0(orVar.e, pu.a(new tz(m0Var2, 0)), 5, z));
        orVar.f = wr0VarA;
        c70 c70Var = new c70(25);
        m0 m0Var3 = orVar.c;
        ra raVar = new ra(m0Var3, wr0VarA, c70Var, 17);
        wr0 wr0Var = orVar.b;
        wr0 wr0Var2 = orVar.d;
        h7 h7Var = new h7(wr0Var, wr0Var2, raVar, wr0VarA, wr0VarA);
        f71 f71Var = new f71();
        f71Var.b = m0Var3;
        f71Var.c = wr0Var2;
        f71Var.d = wr0VarA;
        f71Var.e = raVar;
        f71Var.f = wr0Var;
        f71Var.g = wr0VarA;
        f71Var.h = wr0VarA;
        orVar.g = pu.a(new ra(h7Var, f71Var, new g7(wr0Var, wr0VarA, raVar, wr0VarA), 21));
        return orVar;
    }
}
