package defpackage;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class qq0 {
    public static final void a(View view, int i) {
        int iR = l11.r(i);
        if (iR == 0) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (y30.I(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (iR == 1) {
            if (y30.I(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            view.setVisibility(0);
            return;
        }
        if (iR == 2) {
            if (y30.I(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (iR != 3) {
            return;
        }
        if (y30.I(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    public static Number b(int i, vd0 vd0Var) {
        if (i == 1) {
            return Double.valueOf(vd0Var.z());
        }
        if (i == 2) {
            return new sf0(vd0Var.G());
        }
        if (i == 3) {
            String strG = vd0Var.G();
            if (strG.indexOf(46) >= 0) {
                return e(strG, vd0Var);
            }
            try {
                return Long.valueOf(Long.parseLong(strG));
            } catch (NumberFormatException unused) {
                return e(strG, vd0Var);
            }
        }
        String strG2 = vd0Var.G();
        try {
            return tk0.w(strG2);
        } catch (NumberFormatException e) {
            StringBuilder sbM = l11.m("Cannot parse ", strG2, "; at path ");
            sbM.append(vd0Var.u());
            throw new cm(sbM.toString(), e);
        }
    }

    public static int c(int i) {
        if (i == 0) {
            return 2;
        }
        if (i == 4) {
            return 4;
        }
        if (i == 8) {
            return 3;
        }
        zy.n(i("Unknown visibility ", i));
        return 0;
    }

    public static int d(View view) {
        if (view.getAlpha() == 0.0f && view.getVisibility() == 0) {
            return 4;
        }
        return c(view.getVisibility());
    }

    public static Double e(String str, vd0 vd0Var) throws ej0 {
        try {
            Double dValueOf = Double.valueOf(str);
            if (dValueOf.isInfinite() || dValueOf.isNaN()) {
                boolean z = true;
                if (vd0Var.p != 1) {
                    z = false;
                }
                if (!z) {
                    throw new ej0("JSON forbids NaN and infinities: " + dValueOf + "; at path " + vd0Var.u());
                }
            }
            return dValueOf;
        } catch (NumberFormatException e) {
            StringBuilder sbM = l11.m("Cannot parse ", str, "; at path ");
            sbM.append(vd0Var.u());
            throw new cm(sbM.toString(), e);
        }
    }

    public static int f(int i, int i2, int i3) {
        return zo1.q(i) + i2 + i3;
    }

    public static int g(int i, int i2, int i3, int i4) {
        return zo1.q(i) + i2 + i3 + i4;
    }

    public static String h(int i, int i2, String str, String str2) {
        return str + i + str2 + i2;
    }

    public static String i(String str, int i) {
        return str + i;
    }

    public static /* synthetic */ void j(Object obj) {
        if (obj == null) {
            return;
        }
        s1.d();
    }

    public static /* synthetic */ String k(int i) {
        switch (i) {
            case 1:
                return "design_quick_cursor";
            case 2:
                return "design_rounded_rectangle";
            case 3:
                return "design_squircle";
            case 4:
                return "design_fingerprint1";
            case 5:
                return "design_flower1";
            case 6:
                return "design_flower2";
            case 7:
                return "design_flower3";
            case 8:
                return "design_airplane1";
            case 9:
                return "design_airplane2";
            case 10:
                return "design_airplane3";
            case 11:
                return "design_android";
            case 12:
                return "design_donut";
            case 13:
                return "design_sports1";
            case 14:
                return "design_sports2";
            case 15:
                return "design_sports3";
            case 16:
                return "design_yin_yang";
            case 17:
                return "design_cd";
            case 18:
                return "design_floppy_disk";
            case 19:
                return "design_ghost";
            case 20:
                return "design_watermelon";
            case 21:
                return "custom";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String l(int i) {
        if (i == 1) {
            return "Portrait";
        }
        if (i == 2) {
            return "Landscape";
        }
        if (i == 3) {
            return "Unknown";
        }
        throw null;
    }

    public static /* synthetic */ String m(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "null" : "REMOVING" : "ADDING" : "NONE";
    }

    public static /* synthetic */ String n(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED";
    }

    public static /* synthetic */ int o(String str) {
        if (str == null) {
            zy.r("Name is null");
            return 0;
        }
        if (str.equals("nothing")) {
            return 1;
        }
        if (str.equals("raise")) {
            return 2;
        }
        if (str.equals("hide")) {
            return 3;
        }
        zy.n("No enum constant com.quickcursor.repositories.PreferencesRepository.KeyboardTrackerHandle.".concat(str));
        return 0;
    }

    public static /* synthetic */ int p(String str) {
        if (str == null) {
            zy.r("Name is null");
            return 0;
        }
        if (str.equals("nothing")) {
            return 1;
        }
        if (str.equals("raise")) {
            return 2;
        }
        if (str.equals("thinner")) {
            return 3;
        }
        if (str.equals("disable")) {
            return 4;
        }
        zy.n("No enum constant com.quickcursor.repositories.PreferencesRepository.KeyboardTriggersHandle.".concat(str));
        return 0;
    }

    public static /* synthetic */ int q(String str) {
        if (str == null) {
            zy.r("Name is null");
            return 0;
        }
        if (str.equals("design_quick_cursor")) {
            return 1;
        }
        if (str.equals("design_rounded_rectangle")) {
            return 2;
        }
        if (str.equals("design_squircle")) {
            return 3;
        }
        if (str.equals("design_fingerprint1")) {
            return 4;
        }
        if (str.equals("design_flower1")) {
            return 5;
        }
        if (str.equals("design_flower2")) {
            return 6;
        }
        if (str.equals("design_flower3")) {
            return 7;
        }
        if (str.equals("design_airplane1")) {
            return 8;
        }
        if (str.equals("design_airplane2")) {
            return 9;
        }
        if (str.equals("design_airplane3")) {
            return 10;
        }
        if (str.equals("design_android")) {
            return 11;
        }
        if (str.equals("design_donut")) {
            return 12;
        }
        if (str.equals("design_sports1")) {
            return 13;
        }
        if (str.equals("design_sports2")) {
            return 14;
        }
        if (str.equals("design_sports3")) {
            return 15;
        }
        if (str.equals("design_yin_yang")) {
            return 16;
        }
        if (str.equals("design_cd")) {
            return 17;
        }
        if (str.equals("design_floppy_disk")) {
            return 18;
        }
        if (str.equals("design_ghost")) {
            return 19;
        }
        if (str.equals("design_watermelon")) {
            return 20;
        }
        if (str.equals("custom")) {
            return 21;
        }
        zy.n("No enum constant com.quickcursor.repositories.PreferencesRepository.TrackerDesign.".concat(str));
        return 0;
    }

    public static /* synthetic */ int r(String str) {
        if (str == null) {
            zy.r("Name is null");
            return 0;
        }
        if (str.equals("off")) {
            return 1;
        }
        if (str.equals("low")) {
            return 2;
        }
        if (str.equals("high")) {
            return 3;
        }
        zy.n("No enum constant com.quickcursor.repositories.PreferencesRepository.TrailType.".concat(str));
        return 0;
    }
}
