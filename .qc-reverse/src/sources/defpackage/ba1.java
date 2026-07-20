package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ba1 {
    private static final /* synthetic */ ba1[] $VALUES;
    public static final ba1 all;
    public static final ba1 outside;

    static {
        ba1 ba1Var = new ba1("outside", 0);
        outside = ba1Var;
        ba1 ba1Var2 = new ba1("all", 1);
        all = ba1Var2;
        $VALUES = new ba1[]{ba1Var, ba1Var2};
    }

    public static ba1 valueOf(String str) {
        return (ba1) Enum.valueOf(ba1.class, str);
    }

    public static ba1[] values() {
        return (ba1[]) $VALUES.clone();
    }
}
