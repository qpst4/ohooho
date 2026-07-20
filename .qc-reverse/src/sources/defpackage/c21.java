package defpackage;

import java.sql.Timestamp;
import java.util.Date;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c21 extends fb1 {
    public static final b21 b = new b21();
    public final fb1 a;

    public c21(fb1 fb1Var) {
        this.a = fb1Var;
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        Date date = (Date) this.a.b(vd0Var);
        if (date != null) {
            return new Timestamp(date.getTime());
        }
        return null;
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) {
        this.a.c(ae0Var, (Timestamp) obj);
    }
}
