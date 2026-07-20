package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wc extends rp {
    public final Context a;
    public final xk b;
    public final xk c;
    public final String d;

    public wc(Context context, xk xkVar, xk xkVar2, String str) {
        if (context == null) {
            zy.r("Null applicationContext");
            throw null;
        }
        this.a = context;
        if (xkVar == null) {
            zy.r("Null wallClock");
            throw null;
        }
        this.b = xkVar;
        if (xkVar2 == null) {
            zy.r("Null monotonicClock");
            throw null;
        }
        this.c = xkVar2;
        if (str != null) {
            this.d = str;
        } else {
            zy.r("Null backendName");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof rp) {
            wc wcVar = (wc) ((rp) obj);
            if (this.a.equals(wcVar.a) && this.b.equals(wcVar.b) && this.c.equals(wcVar.c) && this.d.equals(wcVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.d.hashCode() ^ ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.a);
        sb.append(", wallClock=");
        sb.append(this.b);
        sb.append(", monotonicClock=");
        sb.append(this.c);
        sb.append(", backendName=");
        return l11.k(sb, this.d, "}");
    }
}
