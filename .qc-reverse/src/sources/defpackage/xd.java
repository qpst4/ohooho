package defpackage;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xd {
    public static final i70 a = new i70();

    public static void a(SharedPreferences sharedPreferences, SharedPreferences.Editor editor, String str, uv0 uv0Var) {
        String string = sharedPreferences.getString(str.concat("FloatingZone"), null);
        editor.remove(str.concat("FloatingZone"));
        if (string == null || string.isEmpty()) {
            si0.b("Skip setFloatingTrigger for " + str + " because it is empty.");
            return;
        }
        try {
            td0 td0VarB = xr.C(string).b();
            f91 f91VarD = uv0Var.e().d();
            i70 i70Var = a;
            f91VarD.n((db) i70Var.b(td0VarB.d("triggerArea")));
            uv0Var.e().d().l((db) i70Var.b(td0VarB.d("moveArea")));
            uv0Var.e().d().j((db) i70Var.b(td0VarB.d("cursorArea")));
            si0.b("Successfully setFloatingTrigger for ".concat(str));
        } catch (Exception e) {
            StringBuilder sbM = l11.m("Error while trying to setFloatingTrigger for ", str, ", ");
            sbM.append(e.getMessage());
            si0.b(sbM.toString());
        }
    }

    public static void b(SharedPreferences sharedPreferences, String str, uv0 uv0Var) {
        String string = sharedPreferences.getString(str, "simple");
        string.getClass();
        switch (string) {
            case "simple":
                uv0Var.u(tv0.simpleTriggers);
                break;
            case "advanced":
                uv0Var.u(tv0.advancedTriggers);
                break;
            case "floating":
                uv0Var.u(tv0.floating);
                break;
            default:
                uv0Var.u(tv0.disabled);
                break;
        }
        si0.b("Resolution set mode '" + uv0Var.g() + "' from " + str + "=" + string);
    }

    public static void c(SharedPreferences sharedPreferences, SharedPreferences.Editor editor, final String str, uv0 uv0Var) {
        String string = sharedPreferences.getString(str.concat("ZoneList"), null);
        editor.remove(str.concat("ZoneList"));
        if (string == null || string.isEmpty()) {
            si0.b("Skip setSimpleAndAdvancedTriggers for " + str + " because it is empty.");
            return;
        }
        try {
            pd0 pd0VarC = xr.C(string);
            if (!(pd0VarC instanceof kd0)) {
                throw new IllegalStateException("Not a JSON Array: " + pd0VarC);
            }
            final ArrayList arrayList = new ArrayList();
            ((kd0) pd0VarC).forEach(new Consumer() { // from class: wd
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    td0 td0VarB = ((pd0) obj).b();
                    f91 f91VarN = str.equals("portrait") ? if0.p.n(td0VarB.d("name").c()) : if0.o.n(td0VarB.d("name").c());
                    i70 i70Var = xd.a;
                    f91VarN.n((db) i70Var.b(td0VarB.d("triggerArea")));
                    f91VarN.l((db) i70Var.b(td0VarB.d("moveArea")));
                    f91VarN.j((db) i70Var.b(td0VarB.d("cursorArea")));
                    arrayList.add(f91VarN);
                    si0.b("Created trigger '" + f91VarN.g() + "'");
                }
            });
            if (uv0Var.g() == tv0.simpleTriggers) {
                uv0Var.l().t(arrayList);
            } else if (uv0Var.g() == tv0.advancedTriggers) {
                uv0Var.d().d(arrayList);
            }
            si0.b("Successfully setSimpleAndAdvancedTriggers for " + str + " and mode " + uv0Var.g());
        } catch (Exception e) {
            StringBuilder sbM = l11.m("Error while trying to setSimpleAndAdvancedTriggers  for ", str, ", ");
            sbM.append(e.getMessage());
            si0.b(sbM.toString());
        }
    }

    public static void d(SharedPreferences sharedPreferences, SharedPreferences.Editor editor, String str, uv0 uv0Var) {
        y01 y01VarL = uv0Var.l();
        editor.remove(str.concat("TriggerSize"));
        si0.b("Remove '" + str + "TriggerSize'");
        boolean z = sharedPreferences.getBoolean(str.concat("LeftTrigger"), true);
        boolean z2 = sharedPreferences.getBoolean(str.concat("RightTrigger"), true);
        if (z && z2) {
            y01VarL.s(x01.both);
        } else if (z && !z2) {
            y01VarL.s(x01.left);
        } else if (!z && z2) {
            y01VarL.s(x01.right);
        }
        si0.b("Resolution set triggerSides '" + y01VarL.k() + "' from " + str + "LeftTrigger=" + z + " and " + str + "RightTrigger=" + z2);
        editor.remove(str.concat("LeftTrigger"));
        editor.remove(str.concat("RightTrigger"));
        y01VarL.r(sharedPreferences.getInt(str.concat("TriggerPosition"), 0));
        StringBuilder sb = new StringBuilder("Resolution set triggerPosition '");
        sb.append(y01VarL.j());
        sb.append("' from ");
        sb.append(str);
        sb.append("TriggerPosition");
        si0.b(sb.toString());
        editor.remove(str.concat("TriggerPosition"));
        y01VarL.n(sharedPreferences.getInt(str.concat("CursorSpeed"), 0));
        si0.b("Resolution set cursorSpeed '" + y01VarL.d() + "' from " + str + "CursorSpeed");
        editor.remove(str.concat("CursorSpeed"));
        y01VarL.m(sharedPreferences.getInt(str.concat("CursorAreaSize"), 0));
        si0.b("Resolution set cursorAreaSize '" + y01VarL.c() + "' from " + str + "CursorAreaSize");
        editor.remove(str.concat("CursorAreaSize"));
        y01VarL.o(sharedPreferences.getInt(str.concat("TrackerAlign"), 0));
        si0.b("Resolution set trackerAlign '" + y01VarL.e() + "' from " + str + "TrackerAlign");
        editor.remove(str.concat("TrackerAlign"));
        y01VarL.p(sharedPreferences.getInt(str.concat("TrackerDistance"), 0));
        si0.b("Resolution set trackerDistance '" + y01VarL.f() + "' from " + str + "TrackerDistance");
        editor.remove(str.concat("TrackerDistance"));
    }
}
