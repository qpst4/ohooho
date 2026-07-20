package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import com.quickcursor.App;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xv0 {
    public static final xv0 d = new xv0();
    public final i70 a = new i70();
    public final SharedPreferences b;
    public Map c;

    public xv0() {
        Context context = App.c;
        this.b = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        b();
    }

    public final uv0 a() {
        int iC = ey0.c();
        int iB = ey0.b();
        uv0 uv0VarC = (uv0) this.c.get(iC + "x" + iB);
        if (uv0VarC == null) {
            Type type = uv0.MAP_HASH_TYPE;
            int i = iC < iB ? 1 : 2;
            float fMax = Math.max(iC, iB) / Math.min(iC, iB);
            uv0 uv0Var = null;
            float f = Float.MAX_VALUE;
            for (uv0 uv0Var2 : this.c.values()) {
                if (i != uv0Var2.i()) {
                    si0.a("Resolution orientation doesn't match, skipping: '" + uv0Var2.v() + "'.");
                } else {
                    float fAbs = Math.abs(fMax - uv0Var2.h());
                    if (fAbs > 0.3f) {
                        si0.a("Resolution aspect ratio > MAX_ASPECT_RATIO_DIFF skipping: '" + uv0Var2.v() + "'.");
                    } else if (fAbs < f) {
                        uv0Var = uv0Var2;
                        f = fAbs;
                    }
                }
            }
            if (uv0Var != null) {
                si0.a("Resolution scaled from: '" + uv0Var.v() + "'.");
                uv0VarC = uv0.b(iC, iB, uv0Var);
            } else {
                si0.a("Resolution not found, not scaled, created with default values.");
                uv0VarC = uv0.c(iC, iB);
            }
            this.c.put(iC + "x" + iB, uv0VarC);
            c();
        }
        return uv0VarC;
    }

    public final void b() {
        Map map = null;
        try {
            map = (Map) this.a.f(this.b.getString("resolutions", null), uv0.MAP_HASH_TYPE);
        } catch (Exception unused) {
        }
        this.c = map;
        if (map == null) {
            this.c = new HashMap();
            c();
        }
    }

    public final void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.b.edit().putString("resolutions", this.a.j(this.c, uv0.MAP_HASH_TYPE)).apply();
        si0.b("saveToSharedPreferences time: " + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms.");
    }
}
