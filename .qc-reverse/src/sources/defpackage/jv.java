package defpackage;

import android.content.Context;
import android.os.Build;
import android.view.ContextThemeWrapper;
import com.quickcursor.R;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class jv {
    public static final Map a;
    public static final Map b;

    static {
        gv gvVar = new gv();
        hv hvVar = new hv();
        HashMap map = new HashMap();
        map.put("fcnt", gvVar);
        map.put("google", gvVar);
        map.put("hmd global", gvVar);
        map.put("infinix", gvVar);
        map.put("infinix mobility limited", gvVar);
        map.put("itel", gvVar);
        map.put("kyocera", gvVar);
        map.put("lenovo", gvVar);
        map.put("lge", gvVar);
        map.put("meizu", gvVar);
        map.put("motorola", gvVar);
        map.put("nothing", gvVar);
        map.put("oneplus", gvVar);
        map.put("oppo", gvVar);
        map.put("realme", gvVar);
        map.put("robolectric", gvVar);
        map.put("samsung", hvVar);
        map.put("sharp", gvVar);
        map.put("shift", gvVar);
        map.put("sony", gvVar);
        map.put("tcl", gvVar);
        map.put("tecno", gvVar);
        map.put("tecno mobile limited", gvVar);
        map.put("vivo", gvVar);
        map.put("wingtech", gvVar);
        map.put("xiaomi", gvVar);
        a = Collections.unmodifiableMap(map);
        HashMap map2 = new HashMap();
        map2.put("asus", gvVar);
        map2.put("jio", gvVar);
        b = Collections.unmodifiableMap(map2);
    }

    public static boolean a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 31) {
            int i2 = ph.a;
            if (i >= 33) {
                return true;
            }
            if (i >= 32) {
                String str = Build.VERSION.CODENAME;
                str.getClass();
                if (!"REL".equals(str)) {
                    Locale locale = Locale.ROOT;
                    String upperCase = str.toUpperCase(locale);
                    upperCase.getClass();
                    Integer num = upperCase.equals("BAKLAVA") ? num : null;
                    String upperCase2 = "Tiramisu".toUpperCase(locale);
                    upperCase2.getClass();
                    num = upperCase2.equals("BAKLAVA") ? 0 : null;
                    if (num == null || num == null) {
                        if (num == null && num == null) {
                            String upperCase3 = str.toUpperCase(locale);
                            upperCase3.getClass();
                            String upperCase4 = "Tiramisu".toUpperCase(locale);
                            upperCase4.getClass();
                            if (upperCase3.compareTo(upperCase4) >= 0) {
                                return true;
                            }
                        } else if (num != null) {
                            return true;
                        }
                    } else if (num.intValue() >= num.intValue()) {
                        return true;
                    }
                }
            }
            String str2 = Build.MANUFACTURER;
            Locale locale2 = Locale.ROOT;
            iv ivVar = (iv) a.get(str2.toLowerCase(locale2));
            if (ivVar == null) {
                ivVar = (iv) b.get(Build.BRAND.toLowerCase(locale2));
            }
            if (ivVar != null && ivVar.a()) {
                return true;
            }
        }
        return false;
    }

    public static Context b(Context context) {
        return !a() ? context : new ContextThemeWrapper(context, R.style.ThemeOverlay_Material3_DynamicColors_DayNight);
    }
}
