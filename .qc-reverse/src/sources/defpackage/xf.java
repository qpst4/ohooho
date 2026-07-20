package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class xf extends o31 implements z40 {
    public final /* synthetic */ int f;
    public int g;
    public /* synthetic */ Object h;
    public final /* synthetic */ mp i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ xf(mp mpVar, jo joVar, int i) {
        super(joVar);
        this.f = i;
        this.i = mpVar;
    }

    @Override // defpackage.z40
    public final Object f(Object obj, Object obj2) {
        mp mpVar = (mp) obj;
        jo joVar = (jo) obj2;
        switch (this.f) {
        }
        return ((xf) h(joVar, mpVar)).i(ow0.h);
    }

    @Override // defpackage.o31
    public final jo h(jo joVar, Object obj) {
        int i = this.f;
        mp mpVar = this.i;
        switch (i) {
            case 0:
                xf xfVar = new xf((yf) mpVar, joVar, 0);
                xfVar.h = obj;
                return xfVar;
            default:
                xf xfVar2 = new xf((cg) mpVar, joVar, 1);
                xfVar2.h = obj;
                return xfVar2;
        }
    }

    @Override // defpackage.o31
    public final Object i(Object obj) throws Throwable {
        jl1 jl1VarE;
        int i = this.f;
        np npVar = np.b;
        mp mpVar = this.i;
        int i2 = 1;
        jo joVar = null;
        ow0 ow0Var = ow0.h;
        switch (i) {
            case 0:
                yf yfVar = (yf) mpVar;
                float[] fArr = yfVar.f;
                int i3 = this.g;
                try {
                    if (i3 == 0) {
                        yb0.C(obj);
                        mp mpVar2 = (mp) this.h;
                        if (i1.C(mpVar2)) {
                            Uri uri = yfVar.d;
                            if (uri != null) {
                                Rect rect = gg.a;
                                jl1VarE = gg.c(yfVar.b, uri, fArr, yfVar.g, yfVar.h, yfVar.i, yfVar.j, yfVar.k, yfVar.l, yfVar.m, yfVar.n, yfVar.o, yfVar.p);
                            } else {
                                Bitmap bitmap = yfVar.e;
                                if (bitmap != null) {
                                    Rect rect2 = gg.a;
                                    jl1VarE = gg.e(bitmap, fArr, yfVar.g, yfVar.j, yfVar.k, yfVar.l, yfVar.o, yfVar.p);
                                } else {
                                    uf ufVar = new uf(null, null, null, 1);
                                    this.g = 1;
                                    if (yf.a(yfVar, ufVar, this) == npVar) {
                                        return npVar;
                                    }
                                }
                            }
                            fc0.z(mpVar2, iu.b, new wf(yfVar, gg.r((Bitmap) jl1VarE.c, yfVar.m, yfVar.n, yfVar.q), jl1VarE, null));
                        }
                    } else {
                        if (i3 != 1 && i3 != 2) {
                            s1.f("call to 'resume' before 'invoke' with coroutine");
                            return null;
                        }
                        yb0.C(obj);
                    }
                } catch (Exception e) {
                    uf ufVar2 = new uf(null, null, e, 1);
                    this.g = 2;
                    if (yf.a(yfVar, ufVar2, this) == npVar) {
                        return npVar;
                    }
                }
                return ow0Var;
            default:
                cg cgVar = (cg) mpVar;
                Context context = cgVar.b;
                Uri uri2 = cgVar.c;
                int i4 = this.g;
                try {
                } catch (Exception e2) {
                    bg bgVar = new bg(uri2, null, 0, 0, false, false, e2);
                    this.g = 2;
                    rs rsVar = iu.a;
                    Object objU = fc0.U(dj0.a, new vf(cgVar, bgVar, joVar, i2), this);
                    if (objU != npVar) {
                        objU = ow0Var;
                    }
                    if (objU == npVar) {
                        return npVar;
                    }
                }
                if (i4 == 0) {
                    yb0.C(obj);
                    mp mpVar3 = (mp) this.h;
                    if (i1.C(mpVar3)) {
                        Rect rect3 = gg.a;
                        jl1 jl1VarI = gg.i(context, uri2, cgVar.d, cgVar.e);
                        if (i1.C(mpVar3)) {
                            eg egVarQ = gg.q((Bitmap) jl1VarI.c, context, uri2);
                            bg bgVar2 = new bg(uri2, (Bitmap) egVarQ.d, jl1VarI.b, egVarQ.a, egVarQ.b, egVarQ.c, null);
                            this.g = 1;
                            rs rsVar2 = iu.a;
                            Object objU2 = fc0.U(dj0.a, new vf(cgVar, bgVar2, joVar, i2), this);
                            if (objU2 != npVar) {
                                objU2 = ow0Var;
                            }
                            if (objU2 == npVar) {
                                return npVar;
                            }
                        }
                    }
                } else {
                    if (i4 != 1) {
                        if (i4 == 2) {
                            yb0.C(obj);
                            return ow0Var;
                        }
                        s1.f("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    yb0.C(obj);
                }
                return ow0Var;
        }
    }
}
