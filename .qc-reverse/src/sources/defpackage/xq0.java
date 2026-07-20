package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xq0 {
    private static final /* synthetic */ xq0[] $VALUES;
    public static final xq0 proState;
    public static final xq0 subscriptionActivationTime;

    static {
        xq0 xq0Var = new xq0("proState", 0);
        proState = xq0Var;
        xq0 xq0Var2 = new xq0("subscriptionActivationTime", 1);
        subscriptionActivationTime = xq0Var2;
        $VALUES = new xq0[]{xq0Var, xq0Var2};
    }

    public static xq0 valueOf(String str) {
        return (xq0) Enum.valueOf(xq0.class, str);
    }

    public static xq0[] values() {
        return (xq0[]) $VALUES.clone();
    }
}
