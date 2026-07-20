package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class dq {
    public static final dq b;
    public static final dq c;
    public static final /* synthetic */ dq[] d;

    static {
        dq dqVar = new dq("RECTANGLE", 0);
        b = dqVar;
        dq dqVar2 = new dq("OVAL", 1);
        c = dqVar2;
        d = new dq[]{dqVar, dqVar2};
    }

    public static dq valueOf(String str) {
        return (dq) Enum.valueOf(dq.class, str);
    }

    public static dq[] values() {
        return (dq[]) d.clone();
    }
}
