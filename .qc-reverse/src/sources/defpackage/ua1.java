package defpackage;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.Preference;
import com.quickcursor.R;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.extra.design.TriggerActionsDesignActionIconActivity;
import com.quickcursor.android.activities.settings.fragments.triggermode.tabs.extra.design.TriggerActionsDesignPieActivity;
import com.quickcursor.android.preferences.ActionPickerPreference;
import com.quickcursor.android.preferences.DetailedListPreference;
import com.quickcursor.android.preferences.SeekBarDialogPreference;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class ua1 extends hr {
    public final bk j0;
    public final boolean k0;
    public final f91 l0;
    public final m91 m0;
    public DetailedListPreference n0;
    public DetailedListPreference o0;
    public DetailedListPreference p0;
    public ActionPickerPreference q0;
    public ActionPickerPreference r0;
    public qs s0;
    public final d30 t0;

    public ua1(f91 f91Var) {
        super(R.xml.preferences_triggers_actions);
        this.j0 = new bk(200L);
        this.t0 = (d30) Y(new sa1(this, 0), new f4(2));
        boolean z = f91Var != null;
        this.k0 = z;
        this.m0 = z ? f91Var.b() : xv0.d.a().l().g(0).b();
        if (z) {
            this.l0 = f91Var;
            return;
        }
        for (f91 f91Var2 : xv0.d.a().l().l()) {
            this.l0 = f91Var2;
            f91Var2.i(this.m0);
        }
    }

    public static String p0(List list) {
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            h91 h91Var = (h91) it.next();
            if (h91Var.b() != n3.nothing) {
                sb.append(lc1.K(h91Var.b().titleId));
                sb.append(", ");
            }
        }
        return sb.length() <= 2 ? lc1.K(R.string.trigger_actions_swipe_actions_nothing_selected) : sb.substring(0, sb.length() - 2);
    }

    @Override // defpackage.j30
    public final void L() {
        this.F = true;
        r60.o = null;
    }

    @Override // defpackage.hr, defpackage.j30
    public final void R() {
        super.R();
        Preference preferenceH0 = h0("shortActions");
        m91 m91Var = this.m0;
        preferenceH0.E(p0(m91Var.k()));
        h0("longActions").E(p0(m91Var.f()));
        q0();
    }

    @Override // defpackage.hr, defpackage.gq0
    public final void i0(String str, Bundle bundle) {
        super.i0(str, bundle);
        this.n0 = (DetailedListPreference) h0("mode");
        this.o0 = (DetailedListPreference) h0("design");
        this.p0 = (DetailedListPreference) h0("defaultTrigger");
        this.q0 = (ActionPickerPreference) h0("tapAction");
        ActionPickerPreference actionPickerPreference = (ActionPickerPreference) h0("longTapAction");
        this.r0 = actionPickerPreference;
        ActionPickerPreference actionPickerPreference2 = this.q0;
        actionPickerPreference2.P = new pn0(this, 11, actionPickerPreference2);
        actionPickerPreference.P = new pn0(this, 11, actionPickerPreference);
        final int i = 2;
        actionPickerPreference2.g = new sa1(this, i);
        actionPickerPreference.g = new sa1(this, 3);
        m91 m91Var = this.m0;
        actionPickerPreference2.K(m91Var.n());
        this.r0.K(m91Var.h());
        int iMax = Math.max(ey0.d, ey0.e) / 2;
        ((SeekBarDialogPreference) h0("swipeThreshold")).Z = ey0.a(20);
        ((SeekBarDialogPreference) h0("swipeThreshold")).c0 = iMax / 2;
        ((SeekBarDialogPreference) h0("swipeThreshold")).b0 = ey0.a(50);
        ((SeekBarDialogPreference) h0("shortSwipeSize")).c0 = iMax;
        ((SeekBarDialogPreference) h0("shortSwipeSize")).b0 = ey0.a(60);
        ((SeekBarDialogPreference) h0("longSwipeSize")).c0 = iMax;
        ((SeekBarDialogPreference) h0("longSwipeSize")).b0 = ey0.a(60);
        h0("shortActions").g = new sa1(this, 4);
        h0("longActions").g = new sa1(this, 5);
        final int i2 = 0;
        this.n0.e0 = new Runnable(this) { // from class: ta1
            public final /* synthetic */ ua1 c;

            {
                this.c = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i3 = i2;
                ua1 ua1Var = this.c;
                switch (i3) {
                    case 0:
                        ua1Var.h0(ua1Var.m0.u() ? "pieSinglePresets" : "pieMultiPresets").w();
                        break;
                    case 1:
                        ua1Var.h0("defaultTriggerDelay").w();
                        break;
                    default:
                        f91 f91Var = ua1Var.l0;
                        boolean z = ua1Var.k0;
                        m91 m91Var2 = ua1Var.m0;
                        if (m91Var2.r()) {
                            Intent intent = new Intent(ua1Var.u(), (Class<?>) TriggerActionsDesignPieActivity.class);
                            intent.putExtra("triggerIndex", z ? xv0.d.a().d().c().indexOf(f91Var) : -1);
                            ua1Var.f0(intent);
                        } else if (m91Var2.p()) {
                            Intent intent2 = new Intent(ua1Var.u(), (Class<?>) TriggerActionsDesignActionIconActivity.class);
                            intent2.putExtra("triggerIndex", z ? xv0.d.a().d().c().indexOf(f91Var) : -1);
                            ua1Var.f0(intent2);
                        }
                        break;
                }
            }
        };
        final int i3 = 1;
        this.p0.e0 = new Runnable(this) { // from class: ta1
            public final /* synthetic */ ua1 c;

            {
                this.c = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i32 = i3;
                ua1 ua1Var = this.c;
                switch (i32) {
                    case 0:
                        ua1Var.h0(ua1Var.m0.u() ? "pieSinglePresets" : "pieMultiPresets").w();
                        break;
                    case 1:
                        ua1Var.h0("defaultTriggerDelay").w();
                        break;
                    default:
                        f91 f91Var = ua1Var.l0;
                        boolean z = ua1Var.k0;
                        m91 m91Var2 = ua1Var.m0;
                        if (m91Var2.r()) {
                            Intent intent = new Intent(ua1Var.u(), (Class<?>) TriggerActionsDesignPieActivity.class);
                            intent.putExtra("triggerIndex", z ? xv0.d.a().d().c().indexOf(f91Var) : -1);
                            ua1Var.f0(intent);
                        } else if (m91Var2.p()) {
                            Intent intent2 = new Intent(ua1Var.u(), (Class<?>) TriggerActionsDesignActionIconActivity.class);
                            intent2.putExtra("triggerIndex", z ? xv0.d.a().d().c().indexOf(f91Var) : -1);
                            ua1Var.f0(intent2);
                        }
                        break;
                }
            }
        };
        this.o0.e0 = new Runnable(this) { // from class: ta1
            public final /* synthetic */ ua1 c;

            {
                this.c = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i32 = i;
                ua1 ua1Var = this.c;
                switch (i32) {
                    case 0:
                        ua1Var.h0(ua1Var.m0.u() ? "pieSinglePresets" : "pieMultiPresets").w();
                        break;
                    case 1:
                        ua1Var.h0("defaultTriggerDelay").w();
                        break;
                    default:
                        f91 f91Var = ua1Var.l0;
                        boolean z = ua1Var.k0;
                        m91 m91Var2 = ua1Var.m0;
                        if (m91Var2.r()) {
                            Intent intent = new Intent(ua1Var.u(), (Class<?>) TriggerActionsDesignPieActivity.class);
                            intent.putExtra("triggerIndex", z ? xv0.d.a().d().c().indexOf(f91Var) : -1);
                            ua1Var.f0(intent);
                        } else if (m91Var2.p()) {
                            Intent intent2 = new Intent(ua1Var.u(), (Class<?>) TriggerActionsDesignActionIconActivity.class);
                            intent2.putExtra("triggerIndex", z ? xv0.d.a().d().c().indexOf(f91Var) : -1);
                            ua1Var.f0(intent2);
                        }
                        break;
                }
            }
        };
        q0();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // defpackage.hr
    public final void m0(SharedPreferences sharedPreferences, String str) {
        if (str == null) {
            return;
        }
        boolean zEquals = str.equals("pieSinglePresets");
        f91 f91Var = this.l0;
        m91 m91Var = this.m0;
        if (!zEquals && !str.equals("pieMultiPresets")) {
            switch (str) {
                case "shortSwipeSize":
                    m91Var.M(sharedPreferences.getInt(str, 0));
                    break;
                case "actionVibration":
                    m91Var.F(sharedPreferences.getBoolean(str, true));
                    break;
                case "design":
                    m91Var.I(k91.valueOf(sharedPreferences.getString(str, "")));
                    break;
                case "mode":
                    m91Var.L(l91.valueOf(sharedPreferences.getString(str, "")));
                    break;
                case "longSwipeSize":
                    m91Var.J(sharedPreferences.getInt(str, 0));
                    break;
                case "defaultTriggerDelay":
                    m91Var.H(sharedPreferences.getInt(str, 0));
                    break;
                case "swipeThreshold":
                    m91Var.N(sharedPreferences.getInt(str, 0));
                    break;
                case "defaultTrigger":
                    m91Var.G(i3.valueOf(sharedPreferences.getString(str, "")));
                    break;
            }
            if (Arrays.asList("mode", "swipeThreshold", "shortSwipeSize", "longSwipeSize").contains(str)) {
                if (m91Var.s()) {
                    r60.o = null;
                } else {
                    r60.i(f91Var);
                }
            }
            q0();
            this.j0.a(new s4(24));
            return;
        }
        String string = sharedPreferences.getString(str, "");
        string.getClass();
        switch (string.hashCode()) {
            case -1407064543:
                if (string.equals("longNavigationAndNotifications")) {
                }
                break;
            case -1200330292:
                if (string.equals("shortNotifications")) {
                }
                break;
            case -1167907807:
                if (string.equals("shortNavigationAndNotifications")) {
                }
                break;
            case -795754064:
                if (string.equals("longNavigation")) {
                }
                break;
            case -642623662:
                if (string.equals("longTools1")) {
                }
                break;
            case -642623661:
                if (string.equals("longTools2")) {
                }
                break;
            case 778578020:
                if (string.equals("shortBrightnessAndVolume")) {
                }
                break;
            case 981374290:
                if (string.equals("shortTools1")) {
                }
                break;
            case 981374291:
                byte b = string.equals("shortTools2") ? (byte) 8 : (byte) 9;
                break;
            case 1427046320:
                if (string.equals("shortNavigation")) {
                }
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
            Method dump skipped, instruction units count: 570
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ua1.m0(android.content.SharedPreferences, java.lang.String):void");
    }

    @Override // defpackage.hr
    public final void o0(SharedPreferences.Editor editor) {
        m91 m91Var = this.m0;
        editor.putString("mode", m91Var.i().name());
        editor.putString("design", m91Var.e().name());
        editor.putInt("swipeThreshold", m91Var.m());
        editor.putInt("shortSwipeSize", m91Var.l());
        editor.putInt("longSwipeSize", m91Var.g());
        editor.putBoolean("actionVibration", m91Var.o());
        editor.putString("defaultTrigger", m91Var.c().name());
        editor.putInt("defaultTriggerDelay", m91Var.d());
    }

    public final void q0() {
        Preference preferenceH0 = h0("offCategory");
        m91 m91Var = this.m0;
        preferenceH0.F(m91Var.s());
        h0("swipeCategory").F(!m91Var.s());
        h0("swipeCategoryMore").F(!m91Var.s());
        h0("longActions").F(m91Var.t());
        h0("longSwipeSize").F(m91Var.t());
        this.q0.K(m91Var.n());
        this.r0.K(m91Var.h());
        Integer numValueOf = null;
        this.n0.O(m91Var.s() ? null : Integer.valueOf(R.drawable.icon_presets));
        this.o0.O(m91Var.q() ? null : Integer.valueOf(R.drawable.icon_settings));
        DetailedListPreference detailedListPreference = this.p0;
        Iterator it = m91Var.k().iterator();
        while (true) {
            if (!it.hasNext()) {
                Iterator it2 = m91Var.f().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        if (m91Var.c() == i3.delayed) {
                            break;
                        }
                    } else if (((h91) it2.next()).a() == i3.delayed) {
                        break;
                    }
                }
            } else if (((h91) it.next()).a() == i3.delayed) {
                break;
            }
        }
        numValueOf = Integer.valueOf(R.drawable.icon_time);
        detailedListPreference.O(numValueOf);
    }
}
