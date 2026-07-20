package defpackage;

import com.heinrichreimersoftware.materialintro.view.InkPageIndicator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class kb0 extends mb0 {
    public final /* synthetic */ InkPageIndicator d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public kb0(InkPageIndicator inkPageIndicator, int i, int i2, int i3, hb0 hb0Var) {
        super(hb0Var);
        this.d = inkPageIndicator;
        long j = inkPageIndicator.g;
        float f = inkPageIndicator.e;
        setDuration(j);
        setInterpolator(inkPageIndicator.G);
        float[] fArr = inkPageIndicator.q;
        float fMin = (i2 > i ? Math.min(fArr[i], inkPageIndicator.o) : fArr[i2]) - f;
        float[] fArr2 = inkPageIndicator.q;
        float f2 = (i2 > i ? fArr2[i2] : fArr2[i2]) - f;
        float fMax = (i2 > i ? fArr2[i2] : Math.max(fArr2[i], inkPageIndicator.o)) + f;
        float[] fArr3 = inkPageIndicator.q;
        float f3 = (i2 > i ? fArr3[i2] : fArr3[i2]) + f;
        inkPageIndicator.F = new lb0[i3];
        int[] iArr = new int[i3];
        int i4 = 1;
        int i5 = 0;
        if (fMin != f2) {
            setFloatValues(fMin, f2);
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = i + i6;
                inkPageIndicator.F[i6] = new lb0(inkPageIndicator, i7, new hb0(1, inkPageIndicator.q[i7]));
                iArr[i6] = i7;
            }
            addUpdateListener(new ib0(this, i5));
        } else {
            setFloatValues(fMax, f3);
            for (int i8 = 0; i8 < i3; i8++) {
                int i9 = i - i8;
                inkPageIndicator.F[i8] = new lb0(inkPageIndicator, i9, new hb0(0, inkPageIndicator.q[i9]));
                iArr[i8] = i9;
            }
            addUpdateListener(new ib0(this, i4));
        }
        addListener(new jb0(this, iArr, fMin, fMax));
    }
}
