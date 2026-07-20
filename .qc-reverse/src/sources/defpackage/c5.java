package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c5 {
    public static final je0 a;

    static {
        c(16);
        a = c(32);
        b(16);
        b(32);
        a(16, 16);
        a(32, 32);
        ie0 ie0Var = (ie0) je0.g.k();
        ie0Var.f("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        ie0Var.e();
    }

    public static void a(int i, int i2) {
        u5 u5Var = (u5) v5.f.k();
        w5 w5Var = (w5) x5.e.k();
        w5Var.c();
        ((x5) w5Var.c).d = 16;
        x5 x5Var = (x5) w5Var.a();
        u5Var.c();
        v5 v5Var = (v5) u5Var.c;
        v5Var.getClass();
        v5Var.d = x5Var;
        u5Var.c();
        ((v5) u5Var.c).e = i;
        v5 v5Var2 = (v5) u5Var.a();
        j80 j80Var = (j80) k80.f.k();
        l80 l80Var = (l80) m80.f.k();
        l80Var.c();
        m80 m80Var = (m80) l80Var.c;
        m80Var.getClass();
        m80Var.d = 3;
        l80Var.c();
        ((m80) l80Var.c).e = i2;
        m80 m80Var2 = (m80) l80Var.a();
        j80Var.c();
        k80 k80Var = (k80) j80Var.c;
        k80Var.getClass();
        k80Var.d = m80Var2;
        j80Var.c();
        ((k80) j80Var.c).e = 32;
        k80 k80Var2 = (k80) j80Var.a();
        g5 g5Var = (g5) h5.f.k();
        g5Var.c();
        h5 h5Var = (h5) g5Var.c;
        h5Var.getClass();
        h5Var.d = v5Var2;
        g5Var.c();
        h5 h5Var2 = (h5) g5Var.c;
        h5Var2.getClass();
        h5Var2.e = k80Var2;
        h5 h5Var3 = (h5) g5Var.a();
        ie0 ie0Var = (ie0) je0.g.k();
        ie0Var.g(h5Var3.m());
        ie0Var.f("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        ie0Var.e();
    }

    public static void b(int i) {
        b6 b6Var = (b6) c6.f.k();
        b6Var.c();
        ((c6) b6Var.c).e = i;
        d6 d6Var = (d6) e6.e.k();
        d6Var.c();
        ((e6) d6Var.c).d = 16;
        e6 e6Var = (e6) d6Var.a();
        b6Var.c();
        c6 c6Var = (c6) b6Var.c;
        c6Var.getClass();
        c6Var.d = e6Var;
        c6 c6Var2 = (c6) b6Var.a();
        ie0 ie0Var = (ie0) je0.g.k();
        ie0Var.g(c6Var2.m());
        ie0Var.f("type.googleapis.com/google.crypto.tink.AesEaxKey");
        ie0Var.e();
    }

    public static je0 c(int i) {
        n6 n6Var = (n6) o6.e.k();
        n6Var.c();
        ((o6) n6Var.c).d = i;
        o6 o6Var = (o6) n6Var.a();
        ie0 ie0Var = (ie0) je0.g.k();
        ie0Var.g(o6Var.m());
        ie0Var.f("type.googleapis.com/google.crypto.tink.AesGcmKey");
        ie0Var.e();
        return (je0) ie0Var.a();
    }
}
