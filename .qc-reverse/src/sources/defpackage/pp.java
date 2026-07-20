package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class pp {
    public static final pp b;
    public static final /* synthetic */ pp[] c;

    static {
        pp ppVar = new pp("DEFAULT", 0);
        b = ppVar;
        c = new pp[]{ppVar, new pp("LAZY", 1), new pp("ATOMIC", 2), new pp("UNDISPATCHED", 3)};
    }

    public static pp valueOf(String str) {
        return (pp) Enum.valueOf(pp.class, str);
    }

    public static pp[] values() {
        return (pp[]) c.clone();
    }
}
