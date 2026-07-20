package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tv0 {
    private static final /* synthetic */ tv0[] $VALUES;
    public static final tv0 advancedTriggers;
    public static final tv0 disabled;
    public static final tv0 floating;
    public static final tv0 simpleTriggers;

    static {
        tv0 tv0Var = new tv0("disabled", 0);
        disabled = tv0Var;
        tv0 tv0Var2 = new tv0("simpleTriggers", 1);
        simpleTriggers = tv0Var2;
        tv0 tv0Var3 = new tv0("advancedTriggers", 2);
        advancedTriggers = tv0Var3;
        tv0 tv0Var4 = new tv0("floating", 3);
        floating = tv0Var4;
        $VALUES = new tv0[]{tv0Var, tv0Var2, tv0Var3, tv0Var4};
    }

    public static tv0 valueOf(String str) {
        return (tv0) Enum.valueOf(tv0.class, str);
    }

    public static tv0[] values() {
        return (tv0[]) $VALUES.clone();
    }
}
