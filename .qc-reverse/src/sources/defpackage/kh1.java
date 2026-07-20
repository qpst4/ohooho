package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kh1 {
    private static final /* synthetic */ kh1[] $VALUES;
    public static final kh1 alarm;
    public static final kh1 auto;
    public static final kh1 inCall;
    public static final kh1 media;
    public static final kh1 ring;

    static {
        kh1 kh1Var = new kh1("auto", 0);
        auto = kh1Var;
        kh1 kh1Var2 = new kh1("ring", 1);
        ring = kh1Var2;
        kh1 kh1Var3 = new kh1("media", 2);
        media = kh1Var3;
        kh1 kh1Var4 = new kh1("alarm", 3);
        alarm = kh1Var4;
        kh1 kh1Var5 = new kh1("inCall", 4);
        inCall = kh1Var5;
        $VALUES = new kh1[]{kh1Var, kh1Var2, kh1Var3, kh1Var4, kh1Var5};
    }

    public static kh1 valueOf(String str) {
        return (kh1) Enum.valueOf(kh1.class, str);
    }

    public static kh1[] values() {
        return (kh1[]) $VALUES.clone();
    }
}
