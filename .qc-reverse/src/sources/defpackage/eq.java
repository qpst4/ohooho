package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class eq {
    public static final eq b;
    public static final /* synthetic */ eq[] c;

    static {
        eq eqVar = new eq("RECTANGLE", 0);
        b = eqVar;
        c = new eq[]{eqVar, new eq("OVAL", 1), new eq("RECTANGLE_VERTICAL_ONLY", 2), new eq("RECTANGLE_HORIZONTAL_ONLY", 3)};
    }

    public static eq valueOf(String str) {
        return (eq) Enum.valueOf(eq.class, str);
    }

    public static eq[] values() {
        return (eq[]) c.clone();
    }
}
