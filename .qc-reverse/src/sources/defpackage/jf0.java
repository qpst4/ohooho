package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class jf0 {
    private static final /* synthetic */ jf0[] $VALUES;
    public static final jf0 MODE1;
    public static final jf0 MODE2;
    public static final jf0 MODE3;
    public static final jf0 MODE4;

    static {
        jf0 jf0Var = new jf0("MODE1", 0);
        MODE1 = jf0Var;
        jf0 jf0Var2 = new jf0("MODE2", 1);
        MODE2 = jf0Var2;
        jf0 jf0Var3 = new jf0("MODE3", 2);
        MODE3 = jf0Var3;
        jf0 jf0Var4 = new jf0("MODE4", 3);
        MODE4 = jf0Var4;
        $VALUES = new jf0[]{jf0Var, jf0Var2, jf0Var3, jf0Var4};
    }

    public static jf0 valueOf(String str) {
        return (jf0) Enum.valueOf(jf0.class, str);
    }

    public static jf0[] values() {
        return (jf0[]) $VALUES.clone();
    }
}
