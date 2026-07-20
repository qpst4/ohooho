package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class by0 {
    private static final /* synthetic */ by0[] $VALUES;
    public static final by0 force;
    public static final by0 settings;

    static {
        by0 by0Var = new by0("settings", 0);
        settings = by0Var;
        by0 by0Var2 = new by0("force", 1);
        force = by0Var2;
        $VALUES = new by0[]{by0Var, by0Var2};
    }

    public static by0 valueOf(String str) {
        return (by0) Enum.valueOf(by0.class, str);
    }

    public static by0[] values() {
        return (by0[]) $VALUES.clone();
    }
}
