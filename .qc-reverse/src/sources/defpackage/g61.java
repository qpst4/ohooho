package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public enum g61 {
    c("TLSv1.3"),
    d("TLSv1.2"),
    e("TLSv1.1"),
    f("TLSv1"),
    g("SSLv3");

    public final String b;

    g61(String str) {
        this.b = str;
    }

    public static g61 a(String str) {
        str.getClass();
        switch (str) {
            case "TLSv1.1":
                return e;
            case "TLSv1.2":
                return d;
            case "TLSv1.3":
                return c;
            case "SSLv3":
                return g;
            case "TLSv1":
                return f;
            default:
                zy.n("Unexpected TLS version: ".concat(str));
                return null;
        }
    }
}
