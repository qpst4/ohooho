package defpackage;

import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hv implements iv {
    public Long a;

    @Override // defpackage.iv
    public final boolean a() {
        if (this.a == null) {
            try {
                Method declaredMethod = Build.class.getDeclaredMethod("getLong", String.class);
                declaredMethod.setAccessible(true);
                Long l = (Long) declaredMethod.invoke(null, "ro.build.version.oneui");
                l.longValue();
                this.a = l;
            } catch (Exception unused) {
                this.a = -1L;
            }
        }
        return this.a.longValue() >= 40100;
    }
}
