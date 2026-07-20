package defpackage;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z4 {
    public static final gv0 a;
    public static final gv0 b;

    static {
        fv0 fv0VarP = gv0.p();
        fv0VarP.d(zi0.a);
        fv0VarP.e(yb0.m("TinkAead", "Aead", "AesCtrHmacAeadKey"));
        fv0VarP.e(yb0.m("TinkAead", "Aead", "AesEaxKey"));
        fv0VarP.e(yb0.m("TinkAead", "Aead", "AesGcmKey"));
        fv0VarP.e(yb0.m("TinkAead", "Aead", "ChaCha20Poly1305Key"));
        fv0VarP.e(yb0.m("TinkAead", "Aead", "KmsAeadKey"));
        fv0VarP.e(yb0.m("TinkAead", "Aead", "KmsEnvelopeAeadKey"));
        fv0VarP.f("TINK_AEAD_1_0_0");
        gv0 gv0Var = (gv0) fv0VarP.a();
        a = gv0Var;
        fv0 fv0VarP2 = gv0.p();
        fv0VarP2.d(gv0Var);
        fv0VarP2.f("TINK_AEAD_1_1_0");
        fv0 fv0VarP3 = gv0.p();
        gv0 gv0Var2 = zi0.b;
        fv0VarP3.d(gv0Var2);
        fv0VarP3.e(yb0.m("TinkAead", "Aead", "AesCtrHmacAeadKey"));
        fv0VarP3.e(yb0.m("TinkAead", "Aead", "AesEaxKey"));
        fv0VarP3.e(yb0.m("TinkAead", "Aead", "AesGcmKey"));
        fv0VarP3.e(yb0.m("TinkAead", "Aead", "ChaCha20Poly1305Key"));
        fv0VarP3.e(yb0.m("TinkAead", "Aead", "KmsAeadKey"));
        fv0VarP3.e(yb0.m("TinkAead", "Aead", "KmsEnvelopeAeadKey"));
        fv0VarP3.f("TINK_AEAD");
        gv0 gv0Var3 = (gv0) fv0VarP3.a();
        b = gv0Var3;
        try {
            ev0.a("TinkMac", new y4(4));
            yb0.v(gv0Var2);
            ev0.a("TinkAead", new y4(0));
            yb0.v(gv0Var3);
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
