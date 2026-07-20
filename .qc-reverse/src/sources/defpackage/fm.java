package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class fm implements px0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ fm(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.px0
    public final Bundle a() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                Bundle bundle = new Bundle();
                mm mmVar = ((pm) obj).j;
                mmVar.getClass();
                LinkedHashMap linkedHashMap = mmVar.b;
                bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
                bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(mmVar.d));
                bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(mmVar.g));
                return bundle;
            case 1:
                z7 z7Var = (z7) obj;
                while (z7.x(z7Var.w())) {
                }
                z7Var.v.d(yf0.ON_STOP);
                return new Bundle();
            default:
                return ((y30) obj).V();
        }
    }
}
