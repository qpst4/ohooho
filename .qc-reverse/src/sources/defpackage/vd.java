package defpackage;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract class vd {
    public static final wa a;

    static {
        wa waVar = new wa();
        waVar.put("nothing", "nothing");
        waVar.put("hideCursor", "hideCursor");
        waVar.put("notifications", "expandNotifications");
        waVar.put("quickSettings", "expandQuickSettings");
        waVar.put("back", "backButton");
        waVar.put("home", "homeButton");
        waVar.put("recents", "recentsButton");
        waVar.put("swipeAway", "gestureOpenAppMenu");
        a = waVar;
    }

    public static void a(SharedPreferences sharedPreferences, boolean z) {
        lw lwVar;
        wa waVar = a;
        try {
            String string = sharedPreferences.getString("edgeActionSide", "");
            String string2 = sharedPreferences.getString("edgeActionTop", "");
            float f = sharedPreferences.getFloat("edgeActionThreshold", -1.0f);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.remove("edgeActionTop").remove("edgeActionSide").remove("edgeActionThreshold").remove("vibrationOnTopEdgeAction").remove("rippleOnTopEdgeAction").remove("rippleTopEdgeActionColor").remove("vibrationOnSideEdgeAction").remove("rippleOnSideEdgeAction").remove("rippleSideEdgeActionColor").apply();
            if (z) {
                oq0 oq0Var = oq0.k0;
                editorEdit.putFloat(oq0Var.name(), ((Float) oq0Var.c).floatValue());
                oq0.j(editorEdit, oq0.l0);
                oq0.i(editorEdit, oq0.n0);
                oq0.i(editorEdit, oq0.m0);
                oq0.i(editorEdit, oq0.o0);
                oq0.j(editorEdit, oq0.p0);
                oq0.j(editorEdit, oq0.q0);
                oq0.j(editorEdit, oq0.r0);
                oq0 oq0Var2 = oq0.u0;
                editorEdit.putString(oq0Var2.name(), (String) oq0Var2.c);
            } else {
                oq0.f(editorEdit, oq0.k0);
                oq0.g(editorEdit, oq0.l0);
                oq0.e(editorEdit, oq0.n0);
                oq0.e(editorEdit, oq0.m0);
                oq0.e(editorEdit, oq0.o0);
                oq0.g(editorEdit, oq0.p0);
                oq0.g(editorEdit, oq0.q0);
                oq0.g(editorEdit, oq0.r0);
                oq0.h(editorEdit, oq0.u0);
            }
            if (z) {
                lw lwVar2 = null;
                try {
                    lwVar = new lw(n3.valueOf((String) waVar.get(string)), null);
                } catch (Exception unused) {
                    lwVar = null;
                }
                try {
                    lwVar2 = new lw(n3.valueOf((String) waVar.get(string2)), null);
                } catch (Exception unused2) {
                }
                if (lwVar != null) {
                    xw xwVar = xw.e;
                    xwVar.d("leftEdgeBar").d().set(0, lwVar);
                    xwVar.d("rightEdgeBar").d().set(0, lwVar);
                    dx dxVarD = xwVar.d("leftEdgeBar");
                    n3 n3VarB = lwVar.b();
                    n3 n3Var = n3.nothing;
                    dxVarD.j(Boolean.valueOf(n3VarB != n3Var));
                    xwVar.d("rightEdgeBar").j(Boolean.valueOf(lwVar.b() != n3Var));
                }
                if (lwVar2 != null) {
                    dx dxVarD2 = xw.e.d("topEdgeBar");
                    dxVarD2.i();
                    dxVarD2.a(lwVar2);
                    dxVarD2.j(Boolean.valueOf(lwVar2.b() != n3.nothing));
                }
                if (f > 0.0f) {
                    editorEdit.putFloat(oq0.k0.name(), f);
                }
            }
            editorEdit.apply();
            xw.e.g();
            si0.b("Updated to new edge actions.");
        } catch (Exception e) {
            si0.b(e.getStackTrace() + e.getMessage());
            yb0.z("Something went wrong on edge actions update", 1);
        }
    }
}
