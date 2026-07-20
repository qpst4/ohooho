package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class np {
    public static final np b;
    public static final /* synthetic */ np[] c;

    static {
        np npVar = new np("COROUTINE_SUSPENDED", 0);
        b = npVar;
        c = new np[]{npVar, new np("UNDECIDED", 1), new np("RESUMED", 2)};
    }

    public static np valueOf(String str) {
        return (np) Enum.valueOf(np.class, str);
    }

    public static np[] values() {
        return (np[]) c.clone();
    }
}
