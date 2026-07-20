package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wq {
    public static final wq b;
    public static final wq c;
    public static final wq d;
    public static final wq e;
    public static final wq f;
    public static final wq g;
    public static final wq h;
    public static final wq i;
    public static final wq j;
    public static final /* synthetic */ wq[] k;

    static {
        wq wqVar = new wq("TOP_LEFT", 0);
        b = wqVar;
        wq wqVar2 = new wq("TOP_RIGHT", 1);
        c = wqVar2;
        wq wqVar3 = new wq("BOTTOM_LEFT", 2);
        d = wqVar3;
        wq wqVar4 = new wq("BOTTOM_RIGHT", 3);
        e = wqVar4;
        wq wqVar5 = new wq("LEFT", 4);
        f = wqVar5;
        wq wqVar6 = new wq("TOP", 5);
        g = wqVar6;
        wq wqVar7 = new wq("RIGHT", 6);
        h = wqVar7;
        wq wqVar8 = new wq("BOTTOM", 7);
        i = wqVar8;
        wq wqVar9 = new wq("CENTER", 8);
        j = wqVar9;
        k = new wq[]{wqVar, wqVar2, wqVar3, wqVar4, wqVar5, wqVar6, wqVar7, wqVar8, wqVar9};
    }

    public static wq valueOf(String str) {
        return (wq) Enum.valueOf(wq.class, str);
    }

    public static wq[] values() {
        return (wq[]) k.clone();
    }
}
