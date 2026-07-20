package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class cp1 {
    public static final tp1 a(Object obj, Object obj2) {
        tp1 tp1Var = (tp1) obj;
        tp1 tp1Var2 = (tp1) obj2;
        if (!tp1Var2.isEmpty()) {
            if (!tp1Var.b) {
                if (tp1Var.isEmpty()) {
                    tp1Var = new tp1();
                } else {
                    tp1 tp1Var3 = new tp1(tp1Var);
                    tp1Var3.b = true;
                    tp1Var = tp1Var3;
                }
            }
            tp1Var.b();
            if (!tp1Var2.isEmpty()) {
                tp1Var.putAll(tp1Var2);
            }
        }
        return tp1Var;
    }
}
