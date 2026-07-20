package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qm1 extends rm1 implements Serializable {
    public static final qm1 c = new qm1(0);
    public static final qm1 d = new qm1(1);
    public final /* synthetic */ int b;

    public /* synthetic */ qm1(int i) {
        this.b = i;
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        switch (this.b) {
            case 0:
                Comparable comparable = (Comparable) obj;
                Comparable comparable2 = (Comparable) obj2;
                comparable.getClass();
                comparable2.getClass();
                return comparable.compareTo(comparable2);
            default:
                sm1 sm1Var = (sm1) obj;
                sm1 sm1Var2 = (sm1) obj2;
                return rl1.a.b(sm1Var.b, sm1Var2.b).b(sm1Var.c, sm1Var2.c).a();
        }
    }

    public String toString() {
        switch (this.b) {
            case 0:
                return "Ordering.natural()";
            default:
                return super.toString();
        }
    }
}
