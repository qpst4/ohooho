package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tx0 {
    public static final tx0 b;
    public static final tx0 c;
    public static final tx0 d;
    public static final /* synthetic */ tx0[] e;

    static {
        tx0 tx0Var = new tx0("NETWORK_UNMETERED", 0);
        b = tx0Var;
        tx0 tx0Var2 = new tx0("DEVICE_IDLE", 1);
        c = tx0Var2;
        tx0 tx0Var3 = new tx0("DEVICE_CHARGING", 2);
        d = tx0Var3;
        e = new tx0[]{tx0Var, tx0Var2, tx0Var3};
    }

    public static tx0 valueOf(String str) {
        return (tx0) Enum.valueOf(tx0.class, str);
    }

    public static tx0[] values() {
        return (tx0[]) e.clone();
    }
}
