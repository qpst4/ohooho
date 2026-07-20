package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ap {
    public static final ap b;
    public static final ap c;
    public static final /* synthetic */ ap[] d;

    static {
        ap apVar = new ap("BULLET", 0);
        b = apVar;
        ap apVar2 = new ap("ORDERED", 1);
        c = apVar2;
        d = new ap[]{apVar, apVar2};
    }

    public static ap valueOf(String str) {
        return (ap) Enum.valueOf(ap.class, str);
    }

    public static ap[] values() {
        return (ap[]) d.clone();
    }
}
