package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yq0 {
    private static final /* synthetic */ yq0[] $VALUES;
    public static final yq0 lifetime;
    public static final yq0 no;
    public static final yq0 pending;
    public static final yq0 subscription;

    static {
        yq0 yq0Var = new yq0("no", 0);
        no = yq0Var;
        yq0 yq0Var2 = new yq0("pending", 1);
        pending = yq0Var2;
        yq0 yq0Var3 = new yq0("lifetime", 2);
        lifetime = yq0Var3;
        yq0 yq0Var4 = new yq0("subscription", 3);
        subscription = yq0Var4;
        $VALUES = new yq0[]{yq0Var, yq0Var2, yq0Var3, yq0Var4};
    }

    public static yq0 valueOf(String str) {
        return (yq0) Enum.valueOf(yq0.class, str);
    }

    public static yq0[] values() {
        return (yq0[]) $VALUES.clone();
    }
}
