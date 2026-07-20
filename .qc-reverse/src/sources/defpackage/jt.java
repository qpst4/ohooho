package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jt {
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;

    public jt(CharSequence charSequence, CharSequence charSequence2, Integer num, Boolean bool) {
        this.a = charSequence;
        this.b = charSequence2;
        this.c = num;
        this.d = bool;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof jt)) {
            return false;
        }
        jt jtVar = (jt) obj;
        return Objects.equals(this.a, jtVar.a) && Objects.equals(this.b, jtVar.b) && Objects.equals(this.c, jtVar.c) && Objects.equals(this.d, jtVar.d);
    }

    public final int hashCode() {
        return Objects.hashCode(this.d) + ((Objects.hashCode(this.c) + ((Objects.hashCode(this.b) + (Objects.hashCode(this.a) * 31)) * 31)) * 31);
    }

    public final String toString() {
        Object[] objArr = {this.a, this.b, this.c, this.d};
        String[] strArrSplit = "a;b;c;d".length() == 0 ? new String[0] : "a;b;c;d".split(";");
        StringBuilder sb = new StringBuilder();
        sb.append(jt.class.getSimpleName());
        sb.append("[");
        for (int i = 0; i < strArrSplit.length; i++) {
            sb.append(strArrSplit[i]);
            sb.append("=");
            sb.append(objArr[i]);
            if (i != strArrSplit.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
