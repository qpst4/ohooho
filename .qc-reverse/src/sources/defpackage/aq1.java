package defpackage;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class aq1 {
    public static final aq1 c = new aq1();
    public final ConcurrentHashMap b = new ConcurrentHashMap();
    public final sp1 a = new sp1(0);

    public final dq1 a(Class cls) {
        dq1 yp1Var;
        Charset charset = lp1.a;
        if (cls == null) {
            zy.r("messageType");
            return null;
        }
        ConcurrentHashMap concurrentHashMap = this.b;
        dq1 dq1Var = (dq1) concurrentHashMap.get(cls);
        if (dq1Var != null) {
            return dq1Var;
        }
        sp1 sp1Var = this.a;
        sp1Var.getClass();
        hm1 hm1Var = eq1.a;
        hp1.class.isAssignableFrom(cls);
        cq1 cq1VarB = ((tb0) sp1Var.c).b(cls);
        if ((cq1VarB.d & 2) == 2) {
            hm1 hm1Var2 = eq1.a;
            cp1 cp1Var = dp1.a;
            yp1Var = new yp1(hm1Var2, cq1VarB.a);
        } else {
            int i = zp1.a;
            int i2 = rp1.a;
            hm1 hm1Var3 = eq1.a;
            cp1 cp1Var2 = cq1VarB.a() + (-1) != 1 ? dp1.a : null;
            int i3 = up1.a;
            yp1Var = xp1.u(cq1VarB, hm1Var3, cp1Var2);
        }
        dq1 dq1Var2 = (dq1) concurrentHashMap.putIfAbsent(cls, yp1Var);
        return dq1Var2 == null ? yp1Var : dq1Var2;
    }
}
