package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class np0 {
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof np0)) {
            return false;
        }
        np0 np0Var = (np0) obj;
        String str = this.c;
        String str2 = np0Var.c;
        return (str == null && str2 == null) ? Objects.equals(Objects.toString(this.a), Objects.toString(np0Var.a)) && Objects.equals(this.b, np0Var.b) && Boolean.valueOf(this.d).equals(Boolean.valueOf(np0Var.d)) && Boolean.valueOf(this.e).equals(Boolean.valueOf(np0Var.e)) : Objects.equals(str, str2);
    }

    public final int hashCode() {
        String str = this.c;
        return str != null ? str.hashCode() : Objects.hash(this.a, this.b, Boolean.valueOf(this.d), Boolean.valueOf(this.e));
    }
}
