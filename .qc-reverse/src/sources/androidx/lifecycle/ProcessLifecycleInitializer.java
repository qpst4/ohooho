package androidx.lifecycle;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import defpackage.bg0;
import defpackage.cg0;
import defpackage.cr0;
import defpackage.dr0;
import defpackage.fb0;
import defpackage.oy;
import defpackage.ra;
import defpackage.s1;
import defpackage.yf0;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements fb0 {
    @Override // defpackage.fb0
    public final List a() {
        return oy.b;
    }

    @Override // defpackage.fb0
    public final Object b(Context context) {
        context.getClass();
        ra raVarB = ra.B(context);
        raVarB.getClass();
        if (!((HashSet) raVarB.d).contains(ProcessLifecycleInitializer.class)) {
            s1.f("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
            return null;
        }
        if (!cg0.a.getAndSet(true)) {
            Context applicationContext = context.getApplicationContext();
            applicationContext.getClass();
            ((Application) applicationContext).registerActivityLifecycleCallbacks(new bg0());
        }
        dr0 dr0Var = dr0.j;
        dr0Var.getClass();
        dr0Var.f = new Handler();
        dr0Var.g.d(yf0.ON_CREATE);
        Context applicationContext2 = context.getApplicationContext();
        applicationContext2.getClass();
        ((Application) applicationContext2).registerActivityLifecycleCallbacks(new cr0(dr0Var));
        return dr0Var;
    }
}
