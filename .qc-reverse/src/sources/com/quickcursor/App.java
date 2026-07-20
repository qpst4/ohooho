package com.quickcursor;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import defpackage.ey0;
import defpackage.f01;
import defpackage.gb;
import defpackage.k8;
import defpackage.mb;
import defpackage.ow0;
import defpackage.pd1;
import defpackage.y8;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class App extends Application {
    public static Context c = null;
    public static boolean d = false;
    public final ow0 b = new ow0(20);

    public final void a(Context context) {
        context.getClass();
        Locale locale = new Locale(Locale.getDefault().getLanguage());
        this.b.getClass();
        String string = locale.toString();
        string.getClass();
        context.getSharedPreferences("pref_language", 0).edit().putString("key_default_language", string).apply();
        super.attachBaseContext(f01.d(context));
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        a(context);
        c = context;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        Context applicationContext = super.getApplicationContext();
        applicationContext.getClass();
        this.b.getClass();
        return f01.d(applicationContext);
    }

    @Override // android.app.Application, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        configuration.getClass();
        super.onConfigurationChanged(configuration);
        this.b.getClass();
        f01.d(this);
    }

    @Override // android.app.Application
    public final void onCreate() {
        boolean zHasSystemFeature;
        super.onCreate();
        c = this;
        try {
            zHasSystemFeature = getPackageManager().hasSystemFeature("com.microsoft.device.display.displaymask");
        } catch (Exception unused) {
            zHasSystemFeature = false;
        }
        d = zHasSystemFeature;
        if (k8.c != 2) {
            k8.c = 2;
            synchronized (k8.i) {
                try {
                    mb mbVar = k8.h;
                    mbVar.getClass();
                    gb gbVar = new gb(mbVar);
                    while (gbVar.hasNext()) {
                        k8 k8Var = (k8) ((WeakReference) gbVar.next()).get();
                        if (k8Var != null) {
                            ((y8) k8Var).m(true, true);
                        }
                    }
                } finally {
                }
            }
        }
        ey0.e(this);
        pd1.b();
        f01.j();
    }
}
