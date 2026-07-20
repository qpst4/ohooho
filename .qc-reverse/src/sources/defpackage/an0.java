package defpackage;

import android.app.PendingIntent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.core.graphics.drawable.IconCompat;
import com.quickcursor.R;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class an0 {
    public final Bundle a;
    public IconCompat b;
    public final boolean c;
    public final boolean d;
    public final int e;
    public final CharSequence f;
    public final PendingIntent g;

    public an0(String str, PendingIntent pendingIntent) {
        IconCompat iconCompatB = IconCompat.b(R.drawable.common_full_open_on_phone);
        Bundle bundle = new Bundle();
        this.d = true;
        this.b = iconCompatB;
        int iIntValue = iconCompatB.a;
        if (iIntValue == -1) {
            Object obj = iconCompatB.b;
            if (Build.VERSION.SDK_INT >= 28) {
                iIntValue = ju.k(obj);
            } else {
                try {
                    iIntValue = ((Integer) obj.getClass().getMethod("getType", null).invoke(obj, null)).intValue();
                } catch (IllegalAccessException e) {
                    Log.e("IconCompat", "Unable to get icon type " + obj, e);
                    iIntValue = -1;
                } catch (NoSuchMethodException e2) {
                    Log.e("IconCompat", "Unable to get icon type " + obj, e2);
                    iIntValue = -1;
                } catch (InvocationTargetException e3) {
                    Log.e("IconCompat", "Unable to get icon type " + obj, e3);
                    iIntValue = -1;
                }
            }
        }
        if (iIntValue == 2) {
            this.e = iconCompatB.c();
        }
        this.f = bn0.a(str);
        this.g = pendingIntent;
        this.a = bundle;
        this.c = true;
        this.d = true;
    }
}
