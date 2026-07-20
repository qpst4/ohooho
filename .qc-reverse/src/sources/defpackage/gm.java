package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class gm implements co0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ pm b;

    public /* synthetic */ gm(pm pmVar, int i) {
        this.a = i;
        this.b = pmVar;
    }

    @Override // defpackage.co0
    public final void a(pm pmVar) {
        int i = this.a;
        pm pmVar2 = this.b;
        switch (i) {
            case 0:
                pmVar.getClass();
                Bundle bundleC = ((e8) pmVar2.e.c).c("android:support:activity-result");
                if (bundleC != null) {
                    mm mmVar = pmVar2.j;
                    LinkedHashMap linkedHashMap = mmVar.b;
                    LinkedHashMap linkedHashMap2 = mmVar.a;
                    Bundle bundle = mmVar.g;
                    ArrayList<Integer> integerArrayList = bundleC.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
                    ArrayList<String> stringArrayList = bundleC.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
                    if (stringArrayList == null || integerArrayList == null) {
                        return;
                    }
                    ArrayList<String> stringArrayList2 = bundleC.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
                    if (stringArrayList2 != null) {
                        mmVar.d.addAll(stringArrayList2);
                    }
                    Bundle bundle2 = bundleC.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
                    if (bundle2 != null) {
                        bundle.putAll(bundle2);
                    }
                    int size = stringArrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = stringArrayList.get(i2);
                        if (linkedHashMap.containsKey(str)) {
                            Integer num = (Integer) linkedHashMap.remove(str);
                            if (bundle.containsKey(str)) {
                                continue;
                            } else {
                                if (linkedHashMap2 instanceof ce0) {
                                    lc1.r0("kotlin.collections.MutableMap", linkedHashMap2);
                                    throw null;
                                }
                                linkedHashMap2.remove(num);
                            }
                        }
                        Integer num2 = integerArrayList.get(i2);
                        num2.getClass();
                        int iIntValue = num2.intValue();
                        String str2 = stringArrayList.get(i2);
                        str2.getClass();
                        String str3 = str2;
                        linkedHashMap2.put(Integer.valueOf(iIntValue), str3);
                        mmVar.b.put(str3, Integer.valueOf(iIntValue));
                    }
                    return;
                }
                return;
            default:
                l30 l30Var = (l30) ((z7) pmVar2).u.c;
                l30Var.p.b(l30Var, l30Var, null);
                return;
        }
    }
}
