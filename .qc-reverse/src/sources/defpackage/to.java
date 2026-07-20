package defpackage;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class to implements hh0, b3, xa {
    public final /* synthetic */ int b;
    public final /* synthetic */ m3 c;

    public /* synthetic */ to(m3 m3Var, int i) {
        this.b = i;
        this.c = m3Var;
    }

    @Override // defpackage.hh0
    public void a(jh0 jh0Var) {
        int i = this.b;
        m3 m3Var = this.c;
        switch (i) {
            case 0:
                wa waVar = vo.k;
                if (jh0Var != null) {
                    String str = (String) jh0Var.d;
                    n3 n3Var = n3.copy;
                    wa waVar2 = new wa();
                    waVar2.put("copyMode", str);
                    m3Var.q(new i(n3Var, waVar2));
                    break;
                }
                break;
            case 1:
                wa waVar3 = o60.k;
                if (jh0Var != null) {
                    n3 n3Var2 = n3.gestureSwipe;
                    wa waVar4 = new wa(o60.k);
                    waVar4.put("swipeDirection", jh0Var.d);
                    m3Var.q(new i(n3Var2, waVar4));
                    break;
                }
                break;
            default:
                l3 l3Var = i61.k;
                if (jh0Var != null) {
                    String str2 = (String) jh0Var.d;
                    n3 n3Var3 = n3.toggleAutoTapMode;
                    wi0 wi0Var = new wi0();
                    wi0Var.put("autoTapMode", str2);
                    m3Var.q(new i(n3Var3, wi0Var));
                    break;
                }
                break;
        }
    }

    @Override // defpackage.b3
    public void b(SharedPreferences sharedPreferences) {
        int i = this.b;
        m3 m3Var = this.c;
        switch (i) {
            case 2:
                wa waVar = o60.k;
                n3 n3Var = n3.gestureSwipe;
                wa waVar2 = new wa();
                waVar2.put("swipeDirection", sharedPreferences.getString("swipeDirection", dn.j2));
                waVar2.put("swipeDistance", sharedPreferences.getString("swipeDistance", dn.k2));
                waVar2.put("swipeDuration", Integer.valueOf(sharedPreferences.getInt("swipeDuration", dn.l2)));
                waVar2.put("multiTouch", Integer.valueOf(sharedPreferences.getInt("multiTouch", 1)));
                m3Var.q(new i(n3Var, waVar2));
                break;
            case 3:
            case 5:
            case 9:
            default:
                r71 r71Var = mh1.N;
                n3 n3Var2 = n3.volumeSwipe;
                r71 r71Var2 = new r71();
                r71Var2.put("volumeMode", sharedPreferences.getString("volumeMode", dn.T1));
                r71Var2.put("swipeLength", Integer.valueOf(sharedPreferences.getInt("swipeLength", dn.N2)));
                r71Var2.put("showUI", Boolean.valueOf(sharedPreferences.getBoolean("showUI", dn.U1.booleanValue())));
                r71Var2.put("showBar", Boolean.valueOf(sharedPreferences.getBoolean("showBar", dn.K2)));
                r71Var2.put("maxPerc", Integer.valueOf(sharedPreferences.getInt("maxPerc", dn.Z1.intValue())));
                r71Var2.put("smoothTime", Integer.valueOf(sharedPreferences.getInt("smoothTime", dn.b2.intValue())));
                r71Var2.put("orientation", sharedPreferences.getString("orientation", dn.e2));
                r71Var2.put("verticalPosition", Integer.valueOf(sharedPreferences.getInt("verticalPosition", dn.g2.intValue())));
                r71Var2.put("granularity", Integer.valueOf(sharedPreferences.getInt("granularity", dn.X1.intValue())));
                r71Var2.put("accessibilityStream", Boolean.valueOf(sharedPreferences.getBoolean("accessibilityStream", dn.i2.booleanValue())));
                m3Var.q(new i(n3Var2, r71Var2));
                break;
            case 4:
                l3 l3Var = kf0.k;
                n3 n3Var3 = n3.launchApp;
                wa waVar3 = new wa();
                waVar3.put("packageName", sharedPreferences.getString("packageName", ""));
                waVar3.put("windowed", Boolean.valueOf(sharedPreferences.getBoolean("windowed", dn.z2)));
                waVar3.put("windowConfig", sharedPreferences.getString("windowConfig", ""));
                waVar3.put("windowedMode", sharedPreferences.getString("windowedMode", dn.A2));
                m3Var.q(new i(n3Var3, waVar3));
                break;
            case 6:
                wa waVar4 = xi0.k;
                n3 n3Var4 = n3.longTap;
                wi0 wi0Var = new wi0();
                wi0Var.put("longTapDuration", Integer.valueOf(sharedPreferences.getInt("longTapDuration", dn.m2)));
                wi0Var.put("multiTouch", Integer.valueOf(sharedPreferences.getInt("multiTouch", 1)));
                m3Var.q(new i(n3Var4, wi0Var));
                break;
            case 7:
                wi0 wi0Var2 = cy0.k;
                ArrayList arrayList = new ArrayList();
                for (int i2 = -1; i2 <= 3; i2++) {
                    if (sharedPreferences.getBoolean("rotation" + i2, true)) {
                        arrayList.add(String.valueOf(i2));
                    }
                }
                n3 n3Var5 = n3.screenRotate;
                wi0 wi0Var3 = new wi0();
                wi0Var3.put("rotationMode", sharedPreferences.getString("rotationMode", dn.y2));
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
                wi0Var3.put("rotations", sb.toString());
                m3Var.q(new i(n3Var5, wi0Var3));
                break;
            case 8:
                String str = jy0.k;
                n3 n3Var6 = n3.screenshotClipboard;
                wi0 wi0Var4 = new wi0();
                wi0Var4.put("copyClipboard", Boolean.valueOf(sharedPreferences.getBoolean("copyClipboard", dn.r2)));
                wi0Var4.put("saveFile", Boolean.valueOf(sharedPreferences.getBoolean("saveFile", dn.s2)));
                wi0Var4.put("executeAfter", sharedPreferences.getString("executeAfter", dn.x2));
                wi0Var4.put("afterCrop", Boolean.valueOf(sharedPreferences.getBoolean("afterCrop", dn.t2)));
                wi0Var4.put("afterShare", Boolean.valueOf(sharedPreferences.getBoolean("afterShare", dn.u2)));
                wi0Var4.put("afterSave", Boolean.valueOf(sharedPreferences.getBoolean("afterSave", dn.v2)));
                wi0Var4.put("afterDelete", Boolean.valueOf(sharedPreferences.getBoolean("afterDelete", dn.w2)));
                m3Var.q(new i(n3Var6, wi0Var4));
                break;
            case 10:
                r71 r71Var3 = lh1.L;
                n3 n3Var7 = n3.volumeBar;
                r71 r71Var4 = new r71();
                r71Var4.put("volumeMode", sharedPreferences.getString("volumeMode", dn.T1));
                r71Var4.put("showUI", Boolean.valueOf(sharedPreferences.getBoolean("showUI", dn.U1.booleanValue())));
                r71Var4.put("maxPerc", Integer.valueOf(sharedPreferences.getInt("maxPerc", dn.Y1.intValue())));
                r71Var4.put("smoothTime", Integer.valueOf(sharedPreferences.getInt("smoothTime", dn.a2.intValue())));
                r71Var4.put("hideCursor", Boolean.valueOf(sharedPreferences.getBoolean("hideCursor", dn.c2.booleanValue())));
                r71Var4.put("orientation", sharedPreferences.getString("orientation", dn.d2));
                r71Var4.put("verticalPosition", Integer.valueOf(sharedPreferences.getInt("verticalPosition", dn.g2.intValue())));
                r71Var4.put("mode", sharedPreferences.getString("mode", dn.f2));
                r71Var4.put("showBar", Boolean.valueOf(sharedPreferences.getBoolean("showBar", dn.L2)));
                r71Var4.put("granularity", Integer.valueOf(sharedPreferences.getInt("granularity", dn.X1.intValue())));
                r71Var4.put("accessibilityStream", Boolean.valueOf(sharedPreferences.getBoolean("accessibilityStream", dn.i2.booleanValue())));
                m3Var.q(new i(n3Var7, r71Var4));
                break;
        }
    }

    @Override // defpackage.xa
    public void onResult(Object obj) {
        int i = this.b;
        m3 m3Var = this.c;
        switch (i) {
            case 3:
                l3 l3Var = kf0.k;
                String str = (String) obj;
                if (str != null) {
                    n3 n3Var = n3.launchApp;
                    wa waVar = new wa();
                    waVar.put("packageName", str);
                    waVar.put("windowed", Boolean.valueOf(dn.z2));
                    waVar.put("windowConfig", "");
                    waVar.put("windowedMode", dn.A2);
                    m3Var.q(new i(n3Var, waVar));
                    break;
                }
                break;
            default:
                l3 l3Var2 = pf0.k;
                HashMap map = (HashMap) obj;
                if (map != null) {
                    si0.a("Shortcut picked: " + map.get("packageName") + ", " + map.get("intent") + ", Icon: " + map.containsKey("ICON_BASE64_PNG"));
                    m3Var.q(new i(n3.launchShortcut, map));
                    break;
                }
                break;
        }
    }
}
