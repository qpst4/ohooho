package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ta0 {
    public static final ta0 b;
    public static final ta0 c;
    public static final ta0 d;
    public static final /* synthetic */ ta0[] e;

    static {
        ta0 ta0Var = new ta0("GALLERY", 0);
        b = ta0Var;
        ta0 ta0Var2 = new ta0("CAMERA", 1);
        c = ta0Var2;
        ta0 ta0Var3 = new ta0("BOTH", 2);
        d = ta0Var3;
        e = new ta0[]{ta0Var, ta0Var2, ta0Var3};
    }

    public static ta0 valueOf(String str) {
        return (ta0) Enum.valueOf(ta0.class, str);
    }

    public static ta0[] values() {
        return (ta0[]) e.clone();
    }
}
