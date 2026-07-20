package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class l91 {
    private static final /* synthetic */ l91[] $VALUES;
    public static final l91 off;
    public static final l91 pieMulti;
    public static final l91 pieSingle;

    static {
        l91 l91Var = new l91("off", 0);
        off = l91Var;
        l91 l91Var2 = new l91("pieSingle", 1);
        pieSingle = l91Var2;
        l91 l91Var3 = new l91("pieMulti", 2);
        pieMulti = l91Var3;
        $VALUES = new l91[]{l91Var, l91Var2, l91Var3};
    }

    public static l91 valueOf(String str) {
        return (l91) Enum.valueOf(l91.class, str);
    }

    public static l91[] values() {
        return (l91[]) $VALUES.clone();
    }
}
