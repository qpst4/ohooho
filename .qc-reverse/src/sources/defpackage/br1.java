package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public enum br1 {
    c("BROADCAST_ACTION_UNSPECIFIED"),
    d("PURCHASES_UPDATED_ACTION"),
    e("LOCAL_PURCHASES_UPDATED_ACTION"),
    f("ALTERNATIVE_BILLING_ACTION");

    public final int b;

    br1(String str) {
        this.b = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.b);
    }
}
