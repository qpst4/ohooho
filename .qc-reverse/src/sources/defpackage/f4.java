package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f4 extends f01 {
    public final /* synthetic */ int m;

    public /* synthetic */ f4(int i) {
        this.m = i;
    }

    @Override // defpackage.f01
    public m0 B(Context context, Object obj) {
        switch (this.m) {
            case 0:
                ((String) obj).getClass();
                return null;
            case 1:
                String[] strArr = (String[]) obj;
                strArr.getClass();
                if (strArr.length == 0) {
                    return new m0(py.b);
                }
                for (String str : strArr) {
                    if (xy0.f(context, str) != 0) {
                        return null;
                    }
                }
                int iL = gj0.L(strArr.length);
                if (iL < 16) {
                    iL = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iL);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new m0(linkedHashMap);
            case 2:
            case 3:
            default:
                return super.B(context, obj);
            case 4:
                ((Uri) obj).getClass();
                return null;
        }
    }

    @Override // defpackage.f01
    public final Object K(Intent intent, int i) {
        switch (this.m) {
            case 0:
                if (i != -1) {
                    intent = null;
                }
                if (intent != null) {
                    return intent.getData();
                }
                return null;
            case 1:
                if (i == -1 && intent != null) {
                    String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null && stringArrayExtra != null) {
                        ArrayList arrayList = new ArrayList(intArrayExtra.length);
                        for (int i2 : intArrayExtra) {
                            arrayList.add(Boolean.valueOf(i2 == 0));
                        }
                        ArrayList arrayList2 = new ArrayList();
                        for (String str : stringArrayExtra) {
                            if (str != null) {
                                arrayList2.add(str);
                            }
                        }
                        Iterator it = arrayList2.iterator();
                        Iterator it2 = arrayList.iterator();
                        ArrayList arrayList3 = new ArrayList(Math.min(ll.L0(arrayList2), ll.L0(arrayList)));
                        while (it.hasNext() && it2.hasNext()) {
                            arrayList3.add(new bp0(it.next(), it2.next()));
                        }
                        return gj0.M(arrayList3);
                    }
                }
                return py.b;
            case 2:
                return new d4(intent, i);
            case 3:
                return new d4(intent, i);
            case 4:
                return Boolean.valueOf(i == -1);
            default:
                return new d4(intent, i);
        }
    }

    @Override // defpackage.f01
    public final Intent s(Context context, Object obj) {
        Bundle bundleExtra;
        switch (this.m) {
            case 0:
                String str = (String) obj;
                str.getClass();
                Intent type = new Intent("android.intent.action.GET_CONTENT").addCategory("android.intent.category.OPENABLE").setType(str);
                type.getClass();
                return type;
            case 1:
                String[] strArr = (String[]) obj;
                strArr.getClass();
                Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
                intentPutExtra.getClass();
                return intentPutExtra;
            case 2:
                Intent intent = (Intent) obj;
                intent.getClass();
                return intent;
            case 3:
                cc0 cc0Var = (cc0) obj;
                cc0Var.getClass();
                Intent intentPutExtra2 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", cc0Var);
                intentPutExtra2.getClass();
                return intentPutExtra2;
            case 4:
                Uri uri = (Uri) obj;
                uri.getClass();
                Intent intentPutExtra3 = new Intent("android.media.action.IMAGE_CAPTURE").putExtra("output", uri);
                intentPutExtra3.getClass();
                return intentPutExtra3;
            default:
                cc0 cc0Var2 = (cc0) obj;
                Intent intent2 = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent3 = cc0Var2.c;
                if (intent3 != null && (bundleExtra = intent3.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent2.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent3.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent3.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        IntentSender intentSender = cc0Var2.b;
                        intentSender.getClass();
                        cc0Var2 = new cc0(intentSender, null, cc0Var2.d, cc0Var2.e);
                    }
                }
                intent2.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", cc0Var2);
                if (y30.I(2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent2);
                }
                return intent2;
        }
    }
}
