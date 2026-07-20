package defpackage;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ho1 extends un1 {
    public zn1 i;
    public ScheduledFuture j;

    @Override // defpackage.on1
    public final String b() {
        zn1 zn1Var = this.i;
        ScheduledFuture scheduledFuture = this.j;
        if (zn1Var == null) {
            return null;
        }
        String strJ = l11.j("inputFuture=[", zn1Var.toString(), "]");
        if (scheduledFuture != null) {
            long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
            if (delay > 0) {
                return strJ + ", remaining delay=[" + delay + " ms]";
            }
        }
        return strJ;
    }

    @Override // defpackage.on1
    public final void c() {
        zn1 zn1Var = this.i;
        if ((zn1Var != null) & (this.b instanceof dn1)) {
            Object obj = this.b;
            zn1Var.cancel((obj instanceof dn1) && ((dn1) obj).a);
        }
        ScheduledFuture scheduledFuture = this.j;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.i = null;
        this.j = null;
    }
}
