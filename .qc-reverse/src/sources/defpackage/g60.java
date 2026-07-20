package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class g60 {
    private static final /* synthetic */ g60[] $VALUES;
    public static final g60 LONG;
    public static final g60 MEDIUM;
    public static final g60 SHORT;

    static {
        g60 g60Var = new g60("SHORT", 0);
        SHORT = g60Var;
        g60 g60Var2 = new g60("MEDIUM", 1);
        MEDIUM = g60Var2;
        g60 g60Var3 = new g60("LONG", 2);
        LONG = g60Var3;
        $VALUES = new g60[]{g60Var, g60Var2, g60Var3};
    }

    public static g60 valueOf(String str) {
        return (g60) Enum.valueOf(g60.class, str);
    }

    public static g60[] values() {
        return (g60[]) $VALUES.clone();
    }
}
