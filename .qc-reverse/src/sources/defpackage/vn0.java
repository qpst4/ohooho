package defpackage;

import androidx.activity.a;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class vn0 extends hf0 implements v40 {
    public final /* synthetic */ int c;
    public final /* synthetic */ a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ vn0(a aVar, int i) {
        super(1);
        this.c = i;
        this.d = aVar;
    }

    @Override // defpackage.v40
    public final Object g(Object obj) {
        int i = this.c;
        Object obj2 = null;
        a aVar = this.d;
        switch (i) {
            case 0:
                ((kd) obj).getClass();
                eb ebVar = aVar.b;
                ListIterator listIterator = ebVar.listIterator(ebVar.d);
                while (true) {
                    if (listIterator.hasPrevious()) {
                        Object objPrevious = listIterator.previous();
                        if (((r30) objPrevious).a) {
                            obj2 = objPrevious;
                        }
                    }
                }
                r30 r30Var = (r30) obj2;
                if (aVar.c != null) {
                    aVar.c();
                }
                aVar.c = r30Var;
                break;
            default:
                ((kd) obj).getClass();
                if (aVar.c == null) {
                    eb ebVar2 = aVar.b;
                    ListIterator listIterator2 = ebVar2.listIterator(ebVar2.d);
                    while (true) {
                        if (listIterator2.hasPrevious()) {
                            Object objPrevious2 = listIterator2.previous();
                            if (((r30) objPrevious2).a) {
                                obj2 = objPrevious2;
                            }
                        }
                    }
                }
                break;
        }
        return ow0.h;
    }
}
