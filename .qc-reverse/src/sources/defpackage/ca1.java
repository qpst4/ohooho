package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ca1 {
    private static final /* synthetic */ ca1[] $VALUES;
    public static final ca1 custom;
    public static final ca1 off;
    public static final ca1 rectangle;

    static {
        ca1 ca1Var = new ca1("off", 0);
        off = ca1Var;
        ca1 ca1Var2 = new ca1("rectangle", 1);
        rectangle = ca1Var2;
        ca1 ca1Var3 = new ca1("custom", 2);
        custom = ca1Var3;
        $VALUES = new ca1[]{ca1Var, ca1Var2, ca1Var3};
    }

    public static ca1 valueOf(String str) {
        return (ca1) Enum.valueOf(ca1.class, str);
    }

    public static ca1[] values() {
        return (ca1[]) $VALUES.clone();
    }
}
