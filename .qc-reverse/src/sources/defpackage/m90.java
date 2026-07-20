package defpackage;

import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class m90 extends km0 {
    public final /* synthetic */ int c = 2;
    public final /* synthetic */ int d;
    public final /* synthetic */ u90 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m90(u90 u90Var, Object[] objArr, int i, ArrayList arrayList) {
        super("OkHttp %s Push Request[%s]", objArr);
        this.e = u90Var;
        this.d = i;
    }

    @Override // defpackage.km0
    public final void a() {
        switch (this.c) {
            case 0:
                this.e.k.getClass();
                try {
                    this.e.s.r(this.d, 6);
                    synchronized (this.e) {
                        this.e.u.remove(Integer.valueOf(this.d));
                        break;
                    }
                    return;
                } catch (IOException unused) {
                    return;
                }
            case 1:
                this.e.k.getClass();
                try {
                    this.e.s.r(this.d, 6);
                    synchronized (this.e) {
                        this.e.u.remove(Integer.valueOf(this.d));
                        break;
                    }
                    return;
                } catch (IOException unused2) {
                    return;
                }
            default:
                this.e.k.getClass();
                synchronized (this.e) {
                    this.e.u.remove(Integer.valueOf(this.d));
                    break;
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m90(u90 u90Var, Object[] objArr, int i, ArrayList arrayList, boolean z) {
        super("OkHttp %s Push Headers[%s]", objArr);
        this.e = u90Var;
        this.d = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m90(u90 u90Var, Object[] objArr, int i, int i2) {
        super("OkHttp %s Push Reset[%s]", objArr);
        this.e = u90Var;
        this.d = i;
    }
}
