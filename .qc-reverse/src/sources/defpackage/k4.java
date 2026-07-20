package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class k4 extends g4 {
    public final /* synthetic */ int a;
    public final /* synthetic */ mm b;
    public final /* synthetic */ String c;
    public final /* synthetic */ f01 d;

    public /* synthetic */ k4(mm mmVar, String str, f01 f01Var, int i) {
        this.a = i;
        this.b = mmVar;
        this.c = str;
        this.d = f01Var;
    }

    @Override // defpackage.g4
    public final void a(Object obj) {
        int i = this.a;
        f01 f01Var = this.d;
        String str = this.c;
        mm mmVar = this.b;
        switch (i) {
            case 0:
                ArrayList arrayList = mmVar.d;
                Object obj2 = mmVar.b.get(str);
                if (obj2 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + f01Var + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue = ((Number) obj2).intValue();
                arrayList.add(str);
                try {
                    mmVar.b(iIntValue, f01Var, obj);
                    return;
                } catch (Exception e) {
                    arrayList.remove(str);
                    throw e;
                }
            default:
                ArrayList arrayList2 = mmVar.d;
                Object obj3 = mmVar.b.get(str);
                if (obj3 == null) {
                    throw new IllegalStateException(("Attempting to launch an unregistered ActivityResultLauncher with contract " + f01Var + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().").toString());
                }
                int iIntValue2 = ((Number) obj3).intValue();
                arrayList2.add(str);
                try {
                    mmVar.b(iIntValue2, f01Var, obj);
                    return;
                } catch (Exception e2) {
                    arrayList2.remove(str);
                    throw e2;
                }
        }
    }

    public void b() {
        this.b.f(this.c);
    }
}
