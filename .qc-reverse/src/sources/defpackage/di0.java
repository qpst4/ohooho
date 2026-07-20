package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class di0 extends z7 {
    public final u31 A = new u31(new ci0(this, 0));

    public final ei0 E() {
        return (ei0) this.A.a();
    }

    @Override // defpackage.z7, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        context.getClass();
        E().getClass();
        Locale localeG = ix.g(context);
        Locale localeH = ix.h(context);
        if (localeH != null) {
            localeG = localeH;
        } else {
            ix.k(context, localeG);
        }
        Resources resources = context.getResources();
        resources.getClass();
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT >= 26) {
            configuration.setLocale(localeG);
            LocaleList localeList = new LocaleList(localeG);
            LocaleList.setDefault(localeList);
            configuration.setLocales(localeList);
        } else {
            configuration.setLocale(localeG);
        }
        configuration.getClass();
        applyOverrideConfiguration(configuration);
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        ei0 ei0VarE = E();
        Context applicationContext = super.getApplicationContext();
        applicationContext.getClass();
        ei0VarE.getClass();
        return f01.d(applicationContext);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        ei0 ei0VarE = E();
        Context baseContext = super.getBaseContext();
        baseContext.getClass();
        ei0VarE.getClass();
        return f01.d(baseContext);
    }

    @Override // defpackage.z7, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        ei0 ei0VarE = E();
        Resources resources = super.getResources();
        resources.getClass();
        ei0VarE.getClass();
        Locale localeH = ix.h(ei0VarE.d);
        Configuration configuration = resources.getConfiguration();
        if (Build.VERSION.SDK_INT < 26) {
            configuration.locale = localeH;
            configuration.setLayoutDirection(localeH);
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            return resources;
        }
        configuration.setLocale(localeH);
        LocaleList localeList = new LocaleList(localeH);
        LocaleList.setDefault(localeList);
        configuration.setLocales(localeList);
        return resources;
    }

    @Override // defpackage.z7, defpackage.pm, defpackage.om, android.app.Activity
    public void onCreate(Bundle bundle) {
        ei0 ei0VarE = E();
        ei0VarE.getClass();
        ei0VarE.c.add(this);
        ei0 ei0VarE2 = E();
        Activity activity = ei0VarE2.d;
        Locale localeH = ix.h(activity);
        if (localeH != null) {
            ei0VarE2.b = localeH;
        } else {
            ei0VarE2.a(activity);
        }
        if (activity.getIntent().getBooleanExtra("activity_locale_changed", false)) {
            ei0VarE2.a = true;
            activity.getIntent().removeExtra("activity_locale_changed");
        }
        super.onCreate(bundle);
    }

    @Override // defpackage.z7, android.app.Activity
    public void onResume() {
        super.onResume();
        ei0 ei0VarE = E();
        ei0VarE.getClass();
        new Handler().post(new vn1(ei0VarE, 9, this));
    }
}
