package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class i3 {
    private static final /* synthetic */ i3[] $VALUES;
    public static final i3 delayed;
    public static final i3 empty;
    public static final i3 instant;
    public static final i3 instantOrDelayed;
    public static final i3 onRelease;

    static {
        i3 i3Var = new i3("empty", 0);
        empty = i3Var;
        i3 i3Var2 = new i3("instantOrDelayed", 1);
        instantOrDelayed = i3Var2;
        i3 i3Var3 = new i3("instant", 2);
        instant = i3Var3;
        i3 i3Var4 = new i3("onRelease", 3);
        onRelease = i3Var4;
        i3 i3Var5 = new i3("delayed", 4);
        delayed = i3Var5;
        $VALUES = new i3[]{i3Var, i3Var2, i3Var3, i3Var4, i3Var5};
    }

    public static i3 valueOf(String str) {
        return (i3) Enum.valueOf(i3.class, str);
    }

    public static i3[] values() {
        return (i3[]) $VALUES.clone();
    }
}
