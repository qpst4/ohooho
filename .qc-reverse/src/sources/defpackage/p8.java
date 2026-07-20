package defpackage;

import android.content.res.Configuration;
import android.os.LocaleList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p8 {
    public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
        LocaleList locales = configuration.getLocales();
        LocaleList locales2 = configuration2.getLocales();
        if (locales.equals(locales2)) {
            return;
        }
        configuration3.setLocales(locales2);
        configuration3.locale = configuration2.locale;
    }

    public static ai0 b(Configuration configuration) {
        return ai0.a(configuration.getLocales().toLanguageTags());
    }

    public static void c(ai0 ai0Var) {
        LocaleList.setDefault(LocaleList.forLanguageTags(ai0Var.a.a.toLanguageTags()));
    }

    public static void d(Configuration configuration, ai0 ai0Var) {
        configuration.setLocales(LocaleList.forLanguageTags(ai0Var.a.a.toLanguageTags()));
    }
}
