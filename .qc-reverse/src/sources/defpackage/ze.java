package defpackage;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ze {
    public final Object a;
    public volatile Object b;
    public volatile Object c;

    public /* synthetic */ ze(Object obj) {
        this.a = obj;
    }

    public boolean a() {
        z7 z7Var = (z7) this.a;
        try {
            return z7Var.getPackageManager().getApplicationInfo(z7Var.getPackageName(), 128).metaData.getBoolean("com.google.android.play.billingclient.enableBillingOverridesTesting", false);
        } catch (Exception e) {
            pn1.h("BillingClient", "Unable to retrieve metadata value for enableBillingOverridesTesting.", e);
            return false;
        }
    }
}
