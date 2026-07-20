package defpackage;

import android.text.TextUtils;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class hf1 extends f41 {
    public final /* synthetic */ int e;

    public hf1(int i, Class cls, int i2, int i3, int i4) {
        this.e = i4;
        this.a = i;
        this.d = cls;
        this.c = i2;
        this.b = i3;
    }

    @Override // defpackage.f41
    public final Object b(View view) {
        switch (this.e) {
            case 0:
                return Boolean.valueOf(pf1.c(view));
            case 1:
                return pf1.a(view);
            case 2:
                return rf1.b(view);
            default:
                return Boolean.valueOf(pf1.b(view));
        }
    }

    @Override // defpackage.f41
    public final void c(View view, Object obj) {
        switch (this.e) {
            case 0:
                pf1.f(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                pf1.e(view, (CharSequence) obj);
                break;
            case 2:
                rf1.c(view, (CharSequence) obj);
                break;
            default:
                pf1.d(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // defpackage.f41
    public final boolean e(Object obj, Object obj2) {
        boolean zEquals;
        switch (this.e) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            case 2:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
        return !zEquals;
    }
}
