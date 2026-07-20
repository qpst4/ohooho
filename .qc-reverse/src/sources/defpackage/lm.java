package defpackage;

import android.content.Intent;
import android.content.IntentSender;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class lm implements Runnable {
    public final /* synthetic */ int b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ int d;
    public final /* synthetic */ Object e;

    public /* synthetic */ lm(int i, int i2, Object obj, Object obj2) {
        this.b = i2;
        this.c = obj;
        this.d = i;
        this.e = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.b;
        Object obj = this.e;
        int i2 = this.d;
        Object obj2 = this.c;
        switch (i) {
            case 0:
                mm mmVar = (mm) obj2;
                Object obj3 = ((m0) obj).b;
                String str = (String) mmVar.a.get(Integer.valueOf(i2));
                if (str != null) {
                    i4 i4Var = (i4) mmVar.e.get(str);
                    if ((i4Var != null ? i4Var.a : null) != null) {
                        e4 e4Var = i4Var.a;
                        if (mmVar.d.remove(str)) {
                            e4Var.b(obj3);
                        }
                    } else {
                        mmVar.g.remove(str);
                        mmVar.f.put(str, obj3);
                    }
                    break;
                }
                break;
            case 1:
                ((mm) obj2).a(i2, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", (IntentSender.SendIntentException) obj));
                break;
            default:
                ((qt) obj2).b.f(i2, obj);
                break;
        }
    }
}
