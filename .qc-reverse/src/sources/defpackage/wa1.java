package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.preferences.DetailedListPreference;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import com.quickcursor.android.services.CursorAccessibilityService;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wa1 extends hr {
    public final bk j0;
    public final f91 k0;
    public final da1 l0;
    public DetailedListPreference m0;
    public final d30 n0;

    public wa1(f91 f91Var) {
        super(R.xml.preferences_triggers_design);
        this.j0 = new bk(200L);
        this.n0 = (d30) Y(new va1(this), new f4(2));
        boolean z = f91Var != null;
        this.l0 = z ? f91Var.d() : xv0.d.a().l().g(0).d();
        if (z) {
            this.k0 = f91Var;
            return;
        }
        for (f91 f91Var2 : xv0.d.a().l().l()) {
            this.k0 = f91Var2;
            f91Var2.k(this.l0);
        }
    }

    @Override // defpackage.hr, defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        super.i0(str, bundle);
        DetailedListPreference detailedListPreference = (DetailedListPreference) h0("type");
        this.m0 = detailedListPreference;
        detailedListPreference.e0 = new lk0(22, this);
        h0("customImagePicker").g = new va1(this);
        int iA = ey0.a(20);
        f91 f91Var = this.k0;
        int iMax = Math.max(iA, Math.min(f91Var.h().f(), f91Var.h().c()));
        int iCeil = (int) Math.ceil(iMax / 2.0f);
        int iMax2 = Math.max(ey0.a(10), iMax);
        int iMax3 = Math.max(ey0.a(20), iMax);
        ((SeekBarDialogPreference) h0("size")).c0 = iMax;
        ((SeekBarDialogPreference) h0("margin")).c0 = iMax;
        ((SeekBarDialogPreference) h0("cornerRadius")).c0 = iCeil;
        ((SeekBarDialogPreference) h0("borderSize")).c0 = iMax2;
        ((SeekBarDialogPreference) h0("glowSize")).c0 = iMax3;
        p0();
        fp1.o(this, Arrays.asList("type", "rectanglePreset"));
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // defpackage.hr
    public final void m0(SharedPreferences sharedPreferences, String str) {
        da1 da1Var = this.l0;
        if (str != null && str.equals("rectanglePreset")) {
            String string = sharedPreferences.getString(str, "");
            string.getClass();
            switch (string) {
                case "lineAndGlow":
                    da1Var.r();
                    break;
                case "bar":
                    da1Var.o();
                    break;
                case "glow":
                    da1Var.p();
                    break;
                case "line":
                    da1Var.q();
                    break;
                case "roundedRectangle":
                    da1Var.s(this.k0);
                    break;
            }
            if (oq0.a((SharedPreferences) pn0.t().d, oq0.S0)) {
                Context contextB = jv.b(u());
                int color = contextB.getResources().getColor(android.R.color.system_accent1_100, contextB.getTheme());
                da1Var.t(wl.f(color, 180));
                da1Var.u(wl.f(color, 180));
                da1Var.z(color);
            }
            n0();
            xv0.d.c();
            i0(null, null);
            CursorAccessibilityService.j();
            l0();
            return;
        }
        str.getClass();
        switch (str.hashCode()) {
            case -1081309778:
                if (!str.equals("margin")) {
                }
                break;
            case -522699986:
                if (!str.equals("glowSize")) {
                }
                break;
            case 3530753:
                if (!str.equals("size")) {
                }
                break;
            case 3575610:
                if (!str.equals("type")) {
                }
                break;
            case 461547914:
                if (!str.equals("cornerRadiusMode")) {
                }
                break;
            case 583595847:
                if (!str.equals("cornerRadius")) {
                }
                break;
            case 722830999:
                if (!str.equals("borderColor")) {
                }
                break;
            case 961558998:
                if (!str.equals("glowColor")) {
                }
                break;
            case 1287124693:
                if (!str.equals("backgroundColor")) {
                }
                break;
            case 1824903757:
                if (!str.equals("borderSize")) {
                }
                break;
            default:
                break;
        }
        /*  JADX ERROR: Method code generation error
            java.lang.NullPointerException: Switch insn not found in header
            	at java.base/java.util.Objects.requireNonNull(Objects.java:259)
            	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
            	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:88)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:305)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:284)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:412)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:337)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:303)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            */
        /*
            Method dump skipped, instruction units count: 524
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.wa1.m0(android.content.SharedPreferences, java.lang.String):void");
    }

    @Override // defpackage.hr
    public final void o0(SharedPreferences.Editor editor) {
        da1 da1Var = this.l0;
        editor.putString("type", da1Var.l().name());
        editor.putString("cornerRadiusMode", da1Var.f().name());
        si0.b("Color: " + da1Var.b());
        editor.putInt("size", da1Var.k());
        editor.putInt("margin", da1Var.j());
        editor.putInt("backgroundColor", da1Var.b());
        editor.putInt("cornerRadius", da1Var.e());
        editor.putInt("borderSize", da1Var.d());
        editor.putInt("borderColor", da1Var.c());
        editor.putInt("glowSize", da1Var.i());
        editor.putInt("glowColor", da1Var.h());
    }

    public final void p0() {
        Preference preferenceH0 = h0("rectangleCategory");
        da1 da1Var = this.l0;
        preferenceH0.F(da1Var.l() == ca1.rectangle);
        h0("customImageCategory").F(da1Var.l() == ca1.custom);
        this.m0.O(da1Var.n() ? Integer.valueOf(R.drawable.icon_presets) : null);
    }
}
