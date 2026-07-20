package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m60 {
    private static final /* synthetic */ m60[] $VALUES;
    public static final m60 BOTTOM;
    public static final m60 LEFT;
    public static final m60 RIGHT;
    public static final m60 TOP;

    static {
        m60 m60Var = new m60("LEFT", 0);
        LEFT = m60Var;
        m60 m60Var2 = new m60("TOP", 1);
        TOP = m60Var2;
        m60 m60Var3 = new m60("RIGHT", 2);
        RIGHT = m60Var3;
        m60 m60Var4 = new m60("BOTTOM", 3);
        BOTTOM = m60Var4;
        $VALUES = new m60[]{m60Var, m60Var2, m60Var3, m60Var4};
    }

    public static m60 valueOf(String str) {
        return (m60) Enum.valueOf(m60.class, str);
    }

    public static m60[] values() {
        return (m60[]) $VALUES.clone();
    }
}
