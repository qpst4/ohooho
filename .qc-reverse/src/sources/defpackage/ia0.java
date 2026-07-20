package defpackage;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ia0 {
    public static final gv0 a;
    public static final gv0 b;
    public static final gv0 c;

    static {
        fv0 fv0VarP = gv0.p();
        fv0VarP.d(z4.a);
        fv0VarP.e(yb0.m("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey"));
        fv0VarP.e(yb0.m("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey"));
        fv0VarP.f("TINK_HYBRID_1_0_0");
        gv0 gv0Var = (gv0) fv0VarP.a();
        a = gv0Var;
        fv0 fv0VarP2 = gv0.p();
        fv0VarP2.d(gv0Var);
        fv0VarP2.f("TINK_HYBRID_1_1_0");
        b = (gv0) fv0VarP2.a();
        fv0 fv0VarP3 = gv0.p();
        fv0VarP3.d(z4.b);
        fv0VarP3.e(yb0.m("TinkHybridDecrypt", "HybridDecrypt", "EciesAeadHkdfPrivateKey"));
        fv0VarP3.e(yb0.m("TinkHybridEncrypt", "HybridEncrypt", "EciesAeadHkdfPublicKey"));
        fv0VarP3.f("TINK_HYBRID");
        c = (gv0) fv0VarP3.a();
        try {
            a();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static void a() {
        gv0 gv0Var = z4.a;
        gv0 gv0Var2 = zi0.a;
        ev0.a("TinkMac", new y4(4));
        yb0.v(zi0.b);
        ev0.a("TinkAead", new y4(0));
        yb0.v(z4.b);
        ev0.a("TinkHybridEncrypt", new y4(3));
        ev0.a("TinkHybridDecrypt", new y4(2));
        yb0.v(c);
    }
}
