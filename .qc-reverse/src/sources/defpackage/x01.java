package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class x01 {
    private static final /* synthetic */ x01[] $VALUES;
    public static final x01 both;
    public static final x01 left;
    public static final x01 right;

    static {
        x01 x01Var = new x01("left", 0);
        left = x01Var;
        x01 x01Var2 = new x01("right", 1);
        right = x01Var2;
        x01 x01Var3 = new x01("both", 2);
        both = x01Var3;
        $VALUES = new x01[]{x01Var, x01Var2, x01Var3};
    }

    public static x01 valueOf(String str) {
        return (x01) Enum.valueOf(x01.class, str);
    }

    public static x01[] values() {
        return (x01[]) $VALUES.clone();
    }
}
