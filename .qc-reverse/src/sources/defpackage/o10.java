package defpackage;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class o10 {
    public final String a;
    public final Map b;

    public o10(String str, Map map) {
        this.a = str;
        this.b = map;
    }

    public static o10 a(String str) {
        return new o10(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o10)) {
            return false;
        }
        o10 o10Var = (o10) obj;
        return this.a.equals(o10Var.a) && this.b.equals(o10Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.a + ", properties=" + this.b.values() + "}";
    }
}
