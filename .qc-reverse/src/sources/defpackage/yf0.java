package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yf0 {
    private static final /* synthetic */ yf0[] $VALUES;
    public static final wf0 Companion;
    public static final yf0 ON_ANY;
    public static final yf0 ON_CREATE;
    public static final yf0 ON_DESTROY;
    public static final yf0 ON_PAUSE;
    public static final yf0 ON_RESUME;
    public static final yf0 ON_START;
    public static final yf0 ON_STOP;

    static {
        yf0 yf0Var = new yf0("ON_CREATE", 0);
        ON_CREATE = yf0Var;
        yf0 yf0Var2 = new yf0("ON_START", 1);
        ON_START = yf0Var2;
        yf0 yf0Var3 = new yf0("ON_RESUME", 2);
        ON_RESUME = yf0Var3;
        yf0 yf0Var4 = new yf0("ON_PAUSE", 3);
        ON_PAUSE = yf0Var4;
        yf0 yf0Var5 = new yf0("ON_STOP", 4);
        ON_STOP = yf0Var5;
        yf0 yf0Var6 = new yf0("ON_DESTROY", 5);
        ON_DESTROY = yf0Var6;
        yf0 yf0Var7 = new yf0("ON_ANY", 6);
        ON_ANY = yf0Var7;
        $VALUES = new yf0[]{yf0Var, yf0Var2, yf0Var3, yf0Var4, yf0Var5, yf0Var6, yf0Var7};
        Companion = new wf0();
    }

    public static yf0 valueOf(String str) {
        return (yf0) Enum.valueOf(yf0.class, str);
    }

    public static yf0[] values() {
        return (yf0[]) $VALUES.clone();
    }

    public final zf0 a() {
        switch (xf0.a[ordinal()]) {
            case 1:
            case 2:
                return zf0.d;
            case 3:
            case 4:
                return zf0.e;
            case 5:
                return zf0.f;
            case 6:
                return zf0.b;
            default:
                throw new IllegalArgumentException(this + " has no target state");
        }
    }
}
