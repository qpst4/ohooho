package defpackage;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f2 implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ f2(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return ((p2) obj).a.equals(((r2) obj2).I0.c());
            case 1:
                ApplicationInfo applicationInfo = (ApplicationInfo) obj;
                try {
                    if (((PackageManager) obj2).getLaunchIntentForPackage(applicationInfo.packageName) != null) {
                        return !applicationInfo.packageName.equals("com.quickcursor");
                    }
                    return false;
                } catch (Throwable th) {
                    si0.b("getInstalledPackages filter launch intent crash: " + th);
                    return false;
                }
            default:
                return ((f91) obj).g().equals((String) obj2);
        }
    }
}
