package defpackage;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class tz implements z00 {
    public final /* synthetic */ int b;
    public final wr0 c;

    public /* synthetic */ tz(wr0 wr0Var, int i) {
        this.b = i;
        this.c = wr0Var;
    }

    @Override // defpackage.wr0
    public final Object get() {
        int i = this.b;
        wr0 wr0Var = this.c;
        switch (i) {
            case 0:
                String packageName = ((Context) wr0Var.get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                zy.r("Cannot return null from a non-@Nullable @Provides method");
                return null;
            default:
                return new vx0(Integer.valueOf(vx0.e).intValue(), (Context) wr0Var.get(), "com.google.android.datatransport.events");
        }
    }
}
