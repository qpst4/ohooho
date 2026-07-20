package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ce {
    private static final /* synthetic */ ce[] $VALUES;
    public static final ce horizontal;
    public static final ce vertical;

    static {
        ce ceVar = new ce("horizontal", 0);
        horizontal = ceVar;
        ce ceVar2 = new ce("vertical", 1);
        vertical = ceVar2;
        $VALUES = new ce[]{ceVar, ceVar2};
    }

    public static ce valueOf(String str) {
        return (ce) Enum.valueOf(ce.class, str);
    }

    public static ce[] values() {
        return (ce[]) $VALUES.clone();
    }
}
