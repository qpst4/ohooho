package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fq {
    public static final fq b;
    public static final fq c;
    public static final fq d;
    public static final /* synthetic */ fq[] e;

    static {
        fq fqVar = new fq("OFF", 0);
        b = fqVar;
        fq fqVar2 = new fq("ON_TOUCH", 1);
        c = fqVar2;
        fq fqVar3 = new fq("ON", 2);
        d = fqVar3;
        e = new fq[]{fqVar, fqVar2, fqVar3};
    }

    public static fq valueOf(String str) {
        return (fq) Enum.valueOf(fq.class, str);
    }

    public static fq[] values() {
        return (fq[]) e.clone();
    }
}
