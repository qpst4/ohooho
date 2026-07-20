package defpackage;

import android.content.SharedPreferences;
import com.quickcursor.R;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ud {
    public static final i70 a = new i70();
    public static final Type b = new td().b();

    public static Map a() {
        Map<String, ?> all = ((SharedPreferences) pn0.e.d).getAll();
        for (oq0 oq0Var : oq0.values()) {
            if (!all.containsKey(oq0Var.name())) {
                all.put(oq0Var.name(), oq0Var.c);
            }
        }
        Iterator it = oq0.h1.iterator();
        while (it.hasNext()) {
            all.remove(((oq0) it.next()).name());
        }
        all.remove(oq0.g.name());
        all.remove("expiredPreferencesBackup");
        return all;
    }

    public static void b(SharedPreferences.Editor editor, String str, Object obj) {
        if (obj instanceof Boolean) {
            editor.putBoolean(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (oq0.j1.contains(str) || oq0.i1.contains(str) || oq0.k1.contains(str)) {
            if (obj instanceof Double) {
                editor.putFloat(str, ((Double) obj).floatValue());
                return;
            } else {
                editor.putFloat(str, ((Float) obj).floatValue());
                return;
            }
        }
        if (oq0.l1.contains(str)) {
            if (obj instanceof Double) {
                editor.putLong(str, ((Double) obj).longValue());
                return;
            } else {
                editor.putLong(str, ((Long) obj).longValue());
                return;
            }
        }
        if (obj instanceof Double) {
            editor.putInt(str, ((Double) obj).intValue());
            return;
        }
        if (obj instanceof Integer) {
            editor.putInt(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof String) {
            editor.putString(str, (String) obj);
            return;
        }
        try {
            editor.putStringSet(str, new HashSet((ArrayList) obj));
        } catch (Exception unused) {
            si0.b("Can't restore setting: " + str);
        }
    }

    public static void c(Map map, wj wjVar) {
        SharedPreferences.Editor editorEdit = ((SharedPreferences) pn0.e.d).edit();
        for (Map.Entry entry : map.entrySet()) {
            b(editorEdit, (String) entry.getKey(), entry.getValue());
        }
        if (pn0.t().A()) {
            editorEdit.putBoolean(oq0.f.name(), true);
        }
        editorEdit.commit();
        xw.e.f();
        s71.e.b();
        xv0.d.b();
        pd1.b();
        pn0.t().Q(true);
        wjVar.F();
        yb0.y(R.string.backup_settings_restore_done, 1);
        f01.j();
        CursorAccessibilityService.k(true);
        lv.b();
        si0.b("Restore complete");
    }
}
