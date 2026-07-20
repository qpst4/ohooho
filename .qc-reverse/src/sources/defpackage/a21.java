package defpackage;

import java.io.IOException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class a21 extends fb1 {
    public static final a b = new a();
    public final SimpleDateFormat a;

    /* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
    public class a implements gb1 {
        @Override // defpackage.gb1
        public final fb1 a(i70 i70Var, mc1 mc1Var) {
            if (mc1Var.a() == Time.class) {
                return new a21(0);
            }
            return null;
        }
    }

    private a21() {
        this.a = new SimpleDateFormat("hh:mm:ss a");
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        Time time;
        if (vd0Var.I() == 9) {
            vd0Var.E();
            return null;
        }
        String strG = vd0Var.G();
        synchronized (this) {
            TimeZone timeZone = this.a.getTimeZone();
            try {
                try {
                    time = new Time(this.a.parse(strG).getTime());
                } catch (ParseException e) {
                    throw new wd0("Failed parsing '" + strG + "' as SQL Time; at path " + vd0Var.u(), e);
                }
            } finally {
                this.a.setTimeZone(timeZone);
            }
        }
        return time;
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        String str;
        Time time = (Time) obj;
        if (time == null) {
            ae0Var.t();
            return;
        }
        synchronized (this) {
            str = this.a.format((Date) time);
        }
        ae0Var.B(str);
    }

    public /* synthetic */ a21(int i) {
        this();
    }
}
