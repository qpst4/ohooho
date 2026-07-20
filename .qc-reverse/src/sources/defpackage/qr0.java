package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qr0 {
    public static final qr0 b;
    public static final /* synthetic */ qr0[] c;

    static {
        qr0 qr0Var = new qr0("DEFAULT", 0);
        b = qr0Var;
        c = new qr0[]{qr0Var, new qr0("SIGNED", 1), new qr0("FIXED", 2)};
    }

    public static qr0 valueOf(String str) {
        return (qr0) Enum.valueOf(qr0.class, str);
    }

    public static qr0[] values() {
        return (qr0[]) c.clone();
    }
}
