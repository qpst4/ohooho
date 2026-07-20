package defpackage;

import java.util.List;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class kv implements Predicate {
    public final /* synthetic */ int a;
    public final /* synthetic */ List b;

    public /* synthetic */ kv(int i, List list) {
        this.a = i;
        this.b = list;
    }

    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        int i = this.a;
        List list = this.b;
        switch (i) {
            case 0:
                return !list.contains((String) obj);
            default:
                return list.contains(obj);
        }
    }
}
