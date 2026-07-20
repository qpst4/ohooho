package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class n60 {
    private static final /* synthetic */ n60[] $VALUES;
    public static final n60 LONG;
    public static final n60 MEDIUM;
    public static final n60 SHORT;

    static {
        n60 n60Var = new n60("SHORT", 0);
        SHORT = n60Var;
        n60 n60Var2 = new n60("MEDIUM", 1);
        MEDIUM = n60Var2;
        n60 n60Var3 = new n60("LONG", 2);
        LONG = n60Var3;
        $VALUES = new n60[]{n60Var, n60Var2, n60Var3};
    }

    public static n60 valueOf(String str) {
        return (n60) Enum.valueOf(n60.class, str);
    }

    public static n60[] values() {
        return (n60[]) $VALUES.clone();
    }
}
