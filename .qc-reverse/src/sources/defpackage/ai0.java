package defpackage;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ai0 {
    public static final ai0 b = new ai0(new bi0(new LocaleList(new Locale[0])));
    public final bi0 a;

    public ai0(bi0 bi0Var) {
        this.a = bi0Var;
    }

    public static ai0 a(String str) {
        if (str == null || str.isEmpty()) {
            return b;
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i = 0; i < length; i++) {
            String str2 = strArrSplit[i];
            int i2 = zh0.a;
            localeArr[i] = Locale.forLanguageTag(str2);
        }
        return new ai0(new bi0(new LocaleList(localeArr)));
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ai0) {
            return this.a.equals(((ai0) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.a.hashCode();
    }

    public final String toString() {
        return this.a.a.toString();
    }
}
