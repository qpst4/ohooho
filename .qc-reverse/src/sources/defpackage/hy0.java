package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hy0 {
    private static final /* synthetic */ hy0[] $VALUES;
    public static final hy0 crop;
    public static final hy0 extraOptions;
    public static final hy0 nothing;
    public static final hy0 share;

    static {
        hy0 hy0Var = new hy0("nothing", 0);
        nothing = hy0Var;
        hy0 hy0Var2 = new hy0("extraOptions", 1);
        extraOptions = hy0Var2;
        hy0 hy0Var3 = new hy0("crop", 2);
        crop = hy0Var3;
        hy0 hy0Var4 = new hy0("share", 3);
        share = hy0Var4;
        $VALUES = new hy0[]{hy0Var, hy0Var2, hy0Var3, hy0Var4};
    }

    public static hy0 valueOf(String str) {
        return (hy0) Enum.valueOf(hy0.class, str);
    }

    public static hy0[] values() {
        return (hy0[]) $VALUES.clone();
    }
}
