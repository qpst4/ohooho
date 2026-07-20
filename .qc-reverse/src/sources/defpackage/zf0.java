package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zf0 {
    public static final zf0 b;
    public static final zf0 c;
    public static final zf0 d;
    public static final zf0 e;
    public static final zf0 f;
    public static final /* synthetic */ zf0[] g;

    static {
        zf0 zf0Var = new zf0("DESTROYED", 0);
        b = zf0Var;
        zf0 zf0Var2 = new zf0("INITIALIZED", 1);
        c = zf0Var2;
        zf0 zf0Var3 = new zf0("CREATED", 2);
        d = zf0Var3;
        zf0 zf0Var4 = new zf0("STARTED", 3);
        e = zf0Var4;
        zf0 zf0Var5 = new zf0("RESUMED", 4);
        f = zf0Var5;
        g = new zf0[]{zf0Var, zf0Var2, zf0Var3, zf0Var4, zf0Var5};
    }

    public static zf0 valueOf(String str) {
        return (zf0) Enum.valueOf(zf0.class, str);
    }

    public static zf0[] values() {
        return (zf0[]) g.clone();
    }
}
