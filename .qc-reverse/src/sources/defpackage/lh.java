package defpackage;

import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class lh extends gh {
    public static final wa L;
    public static final l3 M;

    static {
        wa waVar = new wa();
        waVar.put("brightnessMode", dn.p2);
        waVar.put("swipeLength", Integer.valueOf(dn.N2));
        waVar.put("showBar", Boolean.valueOf(dn.M2));
        waVar.put("maxPerc", dn.Z1);
        waVar.put("smoothTime", dn.b2);
        waVar.put("orientation", dn.e2);
        waVar.put("verticalPosition", dn.g2);
        L = waVar;
        M = new l3(lh.class, R.string.action_category_settings, R.string.action_value_brightness_swipe, R.string.action_title_brightness_swipe, R.string.action_detail_brightness_swipe, R.drawable.icon_action_brightness_bar, 192, 8196, Boolean.TRUE, new s1(5), null);
    }

    public lh() {
        this.d = i3.instantOrDelayed;
    }
}
