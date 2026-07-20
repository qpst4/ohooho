package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f60 {
    private static final /* synthetic */ f60[] $VALUES;
    public static final f60 LONG;
    public static final f60 MEDIUM;
    public static final f60 SHORT;

    static {
        f60 f60Var = new f60("SHORT", 0);
        SHORT = f60Var;
        f60 f60Var2 = new f60("MEDIUM", 1);
        MEDIUM = f60Var2;
        f60 f60Var3 = new f60("LONG", 2);
        LONG = f60Var3;
        $VALUES = new f60[]{f60Var, f60Var2, f60Var3};
    }

    public static f60 valueOf(String str) {
        return (f60) Enum.valueOf(f60.class, str);
    }

    public static f60[] values() {
        return (f60[]) $VALUES.clone();
    }
}
