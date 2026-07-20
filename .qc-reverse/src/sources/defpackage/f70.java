package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class f70 extends fb1 {
    public final /* synthetic */ int a;

    public /* synthetic */ f70(int i) {
        this.a = i;
    }

    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        switch (this.a) {
            case 0:
                if (vd0Var.I() != 9) {
                    return Double.valueOf(vd0Var.z());
                }
                vd0Var.E();
                return null;
            case 1:
                if (vd0Var.I() != 9) {
                    return Float.valueOf((float) vd0Var.z());
                }
                vd0Var.E();
                return null;
            default:
                vd0Var.P();
                return null;
        }
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        switch (this.a) {
            case 0:
                Number number = (Number) obj;
                if (number != null) {
                    double dDoubleValue = number.doubleValue();
                    i70.a(dDoubleValue);
                    ae0Var.y(dDoubleValue);
                } else {
                    ae0Var.t();
                }
                break;
            case 1:
                Number numberValueOf = (Number) obj;
                if (numberValueOf != null) {
                    float fFloatValue = numberValueOf.floatValue();
                    i70.a(fFloatValue);
                    if (!(numberValueOf instanceof Float)) {
                        numberValueOf = Float.valueOf(fFloatValue);
                    }
                    ae0Var.A(numberValueOf);
                } else {
                    ae0Var.t();
                }
                break;
            default:
                ae0Var.t();
                break;
        }
    }

    public String toString() {
        switch (this.a) {
            case 2:
                return "AnonymousOrNonStaticLocalClassAdapter";
            default:
                return super.toString();
        }
    }
}
