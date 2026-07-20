package defpackage;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ei0 {
    public boolean a;
    public Locale b;
    public final ArrayList c = new ArrayList();
    public final Activity d;

    public ei0(Activity activity) {
        this.d = activity;
    }

    public final void a(Activity activity) {
        Locale localeG = ix.g(activity);
        Locale localeH = ix.h(activity);
        if (localeH != null) {
            localeG = localeH;
        } else {
            ix.k(activity, localeG);
        }
        Locale locale = this.b;
        if (locale == null) {
            fc0.S("currentLanguage");
            throw null;
        }
        if (fc0.b(locale.toString(), localeG.toString())) {
            return;
        }
        this.a = true;
        b();
    }

    public final void b() {
        ArrayList arrayList = this.c;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((di0) obj).getClass();
        }
        Activity activity = this.d;
        activity.getIntent().putExtra("activity_locale_changed", true);
        activity.recreate();
    }

    public final void c(Context context, Locale locale) {
        context.getClass();
        Locale localeG = ix.g(context);
        Locale localeH = ix.h(context);
        if (localeH != null) {
            localeG = localeH;
        } else {
            ix.k(context, localeG);
        }
        if (fc0.b(locale.toString(), localeG.toString())) {
            return;
        }
        ix.k(this.d, locale);
        b();
    }
}
