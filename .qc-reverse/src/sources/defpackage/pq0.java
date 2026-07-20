package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pq0 {
    public static final pq0 b;
    public static final pq0 c;
    public static final pq0 d;
    public static final /* synthetic */ pq0[] e;

    static {
        pq0 pq0Var = new pq0("disabled", 0);
        b = pq0Var;
        pq0 pq0Var2 = new pq0("newCursor", 1);
        c = pq0Var2;
        pq0 pq0Var3 = new pq0("everyRelease", 2);
        d = pq0Var3;
        e = new pq0[]{pq0Var, pq0Var2, pq0Var3};
    }

    public static pq0 valueOf(String str) {
        return (pq0) Enum.valueOf(pq0.class, str);
    }

    public static pq0[] values() {
        return (pq0[]) e.clone();
    }
}
