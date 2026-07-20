package defpackage;

import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.LocaleList;
import android.util.DisplayMetrics;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class fi0 extends ContextWrapper {
    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Locale localeG = ix.g(this);
        Locale localeH = ix.h(this);
        if (localeH != null) {
            localeG = localeH;
        } else {
            ix.k(this, localeG);
        }
        Resources resources = super.getResources();
        resources.getClass();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 26) {
            configuration.setLocales(new LocaleList(localeG));
        } else {
            configuration.setLocale(localeG);
        }
        Resources resources2 = super.getResources();
        resources2.getClass();
        DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
        displayMetrics.getClass();
        return new Resources(getAssets(), displayMetrics, configuration);
    }
}
