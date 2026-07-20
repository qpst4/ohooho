package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class k91 {
    private static final /* synthetic */ k91[] $VALUES;
    public static final k91 actionIcon;
    public static final k91 off;
    public static final k91 pie;

    static {
        k91 k91Var = new k91("off", 0);
        off = k91Var;
        k91 k91Var2 = new k91("pie", 1);
        pie = k91Var2;
        k91 k91Var3 = new k91("actionIcon", 2);
        actionIcon = k91Var3;
        $VALUES = new k91[]{k91Var, k91Var2, k91Var3};
    }

    public static k91 valueOf(String str) {
        return (k91) Enum.valueOf(k91.class, str);
    }

    public static k91[] values() {
        return (k91[]) $VALUES.clone();
    }
}
