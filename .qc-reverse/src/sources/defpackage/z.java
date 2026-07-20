package defpackage;

import android.accessibilityservice.AccessibilityServiceInfo;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z {
    public static final HashMap a = new HashMap();

    public static void a(CursorAccessibilityService cursorAccessibilityService, String str, int i) {
        Integer numValueOf = Integer.valueOf(i);
        HashMap map = a;
        map.put(str, numValueOf);
        Iterator it = map.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        try {
            AccessibilityServiceInfo serviceInfo = cursorAccessibilityService.getServiceInfo();
            if (iIntValue != serviceInfo.eventTypes) {
                si0.a("updateEventTypes: " + iIntValue);
                serviceInfo.eventTypes = iIntValue;
                cursorAccessibilityService.setServiceInfo(serviceInfo);
            }
        } catch (Exception unused) {
            si0.b("updateEventTypes error");
        }
    }
}
