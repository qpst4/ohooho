package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public enum vr0 {
    c("http/1.0"),
    d("http/1.1"),
    e("spdy/3.1"),
    f("h2"),
    g("h2_prior_knowledge"),
    h("quic");

    public final String b;

    vr0(String str) {
        this.b = str;
    }

    public static vr0 a(String str) throws IOException {
        if (str.equals("http/1.0")) {
            return c;
        }
        if (str.equals("http/1.1")) {
            return d;
        }
        if (str.equals("h2_prior_knowledge")) {
            return g;
        }
        if (str.equals("h2")) {
            return f;
        }
        if (str.equals("spdy/3.1")) {
            return e;
        }
        if (str.equals("quic")) {
            return h;
        }
        zy.p("Unexpected protocol: ".concat(str));
        return null;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.b;
    }
}
