package defpackage;

import java.util.Calendar;
import java.util.GregorianCalendar;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class gn0 implements gb1 {
    public final /* synthetic */ int b;
    public final /* synthetic */ fb1 c;

    public /* synthetic */ gn0(fb1 fb1Var, int i) {
        this.b = i;
        this.c = fb1Var;
    }

    @Override // defpackage.gb1
    public final fb1 a(i70 i70Var, mc1 mc1Var) {
        int i = this.b;
        fb1 fb1Var = this.c;
        switch (i) {
            case 0:
                if (mc1Var.a() == Number.class) {
                    return (hn0) fb1Var;
                }
                return null;
            default:
                Class clsA = mc1Var.a();
                if (clsA == Calendar.class || clsA == GregorianCalendar.class) {
                    return (yb1) fb1Var;
                }
                return null;
        }
    }

    public String toString() {
        switch (this.b) {
            case 1:
                return "Factory[type=" + Calendar.class.getName() + "+" + GregorianCalendar.class.getName() + ",adapter=" + ((yb1) this.c) + "]";
            default:
                return super.toString();
        }
    }
}
