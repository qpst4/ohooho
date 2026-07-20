package defpackage;

import com.quickcursor.R;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class mh1 extends lh1 {
    public static final r71 N;
    public static final l3 O;

    static {
        r71 r71Var = new r71();
        r71Var.put("volumeMode", dn.T1);
        r71Var.put("swipeLength", Integer.valueOf(dn.N2));
        r71Var.put("showUI", dn.U1);
        r71Var.put("showBar", Boolean.valueOf(dn.K2));
        r71Var.put("maxPerc", dn.Z1);
        r71Var.put("smoothTime", dn.b2);
        r71Var.put("orientation", dn.e2);
        r71Var.put("verticalPosition", dn.g2);
        r71Var.put("granularity", dn.X1);
        r71Var.put("accessibilityStream", dn.i2);
        N = r71Var;
        O = new l3(mh1.class, R.string.action_category_settings, R.string.action_value_volume_swipe, R.string.action_title_volume_swipe, R.string.action_detail_volume_swipe, R.drawable.icon_action_volume_bar, 192, 8200, Boolean.TRUE, new ay0(17), null);
    }

    public mh1() {
        this.d = i3.instantOrDelayed;
    }
}
