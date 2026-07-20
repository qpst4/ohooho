package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k8 {
    public static final i8 b = new i8(new j8());
    public static int c = -100;
    public static ai0 d = null;
    public static ai0 e = null;
    public static Boolean f = null;
    public static boolean g = false;
    public static final mb h = new mb(0);
    public static final Object i = new Object();
    public static final Object j = new Object();

    public static boolean c(Context context) {
        if (f == null) {
            try {
                int i2 = ta.b;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) ta.class), sa.a() | 128).metaData;
                if (bundle != null) {
                    f = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                f = Boolean.FALSE;
            }
        }
        return f.booleanValue();
    }

    public static void g(y8 y8Var) {
        synchronized (i) {
            try {
                mb mbVar = h;
                mbVar.getClass();
                gb gbVar = new gb(mbVar);
                while (gbVar.hasNext()) {
                    k8 k8Var = (k8) ((WeakReference) gbVar.next()).get();
                    if (k8Var == y8Var || k8Var == null) {
                        gbVar.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void d();

    public abstract void f();

    public abstract boolean h(int i2);

    public abstract void i(int i2);

    public abstract void j(View view);

    public abstract void k(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void l(CharSequence charSequence);
}
