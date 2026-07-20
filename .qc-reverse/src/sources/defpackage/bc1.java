package defpackage;

import java.io.IOException;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public class bc1 extends fb1 {
    @Override // defpackage.fb1
    public final Object b(vd0 vd0Var) throws IOException {
        boolean zY;
        BitSet bitSet = new BitSet();
        vd0Var.a();
        int I = vd0Var.I();
        int i = 0;
        while (I != 2) {
            int iR = l11.r(I);
            if (iR == 5 || iR == 6) {
                int iA = vd0Var.A();
                if (iA == 0) {
                    zY = false;
                } else {
                    if (iA != 1) {
                        ay0.e("Invalid bitset value ", iA, ", expected 0 or 1; at path ", vd0Var.u());
                        return null;
                    }
                    zY = true;
                }
            } else {
                if (iR != 7) {
                    throw new wd0("Invalid bitset value type: " + l11.u(I) + "; at path " + vd0Var.s());
                }
                zY = vd0Var.y();
            }
            if (zY) {
                bitSet.set(i);
            }
            i++;
            I = vd0Var.I();
        }
        vd0Var.m();
        return bitSet;
    }

    @Override // defpackage.fb1
    public final void c(ae0 ae0Var, Object obj) throws IOException {
        BitSet bitSet = (BitSet) obj;
        ae0Var.g();
        int length = bitSet.length();
        for (int i = 0; i < length; i++) {
            ae0Var.z(bitSet.get(i) ? 1L : 0L);
        }
        ae0Var.m();
    }
}
