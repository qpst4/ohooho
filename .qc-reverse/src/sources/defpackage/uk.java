package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class uk {
    public static final uk b;
    public static final /* synthetic */ uk[] c;

    /* JADX INFO: Fake field, exist only in values array */
    uk EF0;

    static {
        uk ukVar = new uk("UNKNOWN", 0);
        uk ukVar2 = new uk("ANDROID_FIREBASE", 1);
        b = ukVar2;
        c = new uk[]{ukVar, ukVar2};
    }

    public static uk valueOf(String str) {
        return (uk) Enum.valueOf(uk.class, str);
    }

    public static uk[] values() {
        return (uk[]) c.clone();
    }
}
