package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.quickcursor.App;
import java.lang.reflect.Type;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xw {
    public static final Type d = new ww().b();
    public static final xw e = new xw();
    public final i70 a = new i70();
    public final SharedPreferences b;
    public HashMap c;

    public xw() {
        Context context = App.c;
        this.b = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        f();
    }

    public static dx a() {
        dx dxVar = new dx();
        dxVar.a(new lw(n3.nothing, null));
        dxVar.j(Boolean.FALSE);
        return dxVar;
    }

    public static dx b() {
        dx dxVar = new dx();
        dxVar.j(Boolean.FALSE);
        dxVar.a(new lw(n3.backButton, null));
        n3 n3Var = n3.nothing;
        dxVar.a(new lw(n3Var, null));
        dxVar.a(new lw(n3Var, null));
        return dxVar;
    }

    public static dx c() {
        dx dxVar = new dx();
        dxVar.j(Boolean.FALSE);
        dxVar.a(new lw(n3.backButton, null));
        n3 n3Var = n3.nothing;
        dxVar.a(new lw(n3Var, null));
        dxVar.a(new lw(n3Var, null));
        return dxVar;
    }

    public final dx d(String str) {
        return (dx) this.c.get(str);
    }

    public final void e() {
        dx dxVar = new dx();
        dxVar.a(new lw(n3.expandNotifications, j00.k));
        dx dxVarB = b();
        Boolean bool = Boolean.FALSE;
        dxVarB.j(bool);
        dx dxVarC = c();
        dxVarC.j(bool);
        wa waVar = new wa();
        waVar.put("topEdgeBar", dxVar);
        waVar.put("leftEdgeBar", dxVarB);
        waVar.put("rightEdgeBar", dxVarC);
        waVar.put("bottomEdgeBar", a());
        this.c = waVar;
        g();
    }

    public final void f() {
        HashMap map = null;
        String string = this.b.getString("edgeActions", null);
        if (string != null) {
            try {
                map = (HashMap) this.a.f(string, d);
            } catch (wd0 unused) {
            }
        }
        this.c = map;
        if (map == null) {
            e();
        }
    }

    public final void g() {
        this.b.edit().putString("edgeActions", this.a.j(this.c, d)).apply();
    }
}
