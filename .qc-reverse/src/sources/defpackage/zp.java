package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class zp {
    public static final zp b;
    public static final zp c;
    public static final /* synthetic */ zp[] d;

    static {
        zp zpVar = new zp("CAMERA", 0);
        b = zpVar;
        zp zpVar2 = new zp("GALLERY", 1);
        c = zpVar2;
        d = new zp[]{zpVar, zpVar2};
    }

    public static zp valueOf(String str) {
        return (zp) Enum.valueOf(zp.class, str);
    }

    public static zp[] values() {
        return (zp[]) d.clone();
    }
}
