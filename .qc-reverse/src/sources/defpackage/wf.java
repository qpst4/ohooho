package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class wf extends o31 implements z40 {
    public int f;
    public final /* synthetic */ yf g;
    public final /* synthetic */ Bitmap h;
    public final /* synthetic */ jl1 i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wf(yf yfVar, Bitmap bitmap, jl1 jl1Var, jo joVar) {
        super(joVar);
        this.g = yfVar;
        this.h = bitmap;
        this.i = jl1Var;
    }

    @Override // defpackage.z40
    public final Object f(Object obj, Object obj2) {
        return ((wf) h((jo) obj2, (mp) obj)).i(ow0.h);
    }

    @Override // defpackage.o31
    public final jo h(jo joVar, Object obj) {
        return new wf(this.g, this.h, this.i, joVar);
    }

    @Override // defpackage.o31
    public final Object i(Object obj) throws Throwable {
        int i = this.f;
        if (i == 0) {
            yb0.C(obj);
            Rect rect = gg.a;
            yf yfVar = this.g;
            Context context = yfVar.b;
            Bitmap.CompressFormat compressFormat = yfVar.r;
            int i2 = yfVar.s;
            Uri uri = yfVar.t;
            Bitmap bitmap = this.h;
            uf ufVar = new uf(bitmap, gg.s(context, bitmap, compressFormat, i2, uri), null, this.i.b);
            this.f = 1;
            Object objA = yf.a(yfVar, ufVar, this);
            np npVar = np.b;
            if (objA == npVar) {
                return npVar;
            }
        } else {
            if (i != 1) {
                s1.f("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            yb0.C(obj);
        }
        return ow0.h;
    }
}
