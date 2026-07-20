package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uo {
    private static final /* synthetic */ uo[] $VALUES;
    public static final uo clipboard;
    public static final uo share;

    static {
        uo uoVar = new uo("clipboard", 0);
        clipboard = uoVar;
        uo uoVar2 = new uo("share", 1);
        share = uoVar2;
        $VALUES = new uo[]{uoVar, uoVar2};
    }

    public static uo valueOf(String str) {
        return (uo) Enum.valueOf(uo.class, str);
    }

    public static uo[] values() {
        return (uo[]) $VALUES.clone();
    }
}
