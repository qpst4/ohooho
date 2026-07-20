package defpackage;

import android.provider.Settings;
import android.view.WindowManager;
import com.quickcursor.R;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class cy0 extends g1 {
    public static final wi0 k;
    public static final l3 l;

    static {
        wi0 wi0Var = new wi0();
        wi0Var.put("rotationMode", dn.y2);
        wi0Var.put("rotations", "0,1");
        k = wi0Var;
        l = new l3(cy0.class, R.string.action_category_settings, R.string.action_value_screen_rotate, R.string.action_title_screen_rotate, R.string.action_detail_screen_rotate, R.drawable.icon_action_screen_rotate, 511, 4, Boolean.TRUE, new ay0(0), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.util.ArrayList] */
    @Override // defpackage.g1
    public final void g() {
        ?? AsList;
        by0 by0VarValueOf = by0.valueOf((String) this.g.getOrDefault("rotationMode", dn.y2));
        try {
            String[] strArrSplit = ((String) this.g.get("rotations")).split(",");
            AsList = new ArrayList();
            for (String str : strArrSplit) {
                if (str.length() > 0) {
                    AsList.add(Integer.valueOf(Integer.parseInt(str)));
                }
            }
        } catch (Exception unused) {
            AsList = Arrays.asList(0, 1);
        }
        if (by0VarValueOf != by0.settings) {
            int currentRotation = zx0.getCurrentRotation();
            int iIntValue = ((Integer) AsList.get(0)).intValue();
            for (int i = 0; i < AsList.size() - 1; i++) {
                if (currentRotation == ((Integer) AsList.get(i)).intValue()) {
                    iIntValue = ((Integer) AsList.get(i + 1)).intValue();
                }
            }
            zx0.a(iIntValue);
            return;
        }
        int rotation = ((WindowManager) this.f.getSystemService("window")).getDefaultDisplay().getRotation();
        int iIntValue2 = ((Integer) AsList.get(0)).intValue();
        for (int i2 = 0; i2 < AsList.size() - 1; i2++) {
            if (rotation == ((Integer) AsList.get(i2)).intValue()) {
                iIntValue2 = ((Integer) AsList.get(i2 + 1)).intValue();
            }
        }
        Settings.System.putInt(this.f.getContentResolver(), "accelerometer_rotation", 0);
        Settings.System.putInt(this.f.getContentResolver(), "user_rotation", iIntValue2);
        if (zx0.d != null) {
            zx0.a(-1);
        }
    }
}
