package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e91 {
    private static final /* synthetic */ e91[] $VALUES;
    public static final e91 bottom;
    public static final e91 left;
    public static final e91 right;
    public static final e91 top;

    static {
        e91 e91Var = new e91("top", 0);
        top = e91Var;
        e91 e91Var2 = new e91("bottom", 1);
        bottom = e91Var2;
        e91 e91Var3 = new e91("left", 2);
        left = e91Var3;
        e91 e91Var4 = new e91("right", 3);
        right = e91Var4;
        $VALUES = new e91[]{e91Var, e91Var2, e91Var3, e91Var4};
    }

    public static e91 valueOf(String str) {
        return (e91) Enum.valueOf(e91.class, str);
    }

    public static e91[] values() {
        return (e91[]) $VALUES.clone();
    }
}
