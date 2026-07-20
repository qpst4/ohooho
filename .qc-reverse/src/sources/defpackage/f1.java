package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 {
    private static final /* synthetic */ f1[] $VALUES;
    public static final f1 ended;
    public static final f1 initial;
    public static final f1 positioned;
    public static final f1 scheduled;
    public static final f1 triggered;

    static {
        f1 f1Var = new f1("initial", 0);
        initial = f1Var;
        f1 f1Var2 = new f1("scheduled", 1);
        scheduled = f1Var2;
        f1 f1Var3 = new f1("positioned", 2);
        positioned = f1Var3;
        f1 f1Var4 = new f1("triggered", 3);
        triggered = f1Var4;
        f1 f1Var5 = new f1("ended", 4);
        ended = f1Var5;
        $VALUES = new f1[]{f1Var, f1Var2, f1Var3, f1Var4, f1Var5};
    }

    public static f1 valueOf(String str) {
        return (f1) Enum.valueOf(f1.class, str);
    }

    public static f1[] values() {
        return (f1[]) $VALUES.clone();
    }
}
