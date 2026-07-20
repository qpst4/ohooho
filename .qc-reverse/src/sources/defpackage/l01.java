package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l01 {
    private static final /* synthetic */ l01[] $VALUES;
    public static final l01 auto;
    public static final l01 disabled;
    public static final l01 enabled;

    static {
        l01 l01Var = new l01("auto", 0);
        auto = l01Var;
        l01 l01Var2 = new l01("enabled", 1);
        enabled = l01Var2;
        l01 l01Var3 = new l01("disabled", 2);
        disabled = l01Var3;
        $VALUES = new l01[]{l01Var, l01Var2, l01Var3};
    }

    public static l01 valueOf(String str) {
        return (l01) Enum.valueOf(l01.class, str);
    }

    public static l01[] values() {
        return (l01[]) $VALUES.clone();
    }
}
