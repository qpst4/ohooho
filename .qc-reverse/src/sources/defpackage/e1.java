package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 {
    private static final /* synthetic */ e1[] $VALUES;
    public static final e1 continuous;
    public static final e1 continuousAfterPositioned;
    public static final e1 instant;
    public static final e1 onReleaseAndPositioned;

    static {
        e1 e1Var = new e1("instant", 0);
        instant = e1Var;
        e1 e1Var2 = new e1("continuous", 1);
        continuous = e1Var2;
        e1 e1Var3 = new e1("onReleaseAndPositioned", 2);
        onReleaseAndPositioned = e1Var3;
        e1 e1Var4 = new e1("continuousAfterPositioned", 3);
        continuousAfterPositioned = e1Var4;
        $VALUES = new e1[]{e1Var, e1Var2, e1Var3, e1Var4};
    }

    public static e1 valueOf(String str) {
        return (e1) Enum.valueOf(e1.class, str);
    }

    public static e1[] values() {
        return (e1[]) $VALUES.clone();
    }
}
