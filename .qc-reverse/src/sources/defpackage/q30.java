package defpackage;

import android.util.Log;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class q30 implements e4 {
    public final /* synthetic */ int b;
    public final /* synthetic */ y30 c;

    public /* synthetic */ q30(y30 y30Var, int i) {
        this.b = i;
        this.c = y30Var;
    }

    @Override // defpackage.e4
    public final void b(Object obj) {
        int i = this.b;
        y30 y30Var = this.c;
        switch (i) {
            case 0:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    iArr[i2] = ((Boolean) arrayList.get(i2)).booleanValue() ? 0 : -1;
                }
                v30 v30Var = (v30) y30Var.C.pollFirst();
                if (v30Var == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                } else {
                    String str = v30Var.b;
                    int i3 = v30Var.c;
                    j30 j30VarH = y30Var.c.h(str);
                    if (j30VarH == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str);
                    } else {
                        j30VarH.Q(i3, strArr, iArr);
                    }
                }
                break;
            case 1:
                d4 d4Var = (d4) obj;
                v30 v30Var2 = (v30) y30Var.C.pollFirst();
                if (v30Var2 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                } else {
                    String str2 = v30Var2.b;
                    int i4 = v30Var2.c;
                    j30 j30VarH2 = y30Var.c.h(str2);
                    if (j30VarH2 == null) {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str2);
                    } else {
                        j30VarH2.H(i4, d4Var.b, d4Var.c);
                    }
                }
                break;
            default:
                d4 d4Var2 = (d4) obj;
                v30 v30Var3 = (v30) y30Var.C.pollFirst();
                if (v30Var3 == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                } else {
                    String str3 = v30Var3.b;
                    int i5 = v30Var3.c;
                    j30 j30VarH3 = y30Var.c.h(str3);
                    if (j30VarH3 == null) {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str3);
                    } else {
                        j30VarH3.H(i5, d4Var2.b, d4Var2.c);
                    }
                }
                break;
        }
    }
}
