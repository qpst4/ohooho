package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lq {
    public static final lq b;
    public static final lq c;
    public static final lq d;
    public static final lq e;
    public static final lq f;
    public static final /* synthetic */ lq[] g;

    static {
        lq lqVar = new lq("NONE", 0);
        b = lqVar;
        lq lqVar2 = new lq("SAMPLING", 1);
        c = lqVar2;
        lq lqVar3 = new lq("RESIZE_INSIDE", 2);
        d = lqVar3;
        lq lqVar4 = new lq("RESIZE_FIT", 3);
        e = lqVar4;
        lq lqVar5 = new lq("RESIZE_EXACT", 4);
        f = lqVar5;
        g = new lq[]{lqVar, lqVar2, lqVar3, lqVar4, lqVar5};
    }

    public static lq valueOf(String str) {
        return (lq) Enum.valueOf(lq.class, str);
    }

    public static lq[] values() {
        return (lq[]) g.clone();
    }
}
