package defpackage;

import com.heinrichreimersoftware.materialintro.view.FadeableViewPager;

/* JADX INFO: compiled from: r8-map-id-cf80f8abcb113d5feb50392a150ad1aafcd9a0d68b58b47d245bdd7749062c30 */
/* JADX INFO: loaded from: classes.dex */
public final class c10 implements kg1 {
    public final kg1 b;
    public final /* synthetic */ FadeableViewPager c;

    public c10(FadeableViewPager fadeableViewPager, kg1 kg1Var) {
        this.c = fadeableViewPager;
        this.b = kg1Var;
    }

    @Override // defpackage.kg1
    public final void a(int i) {
        this.b.a(i);
    }

    @Override // defpackage.kg1
    public final void d(int i) {
        kg1 kg1Var = this.b;
        boolean z = kg1Var instanceof gc0;
        FadeableViewPager fadeableViewPager = this.c;
        kg1Var.d(Math.min(i, (z ? super/*mg1*/.getAdapter() : fadeableViewPager.getAdapter()).c() - 1));
    }

    @Override // defpackage.kg1
    public final void l(float f, int i, int i2) {
        kg1 kg1Var = this.b;
        boolean z = kg1Var instanceof gc0;
        FadeableViewPager fadeableViewPager = this.c;
        int iC = (z ? super/*mg1*/.getAdapter() : fadeableViewPager.getAdapter()).c();
        int iMin = Math.min(i, iC - 1);
        if (i >= iC) {
            f = 0.0f;
        }
        if (i >= iC) {
            i2 = 0;
        }
        kg1Var.l(f, iMin, i2);
    }
}
