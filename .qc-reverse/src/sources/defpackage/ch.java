package defpackage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ch implements dc0 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ ch(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.dc0
    public final hw0 a(jt0 jt0Var) {
        boolean z;
        boolean z2;
        switch (this.a) {
            case 0:
                ix ixVar = (ix) this.b;
                mv0 mv0Var = jt0Var.f;
                g7 g7VarA = mv0Var.a();
                ga0 ga0Var = mv0Var.a;
                w70 w70Var = mv0Var.c;
                if (w70Var.a("Host") == null) {
                    ((jj) g7VarA.d).h("Host", be1.j(ga0Var, false));
                }
                if (w70Var.a("Connection") == null) {
                    ((jj) g7VarA.d).h("Connection", "Keep-Alive");
                }
                if (w70Var.a("Accept-Encoding") == null && w70Var.a("Range") == null) {
                    ((jj) g7VarA.d).h("Accept-Encoding", "gzip");
                    z = true;
                } else {
                    z = false;
                }
                ixVar.getClass();
                List list = Collections.EMPTY_LIST;
                if (list.isEmpty()) {
                    z2 = z;
                } else {
                    StringBuilder sb = new StringBuilder();
                    int size = list.size();
                    int i = 0;
                    while (i < size) {
                        boolean z3 = z;
                        if (i > 0) {
                            sb.append("; ");
                        }
                        lo loVar = (lo) list.get(i);
                        sb.append(loVar.a);
                        sb.append('=');
                        sb.append(loVar.b);
                        i++;
                        z = z3;
                    }
                    z2 = z;
                    ((jj) g7VarA.d).h("Cookie", sb.toString());
                }
                if (w70Var.a("User-Agent") == null) {
                    ((jj) g7VarA.d).h("User-Agent", "okhttp/3.12.1");
                }
                hw0 hw0VarA = jt0Var.a(g7VarA.c(), jt0Var.b, jt0Var.c, jt0Var.d);
                w70 w70Var2 = hw0VarA.g;
                ea0.d(ixVar, ga0Var, w70Var2);
                gw0 gw0VarG = hw0VarA.g();
                gw0VarG.a = mv0Var;
                if (z2 && "gzip".equalsIgnoreCase(hw0VarA.a("Content-Encoding")) && ea0.b(hw0VarA)) {
                    p70 p70Var = new p70(hw0VarA.h.g());
                    jj jjVarC = w70Var2.c();
                    jjVarC.g("Content-Encoding");
                    jjVarC.g("Content-Length");
                    ArrayList arrayList = jjVarC.b;
                    String[] strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
                    jj jjVar = new jj(1);
                    Collections.addAll(jjVar.b, strArr);
                    gw0VarG.f = jjVar;
                    hw0VarA.a("Content-Type");
                    Logger logger = tn0.a;
                    gw0VarG.g = new kt0(-1L, new gt0(p70Var), 0);
                }
                return gw0VarG.a();
            default:
                mv0 mv0Var2 = jt0Var.f;
                u21 u21Var = jt0Var.b;
                boolean z4 = !mv0Var2.b.equals("GET");
                sn0 sn0Var = (sn0) this.b;
                u21Var.getClass();
                try {
                    ca0 ca0VarH = u21Var.d(jt0Var.i, jt0Var.j, jt0Var.k, sn0Var.u, z4).h(sn0Var, jt0Var, u21Var);
                    synchronized (u21Var.d) {
                        u21Var.n = ca0VarH;
                        break;
                    }
                    return jt0Var.a(mv0Var2, u21Var, ca0VarH, u21Var.a());
                } catch (IOException e) {
                    throw new vw0(e);
                }
        }
    }
}
