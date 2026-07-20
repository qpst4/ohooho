package defpackage;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class mm {
    public final LinkedHashMap a = new LinkedHashMap();
    public final LinkedHashMap b = new LinkedHashMap();
    public final LinkedHashMap c = new LinkedHashMap();
    public final ArrayList d = new ArrayList();
    public final transient LinkedHashMap e = new LinkedHashMap();
    public final LinkedHashMap f = new LinkedHashMap();
    public final Bundle g = new Bundle();
    public final /* synthetic */ pm h;

    public mm(pm pmVar) {
        this.h = pmVar;
    }

    public final boolean a(int i, int i2, Intent intent) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        i4 i4Var = (i4) this.e.get(str);
        if ((i4Var != null ? i4Var.a : null) != null) {
            ArrayList arrayList = this.d;
            if (arrayList.contains(str)) {
                i4Var.a.b(i4Var.b.K(intent, i2));
                arrayList.remove(str);
                return true;
            }
        }
        this.f.remove(str);
        this.g.putParcelable(str, new d4(intent, i2));
        return true;
    }

    public final void b(int i, f01 f01Var, Object obj) {
        Bundle bundleExtra;
        int i2;
        pm pmVar = this.h;
        m0 m0VarB = f01Var.B(pmVar, obj);
        if (m0VarB != null) {
            new Handler(Looper.getMainLooper()).post(new lm(i, 0, this, m0VarB));
            return;
        }
        Intent intentS = f01Var.s(pmVar, obj);
        if (intentS.getExtras() != null) {
            Bundle extras = intentS.getExtras();
            extras.getClass();
            if (extras.getClassLoader() == null) {
                intentS.setExtrasClassLoader(pmVar.getClassLoader());
            }
        }
        if (intentS.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            bundleExtra = intentS.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentS.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
        } else {
            bundleExtra = null;
        }
        Bundle bundle = bundleExtra;
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentS.getAction())) {
            String[] stringArrayExtra = intentS.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            xy0.z(pmVar, stringArrayExtra, i);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentS.getAction())) {
            pmVar.startActivityForResult(intentS, i, bundle);
            return;
        }
        cc0 cc0Var = (cc0) intentS.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            cc0Var.getClass();
            i2 = i;
        } catch (IntentSender.SendIntentException e) {
            e = e;
            i2 = i;
        }
        try {
            pmVar.startIntentSenderForResult(cc0Var.b, i2, cc0Var.c, cc0Var.d, cc0Var.e, 0, bundle);
        } catch (IntentSender.SendIntentException e2) {
            e = e2;
            new Handler(Looper.getMainLooper()).post(new lm(i2, 1, this, e));
        }
    }

    public final k4 c(final String str, gg0 gg0Var, final f01 f01Var, final e4 e4Var) {
        a aVarP = gg0Var.p();
        if (aVarP.c.compareTo(zf0.e) >= 0) {
            StringBuilder sb = new StringBuilder("LifecycleOwner ");
            sb.append(gg0Var);
            zf0 zf0Var = aVarP.c;
            sb.append(" is attempting to register while current state is ");
            sb.append(zf0Var);
            sb.append(". LifecycleOwners must call register before they are STARTED.");
            throw new IllegalStateException(sb.toString().toString());
        }
        e(str);
        LinkedHashMap linkedHashMap = this.c;
        j4 j4Var = (j4) linkedHashMap.get(str);
        if (j4Var == null) {
            j4Var = new j4(aVarP);
        }
        dg0 dg0Var = new dg0() { // from class: h4
            @Override // defpackage.dg0
            public final void c(gg0 gg0Var2, yf0 yf0Var) {
                mm mmVar = this.b;
                Bundle bundle = mmVar.g;
                LinkedHashMap linkedHashMap2 = mmVar.e;
                LinkedHashMap linkedHashMap3 = mmVar.f;
                yf0 yf0Var2 = yf0.ON_START;
                String str2 = str;
                if (yf0Var2 != yf0Var) {
                    if (yf0.ON_STOP == yf0Var) {
                        linkedHashMap2.remove(str2);
                        return;
                    } else {
                        if (yf0.ON_DESTROY == yf0Var) {
                            mmVar.f(str2);
                            return;
                        }
                        return;
                    }
                }
                e4 e4Var2 = e4Var;
                f01 f01Var2 = f01Var;
                linkedHashMap2.put(str2, new i4(e4Var2, f01Var2));
                if (linkedHashMap3.containsKey(str2)) {
                    Object obj = linkedHashMap3.get(str2);
                    linkedHashMap3.remove(str2);
                    e4Var2.b(obj);
                }
                d4 d4Var = (d4) tk0.l(str2, bundle);
                if (d4Var != null) {
                    bundle.remove(str2);
                    e4Var2.b(f01Var2.K(d4Var.c, d4Var.b));
                }
            }
        };
        j4Var.a.a(dg0Var);
        j4Var.b.add(dg0Var);
        linkedHashMap.put(str, j4Var);
        return new k4(this, str, f01Var, 0);
    }

    public final k4 d(String str, f01 f01Var, e4 e4Var) {
        e(str);
        this.e.put(str, new i4(e4Var, f01Var));
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            Object obj = linkedHashMap.get(str);
            linkedHashMap.remove(str);
            e4Var.b(obj);
        }
        Bundle bundle = this.g;
        d4 d4Var = (d4) tk0.l(str, bundle);
        if (d4Var != null) {
            bundle.remove(str);
            e4Var.b(f01Var.K(d4Var.c, d4Var.b));
        }
        return new k4(this, str, f01Var, 1);
    }

    public final void e(String str) {
        LinkedHashMap linkedHashMap = this.b;
        if (((Integer) linkedHashMap.get(str)) != null) {
            return;
        }
        for (Number number : new fn(new y50(0, new fp(1, 1)))) {
            Integer numValueOf = Integer.valueOf(number.intValue());
            LinkedHashMap linkedHashMap2 = this.a;
            if (!linkedHashMap2.containsKey(numValueOf)) {
                int iIntValue = number.intValue();
                linkedHashMap2.put(Integer.valueOf(iIntValue), str);
                linkedHashMap.put(str, Integer.valueOf(iIntValue));
                return;
            }
        }
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public final void f(String str) {
        Integer num;
        if (!this.d.contains(str) && (num = (Integer) this.b.remove(str)) != null) {
            this.a.remove(num);
        }
        this.e.remove(str);
        LinkedHashMap linkedHashMap = this.f;
        if (linkedHashMap.containsKey(str)) {
            StringBuilder sbM = l11.m("Dropping pending result for request ", str, ": ");
            sbM.append(linkedHashMap.get(str));
            Log.w("ActivityResultRegistry", sbM.toString());
            linkedHashMap.remove(str);
        }
        Bundle bundle = this.g;
        if (bundle.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + ((d4) tk0.l(str, bundle)));
            bundle.remove(str);
        }
        LinkedHashMap linkedHashMap2 = this.c;
        j4 j4Var = (j4) linkedHashMap2.get(str);
        if (j4Var != null) {
            ArrayList arrayList = j4Var.b;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                j4Var.a.f((dg0) obj);
            }
            arrayList.clear();
            linkedHashMap2.remove(str);
        }
    }
}
