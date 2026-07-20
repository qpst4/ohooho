package defpackage;

import android.view.accessibility.AccessibilityNodeInfo;
import com.quickcursor.android.activities.settings.MissingPermissions;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d1 implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ n3 b;

    public /* synthetic */ d1(n3 n3Var, int i) {
        this.a = i;
        this.b = n3Var;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.a;
        n3 n3Var = this.b;
        switch (i) {
            case 0:
                return ((AccessibilityNodeInfo.AccessibilityAction) obj).getId() == ((Integer) n3Var.extras.get("GLOBAL_ACTION")).intValue();
            default:
                int i2 = MissingPermissions.D;
                return ((p2) obj).a.equals(n3Var);
        }
    }
}
