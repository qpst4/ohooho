package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class t91 {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[e91.values().length];
        a = iArr;
        try {
            iArr[e91.left.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            a[e91.right.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            a[e91.top.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            a[e91.bottom.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
