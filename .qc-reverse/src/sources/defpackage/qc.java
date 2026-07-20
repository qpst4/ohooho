package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class qc {
    public static final pc b = new pc();
    public static final u31 c = new u31(oc.c);
    public final List a = kl.K0("com.asus.mobilemanager", "com.miui.securitycenter", "com.letv.android.letvsafe", "com.huawei.systemmanager", "com.coloros.safecenter", "com.oppo.safe", "com.iqoo.secure", "com.vivo.permissionmanager", "com.evenwell.powersaving.g3", "com.huawei.systemmanager", "com.samsung.android.lool", "com.oneplus.security");

    public static boolean a(Context context, List list) {
        if (list.isEmpty()) {
            return false;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (e(context, (Intent) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Context context, List list, List list2, boolean z) {
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                List<ApplicationInfo> installedApplications = context.getPackageManager().getInstalledApplications(0);
                installedApplications.getClass();
                Iterator<ApplicationInfo> it2 = installedApplications.iterator();
                while (it2.hasNext()) {
                    if (fc0.b(it2.next().packageName, str)) {
                        return z ? f(context, list2) : a(context, list2);
                    }
                }
            }
        }
        return false;
    }

    public static Intent d(String str, String str2, boolean z) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(str, str2));
        if (z) {
            intent.addFlags(268435456);
        }
        return intent;
    }

    public static boolean e(Context context, Intent intent) {
        context.getPackageManager().queryIntentActivities(intent, 65536).getClass();
        return !r1.isEmpty();
    }

    public static boolean f(Context context, List list) throws Exception {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Intent intent = (Intent) it.next();
            if (e(context, intent)) {
                try {
                    context.startActivity(intent);
                    return true;
                } catch (Exception e) {
                    e.printStackTrace();
                    throw e;
                }
            }
        }
        return false;
    }

    public final boolean c(Context context, boolean z) {
        String str = Build.BRAND;
        str.getClass();
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = str.toLowerCase(locale);
        lowerCase.getClass();
        if (lowerCase.equals("asus")) {
            return b(context, lc1.V("com.asus.mobilemanager"), kl.K0(d("com.asus.mobilemanager", "com.asus.mobilemanager.powersaver.PowerSaverSettings", false), d("com.asus.mobilemanager", "com.asus.mobilemanager.autostart.AutoStartActivity", false)), z);
        }
        if (lowerCase.equals("xiaomi") ? true : lowerCase.equals("poco") ? true : lowerCase.equals("redmi")) {
            return b(context, lc1.V("com.miui.securitycenter"), lc1.V(d("com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity", false)), z);
        }
        if (lowerCase.equals("letv")) {
            return b(context, lc1.V("com.letv.android.letvsafe"), lc1.V(d("com.letv.android.letvsafe", "com.letv.android.letvsafe.AutobootManageActivity", false)), z);
        }
        if (lowerCase.equals("honor")) {
            return b(context, lc1.V("com.huawei.systemmanager"), lc1.V(d("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity", false)), z);
        }
        if (lowerCase.equals("huawei")) {
            return b(context, lc1.V("com.huawei.systemmanager"), kl.K0(d("com.huawei.systemmanager", "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity", false), d("com.huawei.systemmanager", "com.huawei.systemmanager.optimize.process.ProtectActivity", false)), z);
        }
        if (!lowerCase.equals("oppo")) {
            if (lowerCase.equals("vivo")) {
                return b(context, kl.K0("com.iqoo.secure", "com.vivo.permissionmanager"), kl.K0(d("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity", false), d("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity", false), d("com.iqoo.secure", "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager", false)), z);
            }
            if (lowerCase.equals("nokia")) {
                return b(context, lc1.V("com.evenwell.powersaving.g3"), lc1.V(d("com.evenwell.powersaving.g3", "com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity", false)), z);
            }
            if (lowerCase.equals("samsung")) {
                return b(context, lc1.V("com.samsung.android.lool"), kl.K0(d("com.samsung.android.lool", "com.samsung.android.sm.ui.battery.BatteryActivity", false), d("com.samsung.android.lool", "com.samsung.android.sm.battery.ui.usage.CheckableAppListActivity", false), d("com.samsung.android.lool", "com.samsung.android.sm.battery.ui.BatteryActivity", false)), z);
            }
            if (lowerCase.equals("oneplus")) {
                if (!b(context, lc1.V("com.oneplus.security"), lc1.V(d("com.oneplus.security", "com.oneplus.security.chainlaunch.view.ChainLaunchAppListActivity", false)), z)) {
                    Intent intent = new Intent();
                    intent.setAction("com.android.settings.action.BACKGROUND_OPTIMIZE");
                    List listV = lc1.V(intent);
                    if (z ? f(context, listV) : a(context, listV)) {
                    }
                }
            }
            return false;
        }
        if (!b(context, kl.K0("com.coloros.safecenter", "com.oppo.safe"), kl.K0(d("com.coloros.safecenter", "com.coloros.safecenter.permission.startup.StartupAppListActivity", false), d("com.oppo.safe", "com.oppo.safe.permission.startup.StartupAppListActivity", false), d("com.coloros.safecenter", "com.coloros.safecenter.startupapp.StartupAppListActivity", false)), z)) {
            try {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.addCategory("android.intent.category.DEFAULT");
                intent2.setData(Uri.parse("package:" + ((Object) context.getPackageName())));
                if (!z) {
                    return e(context, intent2);
                }
                context.startActivity(intent2);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
}
