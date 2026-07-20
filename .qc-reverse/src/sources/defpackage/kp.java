package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kp {
    public static final kp b;
    public static final kp c;
    public static final kp d;
    public static final kp e;
    public static final kp f;
    public static final /* synthetic */ kp[] g;

    static {
        kp kpVar = new kp("CPU_ACQUIRED", 0);
        b = kpVar;
        kp kpVar2 = new kp("BLOCKING", 1);
        c = kpVar2;
        kp kpVar3 = new kp("PARKING", 2);
        d = kpVar3;
        kp kpVar4 = new kp("DORMANT", 3);
        e = kpVar4;
        kp kpVar5 = new kp("TERMINATED", 4);
        f = kpVar5;
        g = new kp[]{kpVar, kpVar2, kpVar3, kpVar4, kpVar5};
    }

    public static kp valueOf(String str) {
        return (kp) Enum.valueOf(kp.class, str);
    }

    public static kp[] values() {
        return (kp[]) g.clone();
    }
}
