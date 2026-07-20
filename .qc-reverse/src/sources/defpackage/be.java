package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class be {
    private static final /* synthetic */ be[] $VALUES;
    public static final be absolute;
    public static final be relative;
    public static final be triggerSwipe;

    static {
        be beVar = new be("absolute", 0);
        absolute = beVar;
        be beVar2 = new be("relative", 1);
        relative = beVar2;
        be beVar3 = new be("triggerSwipe", 2);
        triggerSwipe = beVar3;
        $VALUES = new be[]{beVar, beVar2, beVar3};
    }

    public static be valueOf(String str) {
        return (be) Enum.valueOf(be.class, str);
    }

    public static be[] values() {
        return (be[]) $VALUES.clone();
    }
}
