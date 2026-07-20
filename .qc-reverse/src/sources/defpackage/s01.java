package defpackage;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s01 {
    public static final gv0 a;
    public static final gv0 b;
    public static final gv0 c;

    static {
        fv0 fv0VarP = gv0.p();
        fv0VarP.f("TINK_SIGNATURE_1_0_0");
        fv0VarP.e(yb0.m("TinkPublicKeySign", "PublicKeySign", "EcdsaPrivateKey"));
        fv0VarP.e(yb0.m("TinkPublicKeySign", "PublicKeySign", "Ed25519PrivateKey"));
        fv0VarP.e(yb0.m("TinkPublicKeyVerify", "PublicKeyVerify", "EcdsaPublicKey"));
        fv0VarP.e(yb0.m("TinkPublicKeyVerify", "PublicKeyVerify", "Ed25519PublicKey"));
        gv0 gv0Var = (gv0) fv0VarP.a();
        a = gv0Var;
        fv0 fv0VarP2 = gv0.p();
        fv0VarP2.d(gv0Var);
        fv0VarP2.f("TINK_SIGNATURE_1_1_0");
        b = (gv0) fv0VarP2.a();
        fv0 fv0VarP3 = gv0.p();
        fv0VarP3.f("TINK_SIGNATURE");
        fv0VarP3.e(yb0.m("TinkPublicKeySign", "PublicKeySign", "EcdsaPrivateKey"));
        fv0VarP3.e(yb0.m("TinkPublicKeySign", "PublicKeySign", "Ed25519PrivateKey"));
        fv0VarP3.e(yb0.m("TinkPublicKeyVerify", "PublicKeyVerify", "EcdsaPublicKey"));
        fv0VarP3.e(yb0.m("TinkPublicKeyVerify", "PublicKeyVerify", "Ed25519PublicKey"));
        gv0 gv0Var2 = (gv0) fv0VarP3.a();
        c = gv0Var2;
        try {
            ev0.a("TinkPublicKeySign", new y4(5));
            ev0.a("TinkPublicKeyVerify", new y4(6));
            yb0.v(gv0Var2);
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
