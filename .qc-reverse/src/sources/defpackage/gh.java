package defpackage;

import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import com.quickcursor.App;
import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class gh extends de {
    public static final int I;
    public static final wa J;
    public static final l3 K;
    public final r51 D = new r51(30, true);
    public boolean E;
    public float F;
    public float G;
    public float H;

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0026, code lost:
    
        r4.setAccessible(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002a, code lost:
    
        r0 = ((java.lang.Integer) r4.get(r0)).intValue();
        defpackage.si0.a("device getMaxBrightness() = " + r0);
     */
    static {
        /*
            android.content.Context r0 = com.quickcursor.App.c
            java.lang.String r1 = "power"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.os.PowerManager r0 = (android.os.PowerManager) r0
            if (r0 == 0) goto L4c
            java.lang.Class r1 = r0.getClass()
            java.lang.reflect.Field[] r1 = r1.getDeclaredFields()
            int r2 = r1.length
            r3 = 0
        L16:
            if (r3 >= r2) goto L4c
            r4 = r1[r3]
            java.lang.String r5 = r4.getName()
            java.lang.String r6 = "BRIGHTNESS_ON"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L49
            r1 = 1
            r4.setAccessible(r1)
            java.lang.Object r0 = r4.get(r0)     // Catch: java.lang.IllegalAccessException -> L4c
            java.lang.Integer r0 = (java.lang.Integer) r0     // Catch: java.lang.IllegalAccessException -> L4c
            int r0 = r0.intValue()     // Catch: java.lang.IllegalAccessException -> L4c
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.IllegalAccessException -> L4c
            r1.<init>()     // Catch: java.lang.IllegalAccessException -> L4c
            java.lang.String r2 = "device getMaxBrightness() = "
            r1.append(r2)     // Catch: java.lang.IllegalAccessException -> L4c
            r1.append(r0)     // Catch: java.lang.IllegalAccessException -> L4c
            java.lang.String r1 = r1.toString()     // Catch: java.lang.IllegalAccessException -> L4c
            defpackage.si0.a(r1)     // Catch: java.lang.IllegalAccessException -> L4c
            goto L4e
        L49:
            int r3 = r3 + 1
            goto L16
        L4c:
            r0 = 255(0xff, float:3.57E-43)
        L4e:
            defpackage.gh.I = r0
            wa r0 = new wa
            r0.<init>()
            java.lang.String r1 = "brightnessMode"
            java.lang.String r2 = defpackage.dn.p2
            r0.put(r1, r2)
            java.lang.String r1 = "maxPerc"
            java.lang.Integer r2 = defpackage.dn.Y1
            r0.put(r1, r2)
            java.lang.String r1 = "smoothTime"
            java.lang.Integer r2 = defpackage.dn.a2
            r0.put(r1, r2)
            java.lang.String r1 = "hideCursor"
            java.lang.Boolean r2 = defpackage.dn.c2
            r0.put(r1, r2)
            java.lang.String r1 = "orientation"
            java.lang.String r2 = defpackage.dn.d2
            r0.put(r1, r2)
            java.lang.String r1 = "verticalPosition"
            java.lang.Integer r2 = defpackage.dn.g2
            r0.put(r1, r2)
            java.lang.String r1 = "mode"
            java.lang.String r2 = defpackage.dn.f2
            r0.put(r1, r2)
            boolean r1 = defpackage.dn.M2
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            java.lang.String r2 = "showBar"
            r0.put(r2, r1)
            defpackage.gh.J = r0
            l3 r3 = new l3
            java.lang.Boolean r12 = java.lang.Boolean.TRUE
            s1 r13 = new s1
            r0 = 4
            r13.<init>(r0)
            r14 = 0
            java.lang.Class<gh> r4 = defpackage.gh.class
            r5 = 2131951712(0x7f130060, float:1.9539846E38)
            r6 = 2131952007(0x7f130187, float:1.9540445E38)
            r7 = 2131951907(0x7f130123, float:1.9540242E38)
            r8 = 2131951726(0x7f13006e, float:1.9539875E38)
            r9 = 2131230984(0x7f080108, float:1.8078036E38)
            r10 = 31
            r11 = 4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            defpackage.gh.K = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.gh.<clinit>():void");
    }

    public gh() {
        this.u = lc1.A(App.c, K.iconId).getConstantState().newDrawable().mutate();
    }

    @Override // defpackage.de, defpackage.g1
    public final void g() {
        int iOrdinal = fh.valueOf((String) this.g.get("brightnessMode")).ordinal();
        this.E = iOrdinal == 0 ? Build.VERSION.SDK_INT >= 28 : iOrdinal != 1;
        if (!Settings.System.canWrite(App.c)) {
            yb0.y(R.string.action_require_write_settings_permission, 0);
        }
        this.F = (oq0.c((SharedPreferences) pn0.t().d, oq0.V0) != -2 ? r0 : 1) * 1.0f;
        int iC = oq0.c((SharedPreferences) pn0.t().d, oq0.W0);
        if (iC == -2) {
            iC = I;
        }
        float f = iC * 1.0f;
        this.G = f;
        this.H = f - this.F;
        super.g();
        si0.a("Device brightness min: " + this.F + ", max: " + this.G);
    }

    @Override // defpackage.de
    public final float m() {
        try {
            float f = (Settings.System.getInt(App.c.getContentResolver(), "screen_brightness") - this.F) / this.H;
            return this.E ? (float) Math.sqrt(f) : f;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    @Override // defpackage.de
    public final void n(float f) {
        boolean z = this.E;
        float f2 = this.F;
        float f3 = this.H;
        if (z) {
            f *= f;
        }
        final int i = (int) ((f * f3) + f2);
        this.D.a(new Runnable() { // from class: dh
            @Override // java.lang.Runnable
            public final void run() {
                int i2 = gh.I;
                Settings.System.putInt(App.c.getContentResolver(), "screen_brightness", i);
            }
        });
    }
}
