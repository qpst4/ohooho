package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fh {
    private static final /* synthetic */ fh[] $VALUES;
    public static final fh auto;
    public static final fh interpolator;
    public static final fh normal;

    static {
        fh fhVar = new fh("auto", 0);
        auto = fhVar;
        fh fhVar2 = new fh("normal", 1);
        normal = fhVar2;
        fh fhVar3 = new fh("interpolator", 2);
        interpolator = fhVar3;
        $VALUES = new fh[]{fhVar, fhVar2, fhVar3};
    }

    public static fh valueOf(String str) {
        return (fh) Enum.valueOf(fh.class, str);
    }

    public static fh[] values() {
        return (fh[]) $VALUES.clone();
    }
}
