package defpackage;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w21 {
    public static final gv0 a;
    public static final gv0 b;

    static {
        fv0 fv0VarP = gv0.p();
        fv0VarP.e(yb0.m("TinkStreamingAead", "StreamingAead", "AesCtrHmacStreamingKey"));
        fv0VarP.e(yb0.m("TinkStreamingAead", "StreamingAead", "AesGcmHkdfStreamingKey"));
        fv0VarP.f("TINK_STREAMINGAEAD_1_1_0");
        a = (gv0) fv0VarP.a();
        fv0 fv0VarP2 = gv0.p();
        fv0VarP2.e(yb0.m("TinkStreamingAead", "StreamingAead", "AesCtrHmacStreamingKey"));
        fv0VarP2.e(yb0.m("TinkStreamingAead", "StreamingAead", "AesGcmHkdfStreamingKey"));
        fv0VarP2.f("TINK_STREAMINGAEAD");
        gv0 gv0Var = (gv0) fv0VarP2.a();
        b = gv0Var;
        try {
            ev0.a("TinkStreamingAead", new y4(7));
            yb0.v(gv0Var);
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
