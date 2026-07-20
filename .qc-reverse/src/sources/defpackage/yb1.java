package defpackage;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class yb1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        int iA;
        if (vd0Var.I() == 9) {
            vd0Var.E();
            return null;
        }
        vd0Var.g();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (vd0Var.I() == 4) {
                vd0Var.q();
                return new GregorianCalendar(i, i2, i3, i4, i5, i6);
            }
            String strC = vd0Var.C();
            iA = vd0Var.A();
            strC.getClass();
            switch (strC) {
                case "dayOfMonth":
                    i3 = iA;
                    break;
                case "minute":
                    i5 = iA;
                    break;
                case "second":
                    i6 = iA;
                    break;
                case "year":
                    i = iA;
                    break;
                case "month":
                    i2 = iA;
                    break;
                case "hourOfDay":
                    i4 = iA;
                    break;
            }
        }
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        if (((Calendar) obj) == null) {
            ae0Var.t();
            return;
        }
        ae0Var.h();
        ae0Var.r("year");
        ae0Var.z(r4.get(1));
        ae0Var.r("month");
        ae0Var.z(r4.get(2));
        ae0Var.r("dayOfMonth");
        ae0Var.z(r4.get(5));
        ae0Var.r("hourOfDay");
        ae0Var.z(r4.get(11));
        ae0Var.r("minute");
        ae0Var.z(r4.get(12));
        ae0Var.r("second");
        ae0Var.z(r4.get(13));
        ae0Var.q();
    }
}
