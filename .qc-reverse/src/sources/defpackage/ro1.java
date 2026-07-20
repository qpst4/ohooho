package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ro1 {
    protected int zza;

    public abstract int a(dq1 dq1Var);

    public final byte[] b() {
        try {
            hp1 hp1Var = (hp1) this;
            int iE = hp1Var.e();
            byte[] bArr = new byte[iE];
            zo1 zo1Var = new zo1(iE, bArr);
            dq1 dq1VarA = aq1.c.a(hp1Var.getClass());
            tb0 tb0Var = zo1Var.a;
            if (tb0Var == null) {
                tb0Var = new tb0(zo1Var);
            }
            dq1VarA.c(hp1Var, tb0Var);
            if (iE - zo1Var.d == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            zy.l(l11.j("Serializing ", getClass().getName(), " to a byte array threw an IOException (should never happen)."), e);
            return null;
        }
    }
}
