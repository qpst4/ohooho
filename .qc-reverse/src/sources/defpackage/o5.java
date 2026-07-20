package defpackage;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o5 implements he0 {
    public final /* synthetic */ int a;

    public /* synthetic */ o5(int i) {
        this.a = i;
    }

    public static d5 h(w50 w50Var) throws GeneralSecurityException {
        if (!(w50Var instanceof i80)) {
            s1.l("expected HmacKey proto");
            return null;
        }
        i80 i80Var = (i80) w50Var;
        ee1.c(i80Var.d);
        if (i80Var.f.size() < 16) {
            s1.l("key too short");
            return null;
        }
        t(i80Var.p());
        int iA = l11.a(i80Var.p().d);
        if (iA == 0) {
            iA = 5;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(i80Var.f.e(), "HMAC");
        int i = i80Var.p().e;
        int iR = l11.r(iA);
        if (iR == 1) {
            return new d5("HMACSHA1", secretKeySpec, i);
        }
        if (iR == 2) {
            return new d5("HMACSHA256", secretKeySpec, i);
        }
        if (iR == 3) {
            return new d5("HMACSHA512", secretKeySpec, i);
        }
        s1.l("unknown hash");
        return null;
    }

    public static r5 i(w50 w50Var) throws GeneralSecurityException {
        if (!(w50Var instanceof t5)) {
            s1.l("expected AesCtrKey proto");
            return null;
        }
        t5 t5Var = (t5) w50Var;
        ee1.c(t5Var.d);
        ee1.a(t5Var.f.size());
        x5 x5Var = t5Var.e;
        if (x5Var == null) {
            x5Var = x5.e;
        }
        int i = x5Var.d;
        if (i < 12 || i > 16) {
            s1.l("invalid IV size");
            return null;
        }
        byte[] bArrE = t5Var.f.e();
        x5 x5Var2 = t5Var.e;
        if (x5Var2 == null) {
            x5Var2 = x5.e;
        }
        return new r5(x5Var2.d, bArrE);
    }

    public static p6 j(w50 w50Var) throws GeneralSecurityException {
        if (!(w50Var instanceof r6)) {
            s1.l("expected AesSivKey proto");
            return null;
        }
        r6 r6Var = (r6) w50Var;
        ee1.c(r6Var.d);
        if (r6Var.e.size() == 64) {
            return new p6(r6Var.e.e());
        }
        throw new InvalidKeyException("invalid key size: " + r6Var.e.size() + ". Valid keys must have 64 bytes.");
    }

    public static ix k(w50 w50Var) throws GeneralSecurityException {
        int i;
        if (!(w50Var instanceof bw)) {
            s1.l("expected EciesAeadHkdfPublicKey proto");
            return null;
        }
        bw bwVar = (bw) w50Var;
        ee1.c(bwVar.d);
        tk0.K(bwVar.p());
        xv xvVarP = bwVar.p();
        dw dwVarQ = xvVarP.q();
        int i2 = dwVarQ.d;
        if (i2 != 0) {
            i = 2;
            if (i2 != 2) {
                i = 3;
                if (i2 != 3) {
                    i = 4;
                    if (i2 != 4) {
                        i = 0;
                    }
                }
            }
        } else {
            i = 1;
        }
        if (i == 0) {
            i = 5;
        }
        ECPublicKey eCPublicKeyO = xr.o(tk0.H(i), bwVar.f.e(), bwVar.g.e());
        uv uvVar = xvVarP.e;
        if (uvVar == null) {
            uvVar = uv.e;
        }
        je0 je0Var = uvVar.d;
        if (je0Var == null) {
            je0Var = je0.g;
        }
        new ix(je0Var);
        dwVarQ.f.e();
        int iA = l11.a(dwVarQ.e);
        tk0.I(iA != 0 ? iA : 5);
        tk0.J(xvVarP.p());
        ix ixVar = new ix(12);
        xr.b(eCPublicKeyO.getW(), eCPublicKeyO.getParams().getCurve());
        return ixVar;
    }

    public static ow0 o(w50 w50Var) throws GeneralSecurityException {
        int i;
        if (!(w50Var instanceof zv)) {
            s1.l("expected EciesAeadHkdfPrivateKey proto");
            return null;
        }
        zv zvVar = (zv) w50Var;
        ee1.c(zvVar.d);
        bw bwVar = zvVar.e;
        if (bwVar == null) {
            bwVar = bw.h;
        }
        tk0.K(bwVar.p());
        bw bwVar2 = zvVar.e;
        if (bwVar2 == null) {
            bwVar2 = bw.h;
        }
        xv xvVarP = bwVar2.p();
        dw dwVarQ = xvVarP.q();
        int i2 = dwVarQ.d;
        if (i2 != 0) {
            i = 2;
            if (i2 != 2) {
                i = 3;
                if (i2 != 3) {
                    i = 4;
                    if (i2 != 4) {
                        i = 0;
                    }
                }
            }
        } else {
            i = 1;
        }
        if (i == 0) {
            i = 5;
        }
        xr.n(tk0.H(i), zvVar.f.e());
        uv uvVar = xvVarP.e;
        if (uvVar == null) {
            uvVar = uv.e;
        }
        je0 je0Var = uvVar.d;
        if (je0Var == null) {
            je0Var = je0.g;
        }
        new ix(je0Var);
        dwVarQ.f.e();
        int iA = l11.a(dwVarQ.e);
        tk0.I(iA != 0 ? iA : 5);
        tk0.J(xvVarP.p());
        return new ow0(11);
    }

    public static bj p() {
        aj ajVar = (aj) bj.f.k();
        ajVar.c();
        ((bj) ajVar.c).d = 0;
        byte[] bArrA = dt0.a(32);
        zh zhVarC = zh.c(bArrA, 0, bArrA.length);
        ajVar.c();
        bj bjVar = (bj) ajVar.c;
        bjVar.getClass();
        bjVar.e = zhVarC;
        return (bj) ajVar.a();
    }

    public static iw q() {
        byte[] bArrA = dt0.a(32);
        byte[] bArrM = fc0.M(fc0.w(bArrA));
        jw jwVar = (jw) kw.f.k();
        jwVar.c();
        ((kw) jwVar.c).d = 0;
        byte[] bArrCopyOf = Arrays.copyOf(bArrM, 32);
        zh zhVarC = zh.c(bArrCopyOf, 0, bArrCopyOf.length);
        jwVar.c();
        kw kwVar = (kw) jwVar.c;
        kwVar.getClass();
        kwVar.e = zhVarC;
        kw kwVar2 = (kw) jwVar.a();
        hw hwVar = (hw) iw.g.k();
        hwVar.c();
        ((iw) hwVar.c).d = 0;
        byte[] bArrCopyOf2 = Arrays.copyOf(bArrA, bArrA.length);
        zh zhVarC2 = zh.c(bArrCopyOf2, 0, bArrCopyOf2.length);
        hwVar.c();
        iw iwVar = (iw) hwVar.c;
        iwVar.getClass();
        iwVar.e = zhVarC2;
        hwVar.c();
        iw iwVar2 = (iw) hwVar.c;
        iwVar2.getClass();
        iwVar2.f = kwVar2;
        return (iw) hwVar.a();
    }

    public static void r(q5 q5Var) throws GeneralSecurityException {
        ee1.a(q5Var.e);
        int iA = l11.a(q5Var.f);
        if (iA == 0) {
            iA = 5;
        }
        if (iA == 1) {
            s1.l("unknown HKDF hash type");
            return;
        }
        int iA2 = l11.a(q5Var.p().d);
        if (iA2 == 0) {
            iA2 = 5;
        }
        if (iA2 == 1) {
            s1.l("unknown HMAC hash type");
            return;
        }
        m80 m80VarP = q5Var.p();
        if (m80VarP.e < 10) {
            s1.l("tag size too small");
            return;
        }
        int iA3 = l11.a(m80VarP.d);
        int iR = l11.r(iA3 != 0 ? iA3 : 5);
        if (iR != 1) {
            if (iR != 2) {
                if (iR != 3) {
                    s1.l("unknown hash type");
                    return;
                } else if (m80VarP.e > 64) {
                    s1.l("tag size too big");
                    return;
                }
            } else if (m80VarP.e > 32) {
                s1.l("tag size too big");
                return;
            }
        } else if (m80VarP.e > 20) {
            s1.l("tag size too big");
            return;
        }
        if (q5Var.d >= q5Var.e + q5Var.p().e + 8) {
            return;
        }
        s1.l("ciphertext_segment_size must be at least (derived_key_size + tag_size + 8)");
    }

    public static void s(k6 k6Var) throws GeneralSecurityException {
        ee1.a(k6Var.e);
        int iA = l11.a(k6Var.f);
        if (iA == 0) {
            iA = 5;
        }
        if (iA == 1) {
            s1.l("unknown HKDF hash type");
        } else {
            if (k6Var.d >= k6Var.e + 8) {
                return;
            }
            s1.l("ciphertext_segment_size must be at least (derived_key_size + 8)");
        }
    }

    public static void t(m80 m80Var) throws GeneralSecurityException {
        if (m80Var.e < 10) {
            s1.l("tag size too small");
            return;
        }
        int iA = l11.a(m80Var.d);
        if (iA == 0) {
            iA = 5;
        }
        int iR = l11.r(iA);
        if (iR == 1) {
            if (m80Var.e <= 20) {
                return;
            }
            s1.l("tag size too big");
        } else if (iR == 2) {
            if (m80Var.e <= 32) {
                return;
            }
            s1.l("tag size too big");
        } else if (iR != 3) {
            s1.l("unknown hash type");
        } else {
            if (m80Var.e <= 64) {
                return;
            }
            s1.l("tag size too big");
        }
    }

    @Override // defpackage.he0
    public final fe0 a(zh zhVar) throws GeneralSecurityException {
        switch (this.a) {
            case 0:
                l5 l5Var = (l5) f(zhVar);
                ee0 ee0VarP = fe0.p();
                ee0VarP.f("type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey");
                ee0VarP.g(l5Var.m());
                ee0VarP.e(2);
                return (fe0) ee0VarP.a();
            case 1:
                t5 t5Var = (t5) f(zhVar);
                ee0 ee0VarP2 = fe0.p();
                ee0VarP2.f("type.googleapis.com/google.crypto.tink.AesCtrKey");
                ee0VarP2.g(t5Var.m());
                ee0VarP2.e(2);
                return (fe0) ee0VarP2.a();
            case 2:
                a6 a6Var = (a6) f(zhVar);
                ee0 ee0VarP3 = fe0.p();
                ee0VarP3.f("type.googleapis.com/google.crypto.tink.AesEaxKey");
                ee0VarP3.g(a6Var.m());
                ee0VarP3.e(2);
                return (fe0) ee0VarP3.a();
            case 3:
                h6 h6Var = (h6) f(zhVar);
                ee0 ee0VarP4 = fe0.p();
                ee0VarP4.f("type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey");
                ee0VarP4.g(h6Var.m());
                ee0VarP4.e(2);
                return (fe0) ee0VarP4.a();
            case 4:
                m6 m6Var = (m6) f(zhVar);
                ee0 ee0VarP5 = fe0.p();
                ee0VarP5.f("type.googleapis.com/google.crypto.tink.AesGcmKey");
                ee0VarP5.g(m6Var.m());
                ee0VarP5.e(2);
                return (fe0) ee0VarP5.a();
            case 5:
                r6 r6Var = (r6) f(zhVar);
                ee0 ee0VarP6 = fe0.p();
                ee0VarP6.f("type.googleapis.com/google.crypto.tink.AesSivKey");
                ee0VarP6.g(r6Var.m());
                ee0VarP6.e(2);
                return (fe0) ee0VarP6.a();
            case 6:
                bj bjVarP = p();
                ee0 ee0VarP7 = fe0.p();
                ee0VarP7.f("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
                ee0VarP7.g(bjVarP.m());
                ee0VarP7.e(2);
                return (fe0) ee0VarP7.a();
            case 7:
                qv qvVar = (qv) f(zhVar);
                ee0 ee0VarP8 = fe0.p();
                ee0VarP8.f("type.googleapis.com/google.crypto.tink.EcdsaPrivateKey");
                ee0VarP8.g(qvVar.m());
                ee0VarP8.e(3);
                return (fe0) ee0VarP8.a();
            case 8:
                throw new GeneralSecurityException("Not implemented");
            case 9:
                zv zvVar = (zv) f(zhVar);
                ee0 ee0VarP9 = fe0.p();
                ee0VarP9.f("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
                ee0VarP9.g(zvVar.m());
                ee0VarP9.e(3);
                return (fe0) ee0VarP9.a();
            case 10:
                throw new GeneralSecurityException("Not implemented.");
            case 11:
                iw iwVarQ = q();
                ee0 ee0VarP10 = fe0.p();
                ee0VarP10.f("type.googleapis.com/google.crypto.tink.Ed25519PrivateKey");
                ee0VarP10.g(iwVarQ.m());
                ee0VarP10.e(3);
                return (fe0) ee0VarP10.a();
            case 12:
                throw new GeneralSecurityException("Not implemented");
            case 13:
                i80 i80Var = (i80) f(zhVar);
                ee0 ee0VarP11 = fe0.p();
                ee0VarP11.f("type.googleapis.com/google.crypto.tink.HmacKey");
                ee0VarP11.g(i80Var.m());
                ee0VarP11.e(2);
                return (fe0) ee0VarP11.a();
            case 14:
                ye0 ye0Var = (ye0) f(zhVar);
                ee0 ee0VarP12 = fe0.p();
                ee0VarP12.f("type.googleapis.com/google.crypto.tink.KmsAeadKey");
                ee0VarP12.g(ye0Var.m());
                ee0VarP12.e(5);
                return (fe0) ee0VarP12.a();
            default:
                ef0 ef0Var = (ef0) f(zhVar);
                ee0 ee0VarP13 = fe0.p();
                ee0VarP13.f("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
                ee0VarP13.g(ef0Var.m());
                ee0VarP13.e(5);
                return (fe0) ee0VarP13.a();
        }
    }

    @Override // defpackage.he0
    public final /* bridge */ /* synthetic */ Object b(w50 w50Var) {
        switch (this.a) {
        }
        return g(w50Var);
    }

    @Override // defpackage.he0
    public final String c() {
        switch (this.a) {
            case 0:
                return "type.googleapis.com/google.crypto.tink.AesCtrHmacStreamingKey";
            case 1:
                return "type.googleapis.com/google.crypto.tink.AesCtrKey";
            case 2:
                return "type.googleapis.com/google.crypto.tink.AesEaxKey";
            case 3:
                return "type.googleapis.com/google.crypto.tink.AesGcmHkdfStreamingKey";
            case 4:
                return "type.googleapis.com/google.crypto.tink.AesGcmKey";
            case 5:
                return "type.googleapis.com/google.crypto.tink.AesSivKey";
            case 6:
                return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
            case 7:
                return "type.googleapis.com/google.crypto.tink.EcdsaPrivateKey";
            case 8:
                return "type.googleapis.com/google.crypto.tink.EcdsaPublicKey";
            case 9:
                return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
            case 10:
                return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
            case 11:
                return "type.googleapis.com/google.crypto.tink.Ed25519PrivateKey";
            case 12:
                return "type.googleapis.com/google.crypto.tink.Ed25519PublicKey";
            case 13:
                return "type.googleapis.com/google.crypto.tink.HmacKey";
            case 14:
                return "type.googleapis.com/google.crypto.tink.KmsAeadKey";
            default:
                return "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey";
        }
    }

    @Override // defpackage.he0
    public final Object d(zh zhVar) throws GeneralSecurityException {
        switch (this.a) {
            case 0:
                try {
                    return l((l5) w50.i(l5.g, zhVar));
                } catch (ic0 e) {
                    throw new GeneralSecurityException("expected AesCtrHmacStreamingKey proto", e);
                }
            case 1:
                try {
                    return i((t5) w50.i(t5.g, zhVar));
                } catch (ic0 e2) {
                    throw new GeneralSecurityException("expected serialized AesCtrKey proto", e2);
                }
            case 2:
                try {
                    return g((a6) w50.i(a6.g, zhVar));
                } catch (ic0 e3) {
                    throw new GeneralSecurityException("expected serialized AesEaxKey proto", e3);
                }
            case 3:
                try {
                    return l((h6) w50.i(h6.g, zhVar));
                } catch (ic0 unused) {
                    s1.l("expected AesGcmHkdfStreamingKey proto");
                    return null;
                }
            case 4:
                try {
                    return g((m6) w50.i(m6.f, zhVar));
                } catch (ic0 unused2) {
                    s1.l("expected AesGcmKey proto");
                    return null;
                }
            case 5:
                try {
                    return j((r6) w50.i(r6.f, zhVar));
                } catch (ic0 unused3) {
                    s1.l("expected AesSivKey proto");
                    return null;
                }
            case 6:
                try {
                    return g((bj) w50.i(bj.f, zhVar));
                } catch (ic0 e4) {
                    throw new GeneralSecurityException("invalid ChaCha20Poly1305 key", e4);
                }
            case 7:
                try {
                    return m((qv) w50.i(qv.g, zhVar));
                } catch (ic0 e5) {
                    throw new GeneralSecurityException("expected serialized EcdsaPrivateKey proto", e5);
                }
            case 8:
                try {
                    return n((sv) w50.i(sv.h, zhVar));
                } catch (ic0 e6) {
                    throw new GeneralSecurityException("expected serialized EcdsaPublicKey proto", e6);
                }
            case 9:
                try {
                    return o((zv) w50.i(zv.g, zhVar));
                } catch (ic0 e7) {
                    throw new GeneralSecurityException("expected serialized EciesAeadHkdfPrivateKey proto", e7);
                }
            case 10:
                try {
                    return k((bw) w50.i(bw.h, zhVar));
                } catch (ic0 e8) {
                    throw new GeneralSecurityException("expected serialized EciesAeadHkdfPublicKey proto", e8);
                }
            case 11:
                try {
                    return m((iw) w50.i(iw.g, zhVar));
                } catch (ic0 e9) {
                    throw new GeneralSecurityException("invalid Ed25519 private key", e9);
                }
            case 12:
                try {
                    return n((kw) w50.i(kw.f, zhVar));
                } catch (ic0 e10) {
                    throw new GeneralSecurityException("invalid Ed25519 public key", e10);
                }
            case 13:
                try {
                    return h((i80) w50.i(i80.g, zhVar));
                } catch (ic0 e11) {
                    throw new GeneralSecurityException("expected serialized HmacKey proto", e11);
                }
            case 14:
                try {
                    return g((ye0) w50.i(ye0.f, zhVar));
                } catch (ic0 e12) {
                    throw new GeneralSecurityException("expected KmsAeadKey proto", e12);
                }
            default:
                try {
                    return g((ef0) w50.i(ef0.f, zhVar));
                } catch (ic0 e13) {
                    throw new GeneralSecurityException("expected serialized KmSEnvelopeAeadKey proto", e13);
                }
        }
    }

    @Override // defpackage.he0
    public final w50 e(w50 w50Var) throws GeneralSecurityException {
        int i;
        switch (this.a) {
            case 0:
                if (!(w50Var instanceof n5)) {
                    s1.l("expected AesCtrHmacStreamingKeyFormat proto");
                    return null;
                }
                n5 n5Var = (n5) w50Var;
                if (n5Var.e < 16) {
                    s1.l("key_size must be at least 16 bytes");
                    return null;
                }
                q5 q5Var = n5Var.d;
                if (q5Var == null) {
                    q5Var = q5.h;
                }
                r(q5Var);
                k5 k5Var = (k5) l5.g.k();
                byte[] bArrA = dt0.a(n5Var.e);
                zh zhVarC = zh.c(bArrA, 0, bArrA.length);
                k5Var.c();
                l5 l5Var = (l5) k5Var.c;
                l5Var.getClass();
                l5Var.f = zhVarC;
                q5 q5Var2 = n5Var.d;
                if (q5Var2 == null) {
                    q5Var2 = q5.h;
                }
                k5Var.c();
                l5 l5Var2 = (l5) k5Var.c;
                l5Var2.getClass();
                l5Var2.e = q5Var2;
                k5Var.c();
                ((l5) k5Var.c).d = 0;
                return k5Var.a();
            case 1:
                if (!(w50Var instanceof v5)) {
                    s1.l("expected AesCtrKeyFormat proto");
                    return null;
                }
                v5 v5Var = (v5) w50Var;
                ee1.a(v5Var.e);
                x5 x5Var = v5Var.d;
                if (x5Var == null) {
                    x5Var = x5.e;
                }
                int i2 = x5Var.d;
                if (i2 < 12 || i2 > 16) {
                    s1.l("invalid IV size");
                    return null;
                }
                s5 s5Var = (s5) t5.g.k();
                x5 x5Var2 = v5Var.d;
                if (x5Var2 == null) {
                    x5Var2 = x5.e;
                }
                s5Var.c();
                t5 t5Var = (t5) s5Var.c;
                t5Var.getClass();
                t5Var.e = x5Var2;
                byte[] bArrA2 = dt0.a(v5Var.e);
                zh zhVarC2 = zh.c(bArrA2, 0, bArrA2.length);
                s5Var.c();
                t5 t5Var2 = (t5) s5Var.c;
                t5Var2.getClass();
                t5Var2.f = zhVarC2;
                s5Var.c();
                ((t5) s5Var.c).d = 0;
                return s5Var.a();
            case 2:
                if (!(w50Var instanceof c6)) {
                    s1.l("expected AesEaxKeyFormat proto");
                    return null;
                }
                c6 c6Var = (c6) w50Var;
                ee1.a(c6Var.e);
                e6 e6Var = c6Var.d;
                if ((e6Var == null ? e6.e : e6Var).d != 12) {
                    if (e6Var == null) {
                        e6Var = e6.e;
                    }
                    if (e6Var.d != 16) {
                        s1.l("invalid IV size; acceptable values have 12 or 16 bytes");
                        return null;
                    }
                }
                z5 z5Var = (z5) a6.g.k();
                byte[] bArrA3 = dt0.a(c6Var.e);
                zh zhVarC3 = zh.c(bArrA3, 0, bArrA3.length);
                z5Var.c();
                a6 a6Var = (a6) z5Var.c;
                a6Var.getClass();
                a6Var.f = zhVarC3;
                e6 e6Var2 = c6Var.d;
                if (e6Var2 == null) {
                    e6Var2 = e6.e;
                }
                z5Var.c();
                a6 a6Var2 = (a6) z5Var.c;
                a6Var2.getClass();
                a6Var2.e = e6Var2;
                z5Var.c();
                ((a6) z5Var.c).d = 0;
                return z5Var.a();
            case 3:
                if (!(w50Var instanceof i6)) {
                    s1.l("expected AesGcmHkdfStreamingKeyFormat proto");
                    return null;
                }
                i6 i6Var = (i6) w50Var;
                if (i6Var.e < 16) {
                    s1.l("key_size must be at least 16 bytes");
                    return null;
                }
                k6 k6Var = i6Var.d;
                if (k6Var == null) {
                    k6Var = k6.g;
                }
                s(k6Var);
                g6 g6Var = (g6) h6.g.k();
                byte[] bArrA4 = dt0.a(i6Var.e);
                zh zhVarC4 = zh.c(bArrA4, 0, bArrA4.length);
                g6Var.c();
                h6 h6Var = (h6) g6Var.c;
                h6Var.getClass();
                h6Var.f = zhVarC4;
                k6 k6Var2 = i6Var.d;
                if (k6Var2 == null) {
                    k6Var2 = k6.g;
                }
                g6Var.c();
                h6 h6Var2 = (h6) g6Var.c;
                h6Var2.getClass();
                h6Var2.e = k6Var2;
                g6Var.c();
                ((h6) g6Var.c).d = 0;
                return g6Var.a();
            case 4:
                if (!(w50Var instanceof o6)) {
                    s1.l("expected AesGcmKeyFormat proto");
                    return null;
                }
                o6 o6Var = (o6) w50Var;
                ee1.a(o6Var.d);
                l6 l6Var = (l6) m6.f.k();
                byte[] bArrA5 = dt0.a(o6Var.d);
                zh zhVarC5 = zh.c(bArrA5, 0, bArrA5.length);
                l6Var.c();
                m6 m6Var = (m6) l6Var.c;
                m6Var.getClass();
                m6Var.e = zhVarC5;
                l6Var.c();
                ((m6) l6Var.c).d = 0;
                return l6Var.a();
            case 5:
                if (!(w50Var instanceof t6)) {
                    s1.l("expected AesSivKeyFormat proto");
                    return null;
                }
                t6 t6Var = (t6) w50Var;
                if (t6Var.d != 64) {
                    throw new InvalidAlgorithmParameterException("invalid key size: " + t6Var.d + ". Valid keys must have 64 bytes.");
                }
                q6 q6Var = (q6) r6.f.k();
                byte[] bArrA6 = dt0.a(t6Var.d);
                zh zhVarC6 = zh.c(bArrA6, 0, bArrA6.length);
                q6Var.c();
                r6 r6Var = (r6) q6Var.c;
                r6Var.getClass();
                r6Var.e = zhVarC6;
                q6Var.c();
                ((r6) q6Var.c).d = 0;
                return q6Var.a();
            case 6:
                return p();
            case 7:
                if (!(w50Var instanceof mv)) {
                    s1.l("expected EcdsaKeyFormat proto");
                    return null;
                }
                ov ovVar = ((mv) w50Var).d;
                if (ovVar == null) {
                    ovVar = ov.g;
                }
                fp1.G(ovVar);
                int i3 = ovVar.e;
                i = i3 != 0 ? i3 != 2 ? i3 != 3 ? i3 != 4 ? 0 : 4 : 3 : 2 : 1;
                ECParameterSpec eCParameterSpecM = xr.m(fp1.C(i != 0 ? i : 5));
                KeyPairGenerator keyPairGenerator = (KeyPairGenerator) jz.h.a("EC");
                keyPairGenerator.initialize(eCParameterSpecM);
                KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
                ECPublicKey eCPublicKey = (ECPublicKey) keyPairGenerateKeyPair.getPublic();
                ECPrivateKey eCPrivateKey = (ECPrivateKey) keyPairGenerateKeyPair.getPrivate();
                ECPoint w = eCPublicKey.getW();
                rv rvVar = (rv) sv.h.k();
                rvVar.c();
                ((sv) rvVar.c).d = 0;
                rvVar.c();
                sv svVar = (sv) rvVar.c;
                svVar.getClass();
                svVar.e = ovVar;
                byte[] byteArray = w.getAffineX().toByteArray();
                zh zhVarC7 = zh.c(byteArray, 0, byteArray.length);
                rvVar.c();
                sv svVar2 = (sv) rvVar.c;
                svVar2.getClass();
                svVar2.f = zhVarC7;
                byte[] byteArray2 = w.getAffineY().toByteArray();
                zh zhVarC8 = zh.c(byteArray2, 0, byteArray2.length);
                rvVar.c();
                sv svVar3 = (sv) rvVar.c;
                svVar3.getClass();
                svVar3.g = zhVarC8;
                sv svVar4 = (sv) rvVar.a();
                pv pvVar = (pv) qv.g.k();
                pvVar.c();
                ((qv) pvVar.c).d = 0;
                pvVar.c();
                qv qvVar = (qv) pvVar.c;
                qvVar.getClass();
                qvVar.e = svVar4;
                byte[] byteArray3 = eCPrivateKey.getS().toByteArray();
                zh zhVarC9 = zh.c(byteArray3, 0, byteArray3.length);
                pvVar.c();
                qv qvVar2 = (qv) pvVar.c;
                qvVar2.getClass();
                qvVar2.f = zhVarC9;
                return pvVar.a();
            case 8:
                throw new GeneralSecurityException("Not implemented");
            case 9:
                if (!(w50Var instanceof vv)) {
                    s1.l("expected EciesAeadHkdfKeyFormat proto");
                    return null;
                }
                vv vvVar = (vv) w50Var;
                xv xvVar = vvVar.d;
                if (xvVar == null) {
                    xvVar = xv.g;
                }
                tk0.K(xvVar);
                xv xvVar2 = vvVar.d;
                if (xvVar2 == null) {
                    xvVar2 = xv.g;
                }
                int i4 = xvVar2.q().d;
                i = i4 != 0 ? i4 != 2 ? i4 != 3 ? i4 != 4 ? 0 : 4 : 3 : 2 : 1;
                ECParameterSpec eCParameterSpecM2 = xr.m(tk0.H(i != 0 ? i : 5));
                KeyPairGenerator keyPairGenerator2 = (KeyPairGenerator) jz.h.a("EC");
                keyPairGenerator2.initialize(eCParameterSpecM2);
                KeyPair keyPairGenerateKeyPair2 = keyPairGenerator2.generateKeyPair();
                ECPublicKey eCPublicKey2 = (ECPublicKey) keyPairGenerateKeyPair2.getPublic();
                ECPrivateKey eCPrivateKey2 = (ECPrivateKey) keyPairGenerateKeyPair2.getPrivate();
                ECPoint w2 = eCPublicKey2.getW();
                aw awVar = (aw) bw.h.k();
                awVar.c();
                ((bw) awVar.c).d = 0;
                xv xvVar3 = vvVar.d;
                if (xvVar3 == null) {
                    xvVar3 = xv.g;
                }
                awVar.c();
                bw bwVar = (bw) awVar.c;
                bwVar.getClass();
                bwVar.e = xvVar3;
                byte[] byteArray4 = w2.getAffineX().toByteArray();
                zh zhVarC10 = zh.c(byteArray4, 0, byteArray4.length);
                awVar.c();
                bw bwVar2 = (bw) awVar.c;
                bwVar2.getClass();
                bwVar2.f = zhVarC10;
                byte[] byteArray5 = w2.getAffineY().toByteArray();
                zh zhVarC11 = zh.c(byteArray5, 0, byteArray5.length);
                awVar.c();
                bw bwVar3 = (bw) awVar.c;
                bwVar3.getClass();
                bwVar3.g = zhVarC11;
                bw bwVar4 = (bw) awVar.a();
                yv yvVar = (yv) zv.g.k();
                yvVar.c();
                ((zv) yvVar.c).d = 0;
                yvVar.c();
                zv zvVar = (zv) yvVar.c;
                zvVar.getClass();
                zvVar.e = bwVar4;
                byte[] byteArray6 = eCPrivateKey2.getS().toByteArray();
                zh zhVarC12 = zh.c(byteArray6, 0, byteArray6.length);
                yvVar.c();
                zv zvVar2 = (zv) yvVar.c;
                zvVar2.getClass();
                zvVar2.f = zhVarC12;
                return yvVar.a();
            case 10:
                throw new GeneralSecurityException("Not implemented.");
            case 11:
                return q();
            case 12:
                throw new GeneralSecurityException("Not implemented");
            case 13:
                if (!(w50Var instanceof k80)) {
                    s1.l("expected HmacKeyFormat proto");
                    return null;
                }
                k80 k80Var = (k80) w50Var;
                if (k80Var.e < 16) {
                    s1.l("key too short");
                    return null;
                }
                m80 m80Var = k80Var.d;
                if (m80Var == null) {
                    m80Var = m80.f;
                }
                t(m80Var);
                h80 h80Var = (h80) i80.g.k();
                h80Var.c();
                ((i80) h80Var.c).d = 0;
                m80 m80Var2 = k80Var.d;
                if (m80Var2 == null) {
                    m80Var2 = m80.f;
                }
                h80Var.c();
                i80 i80Var = (i80) h80Var.c;
                i80Var.getClass();
                i80Var.e = m80Var2;
                byte[] bArrA7 = dt0.a(k80Var.e);
                zh zhVarC13 = zh.c(bArrA7, 0, bArrA7.length);
                h80Var.c();
                i80 i80Var2 = (i80) h80Var.c;
                i80Var2.getClass();
                i80Var2.f = zhVarC13;
                return h80Var.a();
            case 14:
                if (!(w50Var instanceof af0)) {
                    s1.l("expected KmsAeadKeyFormat proto");
                    return null;
                }
                xe0 xe0Var = (xe0) ye0.f.k();
                xe0Var.c();
                ye0 ye0Var = (ye0) xe0Var.c;
                ye0Var.getClass();
                ye0Var.e = (af0) w50Var;
                xe0Var.c();
                ((ye0) xe0Var.c).d = 0;
                return xe0Var.a();
            default:
                if (!(w50Var instanceof gf0)) {
                    s1.l("expected KmsEnvelopeAeadKeyFormat proto");
                    return null;
                }
                df0 df0Var = (df0) ef0.f.k();
                df0Var.c();
                ef0 ef0Var = (ef0) df0Var.c;
                ef0Var.getClass();
                ef0Var.e = (gf0) w50Var;
                df0Var.c();
                ((ef0) df0Var.c).d = 0;
                return df0Var.a();
        }
    }

    @Override // defpackage.he0
    public final w50 f(zh zhVar) throws GeneralSecurityException {
        switch (this.a) {
            case 0:
                try {
                    return e((n5) w50.i(n5.f, zhVar));
                } catch (ic0 e) {
                    throw new GeneralSecurityException("expected serialized AesCtrHmacStreamingKeyFormat proto", e);
                }
            case 1:
                try {
                    return e((v5) w50.i(v5.f, zhVar));
                } catch (ic0 e2) {
                    throw new GeneralSecurityException("expected serialized AesCtrKeyFormat proto", e2);
                }
            case 2:
                try {
                    return e((c6) w50.i(c6.f, zhVar));
                } catch (ic0 e3) {
                    throw new GeneralSecurityException("expected serialized AesEaxKeyFormat proto", e3);
                }
            case 3:
                try {
                    return e((i6) w50.i(i6.f, zhVar));
                } catch (ic0 e4) {
                    throw new GeneralSecurityException("expected serialized AesGcmHkdfStreamingKeyFormat proto", e4);
                }
            case 4:
                try {
                    return e((o6) w50.i(o6.e, zhVar));
                } catch (ic0 e5) {
                    throw new GeneralSecurityException("expected serialized AesGcmKeyFormat proto", e5);
                }
            case 5:
                try {
                    return e((t6) w50.i(t6.e, zhVar));
                } catch (ic0 e6) {
                    throw new GeneralSecurityException("expected serialized AesSivKeyFormat proto", e6);
                }
            case 6:
                return p();
            case 7:
                try {
                    return e((mv) w50.i(mv.e, zhVar));
                } catch (ic0 e7) {
                    throw new GeneralSecurityException("expected EcdsaKeyFormat proto", e7);
                }
            case 8:
                throw new GeneralSecurityException("Not implemented");
            case 9:
                try {
                    return e((vv) w50.i(vv.e, zhVar));
                } catch (ic0 e8) {
                    throw new GeneralSecurityException("invalid EciesAeadHkdf key format", e8);
                }
            case 10:
                throw new GeneralSecurityException("Not implemented.");
            case 11:
                return q();
            case 12:
                throw new GeneralSecurityException("Not implemented");
            case 13:
                try {
                    return e((k80) w50.i(k80.f, zhVar));
                } catch (ic0 e9) {
                    throw new GeneralSecurityException("expected serialized HmacKeyFormat proto", e9);
                }
            case 14:
                try {
                    return e((af0) w50.i(af0.e, zhVar));
                } catch (ic0 e10) {
                    throw new GeneralSecurityException("expected serialized KmsAeadKeyFormat proto", e10);
                }
            default:
                try {
                    return e((gf0) w50.i(gf0.f, zhVar));
                } catch (ic0 e11) {
                    throw new GeneralSecurityException("expected serialized KmsEnvelopeAeadKeyFormat proto", e11);
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x00f8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.x4 g(defpackage.w50 r4) throws java.security.GeneralSecurityException {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o5.g(w50):x4");
    }

    public fc0 l(w50 w50Var) throws GeneralSecurityException {
        fc0 j5Var = null;
        switch (this.a) {
            case 0:
                if (w50Var instanceof l5) {
                    l5 l5Var = (l5) w50Var;
                    ee1.c(l5Var.d);
                    if (l5Var.f.size() < 16) {
                        s1.l("key_value must have at least 16 bytes");
                    } else if (l5Var.f.size() >= l5Var.p().e) {
                        r(l5Var.p());
                        byte[] bArrE = l5Var.f.e();
                        int iA = l11.a(l5Var.p().f);
                        if (iA == 0) {
                            iA = 5;
                        }
                        xr.N(iA);
                        int i = l5Var.p().e;
                        int iA2 = l11.a(l5Var.p().p().d);
                        String strN = xr.N(iA2 != 0 ? iA2 : 5);
                        int i2 = l5Var.p().p().e;
                        int i3 = l5Var.p().d;
                        j5Var = new j5();
                        int length = bArrE.length;
                        if (length < 16 || length < i) {
                            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i));
                        }
                        ee1.a(i);
                        if (i2 < 10) {
                            throw new InvalidAlgorithmParameterException(qq0.i("tag size too small ", i2));
                        }
                        if ((strN.equals("HmacSha1") && i2 > 20) || ((strN.equals("HmacSha256") && i2 > 32) || (strN.equals("HmacSha512") && i2 > 64))) {
                            throw new InvalidAlgorithmParameterException("tag size too big");
                        }
                        if (((i3 - i2) - i) - 8 <= 0) {
                            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
                        }
                        Arrays.copyOf(bArrE, bArrE.length);
                    } else {
                        s1.l("key_value must have at least as many bits as derived keys");
                    }
                } else {
                    s1.l("expected AesCtrHmacStreamingKey proto");
                }
                return j5Var;
            default:
                if (w50Var instanceof h6) {
                    h6 h6Var = (h6) w50Var;
                    ee1.c(h6Var.d);
                    s(h6Var.p());
                    byte[] bArrE2 = h6Var.f.e();
                    int iA3 = l11.a(h6Var.p().f);
                    xr.N(iA3 != 0 ? iA3 : 5);
                    j5Var = new f6(bArrE2, h6Var.p().e, h6Var.p().d);
                } else {
                    s1.l("expected AesGcmHkdfStreamingKey proto");
                }
                return j5Var;
        }
    }

    public xr0 m(w50 w50Var) throws GeneralSecurityException {
        int i;
        ix ixVar = null;
        switch (this.a) {
            case 7:
                if (w50Var instanceof qv) {
                    qv qvVar = (qv) w50Var;
                    ee1.c(qvVar.d);
                    fp1.G(qvVar.p().p());
                    int i2 = qvVar.p().p().e;
                    if (i2 != 0) {
                        i = 2;
                        if (i2 != 2) {
                            i = 3;
                            if (i2 != 3) {
                                i = 4;
                                if (i2 != 4) {
                                    i = 0;
                                }
                            }
                        }
                    } else {
                        i = 1;
                    }
                    if (i == 0) {
                        i = 5;
                    }
                    xr.n(fp1.C(i), qvVar.f.e());
                    int iA = l11.a(qvVar.p().p().d);
                    int iE = fp1.E(iA != 0 ? iA : 5);
                    fp1.D(qvVar.p().p().p());
                    ixVar = new ix(11);
                    xy0.K(iE);
                } else {
                    s1.l("expected EcdsaPrivateKey proto");
                }
                return ixVar;
            default:
                if (!(w50Var instanceof iw)) {
                    s1.l("expected Ed25519PrivateKey proto");
                    return null;
                }
                iw iwVar = (iw) w50Var;
                ee1.c(iwVar.d);
                if (iwVar.e.size() != 32) {
                    s1.l("invalid Ed25519 private key: incorrect key length");
                    return null;
                }
                byte[] bArrE = iwVar.e.e();
                c70 c70Var = new c70(12);
                if (bArrE.length == 32) {
                    fc0.M(fc0.w(bArrE));
                    return c70Var;
                }
                zy.n("Given private key's length is not 32");
                return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a A[PHI: r1
  0x006a: PHI (r1v6 int) = (r1v5 int), (r1v7 int), (r1v8 int) binds: [B:20:0x0061, B:22:0x0064, B:24:0x0067] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.yr0 n(defpackage.w50 r5) throws java.security.GeneralSecurityException {
        /*
            r4 = this;
            int r4 = r4.a
            r0 = 0
            r1 = 0
            switch(r4) {
                case 8: goto L46;
                default: goto L7;
            }
        L7:
            boolean r4 = r5 instanceof defpackage.kw
            if (r4 == 0) goto L40
            kw r5 = (defpackage.kw) r5
            int r4 = r5.d
            defpackage.ee1.c(r4)
            zh r4 = r5.e
            int r4 = r4.size()
            r2 = 32
            if (r4 != r2) goto L3a
            ow0 r4 = new ow0
            zh r5 = r5.e
            byte[] r5 = r5.e()
            r3 = 12
            r4.<init>(r3)
            int r3 = r5.length
            if (r3 != r2) goto L34
            int r1 = r5.length
            byte[] r2 = new byte[r1]
            java.lang.System.arraycopy(r5, r0, r2, r0, r1)
            r1 = r4
            goto L45
        L34:
            java.lang.String r4 = "Given public key's length is not 32."
            defpackage.zy.n(r4)
            goto L45
        L3a:
            java.lang.String r4 = "invalid Ed25519 public key: incorrect key length"
            defpackage.s1.l(r4)
            goto L45
        L40:
            java.lang.String r4 = "expected Ed25519PublicKey proto"
            defpackage.s1.l(r4)
        L45:
            return r1
        L46:
            boolean r4 = r5 instanceof defpackage.sv
            if (r4 == 0) goto Lbc
            sv r5 = (defpackage.sv) r5
            int r4 = r5.d
            defpackage.ee1.c(r4)
            ov r4 = r5.p()
            defpackage.fp1.G(r4)
            ov r4 = r5.p()
            int r4 = r4.e
            if (r4 == 0) goto L6c
            r1 = 2
            if (r4 == r1) goto L6a
            r1 = 3
            if (r4 == r1) goto L6a
            r1 = 4
            if (r4 == r1) goto L6a
            goto L6d
        L6a:
            r0 = r1
            goto L6d
        L6c:
            r0 = 1
        L6d:
            r4 = 5
            if (r0 != 0) goto L71
            r0 = r4
        L71:
            int r0 = defpackage.fp1.C(r0)
            zh r1 = r5.f
            byte[] r1 = r1.e()
            zh r2 = r5.g
            byte[] r2 = r2.e()
            java.security.interfaces.ECPublicKey r0 = defpackage.xr.o(r0, r1, r2)
            c70 r1 = new c70
            ov r2 = r5.p()
            int r2 = r2.d
            int r2 = defpackage.l11.a(r2)
            if (r2 != 0) goto L94
            goto L95
        L94:
            r4 = r2
        L95:
            int r4 = defpackage.fp1.E(r4)
            ov r5 = r5.p()
            int r5 = r5.p()
            defpackage.fp1.D(r5)
            r5 = 11
            r1.<init>(r5)
            java.security.spec.ECPoint r5 = r0.getW()
            java.security.spec.ECParameterSpec r0 = r0.getParams()
            java.security.spec.EllipticCurve r0 = r0.getCurve()
            defpackage.xr.b(r5, r0)
            defpackage.xy0.K(r4)
            goto Lc1
        Lbc:
            java.lang.String r4 = "expected EcdsaPublicKey proto"
            defpackage.s1.l(r4)
        Lc1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.o5.n(w50):yr0");
    }
}
