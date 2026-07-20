package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mq {
    public static final mq b;
    public static final mq c;
    public static final mq d;
    public static final /* synthetic */ mq[] e;

    static {
        mq mqVar = new mq("FIT_CENTER", 0);
        b = mqVar;
        mq mqVar2 = new mq("CENTER", 1);
        mq mqVar3 = new mq("CENTER_CROP", 2);
        c = mqVar3;
        mq mqVar4 = new mq("CENTER_INSIDE", 3);
        d = mqVar4;
        e = new mq[]{mqVar, mqVar2, mqVar3, mqVar4};
    }

    public static mq valueOf(String str) {
        return (mq) Enum.valueOf(mq.class, str);
    }

    public static mq[] values() {
        return (mq[]) e.clone();
    }
}
