package defpackage;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class bs extends fb1 {
    public static final as c = new as();
    public final ow0 a;
    public final ArrayList b;

    public bs() {
        ow0 ow0Var = ow0.e;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        this.a = ow0Var;
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(2, 2, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(2, 2));
        }
        if (vc0.a >= 9) {
            arrayList.add(new SimpleDateFormat("MMM d, yyyy h:mm:ss a", locale));
        }
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) {
        Date dateB;
        if (vd0Var.I() == 9) {
            vd0Var.E();
            return null;
        }
        String strG = vd0Var.G();
        synchronized (this.b) {
            try {
                ArrayList arrayList = this.b;
                int size = arrayList.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        try {
                            dateB = oa0.b(strG, new ParsePosition(0));
                            break;
                        } catch (ParseException e) {
                            StringBuilder sbM = l11.m("Failed parsing '", strG, "' as Date; at path ");
                            sbM.append(vd0Var.u());
                            throw new wd0(sbM.toString(), e);
                        }
                    }
                    Object obj = arrayList.get(i);
                    i++;
                    DateFormat dateFormat = (DateFormat) obj;
                    TimeZone timeZone = dateFormat.getTimeZone();
                    try {
                        try {
                            dateB = dateFormat.parse(strG);
                            break;
                        } finally {
                            dateFormat.setTimeZone(timeZone);
                        }
                    } catch (ParseException unused) {
                        dateFormat.setTimeZone(timeZone);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.a.getClass();
        return dateB;
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        String str;
        Date date = (Date) obj;
        if (date == null) {
            ae0Var.t();
            return;
        }
        DateFormat dateFormat = (DateFormat) this.b.get(0);
        synchronized (this.b) {
            str = dateFormat.format(date);
        }
        ae0Var.B(str);
    }

    public final String toString() {
        DateFormat dateFormat = (DateFormat) this.b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }
}
