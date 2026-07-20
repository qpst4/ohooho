package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class sf0 extends Number {
    public final String b;

    public sf0(String str) {
        this.b = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof sf0) {
            return this.b.equals(((sf0) obj).b);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.b);
    }

    public final int hashCode() {
        return this.b.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.b;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return tk0.w(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.b;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return tk0.w(str).longValue();
        }
    }

    public final String toString() {
        return this.b;
    }
}
