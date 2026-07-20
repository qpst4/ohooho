package defpackage;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class yl0 implements Comparable, Parcelable {
    public static final Parcelable.Creator<yl0> CREATOR = new c4(27);
    public final Calendar b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final long g;
    public String h;

    public yl0(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarA = wd1.a(calendar);
        this.b = calendarA;
        this.c = calendarA.get(2);
        this.d = calendarA.get(1);
        this.e = calendarA.getMaximum(7);
        this.f = calendarA.getActualMaximum(5);
        this.g = calendarA.getTimeInMillis();
    }

    public static yl0 a(int i, int i2) {
        Calendar calendarC = wd1.c(null);
        calendarC.set(1, i);
        calendarC.set(2, i2);
        return new yl0(calendarC);
    }

    public static yl0 b(long j) {
        Calendar calendarC = wd1.c(null);
        calendarC.setTimeInMillis(j);
        return new yl0(calendarC);
    }

    public final String c() {
        if (this.h == null) {
            long timeInMillis = this.b.getTimeInMillis();
            Locale locale = Locale.getDefault();
            AtomicReference atomicReference = wd1.a;
            DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
            instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
            instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
            this.h = instanceForSkeleton.format(new Date(timeInMillis));
        }
        return this.h;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.b.compareTo(((yl0) obj).b);
    }

    public final int d(yl0 yl0Var) {
        if (this.b instanceof GregorianCalendar) {
            return (yl0Var.c - this.c) + ((yl0Var.d - this.d) * 12);
        }
        zy.n("Only Gregorian calendars are supported.");
        return 0;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yl0)) {
            return false;
        }
        yl0 yl0Var = (yl0) obj;
        return this.c == yl0Var.c && this.d == yl0Var.d;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.d)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.d);
        parcel.writeInt(this.c);
    }
}
