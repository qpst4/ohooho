package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tq0 {
    public static final tq0 b;
    public static final tq0 c;
    public static final tq0 d;
    public static final /* synthetic */ tq0[] e;

    static {
        tq0 tq0Var = new tq0("DEFAULT", 0);
        b = tq0Var;
        tq0 tq0Var2 = new tq0("VERY_LOW", 1);
        c = tq0Var2;
        tq0 tq0Var3 = new tq0("HIGHEST", 2);
        d = tq0Var3;
        e = new tq0[]{tq0Var, tq0Var2, tq0Var3};
    }

    public static tq0 valueOf(String str) {
        return (tq0) Enum.valueOf(tq0.class, str);
    }

    public static tq0[] values() {
        return (tq0[]) e.clone();
    }
}
