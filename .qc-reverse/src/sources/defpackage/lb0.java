package defpackage;

import com.heinrichreimersoftware.materialintro.view.InkPageIndicator;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class lb0 extends mb0 {
    public final int d;
    public final /* synthetic */ InkPageIndicator e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lb0(InkPageIndicator inkPageIndicator, int i, hb0 hb0Var) {
        super(hb0Var);
        this.e = inkPageIndicator;
        setFloatValues(1.0E-5f, 1.0f);
        this.d = i;
        setDuration(inkPageIndicator.g);
        setInterpolator(inkPageIndicator.G);
        addUpdateListener(new wg(3, this));
        addListener(new m1(8, this));
    }
}
