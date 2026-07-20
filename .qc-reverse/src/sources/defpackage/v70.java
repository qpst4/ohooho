package defpackage;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class v70 {
    public static final ai d = ai.c(":");
    public static final ai e = ai.c(":status");
    public static final ai f = ai.c(":method");
    public static final ai g = ai.c(":path");
    public static final ai h = ai.c(":scheme");
    public static final ai i = ai.c(":authority");
    public final ai a;
    public final ai b;
    public final int c;

    public v70(ai aiVar, ai aiVar2) {
        this.a = aiVar;
        this.b = aiVar2;
        this.c = aiVar2.i() + aiVar.i() + 32;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof v70) {
            v70 v70Var = (v70) obj;
            if (this.a.equals(v70Var.a) && this.b.equals(v70Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() + ((this.a.hashCode() + 527) * 31);
    }

    public final String toString() {
        String strL = this.a.l();
        String strL2 = this.b.l();
        byte[] bArr = be1.a;
        Locale locale = Locale.US;
        return strL + ": " + strL2;
    }

    public v70(ai aiVar, String str) {
        this(aiVar, ai.c(str));
    }

    public v70(String str, String str2) {
        this(ai.c(str), ai.c(str2));
    }
}
