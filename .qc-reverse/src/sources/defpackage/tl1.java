package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tl1 implements Comparable, Serializable {
    public static final tl1 c = new tl1(0);
    public static final tl1 d = new tl1(1);
    public final /* synthetic */ int b;

    public /* synthetic */ tl1(int i) {
        this.b = i;
    }

    public final int a(tl1 tl1Var) {
        switch (this.b) {
            case 0:
                return tl1Var == this ? 0 : 1;
            default:
                return tl1Var == this ? 0 : -1;
        }
    }

    public final void b(StringBuilder sb) {
        switch (this.b) {
            case 0:
                throw new AssertionError();
            default:
                sb.append("(-∞");
                return;
        }
    }

    public final void c(StringBuilder sb) {
        switch (this.b) {
            case 0:
                sb.append("+∞)");
                return;
            default:
                throw new AssertionError();
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        switch (this.b) {
            case 0:
                return ((tl1) obj) == this ? 0 : 1;
            default:
                return ((tl1) obj) == this ? 0 : -1;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof tl1) {
            try {
                if (a((tl1) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        switch (this.b) {
        }
        return System.identityHashCode(this);
    }

    public final String toString() {
        switch (this.b) {
            case 0:
                return "+∞";
            default:
                return "-∞";
        }
    }
}
