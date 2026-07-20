package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class z20 {
    public static final z20 d = new z20("", "", false);
    public final String a;
    public final String b;
    public final boolean c;

    static {
        new z20("\n", "  ", true);
    }

    public z20(String str, String str2, boolean z) {
        if (!str.matches("[\r\n]*")) {
            zy.n("Only combinations of \\n and \\r are allowed in newline.");
            throw null;
        }
        if (!str2.matches("[ \t]*")) {
            zy.n("Only combinations of spaces and tabs are allowed in indent.");
            throw null;
        }
        this.a = str;
        this.b = str2;
        this.c = z;
    }
}
