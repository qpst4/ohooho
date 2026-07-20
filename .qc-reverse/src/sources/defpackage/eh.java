package defpackage;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class eh implements b3 {
    public final /* synthetic */ int b;
    public final /* synthetic */ m3 c;
    public final /* synthetic */ n3 d;

    public /* synthetic */ eh(m3 m3Var, n3 n3Var, int i) {
        this.b = i;
        this.c = m3Var;
        this.d = n3Var;
    }

    @Override // defpackage.b3
    public void b(SharedPreferences sharedPreferences) {
        int i = this.b;
        n3 n3Var = this.d;
        m3 m3Var = this.c;
        switch (i) {
            case 0:
                int i2 = gh.I;
                wa waVar = new wa();
                waVar.put("brightnessMode", sharedPreferences.getString("brightnessMode", dn.p2));
                waVar.put("maxPerc", Integer.valueOf(sharedPreferences.getInt("maxPerc", dn.Y1.intValue())));
                waVar.put("smoothTime", Integer.valueOf(sharedPreferences.getInt("smoothTime", dn.a2.intValue())));
                waVar.put("hideCursor", Boolean.valueOf(sharedPreferences.getBoolean("hideCursor", dn.c2.booleanValue())));
                waVar.put("orientation", sharedPreferences.getString("orientation", dn.d2));
                waVar.put("verticalPosition", Integer.valueOf(sharedPreferences.getInt("verticalPosition", dn.g2.intValue())));
                waVar.put("mode", sharedPreferences.getString("mode", dn.f2));
                waVar.put("showBar", Boolean.valueOf(sharedPreferences.getBoolean("showBar", dn.M2)));
                m3Var.q(new i(n3Var, waVar));
                break;
            case 1:
                wa waVar2 = lh.L;
                wa waVar3 = new wa();
                waVar3.put("brightnessMode", sharedPreferences.getString("brightnessMode", dn.p2));
                waVar3.put("swipeLength", Integer.valueOf(sharedPreferences.getInt("swipeLength", dn.N2)));
                waVar3.put("showBar", Boolean.valueOf(sharedPreferences.getBoolean("showBar", dn.M2)));
                waVar3.put("maxPerc", Integer.valueOf(sharedPreferences.getInt("maxPerc", dn.Z1.intValue())));
                waVar3.put("smoothTime", Integer.valueOf(sharedPreferences.getInt("smoothTime", dn.b2.intValue())));
                waVar3.put("orientation", sharedPreferences.getString("orientation", dn.e2));
                waVar3.put("verticalPosition", Integer.valueOf(sharedPreferences.getInt("verticalPosition", dn.g2.intValue())));
                m3Var.q(new i(n3Var, waVar3));
                break;
            case 2:
                wa waVar4 = j00.k;
                wa waVar5 = new wa();
                waVar5.put("expandToggle", Boolean.valueOf(sharedPreferences.getBoolean("expandToggle", dn.V1.booleanValue())));
                m3Var.q(new i(n3Var, waVar5));
                break;
            case 3:
                wa waVar6 = h60.k;
                wa waVar7 = new wa();
                waVar7.put("pinchDistance", sharedPreferences.getString("pinchDistance", dn.n2));
                waVar7.put("pinchDuration", sharedPreferences.getString("pinchDuration", dn.o2));
                m3Var.q(new i(n3Var, waVar7));
                break;
            case 4:
                wa waVar8 = mf0.k;
                wa waVar9 = new wa();
                waVar9.put("hideCursor", Boolean.valueOf(sharedPreferences.getBoolean("hideCursor", dn.W1.booleanValue())));
                m3Var.q(new i(n3Var, waVar9));
                break;
            case 5:
                wi0 wi0Var = vk0.k;
                wi0 wi0Var2 = new wi0();
                wi0Var2.put("showUI", Boolean.valueOf(sharedPreferences.getBoolean("showUI", dn.U1.booleanValue())));
                wi0Var2.put("steps", Integer.valueOf(sharedPreferences.getInt("steps", dn.q2.intValue())));
                m3Var.q(new i(n3Var, wi0Var2));
                break;
            case 6:
            default:
                wi0 wi0Var3 = o61.k;
                ArrayList arrayList = new ArrayList();
                for (int i3 = -1; i3 <= 3; i3++) {
                    if (sharedPreferences.getBoolean("profile" + i3, true)) {
                        arrayList.add(String.valueOf(i3));
                    }
                }
                wi0 wi0Var4 = new wi0();
                StringBuilder sb = new StringBuilder();
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    while (true) {
                        sb.append((CharSequence) it.next());
                        if (it.hasNext()) {
                            sb.append((CharSequence) ",");
                        }
                    }
                }
                wi0Var4.put("profiles", sb.toString());
                m3Var.q(new i(n3Var, wi0Var4));
                break;
            case 7:
                wi0 wi0Var5 = x51.k;
                wi0 wi0Var6 = new wi0();
                wi0Var6.put("seconds", Integer.valueOf(sharedPreferences.getInt("seconds", dn.h2.intValue())));
                m3Var.q(new i(n3Var, wi0Var6));
                break;
        }
    }
}
