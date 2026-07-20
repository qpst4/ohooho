package defpackage;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class i5 implements he0 {
    static {
        Logger.getLogger(i5.class.getName());
    }

    @Override // defpackage.he0
    public final fe0 a(zh zhVar) {
        f5 f5Var = (f5) f(zhVar);
        ee0 ee0VarP = fe0.p();
        ee0VarP.f("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        ee0VarP.g(f5Var.m());
        ee0VarP.e(2);
        return (fe0) ee0VarP.a();
    }

    @Override // defpackage.he0
    public final String c() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    @Override // defpackage.he0
    public final Object d(zh zhVar) throws GeneralSecurityException {
        try {
            return b((f5) w50.i(f5.g, zhVar));
        } catch (ic0 e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKey proto", e);
        }
    }

    @Override // defpackage.he0
    public final w50 e(w50 w50Var) throws GeneralSecurityException {
        if (!(w50Var instanceof h5)) {
            s1.l("expected AesCtrHmacAeadKeyFormat proto");
            return null;
        }
        h5 h5Var = (h5) w50Var;
        v5 v5Var = h5Var.d;
        if (v5Var == null) {
            v5Var = v5.f;
        }
        t5 t5Var = (t5) ev0.e("type.googleapis.com/google.crypto.tink.AesCtrKey", v5Var);
        k80 k80Var = h5Var.e;
        if (k80Var == null) {
            k80Var = k80.f;
        }
        i80 i80Var = (i80) ev0.e("type.googleapis.com/google.crypto.tink.HmacKey", k80Var);
        e5 e5Var = (e5) f5.g.k();
        e5Var.c();
        f5 f5Var = (f5) e5Var.c;
        f5Var.getClass();
        t5Var.getClass();
        f5Var.e = t5Var;
        e5Var.c();
        f5 f5Var2 = (f5) e5Var.c;
        f5Var2.getClass();
        i80Var.getClass();
        f5Var2.f = i80Var;
        e5Var.c();
        ((f5) e5Var.c).d = 0;
        return e5Var.a();
    }

    @Override // defpackage.he0
    public final w50 f(zh zhVar) throws GeneralSecurityException {
        try {
            return e((h5) w50.i(h5.f, zhVar));
        } catch (ic0 e) {
            throw new GeneralSecurityException("expected serialized AesCtrHmacAeadKeyFormat proto", e);
        }
    }

    @Override // defpackage.he0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final x4 b(w50 w50Var) throws GeneralSecurityException {
        if (!(w50Var instanceof f5)) {
            s1.l("expected AesCtrHmacAeadKey proto");
            return null;
        }
        f5 f5Var = (f5) w50Var;
        ee1.c(f5Var.d);
        t5 t5Var = f5Var.e;
        if (t5Var == null) {
            t5Var = t5.g;
        }
        za0 za0Var = (za0) ev0.b("type.googleapis.com/google.crypto.tink.AesCtrKey").b(t5Var);
        i80 i80Var = f5Var.f;
        if (i80Var == null) {
            i80Var = i80.g;
        }
        d5 d5Var = (d5) ev0.b("type.googleapis.com/google.crypto.tink.HmacKey").b(i80Var);
        i80 i80Var2 = f5Var.f;
        if (i80Var2 == null) {
            i80Var2 = i80.g;
        }
        return new wy(za0Var, d5Var, i80Var2.p().e);
    }
}
